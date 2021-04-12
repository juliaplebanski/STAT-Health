<template>
  <div id="header">
    <img id="logo" src="../assets/logo_stat.png" alt="Logo" />
    <div id="usernav">
      <nav v-if="$store.state.token != ''">
        <ul class="nav nav-pills">
        <li class="nav-item"><i class="fa fa-clinic-medical"></i> <a href="#">Visits</a></li> &nbsp;&nbsp;&nbsp; 
        <li class="nav-item"><i class="fa fa-syringe"></i> <a href="#">Test Results</a></li> &nbsp;&nbsp;&nbsp;
        <li class="nav-item"><i class="fa fa-prescription-bottle"></i> <a href="#">Medications</a></li> &nbsp;&nbsp;&nbsp;
        <li class="nav-item"><i class="fa fa-clipboard-list"></i> <a href="#">Billing & Insurance</a></li>
        </ul>
      </nav>
    </div>
    <div id="nav">
      <router-link class="links" v-bind:to="{ name: 'home' }" v-if="$store.state.token == ''"><i class="fa fa-home"></i> Home </router-link> 
      <router-link class="links" v-bind:to="{ name: 'user-home' }" v-if="$store.state.token != ''"><i class="fa fa-home"> </i> Home </router-link> 
      <router-link class="links" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''"
        >Sign In</router-link
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
  data() {
    return {
      user: this.$store.state.user
    }
  }
};
</script>

<style>
#nav {
  align-self: center;
  color: white;
  margin: 0px 20px 0px 0px;
}
#usernav {
  align-self: center;
  color: white;
  margin: 0px 20px 0px 0px;
}
#header {
  display: flex;
  justify-content: space-between;
  font-size: 1.4em;
  border-bottom: 20px solid #3863a0;
  height: 150px;
  background-color: #46a7ad;
}
.links {
  color: white;
  margin: 10px;
}
.fa  {
  color:white !important;
}
.nav-item {
  margin: 15px;
}
</style>