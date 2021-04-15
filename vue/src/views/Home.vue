<template>
  <div id="home-page">
    <the-header id="header" />

    <div class="container">
      <!-- <p class="emergency">
        IF THIS IS AN EMERGENCY <br />
        PLEASE DIAL 9-1-1 <i class="fa fa-ambulance" id="emergency_icon"></i>
      </p> -->
      <div class="picture-and-slogan">
        <img
          id="doctor-picture"
          src="../assets/doctor_image.jpg"
          alt="Picture of doctor"
        />
        <h2 id="slogan">
          Making Healthcare Better, <br />
          <em>Together</em>
        </h2>
      </div>
      <h3 id="scheduling-section">Schedule the care you need</h3>
      <div class="icon-information">
        <nav class="information-nav">
          <div id="Visit">
            <i class="fa fa-clinic-medical"></i>
            <p class="details">Visits</p>

            <p class="description">
              View past visits, <br />
              view upcoming visits, <br />
              and schedule a visit
            </p>
          </div>

          <div id="Health-Stats">
            <i class="fa fa-heartbeat"></i>
            <p class="details">Health Stats</p>

            <p class="description" id="health-stats-description">
              View important information on <br />
              how your health has changed over time <br />
            </p>
          </div>
          <div id="Medications">
            <i class="fa fa-prescription-bottle"></i>
            <p class="details">Medications</p>

            <p class="description">
              View current prescriptions <br />
              and request refills
            </p>
          </div>

          <div id="Billing-Insurance">
            <i class="fa fa-clipboard-list"></i>
            <p class="details">Billing & Insurance</p>
            <p class="description" id="billing-insurance-description">
              View and pay your bill <br />
              for a recent visit and see what <br />
              services your insurance covers
            </p>
          </div>
        </nav>
      </div>

      <div class="carousel" id="photo-caption">
        <h3 id="news-section">Keep up to date on the latest health news</h3>
        <div class="news">
          <img
            class="covid-map"
            src="../assets/nbc_news_covid_map.png"
            alt="COVID map"
          />
          <p id="covid-map">
            MAP: Covid-19 vaccination tracker across the U.S.
            <a
              href="https://www.nbcnews.com/health/health-news/map-covid-19-vaccination-tracker-across-u-s-n1252085"
              target="_blank"
              ><br />Link to article</a
            >
          </p>

          <img
            class="quarentine"
            src="../assets/nbc_news_quarentine.png"
            alt="quarentine"
          />

          <p id="quarentine-caption">
            Covid vaccines mean the end of quarantine is in sight.<br />
            For some, the view doesn't look so good
            <a
              href="https://www.nbcnews.com/think/opinion/covid-vaccines-mean-end-quarantine-sight-some-view-doesn-t-ncna1262192"
              target="_blank"
              ><br />Link to article</a
            >
          </p>

          <img
            class="no-hate"
            src="../assets/nbc_news_no_hate.png"
            alt="no hate"
          />
          <p id="no-hate">
            CDC says racism is a 'serious threat' to public health
            <a
              href="https://www.nbcnews.com/health/health-news/cdc-says-racism-serious-threat-public-health-n1263547"
              target="_blank"
              >Link to article</a
            >
          </p>
        </div>
      </div>
    </div>
    <div>
      <the-footer id="footer" />
    </div>
  </div>
</template>

<script>
import TheHeader from "../components/TheHeader.vue";
import TheFooter from "../components/TheFooter.vue";

export default {
  name: "home",
  components: {
    TheHeader,
    TheFooter,
  },
};
</script>
<style>
/* #home-page {
  width: 100%;
  height: auto;
  overflow-x: hidden;
  display: grid;
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-areas: 
      "header header header"
      "body body body"
      "footer footer footer";

} */
.container {
  padding: 0px;
  margin: 0px;
  border: 0px;
  display: grid;
  grid-template-columns: 1fr 1f 1fr 1fr;
  grid-template-areas:
    "header header header header"
    "doctor-picture doctor-picture doctor-picture doctor-picture"
    "scheduling-section . . ."
    "icon-information icon-information icon-information icon-information"
    /* "news-section news-section news-section news-section" */
    "carousel carousel carousel carousel"
    "footer footer footer footer";
}
#news-section {
  grid-area: news-section;
  margin-top: 40px;
  margin-left: 0px;
  margin-bottom: 20px;
  font-style: italic;
  color: #1e3250;
}
.news {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: "covid-map quarentine no-hate";
}
.icon-information {
  grid-area: icon-information;
  color: #46a7ad;
  background-color: white;
  font-size: 70px;
  text-align: center;
}
.details {
  font-size: 26px;
}
#health-stats-description {
  font-size: 20px;
}

