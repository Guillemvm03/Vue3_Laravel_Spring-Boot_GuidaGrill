<template>
	<div class="container-xl">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-6">
							<h2>Manage <b>TABLES</b></h2>
						</div>
						<div class="col-sm-6">
							<router-link to="/Dashboard/Tables/tableCreate"><a class="btn btn-success"><span>Add New
										Table</span></a> </router-link>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>NUMBER TABLE</th>
							<th>CAPACITY</th>
							<th>CATEGORY</th>
							<th>AVAILABLE</th>
							<th>STATUS</th>
							<th>IMAGEN TABLE</th>
							<th>MENUS</th>
						</tr>
					</thead>
					<tbody v-if="tables">
						<tr v-for="table in tables.data" :key="tables.data.id">
							<td>{{ table.id }}</td>
							<td>{{ table.table_number }}</td>
							<td>{{ table.capacity }}</td>
							<td>{{ table.category }}</td>
							<td>{{ table.available }}</td>
							<td>{{ table.status }}</td>
							<td>{{ table.img_table }}</td>
							<td>
								<template v-for="menu in table.menus">
									<div>{{ menu.type }}</div>
								</template>
							</td>
							<td>
								<button class="btn btn-success" @click="updateTable(table.id)">Edit</button>
							</td>
							<td>
								<button class="btn btn-danger" @click="deleteTable(table.id)">Delete</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</template>

<script>
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
import Constant from '../Constant';
import { createToaster } from "@meforma/vue-toaster";

export default {
	props: {
		tables: Object,
	},
	setup(props) {
		const toaster = createToaster({ position: "top-right" });
		const store = useStore();
		const router = useRouter();
		const tableCreate = () => {
			router.push("tables")

		}

		const deleteTable = (id) => {
			store.dispatch(`tableDashboard/${Constant.DELETE_TABLE}`, id)
			toaster.success("Table deleted")
			window.location.reload()
		}
		const updateTable = (id) => {
			router.push("/Dashboard/Tables/tableEdit/" + id)
		}
		return { deleteTable, tableCreate, updateTable }
	}
}
</script>
<style scoped>
body {
	color: #e95e0e;
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