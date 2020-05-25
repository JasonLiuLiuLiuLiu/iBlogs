import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'

/**
 * hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
 *                                if not set alwaysShow, only more than one route under the children
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noredirect           if `redirect:noredirect` will no redirct in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
  }
 **/
export const constantRouterMap = [
  {path: '/404', component: () => import('@/views/404'), hidden: true},
  {
    path: '',
    component: Layout,
    redirect: '/index/1',
    children: [
      {
        path: 'index/:id?',
        name: 'index',
        component: () => import('@/views/home/index')
      },
      {
        path: 'article/:slug',
        name: 'article',
        component: () => import('@/views/article/index')
      },
      {
        path: ':type/:meta/:id?',
        name: 'meta',
        component: () => import('@/views/home/index')
      }, {
        path: 'archives',
        name: 'archives',
        component: () => import('@/views/home/archives')
      },
      {
        path: 'allTags',
        name: 'allTags',
        component: () => import('@/views/home/allTags')
      },
      {
        path: 'allCategories',
        name: 'allCategories',
        component: () => import('@/views/home/allCategories')
      }]
  }
]

export default new Router({
  mode: 'history', //后端支持可开
  scrollBehavior: () => ({y: 0}),
  routes: constantRouterMap
})

