<template>
  <section class="profile">
    <header class="header">
      <div class="details">
        <img :src="state.user.user.photo" alt="Photo" class="profile-pic">
        <h1 class="heading">{{ state.user.user.username }}</h1>
        <h1 v-if="state.user.user.type == 'admin'" class="admin">{{ state.user.user.type }}</h1>
        <div class="stats">
          <div class="col-4">
            <h4>Contact</h4>
            <p>{{ state.user.user.email }}</p>
          </div>
        </div>
      </div>
    </header>
  </section>
  <h1>Your Bookings</h1>
  <div class="card border-primary">
    <img class="card-img-top" src="holder.js/100px180/" alt="Title" />
    <div class="card-body">
      <h4 class="card-title">Title</h4>
      <p class="card-text">Text</p>
    </div>
  </div>
</template>

<script>
import Constant from '../Constant';
import { useStore } from 'vuex';
export default {

  setup() {
    const store = useStore();

    store.dispatch(`user/${Constant.INITIALIZE_PROFILE}`);
    const state = store.state
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
.card{
  width: 18rem;
  margin: 1rem;
  display: inline-block;
  border-radius: 6px;
  border: #fff;
  box-shadow: 11px 14px 20px 0px rgb(77, 75, 75);
}
</style>