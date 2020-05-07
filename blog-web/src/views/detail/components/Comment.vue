<template>
  var article = Model.Content;
  var comments = Model.Comments;
  <div id="@article.Id" class="comment-container">
    <div id="comments" class="clearfix">
      @if (article.AllowComment)
      {


      @if (Model.User != null)
      {
      <span class="response">
                        Hi，<a href="@Model.User.HomeUrl" data-no-instant>@Model.User.ScreenName</a>
                        如果你想 <a href="/admin/login" title="注销" data-no-instant>注销</a> ?
                    </span>
      }


      <form method="post" id="comment-form" class="comment-form" onsubmit="return TaleComment.subComment();">
        <input type="hidden" name="coid" id="coid" />
        <input type="hidden" name="cid" id="cid" value="@Model.Content.Id" />
        <input name="author" maxlength="12" id="author" class="form-control input-control clearfix"
               placeholder="姓名 (*)" value="@Model.User?.ScreenName" required />
        <input type="email" name="mail" id="mail" class="form-control input-control clearfix" placeholder="邮箱 (*)"
               value="@Model.User?.Email" required />
        <input type="url" name="url" id="url" class="form-control input-control clearfix" placeholder="网址 (http://)"
               value="@Model.User?.HomeUrl" />
        <textarea name="content" id="textarea" class="form-control" placeholder="客官,留下你的评论." required minlength="5" maxlength="2000"></textarea>

        <button class="submit" id="misubmit">提交</button>
      </form>
      }
      else
      {
      <span class="response">评论已关闭.</span>
      }

      @if (comments?.Rows.Count > 0)
      {
      <ol class="comment-list">
        @foreach (var comment in comments.Rows)
        {
        <li id="li-comment-@comment.Id" class="comment-body comment-parent comment-odd">
          <div id="comment-@comment.Id}">
            <div class="comment-view" onclick="">
              <div class="comment-header">
                <img class="avatar" src="@ViewService.Gravatar(comment.Mail)?s=80&r=G&d=" title="@comment.Author"
                     width="80" height="80">
                <span class="comment-author">
                                            <a href="@comment.Url}" target="_blank" rel="external nofollow">@comment.Author</a>
                                        </span>
              </div>
              <div class="comment-content">
                <span class="comment-author-at"></span>
                <p>@comment.Content</p>
              </div>
              <div class="comment-meta">
                <time class="comment-time">@comment.Created.ToString("yyyy-MM-dd")</time>
                <span class="comment-reply">
                                            <a rel="nofollow" onclick="TaleComment.reply('@comment.Id','@comment.Author');">回复</a>
                                        </span>
              </div>
            </div>
          </div>
          @if (comment.Levels > 0)
          {
          <div class="comment-children">
            <ol class="comment-list">
              @foreach (var child in comment.Children)
              {
              <li id="li-comment-@child.Id"
                  class="comment-body comment-child comment-level-odd comment-odd">
                <div id="comment-@child.Id">
                  <div class="comment-view">
                    <div class="comment-header">
                      <img class="avatar" src="@ViewService.Gravatar(child.Mail)?s=80&r=G&d=" title="@child.Author" width="80" height="80">
                      <span class="comment-author comment-by-author">
                                                                <a href="@child.Url" target="_blank" rel="external nofollow">@child.Author</a>
                                                            </span>
                    </div>
                    <div class="comment-content">
                                                            <span class="comment-author-at">
                                                                @child.CommentAt(comment)
                                                            </span>
                      <p>@child.Content</p>
                    </div>
                    <div class="comment-meta">
                      <time class="comment-time">@child.Created.ToString("yyyy-MM-dd")</time>
                      <span class="comment-reply">
                                                                <a rel="nofollow" onclick="TaleComment.reply('@child.Id','@child.Author');">回复</a>
                                                            </span>
                    </div>
                  </div>
                </div>
              </li>
              }
            </ol>
          </div>
          }
        </li>
        }
      </ol>
      }

      @if (comments != null)
      {
      <div class="lists-navigator clearfix">
        <ol class="page-navigator">
          @if (comments.HasPrevPage)
          {
          <li class="prev"><a href="?cp=@comments.PrevPage#comments">←</a></li>
          }


          @foreach (var navIndex in comments.NavPageNums)
          {
          <li class="@((comments.PageNum==navIndex)?"current":"")"><a href="?cp=@navIndex#comments">@navIndex</a></li>
          }


          @if (comments.HasNextPage)
          {
          <li class="next"><a href="?cp=@comments.NextPage#comments">→</a></li>
          }
        </ol>

      </div>
      }
    </div>
  </div>
</template>
<script>
  (function () {
    window.TaleComment = {
      reply: function (coid, author) {
        $('#comment-form input[name=coid]').val(coid);
        $("html,body").animate({ scrollTop: $('div.comment-container').offset().top }, 500);
        $('#comment-form #textarea').focus();
        $('#comment-form #textarea').val('@@' + author + '  ');
      },
      subComment: function () {
        $.ajax({
          type: 'post',
          url: '/article/comment',
          data: $('#comment-form').serialize(),
          async: false,
          dataType: 'json',
          error: function (jqXHR, status, error) {
            if (status === 'error' && jqXHR.status === 400) {
              alert('非法的请求');
            } else {
              console.log('Request Error:', error)
            }
          },
          success: function (result) {
            $('#comment-form input[name=coid]').val('');
            if (result && result.success) {
              alert('评论成功,管理员审核通过后显示');
              window.location.reload();
            } else {
              if (result.msg) {
                alert(result.msg);
                window.location.reload();
              }
            }
          }
        });
        return false;
      }
    };
  })();

  function getCommentCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg)) {
      return unescape(decodeURI(arr[2]));
    } else {
      return null;
    }
  }

  function addCommentInputValue() {
    document.getElementById('author').value = getCommentCookie('tale_remember_author');
    document.getElementById('mail').value = getCommentCookie('tale_remember_mail');
    document.getElementById('url').value = getCommentCookie('tale_remember_url');
  }
  addCommentInputValue();
</script>
<style>

</style>
