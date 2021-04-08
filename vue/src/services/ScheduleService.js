import axios from 'axios';


export default {

  getAvailability(doctorId, dateOfVisit, patientId) {
    return axios.get(`/home/scheduling/${patientId}/${doctorId}/${dateOfVisit}`)
  },
  addVisit(visit) {
    return axios.post('/home/scheduling', visit)
  }
}