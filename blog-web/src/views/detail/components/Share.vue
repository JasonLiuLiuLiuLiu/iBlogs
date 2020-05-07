<template>
  <div id="post-bottom-bar" class="post-bottom-bar">
    <div class="bottom-bar-inner">
      <div class="bottom-bar-items social-share left">
        <span class="bottom-bar-item">Share : </span>
        <span class="bottom-bar-item bottom-bar-facebook"><a href="https://www.facebook.com/sharer/sharer.php?u=@ViewService.SiteUrl()@Model.Content.Permalink()" target="_blank" title="@Model.Content.Title" rel="nofollow">facebook</a></span>
        <span class="bottom-bar-item bottom-bar-twitter"><a href="https://twitter.com/intent/tweet?url=@ViewService.SiteUrl()@Model.Content.Permalink()&text=@Model.Content.Title" target="_blank" title="@Model.Content.Title" rel="nofollow">Twitter</a></span>
        <span class="bottom-bar-item bottom-bar-weibo"><a href="http://service.weibo.com/share/share.php?url=@ViewService.SiteUrl()@Model.Content.Permalink()&amp;title=@Model.Content.Title" target="_blank" title="@Model.Content.Title" rel="nofollow">Weibo</a></span>
        <span class="bottom-bar-item bottom-bar-qrcode"><a href="https://cli.im/api/qrcode/code?text=@ViewService.SiteUrl()@Model.Content.Permalink()&mhid=sELPDFnok80gPHovKdI" target="_blank" rel="nofollow">QRSetCode</a></span>
      </div>
      <div class="bottom-bar-items right">
        <span class="bottom-bar-item">@Html.Raw(Model.ThePrev("←"))</span>
        <span class="bottom-bar-item">@Html.Raw(Model.TheNext("→"))</span>
        <span class="bottom-bar-item"><a href="#footer">↓</a></span>
        <span class="bottom-bar-item"><a href="#">↑</a></span>
      </div>
    </div>
  </div>
</template>
<script>

</script>
<style>

</style>
