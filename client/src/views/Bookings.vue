<template>
  <div class="booking-card">
    <h1>BOOKINGS</h1>
    <div class="filters">
      <Filters_sidebar :filters="filter_url"/>
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
import { onMounted, onUnmounted } from 'vue';

export default {
  components: { Card_tables , Filters_sidebar},

  setup() {

    const route = useRoute();
    const router = useRouter();
    const store = useStore();

    const onRouteChanged = (to, from) => {
      filter_url = JSON.parse(atob(to.params.filters));
      state.tables = useTableFilters(filter_url);
      console.log(state.tables);
    };

    // Registra el hook después de que el componente se haya montado
    onMounted(() => {
      // Usa el hook proporcionado por Vue Router para detectar cambios en la ruta
      router.afterEach(onRouteChanged);
    });

    // Desregistra el hook antes de que el componente se desmonte para evitar fugas de memoria
    onUnmounted(() => {
      router.afterEach(onRouteChanged);
    });


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


    return { state, filter_url }
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
