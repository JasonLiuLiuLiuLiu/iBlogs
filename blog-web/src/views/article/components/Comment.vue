<template>
  <div id="@article.Id" class="comment-container">
    <div id="comments" class="clearfix">

      <form method="post" id="comment-form" class="comment-form" v-if="this.$store.state.content.content.allowComment">
        <input type="hidden" name="coid" id="coid"/>
        <input type="hidden" name="cid" id="cid" value="@Model.Content.Id"/>
        <input name="author" maxlength="12" id="author" class="form-control input-control clearfix" placeholder="姓名 (*)"
               required/>
        <input type="email" name="mail" id="mail" class="form-control input-control clearfix" placeholder="邮箱 (*)"
               required/>
        <input type="url" name="url" id="url" class="form-control input-control clearfix" placeholder="网址 (http://)"/>
        <textarea name="content" id="textarea" class="form-control" placeholder="客官,留下你的评论." required minlength="5"
                  maxlength="2000"></textarea>

        <button class="submit" id="misubmit">提交</button>
      </form>

      <span class="response" v-else>评论已关闭.</span>


      <ol class="comment-list" v-for="comment in this.comments">
        <li id="li-comment-@comment.Id" class="comment-body comment-parent comment-odd">
          <div id="comment-@comment.Id">
            <div class="comment-view" onclick="">
              <div class="comment-header">
                <img class="avatar" src="" :title="comment.Author"
                     width="80" height="80">
                <span class="comment-author">
                                            <a :href="comment.Url" target="_blank" rel="external nofollow">{{comment.Author}}</a>
                                        </span>
              </div>
              <div class="comment-content">
                <span class="comment-author-at"></span>
                <p>{{comment.Content}}</p>
              </div>
              <div class="comment-meta">
                <time class="comment-time">@comment.Created.ToString("yyyy-MM-dd")</time>
                <span class="comment-reply">
                                            <a rel="nofollow"
                                               onclick="TaleComment.reply('@comment.Id','@comment.Author');">回复</a>
                                        </span>
              </div>
            </div>
          </div>

          <div class="comment-children">
            <ol class="comment-list">

              <li id="li-comment-@child.Id"
                  class="comment-body comment-child comment-level-odd comment-odd">
                <div id="comment-@child.Id">
                  <div class="comment-view">
                    <div class="comment-header">
                      <img class="avatar" src="" title="@child.Author" width="80" height="80">
                      <span class="comment-author comment-by-author">
                                                                <a href="@child.Url" target="_blank"
                                                                   rel="external nofollow">@child.Author</a>
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
                                                                <a rel="nofollow"
                                                                   onclick="TaleComment.reply('@child.Id','@child.Author');">回复</a>
                                                            </span>
                    </div>
                  </div>
                </div>
              </li>
            </ol>
          </div>
        </li>
      </ol>
      <div class="lists-navigator clearfix">
        <ol class="page-navigator">

          <li class="prev"><a href="?cp=@comments.PrevPage#comments">←</a></li>

          <li class=""><a href="?cp=@navIndex#comments">@navIndex</a></li>
          <li class="next"><a href="?cp=@comments.NextPage#comments">→</a></li>
        </ol>

      </div>
    </div>
  </div>
</template>
<script>
  import {getComments} from "../../../api/comment";
  import {dateFormat} from "../../../utils/dateUtils";

  export default {
    name: 'Comment',
    data() {
      return {
        comments: null,
        pageNum: 1,
        pageSize: 10,
      }
    },
    created() {
      this.getComments();
    },
    filters: {
      formatDate(time) {
        const date = new Date(time);
        return dateFormat(date, 'yyyy-MM-dd');
      }
    },
    methods: {
      getComments() {
        getComments(this.$store.state.content.content.id, this.pageNum, this.pageSize).then(response => {
          this.comments = response.data.list;
        })
      }
    }
  }
</script>
<style>

</style>
