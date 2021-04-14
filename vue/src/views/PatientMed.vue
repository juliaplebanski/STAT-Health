<template>
<div>
    <medications />
    <interaction-search />
</div>
  
</template>

<script>
import Medications from "../components/Medications.vue";
import InteractionSearch from "../components/InteractionSearch.vue";

export default {
    name: "patient-med",
    components: {
    Medications,
    InteractionSearch
  },

}
</script>

<style>

</style>