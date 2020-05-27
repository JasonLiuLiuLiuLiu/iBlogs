<template>
  <div class="app-wrapper" :class="classObj">
    <v-header></v-header>
    <app-main></app-main>
    <v-footer></v-footer>
  </div>
</template>

<script>
  import {AppMain, Header, footer} from './components'

  export default {
    name: 'layout',
    components: {
      AppMain,
      vHeader: Header,
      vFooter: footer
    },
    beforeCreate() {
      this.$store.dispatch('getOptions');
    },
    computed: {
      device() {
        return this.$store.state.app.device
      },
      classObj() {
        return {
          mobile: this.device === 'mobile'
        }
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
</style>
