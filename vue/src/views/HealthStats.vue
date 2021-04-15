<template>
  <div id="health-stats-page">
    <the-header id="header" />
    <div id="health-stats-page-body">
      <h3><i id="heart-icon" class="fa fa-heartbeat"></i> Health Stats</h3>
      <div class="weight">
        <div class="health-stats-photo">
          <h3 id="title-for-weight">View your weight stats below</h3>
          <hr class="solid" />
          <div class="health-stats-photo">
            <div id="weight-graph-description">
              <img
                id="weight-graph"
                src="../assets/weight-graph.png"
                alt="Weight Graph"
              />
              <h3 id="weight-note">A note from your doctor:</h3>
              <p id="weight-graph-text">
                Kevin, you have made great progress over these past 6 months!
                <br />You've lost a total of 20lbs, which now puts you in the
                healthy weight range <br />for your age and height. I believe if
                you continue exercising regularly <br />
                and eating you well you will continue to lose weight and your test
                results will improve. <br />
                Your cholestoral will be within a normal range and your average
                heart rate <br />
                should decrease as well. <br />-Dr. Steve "Coach" Carmichael
              </p>
            </div>
            <h3 id="title-for-weight">
              Keep up to date on your BMI to keep it in a healthy range
            </h3>
            <hr class="solid" />
            <div id="bmi">
              <iframe
                src="https://www.mealpro.net/bmi/?color=34a6b0"
                frameborder="0"
                width="400px"
                height="400px"
                style="max-width: 100%"
                id="bmi-widget"
              ></iframe>
              <img
                id="bmi-range"
                src="../assets/bmi-range.png"
                alt="BMI chart"
              />
            </div>
          </div>
        </div>
      </div>
      <h3 id="title-for-weight">View your latest test results below</h3>
      <hr class="solid" />
      <div id="test-results">
        <h3 id="Cholesterol">Cholesterol</h3>
        <p id="cholesterol-results">
          <img
            id="lipid-test-results"
            src="../assets/lipid-profile-blood.png"
            alt="Lipid test results"
          />
          <br />Based on your latest lipid test, you have elevated lipid levels.
        </p>
        <p id="tips-on-info">
          <img
            id="lipid-test-info"
            src="../assets/lipid-results-info.png"
            alt="Lipid test info"
          />
          <br />
          View this infographic for more information on how to read your lipid
          test results.
        </p>

        <h3 id="HeartRate">Heart Rate</h3>
        <p id="heart-rate-results">
          <img id="ecg" src="../assets/ecg.jpg" alt="ecg results" />
          <br />Based on your latest ECG, your resting heart rate, or RHR, is
          elevated.
        </p>
        <hr class="solid" />
        <p id="heart-rate-info-caption">
          <img
            id="heart-rate-info"
            src="../assets/rhr-info.png"
            alt="heart-rate-info"
          />
          <br />
          View this infographic for more information on how to reduce your RHR,
        </p>
      </div>
      <hr class="solid" />
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
  grid-area: heart;
  color: #46a7ad;
  font-size: 1.5em;
  margin-left: 4%;
  margin-top: 4%;
  margin-bottom: 2%;
}
#weight-graph-description {
  display: grid;
  grid-template-columns: 1fr 2fr;
  grid-template-areas:
    ". weight-note"
    "weight-graph doctor-note";
  margin-left: 20px;
  margin-right: 20px;
}
#bmi {
  grid-area: weight;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: "bmi-widget bmi-range";
  margin-left: 50px;
  margin-top: 50px;
}

#bmi-range {
  grid-area: bmi-range;
  height: 300px;
  width: 600px;
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
#title-for-weight {
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
  
}
#test-results {
  grid-area: weight;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "cholesterol ."
    "cholesterol-caption-and-image tips-on-info"
    "divider divider"
    "heart-rate heart-rate"
    "heart-rate-results heart-rate-info-caption";
  margin-left: 50px;
  margin-top: 50px;
}
#cholesterol-results {
  grid-area: cholesterol-caption-and-image;
}
#tips-on-info {
  grid-area: tips-on-info;
}
#heart-rate-results {
  grid-area: heart-rate-results;
}
#heart-rate-info-caption {
  grid-area: heart-rate-info-caption;
}
</style>