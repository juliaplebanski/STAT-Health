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
#main {
  display: flex;
  flex-direction: column;
}

</style>

