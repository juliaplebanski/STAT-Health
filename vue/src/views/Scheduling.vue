<template>
  <div>
      <user-sub-nav />
      <doctor-info />
      <doctor-availability />

  </div>
</template>

<script>
import DoctorInfo from '../components/DoctorInfo.vue'
import UserSubNav from '../components/UserSubNav.vue'
import DoctorAvailability from '../components/DoctorAvailability.vue'

export default {
    components:{
        DoctorInfo,
        UserSubNav,
        DoctorAvailability
    }

}
</script>

<style>

</style>
