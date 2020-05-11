<template>
  <div id="footer" class="footer bg-white">
    <div class="footer-social">
      <div class="footer-container clearfix">
        <div class="social-list">
          @if (!ViewService.SiteOption(ConfigKey.WeiBo).IsNullOrWhiteSpace())
          {
          <a class="social weibo" target="_blank" href="http://weibo.com/@ViewService.SiteOption(ConfigKey.WeiBo)">微博</a>
          }

          @if (!ViewService.SiteOption(ConfigKey.ZhiHu).IsNullOrWhiteSpace())
          {
          <a class="social zhihu" target="_blank" href="https://www.zhihu.com/people/@ViewService.SiteOption(ConfigKey.ZhiHu)">知乎</a>
          }

          <a class="social rss" target="_blank" href="/feed">RSS</a>
          <a class="social rss" target="_blank" href="/sitemap.xml">Site Map</a>

          @if (!ViewService.SiteOption(ConfigKey.Github).IsNullOrWhiteSpace())
          {
          <a class="social github" target="_blank"
             href="https://github.com/@ViewService.SiteOption(ConfigKey.Github)">Github</a>
          }

          @if (!ViewService.SiteOption(ConfigKey.Twitter).IsNullOrWhiteSpace())
          {
          <a class="social twitter" target="_blank" href="https://twitter.com/@ViewService.SiteOption(ConfigKey.Twitter)">Twitter</a>
          }
        </div>
      </div>
    </div>
    <div class="footer-meta">
      <div class="footer-container">
        <div class="meta-item meta-copyright">
          <div class="meta-copyright-info">
            <a href="https://github.com/liuzhenyulive/iblogs" class="info-logo">
              <img src="/templates/themes/default/static/img/logo.png" alt="@ViewService.SiteOption(ConfigKey.SiteTitle)">
            </a>
            <a href="https://www.upyun.com/?utm_source=lianmeng&utm_medium=referral" target="_blank" class="upyun-logo">
              <img src="/templates/themes/default/static/img/upyun_logo5.png" alt="本站由又拍云加速">
            </a>
            <div class="info-text">
              <p>Always coding,Always writing!</p>
              <p>
                Azure Pipeline Build <a href="https://dev.azure.com/ZhenyuDevOps/iBlogs/_build/latest?definitionId=1&branchName=master" target="_blank">@ViewService.BuildNumber()</a>
              </p>
              <p>
                <a href="http://iblogs.site">iblogs.site</a> | <a href="http://www.beian.gov.cn">赣ICP备18014060号-2</a>
              </p>
              <p>
                Powered by  <a href="https://github.com/liuzhenyulive/iblogs" target="_blank">iBlogs</a> &copy; @DateTime.Now.Year <a href="https://github.com/liuzhenyulive" target="_blank">Liu, zhenyu</a>
              </p>
            </div>
          </div>
        </div>

        <div class="meta-item meta-posts">
          @Html.Raw(ViewService.SiteOption(ConfigKey.FootContent1))
        </div>

        <div class="meta-item meta-comments">
          @Html.Raw(ViewService.SiteOption(ConfigKey.FootContent2))
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  export default {
    name:"footer"
  }

</script>
<style>

</style>
