<template>
  <main role="main" class="App-main">
    <div class="Topstory">
      <div class="Topstory-container">
        <div class="Topstory-mainColumn" v-if="!loading&&data!=null">
          <v-content :display-type="displayType" :display-meta="displayMeta" :order-type="orderType"
                     :data="data"></v-content>
        </div>
        <side-bar v-if="!loading&&data!=null"></side-bar>
      </div>
    </div>
  </main>
</template>
<script>
  import SideBar from "./components/SideBar/index"
  import Content from "./components/Content";
  import {archive, category, tag, page, search} from '@/api/content'

  export default {
    name: 'home',
    components: {SideBar, vContent: Content},
    data() {
      return {
        displayType: 'index',
        displayMeta: '',
        orderType: '',
        data: [],
        loading: true,
      }
    },
    created() {
      this.$store.dispatch('getOptions').then(() => {
        let pageNum = this.$route.params.id;
        let pageSize = this.$store.state.options.options.pageSize;
        if (!pageNum) {
          pageNum = 1;
        }
        if (!this.$route.params.type) {
          this.getContents(pageNum, pageSize);
        } else {
          let displayType = this.$route.params.type;
          let meta = this.$route.params.meta;
          this.displayType = displayType;
          this.displayMeta = meta;
          if (displayType === 'category') {
            this.byCategory(pageNum, pageSize)
          } else if (displayType === 'archive') {
            this.displayMeta = Number(this.$route.params.meta);
            this.byArchive(pageNum, pageSize)
          } else {
            this.byTag(pageNum, pageSize)
          }
        }
        this.loading = false;
      });
    },
    methods: {
      getContents(pageNum, pageSize) {
        page(pageNum, pageSize).then(response => {
          this.data = response.data;
        });
      },
      byCategory(pageNum, pageSize) {
        category(this.displayMeta, pageNum, pageSize).then(
          response => {
            this.data = response.data;
          }
        )
      },
      byTag(pageNum, pageSize) {
        tag(this.displayMeta, pageNum, pageSize).then(
          response => {
            this.data = response.data;
          }
        )
      },
      byArchive(pageNum, pageSize) {
        archive(this.displayMeta, pageNum, pageSize).then(
          response => {
            this.data = response.data;
          }
        )
      }
    }
  }
</script>
