<template>
    <div class="card text-start">
      <img class="card-img-top" :src="stateOne.tables.img_table" alt="Title">
      <div class="card-body">
        <h4 class="card-title">Número de mesa: {{ stateOne.tables.table_number }}</h4>
        <p class="card-text">Tipo de mesa: {{ stateOne.tables.category }}</p>
        <p class="card-text">Libre: {{ stateOne.tables.available }}</p>
        <p class="card-text">Estado: {{ stateOne.tables.status }}</p>
      </div>
    </div>
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
      background-color: #f8f9fa;
      margin: 0;
      padding: 0;
      display: flex;
      align-items: center;
      justify-content: center;
      min-height: 100vh;
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
      margin: 6%;
      margin-left: 30%;
    }

    .card:hover {
      transform: scale(1.05);
      box-shadow: 0 0 30px rgba(0, 0, 0, 0.3);
    }

    .card-img-top {
      width: 100%;
      height: 200px;
      object-fit: cover;
      display: block;
      margin: 20px auto; /* Centra la imagen y agrega margen superior e inferior */
    }

    .card-body {
      padding: 20px;
    }

    .card-title {
      font-size: 1.5rem;
      margin-bottom: 10px;
    }

    .card-text {
      color: #555;
    }
</style>