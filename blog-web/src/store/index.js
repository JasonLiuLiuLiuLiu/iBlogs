import Vue from 'vue'
import Vuex from 'vuex'
import app from './modules/app'
import options from "./modules/options";
import content from "./modules/content";
import getters from './getters'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    app,
    options,
    content
  },
  getters
})

export default store
