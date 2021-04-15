<template>
  <div id="pat-med-main">
    <the-header />
    <div id="pat-med-view">
      <medications />
    </div>
    <the-footer />
  </div>
</template>

<script>
import Medications from "../components/Medications.vue";
import TheHeader from "../components/TheHeader.vue";
import TheFooter from "../components/TheFooter.vue";

export default {
  name: "patient-med",
  components: {
    Medications,
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
  grid-template-rows: 1fr 4fr 1fr;
  grid-template-areas:
    "header"
    "pat-med-view"
    "footer";
}
</style>