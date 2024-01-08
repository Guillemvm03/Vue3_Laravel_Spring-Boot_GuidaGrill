<template>
  <section class="profile">
    <header class="header">
      <div class="details">
        <img :src="state.user.photo" alt="Photo" class="profile-pic">
        <h1 class="heading">{{ state.user.username }}</h1>
        <h1 v-if="state.user.type == 'admin'" class="admin">{{ state.user.type }}</h1>
        <div class="stats">
          <div class="col-4">
            <h4>Contact</h4>
            <p>{{ state.user.email }}</p>
          </div>
        </div>
      </div>
    </header>
  </section>

  <h1 class="titleaa">Your Bookings</h1>
  <div v-if="state.bookings.length===0">
    <p class="nobookings">No bookings yet</p>
  </div>
  <div v-else>
    <UserReservationList/>
  </div>

</template>

<script>
import { computed, reactive, ref } from 'vue';
import Constant from '../Constant';
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
import UserReservationList from '../components/UserReservationList.vue';

export default {
  
    components: { UserReservationList },

  setup() {
    const store = useStore();
    const router = useRouter();

    store.dispatch(`user/${Constant.INITIALIZE_PROFILE}`);
    store.dispatch(`booking/${Constant.INITIALIZE_USER_BOOKING}`);
    
    const state = reactive({
      user: computed(() => store.getters["user/GetProfile"]),
      bookings: computed(() => store.getters["booking/GetUserBooking"]),
    });

   return {
      state
    }
  },

}
</script>
<style scoped>
@import url("https://fonts.googleapis.com/css?family=Lato:400,400i,700");

body {
  margin: 0;
  font-family: 'Lato', sans-serif;
}

.titleaa{
  text-align: center;
  font-size: 3rem;
  margin-top: 2rem;
  margin-bottom: 2rem;
  color: #009FFF;
  background: #ec2F4B;
  background: linear-gradient(to right, #ec2F4B, #009FFF);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

.nobookings{
  text-align: center;
  font-size: 2rem;
  margin-top: 2rem;
  margin-bottom: 2rem;
  color: #009FFF;
  background: #ec2F4B;
  background: linear-gradient(to right, #ec2F4B, #009FFF);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

.header {
  min-height: 79vh;
  background: #009FFF;
  background: linear-gradient(to right, #ec2F4B, #009FFF);
  color: white;
  clip-path: ellipse(100vw 60vh at 50% 50%);
  display: flex;
  align-items: center;
  justify-content: center;
  
}

.details {
  text-align: center;
}

.profile-pic {
  height: 15rem;
  width: 15rem;
  object-fit: center;
  border-radius: 50%;
  border: 2px solid #fff;
  box-shadow: 5px 4px 20px 0px rgb(77, 75, 75);
}

.location p {
  display: inline-block;
}

.location svg {
  vertical-align: middle;
}

.stats {
  display: flex;
  justify-content: space-around;
  padding:1rem;
}

.stats .col-4 {
  width: 10rem;
  text-align: center;
}

.heading {
  font-weight: 400;
  font-size: 2.3rem;
  margin: 1rem 0;
}
.admin{
  font-size: 1.8rem;
  color: red;
  border:solid 1px red;
  border-radius: 6px;
  background-color: white;
  box-shadow: 5px 4px 20px 0px rgb(77, 75, 75);
}

</style>