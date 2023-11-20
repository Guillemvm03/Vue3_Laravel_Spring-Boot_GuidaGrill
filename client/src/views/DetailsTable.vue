<template>
    <div class="card text-start">
      <img class="card-img-top" :src="stateOne.tables.img_table" alt="Title">
      <div class="card-body">
        <h4 class="card-title">Número de mesa: {{ stateOne.tables.table_number }}</h4>
        <p class="card-text">Tipo de mesa: {{ stateOne.tables.category }}</p>
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
.card-img-top{
  width: 30%;
  margin: 0 auto;
}
</style>