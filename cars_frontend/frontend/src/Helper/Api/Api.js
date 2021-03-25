import axios from "axios";

const BASE = "http://localhost:8080//api/cars";

export default {
    getCars:async()=>{
        const response = await axios.get(`${BASE}/allcars`);
        if(response.data){
            const dados = response.data.map(function(obj) {
                return { brand: obj.brand, model: obj.model, year:obj.year};
            });
            return(dados);
        }     
    },

    getAllCarsByPartsValue:async()=>{
        const response = await axios.get(`${BASE}/sortedcars`);
        if(response.data){
            const dados = response.data.map(function(obj) {
                return { brand: obj.brand, model: obj.model, year:obj.year};
            });
            console.log("dados");
            console.log(dados);
            return(dados);
        }     
    },

    getDamagedCars:async()=>{
        const response = await axios.get(`${BASE}/damagedcars`);
        if(response.data){
            const dados = response.data.map(function(obj) {
                return { brand: obj.brand, model: obj.model, year:obj.year};
            });
            return(dados);
        }     
    },

    getDamagedParts:async()=>{
        const response = await axios.get(`${BASE}/listparts`);
        if(response.data){
            return(response.data);
        }     
    },

}