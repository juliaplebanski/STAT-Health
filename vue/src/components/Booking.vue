<template>
  <div id="main">
    <div id="booking">
      <div>
        <h3 class="schedule-visit">Schedule a Visit</h3>
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
          v-for="time in formattedTimes"
          v-bind:value="time.value"
          v-bind:key="time.value"
          v-on:click="setSelectedTime(time.value, time.text)"
        >
          {{ time.text }}
        </button>
      </div>
    </div>
    <form 
      id="form"
      v-show="selectedTime"
      v-on:submit.prevent="createVisit()"
      class="homeForm"
    >
      <div>
        <h5>Patient Visit Form</h5>
        <p id="form-input">{{ username }}</p>
        <p id="form-input">>{{ selectedDateText }}</p>
        <p id="form-input">>{{ selectedTimeText }}</p>

        <select id="reason" v-model="reason">
          <option value="0" disabled selected>Select reason for visit</option>
          <option
            v-for="reason in reasons"
            v-bind:value="reason.reason"
            v-bind:key="reason.reason"
          >
            {{ reason.reason }}
          </option>
        </select>
      </div>
      <div class="form-group">
        <label for="description">Add detailed description (optional):</label>
        <textarea
          id="description"
          type="text"
          class="form-control"
          v-model="description"
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
      selectedDateText: "",
      selectedTime: "",
      selectedTimeText: "",
      reason: "",
      description: "",
      formattedTimes: [],
      doctorId: this.$store.state.doctorId,
      userId: this.$store.state.user.id,
      username: this.$store.state.user.username,
      dates: [],
      times: [],
      visit: {},
      reasons: [],
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
      scheduleService
        .getAvailability(this.doctorId, selectedDate, this.userId)
        .then((response) => {
          if (response.status == "200") {
            console.log(response.status + " 2");
            this.times = response.data;
            this.formatAvailableTimes();
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
    setSelectedTime(selectedTime, selectedTimeText) {
      this.selectedTime = selectedTime;
      this.selectedTimeText = selectedTimeText;
      this.times = [];
      this.getSelectedDateText();
      this.getReasons();
    },
    getReasons() {
      scheduleService
        .getReasons()
        .then((response) => {
          if (response.status == "200") {
            console.log(response.status + " 3");
            this.reasons = response.data;
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
    createVisit() {
      this.visit.doctorId = this.doctorId;
      this.visit.startTime = this.selectedTime;
      this.visit.dateOfVisit = this.selectedDate;
      this.visit.statusId = "a";
      this.visit.patientId = this.userId;
      this.visit.visitReason = this.reason;
      this.visit.description = this.description;
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
            this.reset();
          }
        })
        .catch((error) => {
          // handle an error
          console.log(error);
        });
    },
    cancelForm() {
      this.selectedTime = "";
      this.reset();
    },
    reset() {
      const dropDown = document.getElementById("dates");
      dropDown.selectedIndex = "0";
    },
    getSelectedDateText() {
      return this.dates.forEach((date) => {
        if (this.selectedDate == date.value) {
          this.selectedDateText = date.text;
        }
      });
    },
    formatAvailableTimes() {
      return this.times.forEach((time) => {
        if (time.startTime[0] == 0 && time.startTime[1] < 5) {
          let formattedTime = time.startTime.substring(1, 5) + " PM";
          this.formattedTimes.push({
            text: formattedTime,
            value: time.startTime,
          });
        } else if (time.startTime[0] == 0 && time.startTime[1] > 7) {
          let formattedTime = time.startTime.substring(1, 5) + " AM";
          this.formattedTimes.push({
            text: formattedTime,
            value: time.startTime,
          });
        } else if (time.startTime.substring(0, 2) == 12) {
          let formattedTime = time.startTime.substring(0, 5) + " PM";
          this.formattedTimes.push({
            text: formattedTime,
            value: time.startTime,
          });
        } else {
          let formattedTime = time.startTime.substring(0, 5) + " AM";
          this.formattedTimes.push({
            text: formattedTime,
            value: time.startTime,
          });
        }
      });
    },
  },
};
</script>

<style>
 #main {
  display: flex;
  /* flex-direction: column; */
  justify-content: flex-start;
  align-content: flex-start;
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
.schedule-visit {
  padding: 0 10px;
  color: #46a7ad;
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
#form-input {
  padding: 0px;
  margin: 0px;
}
</style>

