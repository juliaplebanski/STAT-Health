import axios from 'axios';


export default {

  getAvailability(doctorId, dateOfVisit, patientId) {
    return axios.get(`/home/scheduling/${patientId}/${doctorId}/${dateOfVisit}`)
  },
  addVisit(visit) {
    return axios.post('/home/scheduling', visit)
  },
  getReasons(){
    return axios.get('/home/scheduling')
  },
  getUpcomingVisits(patientId) {
    return axios.get(`/home/${patientId}`)
  },
  getPreviousVisits(patientId) {
    return axios.get(`/home/visits/${patientId}`)
  },
  getMedications(patientId) {
    return axios.get(`/home/medications/${patientId}`)
  },
}