.emergency {
  grid-area: emergency;
  margin-top: 0px;
  margin-right: 15px;
  font-size: 15px;
  color: red;
  font-weight: bold;
}

#emergency_icon {
  font-size: 25px;
  margin-left: 12px;
}
#doctor-picture {
  height: 525px;
  width: 100%;
  filter: brightness(50%);
}
#slogan {
  font-size: 60px;
  color: rgb(230, 226, 226);
  text-shadow: 4px 4px 4px #1e3250;
  position: absolute;
  top: 50%;
  left: 35%;
  transform: translate(-50%, -50%);
}

#scheduling-section {
  grid-area: scheduling-section;
  margin-top: 40px;
  margin-bottom: 20px;
  margin-left: 15px;
  font-style: italic;
  color: #1e3250;
}
#Visit {
  grid-area: visit;
  display: flex;
  flex-direction: column;
  padding-top: 40px;
  margin-left: 20px;
  margin-right: 30px;
  /* border-style: solid; */
  /* border-color: #46a7ad; */
  background-color: #ebfbfc;
  /* border-width: 4px; */
  border-radius: 10px;
  float: left;

  height: 300px;
  width: 300px;
}
#Health-Stats {
  grid-area: test-results;
  display: flex;
  flex-direction: column;
  padding-top: 40px;
  padding-left: 10px;
  padding-right: 10px;
  margin-left: 30px;
  margin-right: 30px;
  /* border-style: solid;
  border-color: #46a7ad;
  border-width: 7px; */
  background-color: #ebfbfc;
  border-radius: 10px;
  float: left;

  height: 300px;
  width: 300px;
}
#Medications {
  grid-area: medications;
  display: flex;
  flex-direction: column;
  padding-top: 40px;
  margin-left: 30px;
  margin-right: 30px;
  /* border-style: solid;
  border-color: #46a7ad;
  border-width: 7px; */
  background-color: #ebfbfc;
  border-radius: 10px;
  float: left;

  height: 300px;
  width: 300px;
}
#Billing-Insurance {
  grid-area: health-stats;
  display: flex;
  flex-direction: column;
  padding-top: 40px;
  margin-left: 30px;
  margin-right: 20px;
  /* border-style: solid;
  border-color: #46a7ad;
  border-width: 7px; */
  background-color: #ebfbfc;
  border-radius: 20px;
  float: left;

  height: 300px;
  width: 300px;
}
.description {
  color: #1e3250;
  font-size: 20px;
  text-align: center;
}
.picture-and-slogan {
  grid-area: doctor-picture;
  position: relative;
  text-align: left;
  color: white;
}
.carousel {
  grid-area: carousel;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "news-section news-section news-section"
    "covid-map quarentine no-hate";
  padding: 30px;
}

.covid-map {
  grid-area: covid-map;
  display: flex;
  flex-direction: column;
  height: 250px;
  width: auto;
  padding: 20px;
  margin: 30px;
  border: 6px;
  border-style: solid;
  border-color: #46a7ad;
}
.quarentine {
  grid-area: quarentine;
  display: flex;
  flex-direction: column;
  height: 250px;
  width: auto;
  padding: 20px;
  margin-left: 100px;
  margin-right: 100px;
  margin-top: 30px;
  border: 6px;
  border-style: solid;
  border-color: #46a7ad;
}
.no-hate {
  grid-area: no-hate;
  display: flex;
  flex-direction: column;
  height: 250px;
  width: auto;
  padding: 20px;
  margin: 30px;
  border: 6px;
  border-style: solid;
  border-color: #46a7ad;
}
#header {
  grid-area: header;
}
#footer {
  grid-area: footer;
}
#quarentine-caption {
  margin-left: 100px;
}
#covid-map {
  margin-left: 33px;
}
#no-hate {
  margin-left: 31px;
}
</style>



