<template>
    <!-- <div class="card text-start">
      <img class="card-img-top" :src="stateOne.tables.img_table" alt="Title">
      <div class="card-body">
        <h4 class="card-title">Número de mesa: {{ stateOne.tables.table_number }}</h4>
        <p class="card-text">Tipo de mesa: {{ stateOne.tables.category }}</p>
        <p class="card-text">Libre: {{ stateOne.tables.available }}</p>
        <p class="card-text">Estado: {{ stateOne.tables.status  }}</p>
        <p class="card-text">Capacidad: {{ stateOne.tables.capacity }}</p>
        <p class="card-text">Menús:</p>
        <p class="card-menu" v-for="menu in stateOne.tables.menu" :key="menu.id">{{ menu.type }}</p>
      </div>
    </div> -->
    <div class="card mb-3" style="max-width: 600px;" >
      <div class="row g-0">
        <div class="col-md-4">
          <img
          :src="stateOne.tables.img_table" alt="Title"
            class="img-fluid rounded-start"
          />
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <h5 class="card-title">Type: {{stateOne.tables.category}}</h5>
            <p class="card-text">Status: {{stateOne.tables.status}}</p>
            <p class="card-text">Menús:</p>
            <p class="card-menu" v-for="menu in stateOne.tables.menu" :key="menu.id">{{ menu.type }}</p>
            <p class="card-text">
              <small class="text-muted"
                >Capacity: {{stateOne.tables.capacity}} people</small
              >
            </p>
          </div>
        </div>
        <button class="btn btn-outline-success">Booking</button>
      </div>
    </div>
    <br><br><br>
    
</template>
<script>
import {computed, reactive} from 'vue'
import {useRouter} from 'vue-router'
import {useStore} from 'vuex'
import Constant from '../Constant';
import Card_tables from '../components/Card_tables.vue';
export default {
    components: { Card_tables
    },
    setup() {
        const router = useRouter()
        const store = useStore()
        const id = router.currentRoute.value.params.id


        store.dispatch(`tables/${Constant.INITIALIZE_ONE_STATE_TABLES}`, id)
        const stateOne = reactive({
          
            tables: computed(() => store.getters["tables/GetTableById"])
        })
        return {stateOne}
    }
}
</script>
<style scoped>
    body {
      font-family: 'Arial', sans-serif;
      background-color: #f6f7f8;
      margin: 0;
      padding: 0;
      display: flex;
      align-items: center;
      justify-content: center;
      min-height: 100vh;
    }
    img{
      width: 100%;
      height: 100%;
    }
    button{
      margin-top: 10px;
    }
    .card {
      max-width: 400px;
      width: 100%;
      border-radius: 15px;
      overflow: hidden;
      box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
      background-color: #fff;
      transition: transform 0.3s, box-shadow 0.3s;
      text-align: center;
      padding: 2%;
      margin: 5% 10%;
      margin-left: 33%;
      
    }
    .card-menu {
      margin-left: 20%;
      font-weight: 800;
    }

    .card-body {
      margin-left: 5%;
      border-radius: 6px;
      padding: 10px;
      background-color: rgba(255, 167, 3, 0.664);
    }

    .card-title {
      font-size: 1.5rem;
      margin-bottom: 10px;
    }

    .card-text {
      color: #555;
    }
</style>