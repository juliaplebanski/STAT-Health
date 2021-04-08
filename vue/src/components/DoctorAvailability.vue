<template>
  <div id="main">
    <label for="dates">Select desired date:</label>
    <select id="dates" v-model="selected" v-on:change="getAvailability(selected)">
      <option
        v-for="date in dates"
        v-bind:value="date.value"
        v-bind:key="date.value"
      >
        {{ date.text }}
      </option>
    </select>
    <!-- <span>Selected: {{ selected }}</span>  -->
    <div class="btn-group-vertical btn-group-sm" v-show="times.length > 0">
      <button type="button" class="btn btn-secondary" v-for="time in times" v-bind:value="time.startTime" v-bind:key="time.startTime" v-on:click="addVisit(time.startTime)">{{ time.startTime }}</button>
    </div>
  </div>
</template>

<script>
import scheduleService from "../services/ScheduleService.js";

export default {
  name: "doctor-availability",
  data() {
    return {
      selected: "",
      options: [
        { text: "Wednesday, May 5, 2021", value: "5/5/2021" },
        { text: "Wednesday, May 12, 2021", value: "5/12/2021" },
      ],
      dates: [],
      times: [],
      visit: {
        startTime: '',
        endTime: '',
        doctorId: 0,
        patientId: 0,
        dateOfVisit: '',
        statusId: ''
      }
    };
  },
  created() {
    const startDate = new Date();
    this.dates = this.getDates(startDate, 16);
  },
  methods: {
    getDates(startDate, daysToAdd) {
      const aryDates = [];
      for (let i = 1; i <= daysToAdd; i++) {
        let currentDate = new Date();
        currentDate.setDate(startDate.getDate() + i);
        let day = this.dayAsString(currentDate.getDay());
        if (day !== "Saturday" && day !== "Sunday") {
          let dateString =
            day +
            ", " +
            this.monthAsString(currentDate.getMonth()) +
            " " +
            currentDate.getDate() +
            " " +
            currentDate.getFullYear();
          let valueDate = currentDate.toLocaleDateString('fr-CA');
        
          console.log(valueDate);
          aryDates.push({ text: dateString, value: valueDate });
        }
      }
      return aryDates;
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
    getAvailability(selected) {
      const doctorId = this.$store.state.doctorId;
      const user = this.$store.state.user;
      scheduleService.getAvailability(doctorId, selected, user).then((response) => {
          if (response.status == "200") {
            console.log(response.status + " 2");
            this.times = response.data;
          }
        })
        .catch((error) => {
          console.log(error + doctorId + selected);
        });
    },
    createVisit(selectedTime) {
      this.visit.doctorId = this.$store.state.doctorId;
      this.visit.startTime = selectedTime;
      this.visit.endDate = this.times.endDate;
      this.visit.startDate = this.selected;
      this.visit.statusId = 'a';
      this.visit.patientId = this.times.patientId;
      return this.visit;
    }
  },
  addVisit(visit) {
    scheduleService.addVisit(visit).then(response => {
      if(response.status == '201') {
            console.log(response.status + ' 2');
          }
       })
       .catch(error => {
         // handle an error 
         console.log(error);
       })
  }
}
</script>

<style scoped>

button {
  background-color: #1e3250;
  border-color:  #1e3250;
}
button:hover {
  background-color: #3863A0;
  border-color:  #3863A0;
}

</style>
