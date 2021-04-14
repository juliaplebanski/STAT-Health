<template>
  <div id="header">
    <img id="logo" src="../assets/logo_stat.png" alt="Logo" />
    <div id="usernav">
      <nav v-if="$store.state.token != ''">
        <ul class="nav nav-pills">
        <li class="nav-item"><i class="fa fa-clinic-medical" id="visit-icon"></i><a href="#" class="links">Visits</a></li> &nbsp;&nbsp;&nbsp; 
        <li class="nav-item"><i class="fa fa-syringe" id="results-icon"></i><a href="#" class="links">Test Results</a></li> &nbsp;&nbsp;&nbsp;
        <li class="nav-item"><router-link class="links" v-bind:to="{ name: 'patient-med' }"><i class="fa fa-prescription-bottle" id="meds-icon"></i>Medications</router-link></li> &nbsp;&nbsp;&nbsp;
        <li class="nav-item"><i class="fa fa-clipboard-list" id="billing-icon"></i><a href="#" class="links">Billing & Insurance</a></li>
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
        class="links"
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
  margin: 0px 10px 0px 0px;
}
#header {
  display: flex;
  justify-content: space-between;
  font-size: 1.4em;
  border-bottom: 20px solid #4674ad;
  height: 150px;
  background-color: #46a7ad;
}
.links {
  color: white;
  margin: 10px;
}
#visit-icon, #results-icon, #meds-icon, #billing-icon  {
  color:white;
}
#meds-icon {
  margin-right: 7px;
}
.nav-item {
  margin: 15px;
}
</style>