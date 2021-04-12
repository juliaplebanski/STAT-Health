<template>
  <div class="home">
    <doctor-info />
    <upcoming-visits />
  </div>
</template>

<script>

import UpcomingVisits from '../components/UpcomingVisits.vue';
import DoctorInfo from '../components/DoctorInfo.vue';
export default {
  components: { UpcomingVisits, DoctorInfo },

  name: "user-home"
};
</script>
<style>
.home {
display:flex;
justify-content: space-evenly;
}
</style>
