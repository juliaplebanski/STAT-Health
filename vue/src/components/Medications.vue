<template>
  <div id="med-main">
    <div id="med-message">
     <h3><i id="med-bottle" class="fa fa-prescription-bottle"></i> Medications</h3>
    <span>
       Current medications on file. Contact the office at
      (555) 555-5555 if you have any questions.
    </span>
    <span id="emergency">Call 911 if you have an emergency. </span>
    </div>
    <div
      class="card"
      v-for="medication in medications"
      v-bind:value="medication.prescriptionId"
      v-bind:key="medication.prescriptionId"
      v-show="medications.length > 0"
    >
      <h5 id="med-header" class="card-header">
        {{ medication.prescriptionName }} {{ medication.dosageAmount }} <i id="med-pill" class="fa fa-pills"></i>
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
        <button id="refill-btn" class="btn btn-primary" data-toggle="tooltip" data-placement="bottom" title="Refills not available. Contact the office for assistance." disabled>Request Refill</button>
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
  color: white;
  background-color: #46a7ad;
  border: none;
}
/* #refill-btn:hover {
  background-color: #92dce0;
  color: white;
} */
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
  margin-left: 20px;
  margin-top: 20px;
  margin-bottom: 40px;
  text-align: left;
  font-size: 1.2em;
  font-weight: 600;
  color: #1e3250;
}
#emergency {
  color: rgb(186, 39, 39);
  font-weight: bold;
}
#med-main {
  margin-left: 40px;
  margin-right: 40px;
}
#med-pill {
  margin-left: 10px;
}
#med-bottle {
  color: #46a7ad;
  font-size: 1.5em;
}
</style>