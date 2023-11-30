<template>

<h1>Menu List</h1>


    <router-link to="/dashboard/menus/create">
        <button>CREATE</button>
    </router-link>
    <br>
    <button @click="updateMenu()">UPDATE</button>
    <button @click="deleteMenu()">DELETE</button>
    <br>



<DataTable class="display" :options="{ select: true }" :columns="columns" :data="state.menu" ref="tablete">
        <thead>
            <tr>
                <th>ID</th>
                <th>type</th>
                <th>img_Menu</th>
            </tr>
        </thead>
    </DataTable>

<br><br><br><br><br><br>

</template>

<script>
import {reactive, computed, ref, onMounted} from 'vue';
import DataTable from 'datatables.net-vue3';
import DataTablesLib from 'datatables.net';
import 'datatables.net-select';

import Constant from '../../Constant.js';
import { useRouter } from 'vue-router';
import { useStore } from 'vuex';



export default {
    components: { DataTable },
    
    setup() {

        // const toaster = createToaster({ "position": "top-right", "duration": 1500 });
        const store = useStore();
        const router = useRouter();
        DataTable.use(DataTablesLib);

        store.dispatch(`menuDashboard/${Constant.INITIALIZE_MENU}`);

        const state = reactive({
            menu: computed(() => store.getters['menuDashboard/GetMenus'])
        });

        const columns = [
            { data: 'id' },
            { data: 'type' },
            { data: 'img_Menu' },
        ];

        let dt;
        const tablete = ref();
        onMounted(() => {
            dt = tablete.value.dt;
        });


        function updateMenu() {
            const indexs = dt.rows({ selected: true })[0];
            if (indexs.length === 1) {
                const id = state.menu[indexs[0]].id;
                router.push({ name: 'updateMenu', params: { id } })
            } else {
                // toaster.info('You have to select ONE category');
            }
        };

        function deleteMenu() {
            const indexs = dt.rows({ selected: true })[0];
            if (indexs.length > 0) {
                dt.rows({ selected: true }).every(index => store.dispatch(`menuDashboard/${Constant.DELETE_MENU}`, state.menu[index].id));
                router.push('/dashboard/menus');
            } else {
                // toaster.info('You have to at last ONE Menu');
            }
        };

        return { state, columns,tablete, deleteMenu, updateMenu};

    }
}
</script>

<style lang="scss">
@import 'datatables.net-dt';
</style>