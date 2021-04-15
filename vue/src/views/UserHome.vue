<template>
  <div id="uh-home">
    <the-header id="header"/>
    <router-link id="book-visit" v-bind:to="{ name: 'scheduling' }"
      >Schedule a Visit</router-link
    >
    <div id="user-home-message">
        <h3 id="user-home-header">
          <i class="fa fa-home" id="user-home-icon"></i> Home
        </h3>
        <span>
          Please contact the office at (555) 555-5555 if you have any questions.
        </span>
        <span id="emergency">Call 911 if you have an emergency. </span>
      </div>
    <div id="uh-view">
    <doctor-info />
    <upcoming-visits />
    </div>
    <the-footer id="footer"/>
  </div>
</template>

<script>

import UpcomingVisits from '../components/UpcomingVisits.vue';
import DoctorInfo from '../components/DoctorInfo.vue';
import TheHeader from '../components/TheHeader.vue';
import TheFooter from '../components/TheFooter.vue';

export default {
  components: { UpcomingVisits, DoctorInfo, TheHeader, TheFooter },

  name: "user-home"
};
</script>
<style>
#header {
  grid-area: header;
}
#uh-view {
  margin-top: 10%;
  margin-bottom: 50px;
  grid-area: uh-view;
  display:flex;
  justify-content: space-evenly;
}
#footer {
  grid-area: footer;
}
#uh-home {
  display: grid;
  grid-template-rows: 1fr 4fr 1fr;
  grid-template-areas: 
      "header"
      "uh-view"
      "footer";
}
#book-visit {
  float: right;
  margin-right: 5%;
  margin-top: 3%;
  margin-right: 5%;
}
#user-home-message {
  margin-top: 60px;
  margin-left: 60px;
  margin-bottom: 40px;
  text-align: left;
  font-size: 1.2em;
  font-weight: 600;
  color: #1e3250;
}
#user-home-icon {
   color: #46a7ad;
  font-size: 1.5em;
}
</style>
