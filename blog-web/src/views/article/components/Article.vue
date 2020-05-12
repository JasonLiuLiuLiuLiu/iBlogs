<template>
  <article class="main-content page-page" itemscope itemtype="http://schema.org/Article">
    <div class="post-header">
      <h1 class="post-title" itemprop="name headline">
        <a href="@Model.Content.Permalink()">@Model.Content.Title</a>
      </h1>
      <div class="post-data">
        <time datetime="@Model.Content.CreatedStr("yyyy-MM-dd")" itemprop="datePublished">发布于 @Model.Content.CreatedStr("yyyy-MM-dd")</time>
        / @Html.Raw(Model.Content.ShowCategories()) / <a href="#comments">@Model.Content.CommentsNumStr("没有评论", "{0} 条评论")</a> /
        @Model.Content.Hits 浏览
      </div>
    </div>
    <div id="post-content" class="post-content" itemprop="articleBody">
      <p class="post-tags">@Html.Raw(Model.Content.ShowTags())</p>
      <a></a>
      @Html.Raw(Model.Content.ShowContent())
      <p class="post-info">
        本文由 <a href="">@(ViewService.SiteOption(ConfigKey.Author, "阿宇"))</a> 创作，采用 <a href="https://creativecommons.org/licenses/by/4.0/" target="_blank"
                                                                                      rel="external nofollow">知识共享署名4.0</a> 国际许可协议进行许可<br>本站文章除注明转载/出处外，均为本站原创或翻译，转载前请务必署名<br>最后编辑时间为:
        @Model.Content.ModifiedStr("yyyy/MM/dd HH:mm")
      </p>
    </div>
  </article>
</template>
<script>
  export default {
    name:'Article'
  }
</script>
<style>

</style>
