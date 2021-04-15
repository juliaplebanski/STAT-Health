<template>
  <div id="visits-home">
    <the-header id="header" />
    <router-link id="book-visit" v-bind:to="{ name: 'scheduling' }"
          >Schedule a Visit</router-link
        >
    <div id="visits-view">
      <div id="visit-message">
        <h3 id="visits-header">
          <i class="fa fa-clinic-medical" id="visits-icon"></i> Visits
        </h3>
        <span>
          Please contact the office at (555) 555-5555 if you have any questions.
        </span>
        <span id="emergency">Call 911 if you have an emergency. </span>
      </div>
      <div id="all-lists">
        <previous-visits />
        <upcoming-visits />
      </div>
    </div>
    <the-footer id="footer" />
  </div>
</template>

<script>
import UpcomingVisits from "../components/UpcomingVisits.vue";
import PreviousVisits from "../components/PreviousVisits.vue";
import TheHeader from "../components/TheHeader.vue";
import TheFooter from "../components/TheFooter.vue";

export default {
  components: { UpcomingVisits, PreviousVisits, TheHeader, TheFooter },

  name: "user-home",
};
</script>
<style>
#header {
  grid-area: header;
}
#visits-view {
  grid-area: uh-view;
}
#footer {
  grid-area: footer;
}
#visits-home {
  display: grid;
  grid-template-rows: 1fr 4fr 1fr;
  grid-template-areas:
    "header"
    "visits-view"
    "footer";
}
#visit-message {
  margin-top: 60px;
  margin-left: 60px;
  margin-bottom: 40px;
  text-align: left;
  font-size: 1.2em;
  font-weight: 600;
  color: #1e3250;
}
#emergency {
  color: rgb(186, 39, 39);
  font-weight: bold;
}
#visits-icon {
  color: #46a7ad;
  font-size: 1.5em;
}
#all-lists {
  display: flex;
  justify-content: space-evenly;
}
</style>
