import axios from 'axios';


export default {

  getAvailability(doctorId, dateOfVisit) {
    return axios.get(`/home/scheduling/${doctorId}/${dateOfVisit}`)
  },
  addVisit(visit) {
    return axios.post('/home/scheduling', visit)
  }
}