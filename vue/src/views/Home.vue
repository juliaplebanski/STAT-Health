<template>
  <div id="home-page">
    <div class="container">
      <p class="emergency">
        IF THIS IS AN EMERGENCY <br />
        PLEASE DIAL 9-1-1 <i class="fa fa-ambulance" id="emergency_icon"></i>
      </p>
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
              and schedule a visit.
            </p>
          </div>

          <div id="Test-Results">
            <i class="fa fa-syringe"></i>
            <p class="details">Test Results</p>

            <p class="description">
              View past test result information, <br />
              directly sent from your doctor.
            </p>
          </div>
          <div id="Medications">
            <i class="fa fa-prescription-bottle"></i>
            <p class="details">Medications</p>

            <p class="description">
              View current prescriptions, <br />
              and request refills.
            </p>
          </div>

          <div id="Billing-Insurance">
            <i class="fa fa-clipboard-list"></i>
            <p class="details">Billing & Insurance</p>
            <p class="description" id="billing-insurance-description">
              View your bill and pay, <br />
              for a recent visit as well as see what <br />
              services your insurance covers.
            </p>
          </div>
        </nav>
      </div>
      <!-- html code for slideshow -->
      <!-- Slideshow container -->
      <div class="slideshow-container">
        <!-- Full-width images with number and caption text -->
        <div class="mySlides">
          <div class="numbertext">1 / 3</div>
          <img src="../assets/nbc_news_covid_map.png" style="width: 100%" />
          <div class="text">Caption Text</div>
        </div>

        <div class="mySlides fade">
          <div class="numbertext">2 / 3</div>
          <img src="../assets/nbc_news_quarentine.png" style="width: 100%" />
          <div class="text">Caption Two</div>
        </div>

        <div class="mySlides fade">
          <div class="numbertext">3 / 3</div>
          <img src="../assets/nbc_news_no_hate.png" style="width: 100%" />
          <div class="text">Caption Three</div>
        </div>

        <!-- Next and previous buttons -->
        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
        <a class="next" onclick="plusSlides(1)">&#10095;</a>
      </div>
      <br />

      <!-- The dots/circles -->
      <!-- <div style="text-align: center">
        <span class="dot" onclick="currentSlide(1)"></span>
        <span class="dot" onclick="currentSlide(2)"></span>
        <span class="dot" onclick="currentSlide(3)"></span>
      </div>  -->
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
    "doctor-picture doctor-picture doctor-picture doctor-picture"
    "scheduling-section . . ."
    "icon-information icon-information icon-information icon-information"
    "slide-show slide-show slide-show slide-show";
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
#billing-insurance-description {
  font-size: 20px;
}

.emergency {
  grid-area: emergency;
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
  height: 500px;
  width: 1440px;
  /* filter: blur(1px);
  -webkit-filter: blur(1px); */
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
  margin-left: 15px;
  font-style: italic;
  color: #1e3250;
}
#Visit {
  grid-area: visit;
  display: flex;
  flex-direction: column;
  padding: 10px;
  margin: 10px;
  /* border-style: solid; */
  /* border-color: #46a7ad; */
  background-color: #ebfbfc;
  /* border-width: 4px; */
  border-radius: 10px;
  float: left;

  height: 300px;
  width: 300px;
}
#Test-Results {
  grid-area: test-results;
  display: flex;
  flex-direction: column;
  padding: 10px;
  margin: 10px;
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
  padding: 10px;
  margin: 10px;
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
  grid-area: billing-insurance;
  display: flex;
  flex-direction: column;
  padding: 10px;
  margin: 10px;
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
* {
  box-sizing: border-box;
}
Slideshow container .slideshow-container {
  max-width: 1000px;
  height: 600px;
  width: 600px;
  grid-area: slide-show;
  position: relative;
  top: 55%;
  left: 50%;
  transform: translate(-50%, -50%);
}

/* Hide the images by default */
.mySlides {
  display: all;
}

/* Next & previous buttons */
.prev,
.next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  margin-top: -22px;
  padding: 16px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover,
.next:hover {
  background-color: rgba(0, 0, 0, 0.8);
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  /* transition: background-color 0.6s ease; */
}

.active,
.dot:hover {
  background-color: #717171;
}

/* Fading animation */
/* .fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}*/

@-webkit-keyframes fade {
  from {
    opacity: 0.4;
  }
  to {
    opacity: 1;
  }
}

@keyframes fade {
  from {
    opacity: 0.4;
  }
  to {
    opacity: 1;
  }
}
</style>








