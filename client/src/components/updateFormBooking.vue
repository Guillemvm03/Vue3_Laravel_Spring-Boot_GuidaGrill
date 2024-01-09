<template>
  <div class="container">
    <form id="contact" action="" method="post">
      <h3>You'r Reservation</h3>
      <h4>Let us now </h4>
      <fieldset>People:
        <input v-model="state.bookingLocal.capacity" placeholder="People" type="text" tabindex="1" required autofocus>
      </fieldset>
      <fields-timet>
        Date:
        <VueDatePicker v-model="state.bookingLocal.date" placeholder="Select a Date" :disabled-dates="disableDates"
          :max-time="maxTime" :min-time="minTime">
        </VueDatePicker>
      </fields-timet>
      <fieldset>
        Message:
        <textarea v-model="state.bookingLocal.msg" placeholder="Type your Message Here...." tabindex="5"
          required></textarea>
      </fieldset>
      <fieldset>
        <button @click="setValues" name="submit" type="button" id="contact-submit"
          data-submit="...Sending">Submit</button>
      </fieldset>
    </form>

  </div>
</template>

<script>
import { computed, reactive, ref, watch } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import { getCurrentInstance } from "vue";
import Constant from "../Constant";
import { useRoute } from "vue-router";

import VueDatePicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";

export default {
  components: {
    VueDatePicker,
  },
  methods: {
    disableDates(date) {
      const today = new Date();
      const oneWeekLater = new Date();
      oneWeekLater.setDate(today.getDate() + 7);
      return date < today || date > oneWeekLater;
    },
  },
  props: {
    booking: {
      type: Object,
    }
  },

  setup(props) {
    const store = useStore();
    const router = useRouter();
    const route = useRoute();
    const { emit } = getCurrentInstance();
    const id = route.params.id;
    const _booking = props.booking;
    const id_table = props.booking.table_id;
    const menuId = props.booking.menu_id;
    const minTime = ref({ hours: 0, minutes: 0 });
    const maxTime = ref({ hours: 0, minutes: 0 });

    const setValues = () => {
      const matchingMenu = state.table.menu.find(menu => menu.id === menuId);
    };

    store.dispatch(`tables/${Constant.INITIALIZE_ONE_STATE_TABLES}`, id_table);

    store.dispatch(`booking/${Constant.INITIALIZE_TABLES_RESERVATION}`, id);

    store.dispatch(`menus/${Constant.INITIALIZE_ONE_MENU}`, 2);
    const state = reactive({
      table: computed(() => store.getters["tables/GetTableById"]),

      tableReservations: computed(() => store.getters["booking/GetBooking"]),

      menu: computed(() => store.getters["menus/GetMenuOne"]),
      bookingLocal: { ..._booking },

      updatebooking: {
        capacity: "",
        msg: "",
        reservationDay: "",
        reservationTime: "",
        date: "",
      }
    });

    return { state, setValues, minTime, maxTime };
  }


}

</script>

<style scoped>
@import url(https://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,600);

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  -webkit-font-smoothing: antialiased;
  -moz-font-smoothing: antialiased;
  -o-font-smoothing: antialiased;
  font-smoothing: antialiased;
  text-rendering: optimizeLegibility;
}

body {
  font-family: "Open Sans", Helvetica, Arial, sans-serif;
  font-weight: 300;
  font-size: 12px;
  line-height: 30px;
  color: #777;
  /* background:#0CF; */
}

.container {
  max-width: 400px;
  width: 100%;
  margin: 0 auto;
  position: relative;
}

#contact input[type="text"],
#contact input[type="email"],
#contact input[type="tel"],
#contact input[type="url"],
#contact textarea,
#contact button[type="button"] {
  font: 400 12px/16px "Open Sans", Helvetica, Arial, sans-serif;
}

#contact {
  background: #F9F9F9;
  padding: 25px;
  margin: 50px 0;
}

#contact h3 {
  color: #F96;
  display: block;
  font-size: 30px;
  font-weight: 400;
}

#contact h4 {
  margin: 5px 0 15px;
  display: block;
  font-size: 13px;
}

fieldset {
  border: medium none !important;
  margin: 0 0 10px;
  min-width: 100%;
  padding: 0;
  width: 100%;
}

#contact input[type="text"],
#contact input[type="email"],
#contact input[type="tel"],
#contact input[type="url"],
#contact textarea {
  width: 100%;
  border: 1px solid #CCC;
  background: #FFF;
  margin: 0 0 5px;
  padding: 10px;
}

#contact input[type="text"]:hover,
#contact input[type="email"]:hover,
#contact input[type="tel"]:hover,
#contact input[type="url"]:hover,
#contact textarea:hover {
  -webkit-transition: border-color 0.3s ease-in-out;
  -moz-transition: border-color 0.3s ease-in-out;
  transition: border-color 0.3s ease-in-out;
  border: 1px solid #AAA;
}

#contact textarea {
  height: 100px;
  max-width: 100%;
  resize: none;
}

#contact button[type="button"] {
  cursor: pointer;
  width: 100%;
  border: none;
  background: #0CF;
  color: #FFF;
  margin: 0 0 5px;
  padding: 10px;
  font-size: 15px;
}

#contact button[type="button"]:hover {
  background: #09C;
  -webkit-transition: background 0.3s ease-in-out;
  -moz-transition: background 0.3s ease-in-out;
  transition: background-color 0.3s ease-in-out;
}

#contact button[type="button"]:active {
  box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.5);
}

#contact input:focus,
#contact textarea:focus {
  outline: 0;
  border: 1px solid #999;
}

::-webkit-input-placeholder {
  color: #888;
}

:-moz-placeholder {
  color: #888;
}

::-moz-placeholder {
  color: #888;
}

:-ms-input-placeholder {
  color: #888;
}
</style>