import axios from 'axios';

export default {

  getAvailability(selectedDate) {
    return axios.get('/scheduling', selectedDate)
  },

}