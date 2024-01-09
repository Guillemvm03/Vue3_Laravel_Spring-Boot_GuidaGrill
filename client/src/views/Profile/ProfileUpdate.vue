<template>
  <updateFormBooking :booking="state.booking" />
</template>

<script>
import { reactive, computed } from 'vue'
import { useStore } from 'vuex'
import { useRoute, useRouter } from 'vue-router'
import Constant from '../../Constant';

import updateFormBooking from '../../components/updateFormBooking.vue';

export default {
  components: { updateFormBooking },



  setup() {
    const store = useStore();
    const route = useRoute();
    const id = route.params.id;

    store.dispatch(`booking/${Constant.INITIALIZE_ONE_BOOKING}`, id);

    const state = reactive({

      booking: computed(() => store.getters["booking/GetBookingOne"]),

    })
    return { state, updatebooking }
  }

};
</script>

<style scoped></style>