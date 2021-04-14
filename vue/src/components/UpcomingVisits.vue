<template>
  <div id="uv-main">
    <router-link id="book-visit" v-bind:to="{ name: 'scheduling' }"
      >Schedule a Visit</router-link
    >
    <div id="uv-list">
      <h4 id="upcoming-visits">Upcoming Visits</h4>
      <p v-show="upcomingVisits.length == 0" class="uv-text">No upcoming visits at this time.<p>
      <div
        class="card"
        v-for="upcomingVisit in upcomingVisits"
        v-bind:value="upcomingVisit.patientId"
        v-bind:key="upcomingVisit.patientId"
      >
        <h5 id="uv-header" class="card-header">
          {{ upcomingVisit.dateOfVisit }} @ {{ upcomingVisit.startTime }}
        </h5>
        <div class="card-body">
          <!-- <h5 id="uv-doc" class="card-title">
            Dr. {{ upcomingVisit.doctorFirstName }}
            {{ upcomingVisit.doctorLastName }}
          </h5> -->
          <p class="uv-title"><span>
            Reason for visit: </span><span class="uv-text">{{ upcomingVisit.visitReason }}</span>
          </p>
          <p class="uv-title"><span>
            Visit details: </span><span class="uv-text">{{ upcomingVisit.description }}</span>
          </p>
          <!-- <a href="#" class="btn btn-primary">View Details</a> -->
        </div>
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
  margin: 20px;
}
#upcoming-visits {
  font-style: italic;
  color: #1e3250;
}
#uv-list {
  max-width: 600px;
  justify-self: baseline;
}

#book-visit {
  min-width: 200px;
  max-width: 200px;
  height: 40px;
  color: white;
  background-color: #46a7ad;
  padding-top: 8px;
  padding-left: 30px;
  font-size: 1.1em;
  font-weight: bold;
  text-decoration: none;
  border-radius: 8px;
  align-self: flex-end;
}
#book-visit:hover {
  background-color: #92dce0;
  color: white;
}
#uv-main {
  display: flex;
  flex-direction: column;
}
#uv-header {
  background-color: #4674ad;
  text-align: left;
  padding: 10px;
  color: white;
  font-weight: bold;
}
.uv-title {
  color: #1e3250;
  font-weight: bold;
}
.uv-text {
  text-align: left;
  padding: 5px;
  color: #1e3250;
  background-color: white;
  font-weight: normal;
}
.uv-doc {
  color: #1e3250;
}
</style>