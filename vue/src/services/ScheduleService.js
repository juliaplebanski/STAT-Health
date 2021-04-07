import axios from 'axios';

export default {

  getAvailability(doctorId, selectedDate) {
    return axios.get('/home/scheduling/doctorId/selectedDate', doctorId, selectedDate)
  },

}