<template>
  <div id="sched-main">
    <!-- <div id="booking-visit"> -->
    <booking />
    <!-- </div> -->
  </div>
</template>

<script>
// import DoctorInfo from "../components/DoctorInfo.vue";
import Booking from "../components/Booking.vue";

export default {
  components: {
    // DoctorInfo,
    Booking,
  },
};
</script>

<style>
#sched-main {
  display: flex;
  align-content: center;
}
</style>

