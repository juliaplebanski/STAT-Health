<template>
  <div id="main">
    <user-sub-nav id="nav" />
    <div id="doc-info">
      <doctor-info id="info" />
    </div>
    <doctor-availability id="dates" />
  </div>
</template>

<script>
import DoctorInfo from "../components/DoctorInfo.vue";
import UserSubNav from "../components/UserSubNav.vue";
import DoctorAvailability from "../components/DoctorAvailability.vue";

export default {
  components: {
    DoctorInfo,
    UserSubNav,
    DoctorAvailability,
  },
};
</script>

<style scoped>
/* div#main {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: 
      "nav dates"
      "info dates";
} */
div#nav {
  /* grid-area: "nav"; */
  margin: 20px;
}
div#doc-info {
  /* grid-area: "info"; */
  margin: 20px 40px 60px 60px;
}
div#dates {
  /* grid-area: "dates"; */
  margin: 40px 40px 60px 60px;
}
</style>
