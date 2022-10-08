<template>
  数据源页面 {{this.$route.query.account}}
</template>

<script>
export default {
  name: "DataSourceView",
  data() {
    return {
      currentUser: {}
    }
  }
}
</script>

<style scoped>

</style>