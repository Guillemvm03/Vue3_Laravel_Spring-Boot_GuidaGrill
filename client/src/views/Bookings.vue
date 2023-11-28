<template>
    <div class="booking-card">
    <h1>BOOKINGS</h1>
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <card_tables v-for="table in state.tables" :key="table.id" :table="table" />
    </div>
    <br>
</div>
</template>


<script>
import { reactive, computed } from 'vue'
import { useStore } from 'vuex'
import Card_tables from '../components/Card_tables.vue';
import Constant from '../Constant.js';
export default {
    components: { Card_tables },
    setup() {
        const store = useStore();

        store.dispatch(`tables/${Constant.INITIALIZE_TABLES}`)

        
        const state = reactive({
            tables: computed(() => store.getters["tables/GetTables"])
        })
        // console.log(state);

        return { state }
    }
}
</script>
<style lang="scss" scoped>
// .row{
    

// }

.booking-card{
    margin-top: 20px;
    max-width: 1280px;
  margin: 0 auto;
  padding: 2rem;
  text-align: center;


  
}
</style>
```