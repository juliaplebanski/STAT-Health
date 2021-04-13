<template>
  <div>
    <div class="card" style="width: 22rem">
      <h3 class="card-title">Primary Care Provider</h3>
      <img
        src="../assets/doctor_coach.png"
        class="card-img-top"
        alt="Photo of Doctor"
      />
      <div class="card-body">
        <h5 class="card-text">Dr. Steve "Coach" Carmichael</h5>
        <p class="card-text" id = "text-for-doctor-info">Ohio Tech Care</p>
        <p class="card-text" id = "text-for-doctor-info">4 Loop Lane</p>
        <p class="card-text" id = "text-for-doctor-info">Columbus, OH 43232</p>
        <i class="fa fa-envelope" id = "icon-for-doctor-info"></i><p class="card-text">dr.coach.steve@otc.com</p>
        <i class="fa fa-phone" id = "icon-for-doctor-info"></i><p class="card-text">(555) 555 - 5555</p>
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
  text-align: center !important;
  font-family: 'Oswald', sans-serif;
  font-weight: bold;
  font-size: 1.4rem;
  line-height: 1.1rem;
  padding: 10px;
  background-color: #badee0 !important;
  white-space: nowrap;
  border-bottom: 1px solid #e3e8ed;

}
 .card-text {
  font-family: 'Oswald', sans-serif;
  font-weight: 600;
  font-size: 1.1rem;
  line-height: 1.1rem;
  padding: 0 20px;
  color: #1e3250;
  white-space: nowrap; 

} 
#text-for-doctor-info {
  padding: 3px;
  margin: 3px;
}
#icon-for-doctor-info {
  color: #46a7ad !important;
  position: relative;
  top: 5px;
  left: 5px;
}



</style>