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
import { useRouter, useRoute } from 'vue-router';
import { useTableFilters } from '../composables/tables/useTable';

export default {
    components: { Card_tables },
    
    setup() {

        const route = useRoute();
        const router = useRouter();
        // const store = useStore();



          let filter_url = {
          // table_number: 0,
          // capacity: 0,
          // category: "",
          // available: 0,
          // status: "",
          // img_table: "",
          menus: [],
        };

        try {
            if (route.params.filters !== '') {
              filter_url = JSON.parse(atob(route.params.filters));
            }
        } catch (error) {
        }

        const state = reactive({
            tables: useTableFilters(filter_url)

            // page: filter_url.page,
            // totalPages: useMesaPaginate(filter_url)

        });

        // const ApplyFilters = (filters) => {
        //     const filters_64 = btoa(JSON.stringify(filters));
        //     router.push({ name: "reservationFilters", params: { filters: filters_64 } });
        //     state.mesas = useMesaFilters(filters);
        //     state.totalPages = useMesaPaginate(filters);

        // }

        // const deleteAllFilters = (deleteFilters) => {
        //     router.push({ name: "reservation" });
        //     state.mesas = useMesaFilters(deleteFilters);
        //     state.page = 1;
        //     filter_url = deleteFilters;
        //     state.totalPages = useMesaPaginate(deleteFilters);
        // }


        // store.dispatch(`tables/${Constant.INITIALIZE_TABLES}`)

        
        // const state = reactive({
        //     tables: computed(() => store.getters["tables/GetTables"])
        // })

        return { state }
    }
}
</script>
<style lang="scss" scoped>

.booking-card{
    margin-top: 20px;
    max-width: 1280px;
  margin: 0 auto;
  padding: 2rem;
  text-align: center;
}
.card {
    transition: transform 0.3s, box-shadow 0.3s;
    border: none;
    position: relative;
  }

  .card:hover {
    transform: scale(1.05);
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
  }

  .card-body {
    padding: 20px;
  }
</style>
```