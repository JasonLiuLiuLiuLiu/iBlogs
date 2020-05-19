import Cookies from 'js-cookie'

const app = {
  state: {
    sidebar: {
      weChatOpen: false,
      opened: !+Cookies.get('sidebarStatus'),
      withoutAnimation: false
    },
    device: 'desktop'
  },
  mutations: {
    TOGGLE_SIDEBAR: state => {
      if (state.sidebar.opened) {
        Cookies.set('sidebarStatus', 1)
      } else {
        Cookies.set('sidebarStatus', 0)
      }
      state.sidebar.opened = !state.sidebar.opened
    },
    TOGGLE_WECHAT: (state, open) => {
      state.sidebar.weChatOpen = open
    },
    CLOSE_SIDEBAR: (state, withoutAnimation) => {
      Cookies.set('sidebarStatus', 1)
      state.sidebar.opened = false
      state.sidebar.withoutAnimation = withoutAnimation
    },
    TOGGLE_DEVICE: (state, device) => {
      state.device = device
    }
  },
  actions: {
    ToggleSideBar: ({commit}) => {
      commit('TOGGLE_SIDEBAR')
    },
    ToggleWeChat: ({commit},open) => {
      commit('TOGGLE_WECHAT',open)
    },
    CloseSideBar({commit}, {withoutAnimation}) {
      commit('CLOSE_SIDEBAR', withoutAnimation)
    },
    ToggleDevice({commit}, device) {
      commit('TOGGLE_DEVICE', device)
    }
  }
}

export default app
