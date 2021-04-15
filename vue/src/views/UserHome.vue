<template>
  <div id="uh-home">
    <the-header id="header"/>
    <router-link id="book-visit" v-bind:to="{ name: 'scheduling' }"
      >Schedule a Visit</router-link
    >
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
</style>
