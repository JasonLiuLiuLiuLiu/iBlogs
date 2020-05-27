<template>
  <div>
    <v-article></v-article>
    <share></share>
    <comment></comment>
  </div>
</template>

<script>
  import Article from "./components/Article";
  import Comment from "./components/Comment";
  import Share from "./components/Share";

  export default {
    name: 'article',
    components: {Comment, Share, vArticle: Article}
  }
</script>

<style>

</style>
