<template>
 <div id="home">
  <div class="home">

<p class = "emergency" id= "emergency">
  IF THIS IS AN EMERGENCY
</p>
<p class = "emergency" id= "emergency">
  PLEASE DIAL 9-1-1       <i class="fa fa-ambulance" id= "emergency_icon"></i> 


</p>

<h2>Making Healthcare Better, Together</h2>

<h3>Schedule the care you need</h3>
<div id ="icon-information">
      <nav class ="nav">
        <div id= "Visit">
    <i class="fa fa-clinic-medical"></i><p class = "details"> Visits </p> &nbsp;&nbsp;
    <p>
       View past visits, <br /> 
       view upcoming visits, <br /> 
       and schedule a visit.
    </p>
    </div>

    <div id ="Test-Results">
    <i class="fa fa-syringe"></i><p class = "details"> Test Results </p>&nbsp;&nbsp;
  <p>
View past test result information, <br/> 
directly sent from your doctor.
    </p>
  </div>
  <div id= "Medications">
    <i class="fa fa-prescription-bottle"></i><p class = "details"> Medications </p>&nbsp;&nbsp;
<p>
View current prescriptions, <br/>
and request refills.
    </p>
  </div>

<div id = "Billing-Insurance">
    <i class="fa fa-clipboard-list"></i><p class = "details"> Billing & Insurance </p>
   <p>  View your bill and pay, <br/>
     for a recent visit as well as see what <br/>
     services your insurance covers. </p>
</div>
      </nav>
  </div>
  </div>
  
 </div>
</template>

<script>

export default {
  name: "home",

};
</script>


<style>
#Visit {
  grid-area: visit;
  display: flex;
  flex-direction: column;
}
#Test-Results {
  grid-area: test-results;
  display: flex;
  flex-direction: column;
}
#Medications {
  grid-area: medications;
  display: flex;
  flex-direction: column;
}
#Billing-Insurance {
  grid-area: billing-insurance;
  display: flex;
  flex-direction: column;
}
#icon-information {
  color: #1e3250;
  background-color: white;
  display: flex;
  justify-content: space-evenly;

}


.nav{
  font-size: 55px;
  display: flex-end;
  justify-content: space-between;


}
.emergency{
display: flex-end;
font-size: 15px;
display: flex;
justify-content: flex-end;
color: red;
font-weight: bold;


}

#emergency_icon{
font-size: 25px;
margin-left: 22px;
}

.details{
  font-size: 20px;
  /*font-style: italic;*/
  color: black;

}

h2{
  text-align: center;
font-style: italic;
}

h3{
font-style: italic;

}
p{
  color: black;
  font-size: 12px;
}
 </style>

