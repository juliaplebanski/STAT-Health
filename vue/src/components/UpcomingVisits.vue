<template>
  <div id="uv-main">
    <router-link id="book-visit" v-bind:to="{ name: 'scheduling' }">Schedule a Visit</router-link>
    <h4 id="upcoming-visits">Upcoming Visits</h4>
    <div
      class="card"
      v-for="upcomingVisit in upcomingVisits"
      v-bind:value="upcomingVisit.patientId"
      v-bind:key="upcomingVisit.patientId"
    >
      <h5 class="card-header">
        {{ upcomingVisit.dateOfVisit }} @ {{ upcomingVisit.startTime }}
      </h5>
      <div class="card-body">
        <h5 class="card-title">
          Dr. {{ upcomingVisit.doctorFirstName }}
          {{ upcomingVisit.doctorLastName }}
        </h5>
        <p class="card-text">
          Reason for visit: {{ upcomingVisit.visitReason }}
        </p>
        <p class="card-text">Visit details: {{ upcomingVisit.description }}</p>
        <!-- <a href="#" class="btn btn-primary">View Details</a> -->
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
  created() {
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
            this.formatAvailableTimes();
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
    formatAvailableTimes() {
      return this.upcomingVisits.forEach((visit) => {
        if (visit.startTime[0] == 0 && visit.startTime[1] < 5) {
          let formattedTime = visit.startTime.substring(1, 5) + " PM";
          visit.startTime = formattedTime;
        } else if (visit.startTime[0] == 0 && visit.startTime[1] > 7) {
          let formattedTime = visit.startTime.substring(1, 5) + " AM";
          visit.startTime = formattedTime;
        } else if (visit.startTime.substring(0, 2) == 12) {
          let formattedTime = visit.startTime.substring(0, 5) + " PM";
          visit.startTime = formattedTime;
        } else {
          let formattedTime = visit.startTime.substring(0, 5) + " AM";
          visit.startTime = formattedTime;
        }
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
.card {
  grid-area:card;
  margin: 20px;
}
#upcoming-visits {
  grid-area: upcoming;
  font-style: italic;
  color: #1e3250;
}
#book-visit {
  grid-area: book;
  min-width: 200px;
  height: 40px;
  border: 1px solid #D1DAE4;
  color: #1E3250;
  background-color:  #CDEAEC;
  padding: 10px 30px 10px 30px;
  font-size: 1.1em;
  text-decoration: none;
  padding-bottom: 10px;
}
#book-visit:hover {
  background-color:  #46A7AD;
  color:white;
}
#uv-main {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    ". book"
    "upcoming ."
    "card card";
}

.card-title,
.card-text {
  text-align: left !important;
  padding: 5px;
  color: #1e3250;
  background-color: white !important;
  font-weight: normal;
}
.card-header {
  background-color: #badee0;
  color: #1e3250;
  font-weight: bold;
}

</style>