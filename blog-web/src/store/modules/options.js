import {getOptions} from '@/api/option';

let loaded = false
const keys = [
  'FootContent1',
  'FootContent2',
  'Announcement',
  'ContentCount',
  'CommentCount',
  'SiteInstallTime',
  'LastActiveTime',
  'SiteUrl',
  'pageSize',
  'SideBarCategoriesCount',
  'hotCategories',
  'SideBarTagsCount',
  'hotTags',
  'friendlyLinks',
  'Author'
];
const options = {
  state: {
    options: {
      FootContent1: "页脚1",
      FootContent2: "页脚2",
      Announcement: "通知公告",
      ContentCount: 0,
      CommentCount: 0,
      SiteInstallTime: '2020-01-01',
      LastActiveTime: '2020-01-01',
      SiteUrl: 'http://localhost:8090/',
      pageSize: 20,
      SideBarCategoriesCount: 5,
      hotCategories: [],
      SideBarTagsCount: 5,
      hotTags: [],
      friendlyLinks: [{title: 'LiuZhenYu', link: 'https://github.com/liuzhenyulive'}],
      Author: 'iBlogs'
    }
  },
  mutations: {
    SET_OPTIONS: (state, options) => {
      state.options = options
    }
  },
  actions: {
    getOptions({commit}) {
      if (loaded)
        return;
      getOptions(keys).then(response => {
        commit('SET_OPTIONS', response.data),
          loaded=true;
      })
    }
  }
}

export default options
