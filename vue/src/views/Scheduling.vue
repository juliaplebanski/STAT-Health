<template>
  <div>
    <user-sub-nav id="nav" />
    <div class="main">
      <doctor-info id="info" />
      <doctor-availability id="dates" />
    </div>
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
div.main {
  display: flex;
  justify-content: flex-start;
}
div#nav {
  margin: 20px;
}
div#info {
  margin: 20px 40px 60px 60px;
}
div#dates {
  margin: 40px 40px 60px 60px;
}
</style>
