<template>
  <div>
    <div class="main-content page-page" itemscope itemtype="http://schema.org/Article">
      <div class="post-header">
        <h1 class="post-title" itemprop="name headline">
          <a :href="'/article/'+(content.slug&&content.slug!=null?encodeURIComponent(content.slug):content.id)">{{content.title}}</a>
        </h1>
        <div class="post-data">
          <time :datetime="content.created|formatDate" itemprop="datePublished">发布于 {{content.created|formatDate}}</time>
          / <span v-html="showCategory(content.categories)"></span> / <a href="#comments">{{content.commentsNum==0?'没有评论':content.commentsNum+'条评论'}}</a>
          / {{content.hits}} 浏览
        </div>
      </div>
      <div id="post-content" class="post-content" itemprop="articleBody">
        <p class="post-tags"><span v-html="showTag(content.tags)"></span></p>
        <a></a>
        <span v-html="content.content"></span>
        <p class="post-info">
          本文由 <a href="">{{content.author==null||content.author==''?this.$store.state.options.options.Author:content.author}}</a> 创作，采用 <a
          href="https://creativecommons.org/licenses/by/4.0/" target="_blank"
          rel="external nofollow">知识共享署名4.0</a> 国际许可协议进行许可<br>本站文章除注明转载/出处外，均为本站原创或翻译，转载前请务必署名<br>最后编辑时间为:
          {{content.modified|formatDate}}
        </p>
      </div>
    </div>
  </div>

</template>
<script>
  import {index} from "../../../api/content";
  import {dateFormat} from "../../../utils/dateUtils";

  export default {
    name: 'Article',
    data() {
      return {
        content: {
          author: null,
          categories: "默认分类",
          commentsNum: 0,
          content: "",
          created: "2019-09-11T05:13:00.028+0000",
          hits: 22,
          id: 1,
          modified: "2019-10-10T00:37:38.725+0000",
          slug: "about",
          tags: null,
          thumbImg: null,
          title: "关于",
        }
      }
    },
    created() {
      var slug = this.$route.params.slug;
      this.getContent(slug);
    },
    filters: {
      formatDate(time) {
        const date = new Date(time);
        return dateFormat(date, 'yyyy-MM-dd');
      }
    },
    methods: {
      getContent(url) {
        index(encodeURIComponent(url)).then(response => {
          this.content = response.data
          this.$store.dispatch('getOptions',response.data)
        })
      },
      showCategory(categories) {
        if (categories) {
          let arr = categories.split(',');
          let sbuf = "";
          for (const s in arr) {
            sbuf += "<a href=\"/category/" + encodeURIComponent(arr[s]) + "\">" + arr[s] + "</a>";
          }
          return sbuf;
        }
        return this.showCategory("默认分类");
      },
      showTag(tags) {
        if (tags) {
          let arr = tags.split(',');
          let sbuf = "";
          for (const c in arr) {
            sbuf += "<a href=\"/tag/" + encodeURIComponent(arr[c]) + "\">" + arr[c] + "</a>";
          }
          return sbuf;
        }
        return "";
      }
    }
  }
</script>
<style>

</style>
