<template>
  <div id="footer">
    <img id="logo" src="../assets/jghealthsystems_logo.png" alt="Our Logo" />
    <p id="copyright">&#169;2021 JG Health Systems</p>
    <div id="about">
      <h5 class="titles-in-footer">About JG Health Systems</h5>
      <a href="#" target="_blank" id="links-for-footer">About Us</a>
      <a href="#" target="_blank" id="links-for-footer">Our Doctors</a>
      <a href="#" target="_blank" id="links-for-footer">Privacy Policy</a>
      <a href="#" target="_blank" id="links-for-footer">Terms & Conditions</a>
    </div>
    <div id="patients">
      <h5 class="titles-in-footer">For Patients</h5>
      <a href="#" target="_blank" id="links-for-footer"
        >Preparing for your Visit</a
      >
      <a href="#" target="_blank" id="links-for-footer">Patient Education</a>
      <a href="#" target="_blank" id="links-for-footer">Virtual Health</a>
    </div>

    <div id="contact-us">
      <h5 class="titles-in-footer">
        <i class="icomoon icon-question"></i> Contact Us
      </h5>
      <p id="contact-info">
        Phone Number: 1-800-JGHELPS <br />
        Email: Help@jghealthsystems.com <br />
        Hours: M-F 9am-5pm
      </p>
    </div>

    <div id="social">
      <h5 class="titles-in-footer">Follow Us</h5>
      <ul id="social-icons">
        <li id="lists-for-social-media-icons">
          <a href="#" id="links-for-footer"
            ><i class="fab fa-facebook fa-3x" id="social-media-icon"></i
          ></a>
        </li>
        <li>
          <a href="#" id="links-for-footer"
            ><i class="fab fa-instagram fa-3x" id="social-media-icon"></i
          ></a>
        </li>
        <li>
          <a href="#" id="links-for-footer"
            ><i class="fab fa-twitter fa-3x" id="social-media-icon"></i
          ></a>
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
  margin: 0px 0px 0px 0px 10px;
}
#about {
  grid-area: about;
  display: flex;
  flex-direction: column;
}
#contact-us {
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
#social-media-icon {
  background-color: #46a7ad;
  color: white;
  margin: 5px;
}
#social-media-icon:hover {
  color: #1e3250;
}
#links-for-footer {
  color: white;
}
#links-for-footer:hover {
  color: #1e3250;
}
#lists-for-social-media-icons {
  background-color: #46a7ad;
}

.titles-in-footer {
  color: #1e3250;
}

#contact-info {
  color: white;
}
</style>
