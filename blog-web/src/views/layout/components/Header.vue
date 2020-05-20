<template>
  <headroom>
    <header id="header" class="bg-white Sticky AppHeader header" style="position: relative" data-za-module="TopNavBar">
      <div class="navbar-container">
        <a :href="this.$store.state.options.options.SiteUrl" class="navbar-logo">
          <img src="/static/img/logo.png" alt="@ViewService.SiteOption(ConfigKey.SiteTitle)" />
        </a>
        <div class="navbar-menu">
          <a href="/archives">归档</a>
          <a href="/links">友链</a>
          <a href="/about">关于</a>
        </div>
        <div class="navbar-search" onclick="">
          <span class="icon-search"></span>
          <form role="search" onsubmit="return false;">
                    <span class="search-box">
                        <input type="text" id="search-inp" class="input" placeholder="搜索..." maxlength="30"
                               autocomplete="off">
                    </span>
          </form>
        </div>
        <div class="navbar-mobile-menu" onclick="">
          <span class="icon-menu cross"><span class="middle"></span></span>
          <ul>
            <li><a href="/archives">归档</a></li>
            <li><a href="/links">友链</a></li>
            <li><a href="/about">关于</a></li>
          </ul>
        </div>
      </div>
    </header>
  </headroom>
</template>
<script>
  import { headroom } from 'vue-headroom'

  export default {
    name:"header",
    components: {
      headroom
    }
  }

</script>
<style>

</style>
