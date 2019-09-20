<template>
<div class="app-breadcrumb">
  山西省垣曲县望仙村村民管理系统<span class="breadBtn">体验版-练手</span>
</div>
</template>

<script>
import {generateTitle} from '@/utils/i18n'

export default {
  created() {
    this.getBreadcrumb()
  },
  data() {
    return {
      levelList: null
    }
  },
  watch: {
    $route() {
      this.getBreadcrumb()
    }
  },
  methods: {
    generateTitle,
    getBreadcrumb() {
      let matched = this.$route.matched.filter(item => item.name)
      const first = matched[0]
      if (first && first.name !== 'dashboard') {
        matched = [{path: '/dashboard', meta: {title: 'dashboard'}}].concat(
          matched
        )
      }
      this.levelList = matched
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" background scoped>
.app-breadcrumb {
  display: inline-block;
  font-size: 18px;
  line-height: 50px;
  margin-left: 10px;
  color: #e6dcdc;
  cursor: text;
  .breadBtn{background: #b4b4bd; font-size: 14px ;padding:0 10px;display: inline-block;height: 30px; line-height: 30px;border-radius: 10px; margin-left: 15px;}
}
</style>
