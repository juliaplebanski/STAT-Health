<template>
  <div id="main">
    <img 
      src="../assets/stat logo.png"
      class="logo-img-top"
      alt="Logo"
    />
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''"
        >Login</router-link
      >
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
  </div>
</template>

<script>
export default {
  name: "the-header",
};
</script>

<style>
div#main{
  display: flex;
  justify-content: space-between;

}
img {
  height: 150px;
  width: auto;
}
</style>