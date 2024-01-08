<template>
    <ReservationDash :reservations="state.reservations" />
</template>
<script>
import { reactive, computed } from 'vue';
import ReservationDash from '../../components/ReservationDash.vue';
import { useStore } from 'vuex';
import Constant from '../../Constant.js';

export default{
    components: {
        ReservationDash
    },
    setup(){
        const store = useStore();
        store.dispatch(`reservationDashboard/${Constant.INITIALIZE_RESERVATIONS}`);

        const state = reactive({
            reservations: computed(() => store.getters[`reservationDashboard/GetReservations`]),
        });
        return {state}
    }
}
</script>
