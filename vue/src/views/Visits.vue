<template>
  <div id="visits-home">
    <the-header id="header"/>
    <div id="visits-view">
    <upcoming-visits />
    <previous-visits />
    </div>
    <the-footer id="footer"/>
  </div>
</template>

<script>

import UpcomingVisits from '../components/UpcomingVisits.vue';
import PreviousVisits from '../components/PreviousVisits.vue';
import TheHeader from '../components/TheHeader.vue';
import TheFooter from '../components/TheFooter.vue';

export default {
  components: { UpcomingVisits, PreviousVisits, TheHeader, TheFooter },

  name: "user-home"
};
</script>
<style>
#header {
  grid-area: header;
}
#visits-view {
  margin-top: 50px;
  margin-bottom: 50px;
  grid-area: uh-view;
  display:flex;
  justify-content: space-evenly;
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

</style>
