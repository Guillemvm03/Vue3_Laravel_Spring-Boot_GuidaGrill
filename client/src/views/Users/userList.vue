<template>
	<div class="container-xl">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-6">
							<h2>Manage <b>USERS</b></h2>
						</div>
						<div class="col-sm-6">
							<router-link to="/dashboard/users/create"><a class="btn btn-success"><span>Add New
										User</span></a> </router-link>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">

					<div class="col-sm-6 text-center d-flex align-items-center justify-content-end">
						<button @click="deleteMenu()" class="btn btn-danger">Delete</button>
					</div>

					<DataTable class="display" :options="{ select: true }" :columns="columns" :data="state.users"
						ref="usersel">
						<thead>
							<tr>
								<th>ID</th>
								<th>username</th>
								<th>email</th>
								<th>type</th>
								<th>is_active</th>
								<th>photo</th>
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

import { reactive, computed, ref, onMounted } from 'vue';
import DataTable from 'datatables.net-vue3';
import DataTablesLib from 'datatables.net';
import 'datatables.net-select';

import Constant from '../../Constant.js';
import { useRouter } from 'vue-router';
import { useStore } from 'vuex';

export default {

	components: { DataTable },


	setup() {

		const router = useRouter();
		const store = useStore();
		DataTable.use(DataTablesLib);


		store.dispatch(`userDashboard/${Constant.INITIALIZE_USERS}`);

		const state = reactive({

			users: computed(() => store.getters['userDashboard/getUsers'])

		});

		let dt;
		const usersel = ref();
		onMounted(() => {
			dt = usersel.value.dt;
		});

		const columns = [
			{ data: 'id' },
			{ data: 'username' },
			{ data: 'email' },
			{ data: 'type' },
			{ data: 'is_active' },
			{ data: 'photo' },
		];

		function deleteMenu() {
			const indexs = dt.rows({ selected: true })[0];
			if (indexs.length > 0) {
				dt.rows({ selected: true }).every(index => store.dispatch(`userDashboard/${Constant.DELETE_USER}`, state.users[index].id));
				router.push('/dashboard');
			}
		};
		return { state, columns, deleteMenu, usersel }

	}

}
</script>

<style scoped>
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
	background: #e96107;
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