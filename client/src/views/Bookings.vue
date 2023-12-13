<template>
  
  <div class="booking-card">
    <h1>BOOKINGS</h1>
    <div class="filters">
      <Filters_sidebar @filters1="ApplyFilters" @deleteFilters="deleteFilters" :filters="filter_url"/>
    </div>
    <br>
    <div v-if="state.tables.length > 0" class="row row-cols-1 row-cols-md-3 g-4">
      <Card_tables v-for="table in state.tables" :key="table.id" :table="table" />
    </div>

    <div v-else>
      <h2>There are no tables available with the selected filters.</h2>
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
import Filters_sidebar from '../components/Filters-sidebar.vue';
import Search from '../components/Search.vue';

export default {
  components: { Card_tables , Filters_sidebar, Search},

  setup() {

    const route = useRoute();
    const router = useRouter();
    const store = useStore();

    let filter_url = {
      // table_number: 0,
      // capacity: 0,
      category: "",
      available: 0,
      // status: "",
      // img_table: "",
      menus: [],
      all: true
    };

    try {
      if (route.params.filters !== '') {
        filter_url = JSON.parse(atob(route.params.filters));
      }
    } catch (error) {
    }

    const state = reactive({
      tables: useTableFilters(filter_url),
      // page: filter_url.page,
      // totalPages: useMesaPaginate(filter_url)

    });

    const ApplyFilters = (filters1) => {
      filters1.all = false;
        const filters_64 = btoa(JSON.stringify(filters1));
        router.push({ name: "bookingFilters", params: { filters: filters_64 } });
        state.tables = useTableFilters(filters1);
        // state.totalPages = useMesaPaginate(filters);

    }

    const deleteFilters = (deleteFilters) => {
        console.log("entra");
      deleteFilters.all = true;
        router.push({ name: "Bookings" });
        state.tables = useTableFilters(deleteFilters);
        // state.page = 1;
        filter_url = deleteFilters;
        // state.totalPages = useTableFilters(deleteFilters);
    }


    return { state, filter_url, ApplyFilters, deleteFilters }
  }
}
</script>
<style lang="scss" scoped>
.booking-card {
  margin-top: 20px;
  max-width: 1280px;
  margin: 0 auto;
  padding: 2rem;
  text-align: center;
}
h2{
  color: red;
  padding: 40px;
  text-align: center;
  font-size: 30px;
}
</style>
