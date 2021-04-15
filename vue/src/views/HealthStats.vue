<template>
  <div id="health-stats-page">
    <the-header id="header" />
    <div id="h-stats-view">
    <h3><i id="heart-icon" class="fa fa-heartbeat"></i> Health Stats</h3>
    <h5>
       Chart your health progress. Contact the office at
      (555) 555-5555 if you have any questions.
    </h5>
    </div>
    <div class="weight">
      <!-- <div class="health-stats-photo"> -->
        <img
          id="weight-graph"
          src="../assets/weight-graph.png"
          alt="Weight Graph"
        />
        <img id="bmi-range" src="../assets/bmi-range.png" alt="BMI chart" />
        <!-- <p id="bmi-calc">View your BMI calculation below!</p> -->
        <iframe
          src="https://www.mealpro.net/bmi/?color=34a6b0"
          frameborder="0"
          width="400px"
          height="400px"
          style="max-width: 100%"
          id="bmi-widget"
        ></iframe>
      <!-- </div> -->
    </div>
    <the-footer id="footer" />
  </div>
</template>

<script>
import TheHeader from "../components/TheHeader.vue";
import TheFooter from "../components/TheFooter.vue";

export default {
  name: "HealthStats",
  components: {
    TheHeader,
    TheFooter,
  },
};
</script>

<style>
#h-stats-view {
  margin-top: 60px;
  margin-left: 60px;
  margin-bottom: 40px;
  text-align: left;
  font-size: 1.5em;
  font-weight: 600;
  color: #1e3250;
}
#header {
  grid-area: header;
}
#footer {
  grid-area: footer;
}
#heart-icon {
  grid-area: heart;
  color: #46a7ad;
  font-size: 1.5em;
  margin-left: 4%;
  margin-top: 4%;
  margin-bottom: 2%;
}
/* #weight-graph-description {
  display: grid;
  grid-template-columns: 1fr 2fr;
  grid-template-areas:
    ". weight-note"
    "weight-graph doctor-note";
  margin-left: 20px;
  margin-right: 20px;
} */
.weight {
  grid-area: weight;
  display: flex;
  justify-content: space-evenly;
  max-height: 400px;
}
#bmi-range {
  width: 400px;
  margin: 20px;
}
#weight-graph {
  grid-area: weight-graph;
  width: 450px;
  height: 300px;
}
#bmi-widget {
  grid-area: bmi-widget;
  justify-content: center;
  height: 300px;
  width: 600px;
}
/* #title-for-weight {
  font-size: 25px;
  margin-top: 20px;
  margin-left: 20px;
}
#weight-graph-text {
  grid-area: doctor-note;
  color: #1e3250;
  background-color: #b0eaed;
  font-size: 21px;
  padding: 10px;
  border-radius: 10px;
  margin-top: 10px;
  padding-top: 20px;
  margin-right: 20px;
  font-style: italic;
}
#weight-note {
  font-size: 20px;
  grid-area: weight-note;
}
hr.solid {
  grid-area: divider;
  border-top: 5px solid rgb(143, 142, 142);
  margin-left: 10px;
  margin-right: 10px;
}
#Cholesterol {
  grid-area: cholesterol;
  font-style: italic;
}
#lipid-test-results {
  grid-area: lipid-results;
}
#lipid-test-info {
  grid-area: lipid-test-info;
  height: 250px;
  width: 500px;
}
#HeartRate {
  grid-area: heart-rate;
  font-style: italic;
}
#ecg {
  grid-area: ecg;
  height: 250px;
  width: 500px;
  margin-top: 20px;
}
#heart-rate-info {
  grid-area: heart-rate-info;
  height: 300px;
  width: 400px;
  margin: 20px;
} */
#health-stats-page {
  display: grid;
  grid-template-rows: 1fr 4fr 1fr;
  grid-template-areas: 
      "header"
      "weight"
      "footer";
}
</style>