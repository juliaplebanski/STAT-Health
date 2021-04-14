<template>
  <div id="health-stats-page">
    <the-header id="header" />
    <h3><i id="heart-icon" class="fa fa-heartbeat"></i> Health Stats</h3>
    <div class="weight">
      
      <div class="health-stats-photo">
          <div class="health-stats-photo">
        <img
          id="weight-graph"
          src="../assets/weight-graph.png"
          alt="Weight Graph"
        />
        <img id="bmi-range" src="../assets/bmi-range.png" alt="BMI chart" />
<p>View your BMI calculation below!</p>
      <iframe
        src="https://www.mealpro.net/bmi/?color=34a6b0"
        frameborder="0"
        width="400px"
        height="400px"
        style="max-width: 100%"
        id="bmi-widget"
      ></iframe>
       </div>
      </div>
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
#heart-icon {
  color: #46a7ad;
  font-size: 1.5em;
}
.weight {
  height: 20%;
  width: 100%;
  display: flex;
  flex-direction: row;
}

#bmi-range {
  width: 600px;
  height: 400px;
}
#weight-graph {
  width: 600px;
  height: 400px;
}
P{
  font-style: italic;
  align-items: center;
}
#bmi-widget{
justify-content: center;
height: 535px;
width: 150%;

}
</style>