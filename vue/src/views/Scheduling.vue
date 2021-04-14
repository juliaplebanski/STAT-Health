<template>
  <div id="sched-main">
    <the-header id="header" />
    <div id="booking-view">
      <booking />
    </div>
    <the-footer id="footer" />
  </div>
</template>

<script>
import Booking from "../components/Booking.vue";
import TheHeader from "../components/TheHeader.vue";
import TheFooter from "../components/TheFooter.vue";

export default {
  components: {
    Booking,
    TheHeader,
    TheFooter,
  },
};
</script>

<style>
#header {
  grid-area: header;
}
#booking-view {
  grid-area: b-view;
  margin-top: 50px;
  margin-bottom: 50px;
  display: flex;
  align-content: center;
}
#footer {
  grid-area: footer;
}
#sched-main {
  display: grid;
  grid-template-rows: 1fr 6fr 1fr;
  grid-template-areas:
    "header"
    "b-view"
    "footer";
}
</style>

