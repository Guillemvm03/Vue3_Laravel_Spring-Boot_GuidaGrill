import Constant from "../../../Constant";
import ReservationServiceDashboard from "../../../services/admin/ReservationServiceDashboard";

export const reservationDashboard = {
    namespaced: true,
    actions:{
        [Constant.INITIALIZE_RESERVATIONS]: async (store) => {
            try {
                const response = await ReservationServiceDashboard.GetReservations();
                store.commit(Constant.INITIALIZE_RESERVATIONS, response.data);
            } catch (error) {
                console.error(error);
            }
        },
        [Constant.INITIALIZE_ONE_RESERVATION]: async (store, payload) => {
            try {
                const data = store.state.reservations ?? [];
                const index = data.findIndex(item => item.id == payload);
                if (index === -1) {
                    const response = await ReservationServiceDashboard.GetReservation(payload);
                    store.commit(Constant.INITIALIZE_ONE_RESERVATION, response.data);
                } else {
                    store.commit(Constant.INITIALIZE_ONE_RESERVATION, store.state.reservations[index]);
                }
            } catch (error) {
                console.error(error);
            }
        },
        [Constant.UPDATE_RESERVATION]: async (store, payload) => {
            console.log(payload);
            try {
                const response = await ReservationServiceDashboard.UpdateReservation(payload);
                console.log(response);
                store.commit(Constant.UPDATE_RESERVATION, response.data);
            } catch (error) {
                console.error(error);
            }
        },
        [Constant.DELETE_RESERVATION]: async (store, payload) => {
            try {
                const response = await ReservationServiceDashboard.DeleteReservation(payload);
                store.commit(Constant.DELETE_RESERVATION, response.data);
            } catch (error) {
                console.error(error);
            }
        }

    },
    mutations:{
        [Constant.INITIALIZE_RESERVATIONS]: (state, payload) => {
            state.reservations = payload;

        },
        [Constant.INITIALIZE_ONE_RESERVATION]: (state, payload) => {
            state.reservation = payload;
        },
        [Constant.UPDATE_RESERVATION]: (state, payload) => {
            console.log(payload);
            state.reservations = payload;
        },
    },
    getters:{
        GetReservations: (state) => {
            return state.reservations;
        },
        GetReservation: (state) => {
            return state.reservation;
        },
    }
}