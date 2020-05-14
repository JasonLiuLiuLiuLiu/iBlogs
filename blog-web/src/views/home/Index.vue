<template>
  <main role="main" class="App-main">
    <div class="Topstory">
      <div class="Topstory-container">
        <div class="Topstory-mainColumn">
          <v-content></v-content>
        </div>
        <side-bar></side-bar>
      </div>
    </div>
  </main>
</template>
<script>
  import SideBar from "./components/SideBar/index"
  import Content from "./components/Content";

  export default {
    name: 'home',
    components: {SideBar, vContent:Content}
  }
</script>
