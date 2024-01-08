import Constant from "../../../Constant";
import BookingService from "../../../services/client/BookingService.js";
import { createToaster } from "@meforma/vue-toaster";
const toaster = createToaster({ position: "top-right", duration: 2000 });
export const booking = {
  namespaced: true,

  actions: {
    [Constant.INITIALIZE_TABLES_RESERVATION]: async (store, payload) => {
      try {
        const response = await BookingService.getTablesBooking(payload);
        if (response.status === 200) {
          store.commit(Constant.INITIALIZE_TABLES_RESERVATION, response.data);
        }
      } catch (error) {
        console.error("Error in catch block:", error);
      }
    },

    [Constant.ADD_BOOKING]: async (store, payload) => {
      try {
        const response = await BookingService.addBooking(payload);
        if (response.status === 201) {
          store.commit(Constant.ADD_BOOKING, true);
        }
      } catch (error) {
        console.error("Error in catch block:", error);
      }
    },

    [Constant.INITIALIZE_USER_BOOKING]: async (store, payload) => {
      try {
        const response = await BookingService.getUserBooking();
        if (response.status === 200) {
          store.commit(Constant.INITIALIZE_USER_BOOKING, response.data);
        }
      } catch (error) {
        console.error("Error in catch block:", error);
      }
    },

    [Constant.DELETE_USER_BOOKING]: async (store, payload) => {
      try {
        const response = await BookingService.deleteUserBooking(payload);
        if (response.status === 200) {
          store.dispatch(Constant.INITIALIZE_USER_BOOKING);
        }
      } catch (error) {
        console.error("Error in catch block:", error);
      }
    },

    [Constant.INITIALIZE_ONE_BOOKING]: async (store, payload) => {
      try {
        const response = await BookingService.getOneBooking(payload);
        if (response.status === 200) {
          store.commit(Constant.INITIALIZE_ONE_BOOKING, response.data);
        }
      } catch (error) {
        console.error("Error in catch block:", error);
      }
    },

    [Constant.UPDATE_USER_BOOKING]: async (store, payload) => {
      try {
        const response = await BookingService.updateUserBooking(payload);
        if (response.status === 200) {
          store.dispatch(Constant.INITIALIZE_USER_BOOKING);
        }
      } catch (error) {
        console.error("Error in catch block:", error);
      }
    },
  },

  mutations: {
    [Constant.INITIALIZE_TABLES_RESERVATION]: (state, payload) => {
      state.booking = payload;
    },

    [Constant.INITIALIZE_USER_BOOKING]: (state, payload) => {
      state.userBooking = payload;
    },

    [Constant.DELETE_USER_BOOKING]: (state, payload) => {
      state.userBooking = payload;
    },
    [Constant.INITIALIZE_ONE_BOOKING]: (state, payload) => {
      state.bookingone = payload;
    },
    [Constant.UPDATE_USER_BOOKING]: (state, payload) => {
      state.userBooking = payload;
    },
  },

  getters: {
    GetBooking: (state) => {
      return state.booking;
    },
    GetUserBooking: (state) => {
      return state.userBooking;
    },
    GetBookingOne: (state) => {
      return state.bookingone;
    },
  },
};
