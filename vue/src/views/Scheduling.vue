<template>
  <div id="main">
    <div id="info">
    <doctor-info />
    </div>
    <div id="booking">
    <booking />
    </div>
  </div>
</template>

<script>
import DoctorInfo from "../components/DoctorInfo.vue";
import Booking from "../components/Booking.vue";

export default {
  components: {
    DoctorInfo,
    Booking,
  },
};
</script>

<style>
#booking {
  grid-area: booking;
  
}
#info {
  grid-area: info;
}
#main {
  display: grid;
  grid-template-columns: 1fr 2fr ;
  grid-template-areas: 
  "info booking";
  /* ". booking"; */
}


</style>

