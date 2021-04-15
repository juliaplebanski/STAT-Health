<template>
  <div id="sched-main">
    <the-header id="header" />
    <div id="patient-message">
      <h3><i id="med-visit-icon" class="fa fa-clinic-medical"></i> Schedule a Visit</h3>
      <h5>If you need to schedule a visit more than 2 weeks in advance, please call the office at (555) 555-5555.</h5>
    </div>
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
  margin-left: 10%;
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
#patient-message {
  margin-top: 60px;
  margin-left: 60px;
  margin-bottom: 40px;
  text-align: left;
  font-size: 1.2em;
  font-weight: 600;
  color: #1e3250;
}
#med-visit-icon {
  color: #46a7ad;
  font-size: 1.5em;
}
</style>

