<template>
  <div id="home-page">
    <div class="container">
      <p class="emergency">
        IF THIS IS AN EMERGENCY <br />
        PLEASE DIAL 9-1-1 <i class="fa fa-ambulance" id="emergency_icon"></i>
      </p>

      <h2 id="slogan">Making Healthcare Better, Together</h2>

      <h3 id="scheduling-section">Schedule the care you need</h3>
      <div class="icon-information">
        <nav class="information-nav">
          <div id="Visit">
            <i class="fa fa-clinic-medical"></i>
            <p class="details">Visits</p>
            &nbsp;&nbsp;
            <p class="description">
              View past visits, <br />
              view upcoming visits, <br />
              and schedule a visit.
            </p>
          </div>

          <div id="Test-Results">
            <i class="fa fa-syringe"></i>
            <p class="details">Test Results</p>
            &nbsp;&nbsp;
            <p class="description">
              View past test result information, <br />
              directly sent from your doctor.
            </p>
          </div>
          <div id="Medications">
            <i class="fa fa-prescription-bottle"></i>
            <p class="details">Medications</p>
            &nbsp;&nbsp;
            <p class="description">
              View current prescriptions, <br />
              and request refills.
            </p>
          </div>

          <div id="Billing-Insurance">
            <i class="fa fa-clipboard-list"></i>
            <p class="details">Billing & Insurance</p>
            <p class="description">
              View your bill and pay, <br />
              for a recent visit as well as see what <br />
              services your insurance covers.
            </p>
          </div>
          <p id = "widget-header"> See what you need before booking an appointment</p>
          <iframe
            src="https://www.health.gov/myhealthfinder?widget=true"
            name="myhealthfinderframe"
            frameborder="0"
            id="myhealthfinderframe"
            scrolling="yes"
            height="485"
            width="100%"
            marginheight="0"
            title="myhealthfinder widget"
            marginwidth="0"
            ><p>Your browser does not support iframes.</p></iframe
          >
          <div
            class="bingwidget"
            data-type="covid19"
            data-market="en-us"
            data-language="en-us"
            data-app="bingwidget"
          ></div>
        </nav>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>
<style>
#home-page {
  width: 100%;
  height: auto;
  margin: 0px;
  padding: 0px;
  overflow-x: hidden;
}
.container {
  padding: 0px;
  margin: 0px;
  border: 0px;
  display: grid;
  grid-template-columns: 1fr 1f 1fr 1fr;
  grid-template-areas:
    ". . . emergency"
    ". slogan slogan ."
    "scheduling-section . . ."
    "icon-information icon-information icon-information icon-information";
}

.icon-information {
  grid-area: icon-information;
  color: #46a7ad;
  background-color: white;
  font-size: 20px;
}

.emergency {
  grid-area: emergency;
  font-size: 15px;
  color: red;
  font-weight: bold;
}

#emergency_icon {
  font-size: 25px;
  margin-left: 12px;
}
#slogan {
  grid-area: slogan;
  font-style: italic;
  color: #1e3250;
}

#scheduling-section {
  grid-area: scheduling-section;
  font-style: italic;
  color:#1e3250
}
#Visit {
  grid-area: visit;
  display: flex;
  flex-direction: column;
  padding: 10px;
  margin: 10px;
  border-style: solid;
  border-color: #46a7ad;
  border-width: 7px;
  border-radius: 10px;
  float: left;
  width: 25%;
}
#Test-Results {
  grid-area: test-results;
  display: flex;
  flex-direction: column;
  padding: 10px;
  margin: 10px;
  border-style: solid;
  border-color: #46a7ad;
  border-width: 7px;
  border-radius: 10px;
  float: left;
  width: 25%;
}
#Medications {
  grid-area: medications;
  display: flex;
  flex-direction: column;
  padding: 10px;
  margin: 10px;
  border-style: solid;
  border-color: #46a7ad;
  border-width: 7px;
  border-radius: 10px;
  float: left;
  width: 25%;
}
#Billing-Insurance {
  grid-area: billing-insurance;
  display: flex;
  flex-direction: column;
  padding: 10px;
  margin: 10px;
  border-style: solid;
  border-color: #46a7ad;
  border-width: 7px;
  border-radius: 10px;
  float: left;
  width: 17%;
}
.description {
  color: #1e3250;
  font-size: 12px;
}
#myhealthfinderframe {
  padding-bottom: 20px;
}
#widget-header {
  color:#1e3250;
  padding-left: 10px;
  font-weight: bold;
}
</style>


