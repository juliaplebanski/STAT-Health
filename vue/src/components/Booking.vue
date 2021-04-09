<template>
  <div id="main">
    <h3 for="appointment" class="schedule-appointment">Schedule Appointment</h3>
    <div>
      <label for="dates">Select desired date:</label>

      <select
        id="dates"
        v-model="selectedDate"
        v-on:change="getAvailability(selectedDate)"
      >
        <option value="" disabled selected>Select desired date</option>
        <option
          v-for="date in dates"
          v-bind:value="date.value"
          v-bind:key="date.value"
        >
          {{ date.text }}
        </option>
      </select>
    </div>
    <div class="btn-group-vertical btn-group-sm" v-show="times.length > 0">
      <button
        type="button"
        class="btn btn-secondary"
        v-for="time in times"
        v-bind:value="time.startTime"
        v-bind:key="time.startTime"
        v-on:click="setSelectedTime(time.startTime)"
      >
        {{ time.startTime }}
      </button>
    </div>
    <form
      v-show="selectedTime"
      v-on:submit.prevent="createVisit()"
      class="homeForm"
    >
      <div>
        <h5>Patient Visit Form</h5>
        <label for="reason">Select reason for visit:</label>
        <select id="reason" v-model="visit.reason">
          <option
            v-for="reason in reasons"
            v-bind:value="reason.value"
            v-bind:key="reason.value"
          >
            {{ reason.text }}
          </option>
        </select>
      </div>
      <div class="form-group">
        <label for="description">Add detailed description (optional):</label>
        <textarea
          id="description"
          type="text"
          class="form-control"
          v-model="visit.description"
        >
Enter description here
        </textarea>
      </div>
      <button class="btn btn-submit">Submit</button>
      <button class="btn btn-cancel" type="cancel" v-on:click="cancelForm()">
        Cancel
      </button>
    </form>
  </div>
</template>

<script>
import scheduleService from "../services/ScheduleService.js";

export default {
  name: "booking",
  data() {
    return {
      selectedDate: "",
      selectedTime: "",
      doctorId: this.$store.state.doctorId,
      userId: this.$store.state.user.id,
      dates: [],
      times: [],
      visit: {},
      reasons: [
        { text: "Annual Checkup", value: "Annual Checkup" },
        { text: "Back Problems", value: "Back Problems" },
        { text: "Diabetes Testing", value: "Diabetes Testing" },
      ],
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
          let valueDate = currentDate.toLocaleDateString("fr-CA");

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
    getAvailability(selectedDate) {
      // const doctorId = this.$store.state.doctorId;
      // const userId = this.$store.state.user.id;
      scheduleService
        .getAvailability(this.doctorId, selectedDate, this.userId)
        .then((response) => {
          if (response.status == "200") {
            console.log(response.status + " 2");
            this.times = response.data;
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
    setSelectedTime(selectedTime) {
      this.selectedTime = selectedTime;
      this.times = [];
    },
    createVisit() {
      this.visit.doctorId = this.doctorId;
      this.visit.startTime = this.selectedTime;
      this.visit.dateOfVisit = this.selectedDate;
      this.visit.statusId = "a";
      this.visit.patientId = this.userId;
      this.addVisit(this.visit);
    },

    addVisit(visit) {
      scheduleService
        .addVisit(visit)
        .then((response) => {
          if (response.status == "201") {
            console.log(response.status + " 2");
            this.selectedTime = "";
            this.visit = {};
          }
        })
        .catch((error) => {
          // handle an error
          console.log(error);
        });
    },
    cancelForm() {
      this.selectedTime = "";
     
    },
  },
};
</script>

<style scoped>
#main {
  display: flex;
  flex-direction: column;
}
button {
  margin: 5px;
  background-color: #1e3250;
  border-color: #1e3250;
  color: whitesmoke;
}
button:hover {
  background-color: #3863a0;
  border-color: #3863a0;
}
.schedule-appointment {
  padding: 0 20px;
  color: teal;
}
form input {
  width: 100%;
}

.homeForm {
  padding: 30px;
  margin-bottom: 10px;
  border: 1px solid gray;
}

.form-group {
  margin-bottom: 10px;
  margin-top: 10px;
}

.form-control {
  display: flex;
  align-items: flex-start;
  width: 100%;
  height: 30px;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
}
textarea.form-control {
  height: 75px;
  font-family: Arial, Helvetica, sans-serif;
}
select.form-control {
  width: 20%;
  display: inline-block;
  margin: 10px 20px 10px 10px;
}
</style>