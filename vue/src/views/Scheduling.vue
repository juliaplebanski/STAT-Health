<template>
  <div id="sched-main">
    <booking />
  </div>
</template>

<script>
import Booking from "../components/Booking.vue";

export default {
  components: {
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

