<template>
  <div>
    <div class="card" v-for="upcomingVisit in upcomingVisits" v-bind:value="upcomingVisit.patientId" v-bind:key="upcomingVisit.patientId">
      <h5 class="card-header">{{ upcomingVisit.dateOfVisit }} @ {{ upcomingVisit.startTime }}</h5>
      <div class="card-body">
        <h5 class="card-title">Dr. {{ upcomingVisit.doctorFirstName }} {{ upcomingVisit.doctorLastName }}</h5>
        <p class="card-text">
          Reason for visit: {{ upcomingVisit.visitReason }}
        </p>
        <p class="card-text">
          Visit details: {{ upcomingVisit.description }}
        </p>
        <a href="#" class="btn btn-primary">View Details</a>
      </div>
    </div>
  </div>
</template>

<script>
import scheduleService from "../services/ScheduleService.js";
export default {
  name: "upcoming-visits",
  data() {
    return {
      userId: this.$store.state.user.id,
      upcomingVisits: [],
    };
  },
  created(){
    this.getUpcomingVisits();
  },
  methods: {
    getUpcomingVisits() {
      scheduleService
        .getUpcomingVisits(this.userId)
        .then((response) => {
          if (response.status == "200") {
            console.log(response.status + " 2");
            this.upcomingVisits = response.data;
            this.getDates();
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getDates() {
      return this.upcomingVisits.forEach((visit) => {
        let date = new Date(visit.dateOfVisit);
        let day = this.dayAsString(date.getDay());
        let dateString =
          day +
          ", " +
          this.monthAsString(date.getMonth()) +
          " " +
          date.getDate() +
          " " +
          date.getFullYear();
          visit.dateOfVisit = dateString;
          console.log(dateString);
      });
    },

    monthAsString(monthIndex) {
      // let d = new Date();
      let month = new Array();
      month[0] = "January";
      month[1] = "February";
      month[2] = "March";
      month[3] = "April";
      month[4] = "May";
      month[5] = "June";
      month[6] = "July";
      month[7] = "August";
      month[8] = "September";
      month[9] = "October";
      month[10] = "November";
      month[11] = "December";
      return month[monthIndex];
    },
    dayAsString(dayIndex) {
      let weekdays = new Array(7);
      weekdays[0] = "Sunday";
      weekdays[1] = "Monday";
      weekdays[2] = "Tuesday";
      weekdays[3] = "Wednesday";
      weekdays[4] = "Thursday";
      weekdays[5] = "Friday";
      weekdays[6] = "Saturday";
      return weekdays[dayIndex];
    },
  },
};
</script>

<style>
</style>