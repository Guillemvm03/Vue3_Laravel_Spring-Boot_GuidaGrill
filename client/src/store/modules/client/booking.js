import Constant from "../../../Constant";
import BookingService from "../../../services/client/BookingService.js";
import { createToaster } from "@meforma/vue-toaster";
import router from "../../../router/index.js";
const toaster = createToaster({ "position": "top-right", "duration": 2000 });
export const booking = {
  namespaced: true,

  actions: {

    [Constant.INITIALIZE_ONE_BOOKING]: async (store, payload) => {
      try {
        const response = await BookingService.getOneBooking(payload);
        if (response.status === 200) {
          store.commit(Constant.INITIALIZE_ONE_BOOKING, response.data);
        }
      }
      catch (error) {
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
        // toaster.error("Booking error action");
      }
    },

    [Constant.INITIALIZE_USER_BOOKING]: async (store, payload) => {
      try {
        const response = await BookingService.getUserBooking();
        if (response.status === 200) {
          store.commit(Constant.INITIALIZE_USER_BOOKING, response.data);
        }
      }
      catch (error) {
        console.error("Error in catch block:", error);
      }
    }


  },



  mutations: {

    [Constant.ADD_BOOKING]: (state, payload) => {
      if (payload) {
        toaster.success('Booking made successfuly, check your mail to confirm');
        // window.location.reload();
    }
    },

    [Constant.INITIALIZE_ONE_BOOKING]: (state, payload) => {
      state.booking = payload;
    },

    [Constant.INITIALIZE_USER_BOOKING]: (state, payload) => {
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
  },
};
