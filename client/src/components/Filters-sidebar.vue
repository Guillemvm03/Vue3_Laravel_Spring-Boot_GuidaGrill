<template>
  <div class="filters-sidebar">
    <h2>Filtros</h2>
    <label>Available:</label>
    <select v-model="state.filters.available">
      <option :value="0">Available</option>
      <option :value="1">Not Available</option>      
    </select>
    <label>Tipo de Mesa:</label>
    <select v-model="state.filters.category">
      <option value="null">Cualquiera</option>
      <option value="double">Double</option>
      <option value="Outside">Outside</option>
      <option value="VIP">VIP</option>
    </select>   
    <label>Comida:</label>
    <select v-model="state.filters.menu">
      <option value="null">Cualquiera</option>
      <option value="1">Breakfast</option>
      <option value="2">Lunch</option>
      <option value="3">Dinner</option>
      <option value="4">Degustation</option>
    </select>
    <br>
    <button class="btn btn-success" @click="sendData()">Filtrar</button>
  </div>
</template>

<script>
import { reactive } from 'vue';
import { useStore } from 'vuex';
import Constant from '../Constant.js';
import { useRouter } from 'vue-router';

export default {
  props: {
  filters: Object,
  },
  emit:{
    
  },
  setup(props){
    const store = useStore();
    const router = useRouter();
    const filters_ = props.filters;

    const state  = reactive({
      filters : {
        ...props.filters
      }
    })
    console.log(state.filters);
    const sendData = () => {
      if(state.filters.available == 0){
        console.log("available");
        state.filters.available = true;
      }else{
        console.log("not available");
        state.filters.available = false;
      }
      state.filters.all = false;
      console.log(state.filters);

      const filters_64 = btoa(JSON.stringify(state.filters));
      router.push({ name: "bookingFilters", params: { filters: filters_64 } });
    }

    return {state , sendData}
  }
  
};
</script>

<style lang="scss" scoped>
.filters-sidebar {
  padding: 15px;
  border: 1px solid #ccc;
  border-radius: 5px;
}
button{
  margin-top: 10px;
}
label{
  margin-left: 30px;
  margin-right: 10px;
}
</style>