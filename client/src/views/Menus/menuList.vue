<template>

<br><br>


<div class="container-xl">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-6">
							<h2>Manage <b>MENUS</b></h2>
						</div>
						<div class="col-sm-6">
							<router-link to="/dashboard/menus/create"><a class="btn btn-success"><span>Add New
										Menu</span></a> </router-link>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
    
                    <div class="col-sm-6 text-center d-flex align-items-center justify-content-end"> <!-- Clases Bootstrap para centrar y alinear al final -->
                        <button @click="updateMenu()" class="btn btn-primary mr-2">Update</button>
                        <button @click="deleteMenu()" class="btn btn-danger">Delete</button>
                    </div>

                    <DataTable class="display" :options="{ select: true }" :columns="columns" :data="state.menu" ref="tablete">

                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>type</th>
                            <th>img_Menu</th>
                        </tr>
                    </thead>
					<tbody>
						
					</tbody>
                </DataTable>
                
				</table>
			</div>
		</div>
	</div>


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

body {
	color: #566787;
	background: #f5f5f5;
	font-family: 'Varela Round', sans-serif;
	font-size: 13px;
}

.table-responsive {
	margin: 30px 0;
}

.table-wrapper {
	background: #fff;
	padding: 20px 25px;
	border-radius: 3px;
	min-width: 1000px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.table-title {
	padding-bottom: 15px;
	background: #435d7d;
	color: #fff;
	padding: 16px 30px;
	min-width: 100%;
	margin: -20px -25px 10px;
	border-radius: 3px 3px 0 0;
}

.table-title h2 {
	margin: 5px 0 0;
	font-size: 24px;
}

.table-title .btn-group {
	float: right;
}

.table-title .btn {
	color: #fff;
	float: right;
	font-size: 13px;
	border: none;
	min-width: 50px;
	border-radius: 2px;
	border: none;
	outline: none !important;
	margin-left: 10px;
}

.table-title .btn i {
	float: left;
	font-size: 21px;
	margin-right: 5px;
}

.table-title .btn span {

	float: left;
	margin-top: 2px;
}

table.table tr th,
table.table tr td {
	border-color: #e9e9e9;
	padding: 12px 15px;
	vertical-align: middle;
}

table.table tr th:first-child {
	width: 60px;
}

table.table tr th:last-child {
	width: 100px;
}

table.table-striped tbody tr:nth-of-type(odd) {
	background-color: #fcfcfc;
}

table.table-striped.table-hover tbody tr:hover {
	background: #f5f5f5;
}

table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

table.table td:last-child i {
	opacity: 0.9;
	font-size: 22px;
	margin: 0 5px;
}

table.table td a {
	font-weight: bold;
	color: #566787;
	display: inline-block;
	text-decoration: none;
	outline: none !important;
}

table.table td a:hover {
	color: #2196F3;
}

table.table td a.edit {
	color: #FFC107;
}

table.table td a.delete {
	color: #F44336;
}

</style>