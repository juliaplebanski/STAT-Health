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
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
}
#body {
    grid-area: body;
    display: flex;
    justify-content: center;
    /* flex-wrap: wrap; */
}
#footer {
  grid-area: footer;
    display: flex;
    align-items: flex-start;
    justify-content: center;
    /* flex-wrap: wrap; */
}
#app {
  display: grid;
  grid-template-rows: 1fr 5fr 1fr;
  grid-template-areas: 
      "header"
      "body"
      "footer";
}
</style>

