<template>
  <div id="med-main">
    <span id="med-message">
      These are your medications currently on file. Please contact the office at
      (555) 555-5555 if you have any questions.
    </span>
    <span id="emergency">Call 911 if you have an emergency. </span>
    <div
      class="card"
      v-for="medication in medications"
      v-bind:value="medicaton.prescriptionId"
      v-bind:key="medication.prescriptionId"
      v-show="medications.length > 0"
    >
      <h5 id="med-header" class="card-header">
        {{ medication.prescription_name }} {{ medication.dosage_amount }}
      </h5>
      <div class="card-body">
        <p class="med-title">
          <span> About this medication: </span
          ><span class="uv-text">{{ medication.description }}</span>
        </p>
        <p class="med-title">
          <span> Instructions: </span
          ><span class="med-text">{{ medication.instructions }}</span>
        </p>
        <a href="#" id="refill-btn" class="btn btn-primary">Request Refill</a>
      </div>
    </div>
  </div>
</template>

<script>
import scheduleService from "../services/ScheduleService.js";
export default {
  name: "medications",
  data() {
    return {
      userId: this.$store.state.user.id,
      medications: [],
    };
  },
  created() {
    this.getMedications();
  },
  methods: {
    getMedications() {
      scheduleService
        .getMedications(this.userId)
        .then((response) => {
          if (response.status == "200") {
            console.log(response.status + " 2");
            this.medications = response.data;
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style>
.card {
  margin: 20px;
}
#refill-btn {
  /* min-width: 200px;
  max-width: 200px;
  height: 40px; */
  color: white;
  background-color: #46a7ad;
  /* padding-top: 8px;
  padding-left: 30px;
  font-size: 1.1em;
  font-weight: bold;
  text-decoration: none;
  border-radius: 8px;
  align-self: flex-end; */
}
#refill-btn:hover {
  background-color: #92dce0;
  color: white;
}
#med-header {
  background-color: #4674ad;
  text-align: left;
  padding: 10px;
  color: white;
  font-weight: bold;
}
.med-title {
  color: #1e3250;
  font-weight: bold;
}
.med-text {
  text-align: left;
  padding: 5px;
  color: #1e3250;
  background-color: white;
  font-weight: normal;
}
#med-message {
  margin-left: 200px;
  margin-bottom: 40px;
  font-size: 1.2em;
  font-weight: bold;
  color: #1e3250;
}
#emergency {
  margin-left: 200px;
  margin-bottom: 40px;
  color: rgb(186, 39, 39);
  font-size: 1.2em;
  font-weight: bold;
}
</style>