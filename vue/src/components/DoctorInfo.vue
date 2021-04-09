<template>
  <div>
    <!-- <h3>Primary Care Provider</h3>
    <img src="../assets/docinfo.png" alt="doctor logo">
    <p>Doctor Name</p>
    <p>Office Name</p>
    <p>Street Address</p>
    <p>City, State, Zipcode</p>
    <p>Doctor Email</p>
    <p>Doctor Phone</p> -->
    <div class="card" style="width: 15rem">
      <img
        src="../assets/docinfo.png"
        class="card-img-top"
        alt="Photo of Doctor"
      />
      <div class="card-body">
        <h5 class="card-title">Primary Care Provider</h5>
        <h5 class="card-text">Dr. Steve Carmichael</h5>
        <h5 class="card-text">Ohio Tech Care</h5>
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
.card-title {
  font-family: 'Oswald', sans-serif;
  font-weight: 300;
  font-size: 1.1rem;
  line-height: 1.1rem;
  padding: 0 20px;
  color: teal;
  white-space: nowrap;

}
 .card-text {
  font-family: 'Oswald', sans-serif;
  font-weight: 300;
  font-size: 1.1rem;
  line-height: 1.1rem;
  padding: 0 20px;
  color: teal;
  white-space: nowrap; 

} 

</style>