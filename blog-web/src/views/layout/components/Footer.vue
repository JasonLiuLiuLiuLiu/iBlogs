<template>
  <div id="footer" class="footer bg-white">
    <div class="footer-social">
      <div class="footer-container clearfix">
        <div class="social-list">
          <a class="social rss" target="_blank" href="/feed">RSS</a>
          <a class="social rss" target="_blank" href="/sitemap.xml">Site Map</a>
        </div>
      </div>
    </div>
    <div class="footer-meta">
      <div class="footer-container">
        <div class="meta-item meta-copyright">
          <div class="meta-copyright-info">
            <a href="https://github.com/liuzhenyulive/iblogs" class="info-logo">
              <img src="/static/img/logo.png" alt="">
            </a>
            <a href="https://www.upyun.com/?utm_source=lianmeng&utm_medium=referral" target="_blank" class="upyun-logo">
              <img src="/static/img/upyun_logo5.png" alt="本站由又拍云加速">
            </a>
            <div class="info-text">
              <p>Always coding,Always writing!</p>
              <p>
                Azure Pipeline Build <a
                href="https://dev.azure.com/ZhenyuDevOps/iBlogs/_build/latest?definitionId=1&branchName=master"
                target="_blank">BuildNumber</a>
              </p>
              <p>
                <a href="http://iblogs.site">iblogs.site</a> | <a href="http://www.beian.gov.cn">赣ICP备18014060号-2</a>
              </p>
              <p>
                Powered by <a href="https://github.com/liuzhenyulive/iblogs" target="_blank">iBlogs</a> &copy; 2020 <a
                href="https://github.com/liuzhenyulive" target="_blank">Liu, zhenyu</a>
              </p>
            </div>
          </div>
        </div>

        <div class="meta-item meta-posts">
          <span v-html="Options.FootContent1"></span>
        </div>

        <div class="meta-item meta-comments">
          <span v-html="Options.FootContent2"></span>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  import {getOptions} from '@/api/option'

  const keys = ['FootContent1', 'FootContent2'];

  export default {
    name: "footer",
    data() {
      return {
        Options: {
          FootContent1: "页脚1",
          FootContent2: "页脚2"
        }
      }
    },
    created() {
      this.getOptions();
    },
    methods: {
      getOptions() {
        getOptions(keys).then(response => {
          this.Options = response.data;
        });
      }
    }
  }
</script>
<style>

</style>
