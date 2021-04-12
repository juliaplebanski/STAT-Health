<template>
  <div id="footer">
    <img id="logo" src="../assets/jghealthsystems_logo.png" alt="Our Logo" />
    <p id="copyright">&#169;2021 JG Health Systems</p>
    <div id="about">
      <h5>About JG Health Systems</h5>
      <a href="#" target="_blank">About Us</a>
      <a href="#" target="_blank">Our Doctors</a>
      <a href="#" target="_blank">Privacy Policy</a>
      <a href="#" target="_blank">Terms & Conditions</a>
    </div>
    <div id="patients">
      <h5>For Patients</h5>
      <a href="#" target="_blank">Preparing for your Visit</a>
      <a href="#" target="_blank">Patient Education</a>
      <a href="#" target="_blank">Virtual Health</a>
    </div>
 
<div id="contact-us">
      <h5> <i class="icomoon icon-question"></i> Contact Us</h5>
      <p id= "contact-info">
        Phone Number: 1-800-JGHELPS <br />
        Email: Help@jghealthsystems.com <br />
        Hours: M-F 9am-5pm
      </p>
    </div>


    <div id="social">
      <h5>Follow Us</h5>
      <ul id="social-icons">
        <li>
          <a href="#"><i class="fab fa-facebook fa-3x"></i></a>
        </li>
        <li>
          <a href="#"><i class="fab fa-instagram fa-3x"></i></a>
        </li>
        <li>
          <a href="#"><i class="fab fa-twitter fa-3x"></i></a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "the-footer",
};
</script>

<style>
#logo {
  grid-area: logo;
  width: 175px;
  height: auto;
  margin: 0px 0px 0px 0px 10px;
}
#copyright {
  grid-area: copyright;
  margin: 0px 0px 0px 0px 10px ;
}
#about {
  grid-area: about;
  display: flex;
  flex-direction: column;
}
#contact-us{
  grid-area: contact-us;
  display: flex;
  flex-direction: column;
}

#social {
  grid-area: social;
  background-color: #46a7ad;
  display: flex;
  flex-direction: column;
}
#patients {
  grid-area: patients;
  display: flex;
  flex-direction: column;
}
#footer {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
  grid-template-areas:
    ". about patients contact-us social"
    "logo about patients contact-us social"
    "copyright . . . .";
  color: #1e3250;
  border-top: 20px solid #3863a0;
  padding: 10px;
  background-color: #46a7ad;
}

ul#social-icons {
  list-style-type: none;
  padding: 5px;
  width: auto;
  background-color: #46a7ad;
  display: flex;
  text-align: center;
}
.fab {
  background-color: #46a7ad;
  color: white;
  margin: 5px;
}
.fab:hover {
  color: #1e3250;
}
a {
  color:white;
}
a:hover {
  color: #1e3250;
}
li {
    background-color: #46a7ad;
}

h5 {
  color: #3863A0;
}

#contact-info{
  color: white;
}
</style>
