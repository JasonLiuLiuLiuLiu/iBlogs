<template>
  <div class="GlobalSideBar" data-za-detail-view-path-module="RightSideBar">
    <div>
      <div class="Sticky">
        <Blog></Blog>
        <WeChat id="WeChat" :style="{display:this.$store.state.app.sidebar.weChatOpen?'':'none'}"></WeChat>
        <Menu></Menu>
        <notice></notice>
        <SiteInfo></SiteInfo>
        <Category></Category>
        <tag></tag>
        <Link></Link>
      </div>
    </div>
  </div>
</template>
<script>
  import Blog from './Blog'
  import Menu from './Menu'
  import Notice from './Notice'
  import SiteInfo from './SiteInfo'
  import Tag from './Tag'
  import Category from './Category'
  import Link from './Link'
  import WeChat from "./WeChat";

  export default {
    name:"SideBar",
    components: {Notice, Link, Tag, Category, SiteInfo, Menu, Blog, WeChat},
    comments: {Blog, Menu, Notice, SiteInfo, Tag, Category, Link, WeChat}
  }
</script>
<style>

</style>
