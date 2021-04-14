<template>
  <div id="pat-med-main">
    <the-header />
    <div id="pat-med-view">
      <medications />
      <interaction-search />
    </div>
    <the-footer />
  </div>
</template>

<script>
import Medications from "../components/Medications.vue";
import InteractionSearch from "../components/InteractionSearch.vue";
import TheHeader from "../components/TheHeader.vue";
import TheFooter from "../components/TheFooter.vue";

export default {
  name: "patient-med",
  components: {
    Medications,
    InteractionSearch,
    TheFooter,
    TheHeader,
  },
};
</script>

<style>
#header {
  grid-area: header;
}
#pat-med-view {
  margin-top: 50px;
  margin-bottom: 50px;
  grid-area: pat-med-view;
  display: flex;
  align-content: center;
}
#footer {
  grid-area: footer;
}
#pat-med-main {
  display: grid;
  grid-template-rows: 1fr 5fr 1fr;
  grid-template-areas:
    "header header header"
    "pat-med-view pat-med-view pat-med-view"
    "footer footer footer";
}
</style>