<template>
  <div>
    <form id="med-search">
    <label>Search for Drug Interactions:</label>
    <input type="text" name="drug" v-model="drugName"/>
    <button class="btn btn-submit">Submit</button>
    </form>
  </div>
</template>

<script>

export default {
  name: "interaction-search",
  data() {
    return {
      drugName: "",
  
    };
  },
  methods: {
    getInteractions() {
      fetch(
        "https://rxnav.nlm.nih.gov/REST/interaction/interaction.xml?rxcui=?&sources=sources"
      )
        .then((response) => {
          if (response.status !== 200) {
            console.log(
              "Looks like there was a problem. Status Code: " + response.status
            );
            return;
          }
          // Examine the text in the response
          response.json().then((data) => {
            console.log(data);
            this.medLookup = data;
          });
        })
        .catch((err) => {
          console.log("Fetch Error", err);
        });
    },
  },
};
</script>

<style>
</style>