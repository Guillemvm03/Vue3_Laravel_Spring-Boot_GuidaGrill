<template>
  <div class="filters-sidebar">
    <h2>Filters tables</h2>
    <label>Table Type:</label>
    <select v-model="state.filters.category">
      <option value="double">Double</option>
      <option value="Outside">Outside</option>
      <option value="VIP">VIP</option>
    </select>   
    <label>Type of food:</label>
    <select v-model="state.filters.menus">
      <option :value=[1]>Breakfast</option>
      <option :value=[2]>Lunch</option>
      <option :value=[3]>Dinner</option>
      <option :value=[4]>Degustation</option>
    </select>
    <br>
    <button class="btn btn-success" @click="sendData()">Filter</button>
    <button class="btn btn-danger" @click="deleteFilters()">Delete</button>
  </div>
</template>

<script>
import { getCurrentInstance, reactive } from 'vue';

export default {
  props: {
  filters: Object,
  },
  emit:{
    filters1 : Object,
    deleteFilters : Object,
  },
  setup(props){
    const filters_ = props.filters;
    const { emit } = getCurrentInstance();
    

    const state  = reactive({
      filters : {
        ...filters_
      }
    })
    const sendData = () => {
      emit('filters1', state.filters);    
    }

    const deleteFilters = () => {
      state.filters.category = "";
      state.filters.menus = [];
      state.filters.all = true;
      state.filters.page = 1;
      state.filters.limit = 3;
      emit('deleteFilters', state.filters);
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