<template>
  <div id="app">
    <router-view v-if="$route.meta.layout === false"/>
    <Layout v-else/>
  </div>
</template>

<script>

import Layout from "@/page/layout";
export default {
  name: 'App',
  components: {
    Layout
  }
}
</script>

<style>
html,body{
  width: 100%;
  height: 100%;
  padding: 0;
  margin: 0;
}
#app {
  height: 100%;
}

</style>
