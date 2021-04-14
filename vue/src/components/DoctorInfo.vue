<template>
  <div>
    <div class="card" style="width: 22rem">
      <img
        src="../assets/doctor_coach.png"
        class="card-img-top"
        alt="Photo of Doctor"
      />
      <h3 id="doc-title" class="card-title">Primary Care Provider</h3>
      <div class="card-body">
        <h5 id="doc-name" class="card-text">Dr. Steve "Coach" Carmichael</h5>
        <p class="card-text" id="doc-loc">Ohio Tech Care</p>
        <p class="card-text" id="doc-street">4 Loop Lane</p>
        <p class="card-text" id="doc-street">Suite 404</p>
        <p class="card-text" id="doc-state">Columbus, OH 43232</p>
        <p class="doc-icons">
          <i class="fa fa-envelope" id="email-icon"></i
          ><span class="card-text" id="doc-email">dr.coach.steve@otc.com</span>
        </p>
        <p class="doc-icons">
          <i class="fa fa-phone" id="phone-icon"></i
          ><span class="card-text" id="doc-phone">(555) 555 - 5555</span>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "doctor-info",
};
</script>

<style>
#doc-title {
  text-align: center;
  font-weight: bold;
  font-size: 1.4rem;
  color: #1e3250;
  padding: 10px;
  background-color: #93cacd;
  white-space: nowrap;
}
#doc-name {
  color: #1e3250;
  font-weight: bold;
}
#doc-loc,
#doc-street,
#doc-state,
#doc-email,
#doc-phone {
  font-family: "Oswald", sans-serif;
  font-size: 1.1rem;
  line-height: 1.1rem;
  padding: 1px;
  margin: 0px;
  color: #1e3250;
  white-space: nowrap;
}
.doc-icons {
  margin: 10px;
  font-size: 20px;
}
#email-icon,
#phone-icon {
  color: #46a7ad;
  position: relative;
  margin-right: 8px;
}
</style>