<template>
  <div id="sched-main">
    <div id="booking-visit">
    <booking />
    </div>
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

/* #booking-visit {
  grid-area: booking;
  
}
#info {
  grid-area: info;
}
#sched-main {
  display: grid;
  grid-template-columns: 1fr 2fr ;
  grid-template-areas: 
  "info booking";
  
} */


</style>

