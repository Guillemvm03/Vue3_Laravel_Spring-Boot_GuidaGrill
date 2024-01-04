import Constant from "../../../Constant";
import BookingService from "../../../services/client/BookingService.js";
import { createToaster } from "@meforma/vue-toaster";
import router from "../../../router/index.js";
const toaster = createToaster({ "position": "top-right", "duration": 2000 });
export const booking = {
  namespaced: true,

  actions: {
    [Constant.ADD_BOOKING]: async (store, payload) => {
      try {
        console.log("payload", payload);
        const response = await BookingService.addBooking(payload);
        if (response.status === 201) {
          store.commit(Constant.ADD_BOOKING, true);
        }
      } catch (error) {
        console.error("Error in catch block:", error);
        // toaster.error("Booking error action");
      }
    },

  },

  mutations: {

    [Constant.ADD_BOOKING]: (state, payload) => {
      if (payload) {
        toaster.success('Booking made successfuly, check your mail to confirm');
        // window.location.reload();
    }
    },

  },

  getters: {},
};
