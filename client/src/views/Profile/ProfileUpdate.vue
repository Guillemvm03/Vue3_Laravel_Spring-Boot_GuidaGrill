<template>


  <!-- <div v-if="stateOne.mesas">
    <form_details :reservations="stateOne.mesas.reservations" @send_data="reservation_emit" />
  </div>
  <div v-else>
    <span>Table not available</span>
  </div>
 -->

 <updateFormBooking :booking="state.booking"/>

</template>

<script>
import { reactive, computed, ref } from 'vue'
import { useStore } from 'vuex'
import { useRoute, useRouter } from 'vue-router'
import Constant from '../../Constant';

import updateFormBooking from '../../components/updateFormBooking.vue';

export default {
  components: { updateFormBooking },



  setup() {
    const store = useStore();
    const route = useRoute();
    const router = useRouter();
    const id = route.params.id;  

	  const updatebooking = () => {
			
	}

    store.dispatch(`booking/${Constant.INITIALIZE_ONE_BOOKING}`, id);

	// store.dispatch(`table/${Constant.INITIALIZE_ONE_STATE_TABLES}`, id);
    const state = reactive({

      booking: computed(() => store.getters["booking/GetBookingOne"]),


    })
	

    return { state, updatebooking }
  }

};
</script>

<style scoped>

</style>