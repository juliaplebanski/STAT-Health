<template>
  <div id="booking-main">
    <div id="patient-message">
      <h3><i id="med-visit-icon" class="fa fa-clinic-medical"></i> Schedule a Visit</h3>
      <h5>If you need to schedule a visit more than 2 weeks in advance, please call the office at (555) 555-5555.</h5>
    </div>
    <div id="booking">
      <div>
        <h4 id="schedule-visit">Select a date to begin</h4>
        <select
          id="dates"
          v-model="selectedDate"
          v-on:change="getAvailability(selectedDate)"
        >
          <option id="time-options" value="" disabled selected>
          </option>
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
          id="time-btn"
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
    <div id="forms">
      <form
        id="patient-form"
        v-show="selectedTime"
        v-on:submit.prevent="createVisit()"
        class="homeForm"
      >
        <h3 id="patient-header">Patient Visit Form</h3>
        <div>
          <p class="no-space">
            <span class="patient-titles">Name: </span
            ><span>{{ username }}</span>
          </p>
          <p class="no-space">
            <span class="patient-titles">Date: </span
            ><span>{{ selectedDateText }}</span>
          </p>
          <p class="no-space">
            <span class="patient-titles">Time: </span
            ><span>{{ selectedTimeText }}</span>
          </p>

          <select id="reason" v-model="reason" required>
            <option value="" disabled selected>Select reason for visit</option>
            <option
              v-for="reason in reasons"
              v-bind:value="reason.reason"
              v-bind:key="reason.reason"
            >
              {{ reason.reason }}
            </option>
          </select>
        </div>
        <div id="desc" class="form-group">
          <label for="description" class="patient-titles"
            >Add detailed description (optional):</label
          >
          <textarea
            id="description"
            type="text"
            class="form-control"
            v-model="description"
          >
Enter description here
        </textarea
          >
        </div>
        <button class="btn btn-submit" v-on:click="showConfirmation()">
          Submit
        </button>
        <button class="btn btn-cancel" type="cancel" v-on:click="cancelForm()">
          Cancel
        </button>
      </form>
      <div id="confirmation" v-show="confirmed">
        <i id="confo-check" class="fa fa-check-circle"></i>
        <h3 id="confo-header">Your appointment is confirmed!</h3>
        <p id="doc-name" class="no-space">Dr. Steve "Coach" Carmichael</p>
        <p class="no-space">
          <span class="confo-page-title">Date: </span
          ><span class="confo-page"> {{ selectedDateText }}</span>
        </p>
        <p class="no-space">
          <span class="confo-page-title">Time: </span
          ><span class="confo-page">{{ selectedTimeText }}</span>
        </p>
        <p class="no-space">
          <span class="confo-page-title">Reason: </span
          ><span class="confo-page"> {{ reason }}</span>
        </p>
        <p class="no-space">
          <span class="confo-page-title">Visit Details: </span
          ><span class="confo-page"> {{ description }}</span>
        </p>
        <div id="home-button">
          <router-link id="return-home" v-bind:to="{ name: 'user-home' }"
            >Return Home</router-link
          >
        </div>
      </div>
    </div>
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
      confirmed: false,
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
            // this.visit = {};
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
    showConfirmation() {
      this.confirmed = true;
      document.getElementById("dates").disabled = true;
    },
  },
};
</script>

<style>
button {
  margin: 5px;
  background-color: #4674ad;
  color: white;
}
button:hover,
#time-btn:hover {
  background-color: #1e3250;
}
#time-btn {
  margin: 10px 0px 0px 40px;
  background-color: #4674ad;
  color: white;
}
#schedule-visit {
  /* padding: 0 10px; */
  color: #278b90;
}
#patient-form {
  min-width: 500px;
  max-width: 500px;
  padding-top: 20px;
  padding-left: 20px;
  padding-right: 20px;
  padding-bottom: 20px;
  margin: 10px 0px 0px 20px;
  border: 1px solid #ced4da;
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
  border: 1px solid #bfc8d1;
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
#patient-header {
  text-align: center;
  color: #1e3250;
  font-weight: bold;
  padding-bottom: 20px;
}
.patient-titles {
  color: #1e3250;
  font-weight: bold;
}
#patient-message {
  grid-area: message;
  margin-left: 200px;
  margin-bottom: 40px;
  color: #1e3250;
}
#reason,
#dates {
  margin-top: 10px;
  padding: 5px 0px 5px 0px;
}
#desc {
  margin: 20px 0px 20px 0px;
}
#forms {
  grid-area: forms;
}
#booking {
  grid-area: booking;
  background-color: #e0f5f6;
  border-radius: 10px;
  justify-self: center;
  min-width: 400px;
  max-width: 400px;
  min-height: 400px;
  padding-top: 20px;
  padding-left: 80px;
  padding-bottom: 20px;
  margin: 10px 20px 0px 40px;
}
#confirmation {
  grid-area: confirmation;
  margin-left: 30px;
}
#confo-check {
  color: #46a7ad;
  font-size: 150px;
}
#confo-header {
  color: #1e3250;
  margin-top: 20px;
  margin-bottom: 20px;
}
.confo-page-title {
  font-weight: bold;
  color: #1e3250;
  font-size: 20px;
}
.confo-page {
  color: #1e3250;
  font-size: 20px;
}
#doc-name {
  color: #1e3250;
  font-size: 20px;
  font-weight: bold;
}
.no-space {
  padding: 1px;
  margin: 1px;
}
#return-home {
  min-width: 200px;
  height: 40px;
  border-radius: 4px;
  color: white;
  background-color: #46a7ad;
  font-weight: bold;
  padding: 10px 30px 10px 30px;
  text-decoration: none;
}
#return-home:hover {
  background-color: #cdeaec;
  color: #1e3250;
}
#home-button {
  margin-top: 30px;
}
#dates {
  margin-left: 8px;
  color: #1e3250;
  border: 1px solid rgb(202, 195, 195);
}
#reason {
  color: #1e3250;
  border: 1px solid rgb(202, 195, 195);
}
#booking-main {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: 
  "message message"
  "booking forms"
  "booking forms";
}
#med-visit-icon {
  color: #46a7ad;
  font-size: 1.3em;
}
</style>
