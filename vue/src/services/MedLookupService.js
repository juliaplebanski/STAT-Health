import axios from 'axios';

// const http = axios.create( {
//    baseURL: process.env.VUE_APP_WEATHER_API
// })


export default {
    getInteractions(medication) {
        return axios.get('https://rxnav.nlm.nih.gov/REST/interaction/interaction.xml?rxcui=?&sources=sources', medication)
    }
}       