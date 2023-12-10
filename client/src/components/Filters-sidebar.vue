<template>
  <div class="filters-sidebar">
    <h2>Filters tables</h2>
    <!-- <label>Available:</label>
    <select v-model="state.filters.available">
      <option :value="0">Available</option>
      <option :value="1">Not Available</option>      
    </select> -->
    <label>Table Type:</label>
    <select v-model="state.filters.category">
      <option value="double">Double</option>
      <option value="Outside">Outside</option>
      <option value="VIP">VIP</option>
    </select>   
    <label>Type of food:</label>
    <select v-model="state.filters.menu">
      <option value="1">Breakfast</option>
      <option value="2">Lunch</option>
      <option value="3">Dinner</option>
      <option value="4">Degustation</option>
    </select>
    <br>
    <button class="btn btn-success" @click="sendData()">Filtrar</button>
    <button class="btn btn-danger" @click="deleteFilters()">Delete</button>
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
        ...filters_
      }
    })
    const sendData = () => {
     
      state.filters.all = false;
      state.filters.available = true;
      console.log(state.filters);

      const filters_64 = btoa(JSON.stringify(state.filters));
      router.push({ name: "bookingFilters", params: { filters: filters_64 } });      
    }

    const deleteFilters = () => {
      state.filters.all = true;
      state.filters.available = true;
      state.filters.category = "";
      state.filters.menus = null;
      console.log(state.filters);

      // const filters_64 = btoa(JSON.stringify(state.filters));
      // router.push({ name: "bookingFilters", params: { filters: filters_64 } });
      router.push({ name: "Bookings" });
      window.location.reload();
    }

    return {state , sendData, deleteFilters}
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
  margin-left: 10px;}
label{
  margin-left: 30px;
  margin-right: 10px;
}
</style>