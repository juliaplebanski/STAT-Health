import axios from 'axios';


export default {

  getAvailability(doctorId, dateOfVisit) {
    return axios.get(`/home/scheduling/${doctorId}/${dateOfVisit}`, doctorId, dateOfVisit)
  },

}