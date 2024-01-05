<template>
    <div class="container-xl">
        <div class="table-responsive">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manage <b>RESERVATIONS</b></h2>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>username</th>
                            <th>Table id</th>
                            <th>Menu</th>
                            <th>Time</th>
                            <th>Day</th>
                            <th>Approved</th>
                            <th>Mensage</th>
                        </tr>
                    </thead>
                    <tbody v-if="reservations">
                        <tr v-for="reservation in reservations.data" :key="reservations.data.id">
                            <td>{{ reservation.id }}</td>
                            <td>{{ reservation.user_id }}</td>
                            <td>{{ reservation.table_id }}</td>
                            <td>{{ reservation.menu_id }}</td>
                            <td>{{ reservation.reservation_time }}</td>
                            <td>{{ reservation.reservation_day }}</td>
                            <td>{{ reservation.approved }}</td>
                            <td>{{ reservation.msg }}</td>
                            <td><button v-if="reservation.approved !== 1" class="btn btn-success"
                                    @click="updateReservation(reservation.id)">Accept
                                    Reservation</button>
                                <button v-else class="btn btn-danger" @click="deleteReservation(reservation.id)">Delete
                                    Reservation</button>

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
import { createToaster } from '@meforma/vue-toaster';

export default {
    props: {
        reservations: Object
    },
    setup(props) {
        const store = useStore();
        const router = useRouter();
        const toaster = createToaster({
            position: 'top-right',
            duration: 2000,
            singleton: true
        });
        const updateReservation = (id) => {
            store.dispatch(`reservationDashboard/${Constant.UPDATE_RESERVATION}`, id)
            toaster.success('Reservation Accepted');
            window.location.reload();
            // router.push('/Dashboard');

        }
        const deleteReservation = (id) => {
            store.dispatch(`reservationDashboard/${Constant.DELETE_RESERVATION}`, id)
            toaster.success('Reservation Deleted');
            window.location.reload();
            //  router.push('/Dashboard');
            
        }
        return {
            updateReservation,
            deleteReservation
        }
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