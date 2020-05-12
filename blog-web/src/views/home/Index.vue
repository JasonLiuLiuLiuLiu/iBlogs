<template>
  <main role="main" class="App-main">
    <div class="Topstory">
      <div class="Topstory-container">
        <div class="Topstory-mainColumn">
          <display-type></display-type>
          <content-card></content-card>
          <page></page>
        </div>
        <side-bar></side-bar>
      </div>
    </div>
  </main>
</template>
<script>
  import SideBar from "./components/SideBar/index"
  import DisplayType from "./components/DisplayType";
  import ContentCard from "./components/ContentCard";
  import Page from "./components/Page";
  export default {
    name:'home',
    components: {SideBar, Page, ContentCard, DisplayType},
    comments:{SideBar,DisplayType,ContentCard,Page}
  }
</script>
