<template>
  <div id="app">
    <the-header id="header"/>
    <router-view id="body"/>
    <the-footer id="footer"/> 
  </div>
</template>

<script>
import TheHeader from './components/TheHeader.vue';
import TheFooter from './components/TheFooter.vue';

export default{
  name: 'App',
  components:{
    TheHeader,
    TheFooter
  }
}
</script>

<style>
#header {
  grid-area: header;
}
#body {
    grid-area: body;

}
#footer {
  grid-area: footer;
}
#app {
  display: grid;
  grid-template-rows: 1fr 4fr 1fr;
  grid-template-areas: 
      "header"
      "body"
      "footer";
}
</style>

