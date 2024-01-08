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
  <div class="pag-a">
  <paginate v-model="state.page" :page-count="state.totalPages" :page-range="3" :margin-pages="2"
            :click-handler="clickCallback" :prev-text="'Prev'" :next-text="'Next'" :container-class="'pagination'"
            :page-class="'page-item'">
        </paginate>
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
import Paginate from 'vuejs-paginate-next';
import { useTablePaginate } from '../composables/tables/useTable';

export default {
  components: { Card_tables , Filters_sidebar, Search, Paginate},





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
      all: true,
      page:1,
      limit:3,
    };

    try {
      if (route.params.filters !== '') {
        filter_url = JSON.parse(atob(route.params.filters));
      }
    } catch (error) {
    }

    const state = reactive({
      tables: useTableFilters(filter_url),
      page: filter_url.page,
      totalPages: useTablePaginate(filter_url)

    });

    const ApplyFilters = (filters1) => {
      filters1.all=false
        const filters_64 = btoa(JSON.stringify(filters1));
        router.push({ name: "bookingFilters", params: { filters: filters_64 } });
        state.tables = useTableFilters(filters1);
        state.totalPages = useTablePaginate(filters1);

    }

    const deleteFilters = (deleteFilters) => {
        router.push({ name: "Bookings" });
        state.tables = useTableFilters(deleteFilters);
        state.page = 1;
        filter_url = deleteFilters;
        state.totalPages = useTablePaginate(deleteFilters);
    }

    const clickCallback = (pageNum) => {
            try {
                if (route.params.filters !== '') {
                  filter_url = JSON.parse(atob(route.params.filters));
                }
            } catch (error) {
            }
            filter_url.page = pageNum;
            state.page = pageNum;
            ApplyFilters(filter_url)
        }

    return { state, filter_url, ApplyFilters, deleteFilters, clickCallback }
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

.pag-a{
display: flex;
justify-content: center;
margin: 0;
}


</style>
