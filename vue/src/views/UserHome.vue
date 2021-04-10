<template>
  <div class="home">
    <user-sub-nav id="nav" />
    <doctor-info />
    <upcoming-visits />
  </div>
</template>

<script>

import UpcomingVisits from '../components/UpcomingVisits.vue';
import DoctorInfo from '../components/DoctorInfo.vue';
import UserSubNav from "../components/UserSubNav.vue";
export default {
  components: { UpcomingVisits, DoctorInfo, UserSubNav },

  name: "user-home"
};
</script>