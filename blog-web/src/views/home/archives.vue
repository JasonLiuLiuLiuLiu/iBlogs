<template>
  <main role="main" class="App-main">
    <div class="Topstory">
      <div class="Topstory-container">
        <div class="Topstory-mainColumn">
          <div class="Card Topstory-noMarginCard Topstory-tabCard">
            <nav class="TopstoryTabs Topstory-tabs">

                        <span class="TagsHeader">
                            <svg class="Zi Zi--Live" fill="currentColor" style="color: rgb(0, 132, 255);"
                                 viewBox="0 0 512 512" width="24" height="24">
                                <g><path
                                  d="m461 145c0-27.123-19.737-49.724-45.602-54.197-4.516-34.267-33.917-60.803-69.398-60.803-5.638 0-11.243.742-16.981 2.257-19.008-20.581-45.257-32.257-73.019-32.257-52.051 0-94.941 39.975-99.583 90.836-25.774 4.548-45.417 27.106-45.417 54.164 0 1.678.08 3.345.229 5h-50.229c-5.523 0-10 4.477-10 10v252c0 2.731 1.158 5.301 2.929 7.071l90 90c1.826 1.826 4.373 2.929 7.071 2.929h150c5.523 0 10-4.477 10-10v-111c0-5.523-4.477-10-10-10s-10 4.477-10 10v101h-130v-80c0-5.523-4.477-10-10-10h-80v-232h46.015c9.289 18.196 28.158 30 48.985 30h125v101c0 5.523 4.477 10 10 10s10-4.477 10-10v-101h95c30.327 0 55-24.673 55-55zm-320 277v55.858l-55.858-55.858zm265-242h-240c-19.224 0-35-15.601-35-35 0-19.299 15.701-35 35-35 5.523 0 10-4.477 10-10 0-44.112 35.888-80 80-80 23.954 0 46.539 10.947 61.962 30.035 2.677 3.313 7.16 4.565 11.166 3.124 5.903-2.126 11.422-3.159 16.872-3.159 27.57 0 50 22.43 50 50 0 5.523 4.477 10 10 10 19.299 0 35 15.701 35 35s-15.701 35-35 35z"/><path
                                  d="m241 276h-120c-5.523 0-10 4.477-10 10s4.477 10 10 10h120c5.523 0 10-4.477 10-10s-4.477-10-10-10z"/>
<path d="m241 336h-120c-5.523 0-10 4.477-10 10s4.477 10 10 10h120c5.523 0 10-4.477 10-10s-4.477-10-10-10z"/><circle
                                    cx="301" cy="346" r="10"/></g>
                            </svg>
                            &nbsp 文章归档
                        </span>
            </nav>
          </div>
          <div id="TopstoryContent" class="Topstory-content">
            <div class="ListShortcut">
              <div class="Topstory-hot HotList" v-for="(archive,index) in list">

                <section class="HotItem">
                  <div class="HotItem-index">
                    <div class="HotItem-rank" :class=" index<4?'HotItem-hot':''">{{index}}
                    </div>
                  </div>
                  <div class="HotItem-content">
                    <a :href="'/archive/'+encodeURIComponent(archive.date)" :title="archive.date|formatDate">
                      <h2 class="HotItem-title">{{archive.date|formatDate}}</h2>
                    </a>
                    <div class="HotItem-metrics">
                      <svg class="Zi Zi--Hot" fill="currentColor" viewBox="0 0 24 24" width="18" height="18">
                        <path fill="url(#id-2014200654-a)"
                              d="M14.553 20.78c.862-.651 1.39-1.792 1.583-3.421.298-2.511-.656-4.904-2.863-7.179.209 2.291.209 3.73 0 4.314-.41 1.143-1.123 1.983-1.91 2.03-1.35.079-2.305-.512-2.863-1.774-.676 1.25-.782 2.556-.318 3.915.31.906.94 1.684 1.89 2.333C7.144 20.131 5 17.336 5 14.022c0-2.144.898-4.072 2.325-5.4.062 2.072.682 3.598 2.13 4.822-.67-1.112-.734-2.11-.734-3.517 0-3.253 2.067-6.007 4.913-6.927a7.35 7.35 0 0 0 2.157 4.918C17.722 9.214 19 11.463 19 14.022c0 3.073-1.844 5.7-4.447 6.758z"
                              fill-rule="evenodd"></path>
                      </svg>
                      热度: {{archive.count}}
                      <span class="HotItem-action">
                                                    <div class="Popover ShareMenu">
                                                        <div class="ShareMenu-toggler" id="Popover5-toggle"
                                                             aria-haspopup="true" aria-expanded="false"
                                                             aria-owns="Popover5-content">
                                                            <button type="button"
                                                                    class="Button Button--plain Button--withIcon Button--withLabel">
                                                                <span
                                                                  style="display: inline-flex; align-items: center;">
                                                                    <svg class="Zi Zi--Share Button-zi"
                                                                         fill="currentColor" viewBox="0 0 24 24"
                                                                         width="1.2em" height="1.2em">
                                                                        <path
                                                                          d="M2.931 7.89c-1.067.24-1.275 1.669-.318 2.207l5.277 2.908 8.168-4.776c.25-.127.477.198.273.39L9.05 14.66l.927 5.953c.18 1.084 1.593 1.376 2.182.456l9.644-15.242c.584-.892-.212-2.029-1.234-1.796L2.93 7.89z"
                                                                          fill-rule="evenodd"></path>
                                                                    </svg>
                                                                </span>详情
                                                            </button>
                                                        </div>
                                                    </div>
                                                </span>
                    </div>
                  </div>
                </section>
              </div>
            </div>
          </div>
        </div>
        <side-bar></side-bar>
      </div>
    </div>
  </main>
</template>
<script>
  import SideBar from "./components/SideBar/index"
  import {archives} from "@/api/content.js"
  import {dateFormat} from "../../utils/dateUtils";

  export default {
    name: 'archives',
    data() {
      return {
        list: []
      }
    },
    filters: {
      formatDate(time) {
        const date = new Date(time);
        return dateFormat(date, 'yyyy-MM-dd');
      }
    },
    created() {
      archives().then(response => {
        this.list = response.data
      })
    },
    components: {SideBar}
  }
</script>
