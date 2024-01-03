<template>
   <HeaderVue />
  <router-view></router-view>  
 <FooterVue/>
</template>

<script setup>
import { RouterView } from 'vue-router'
import FooterVue from './components/Footer.vue';
import HeaderVue from './components/Header.vue';
import { useStore } from 'vuex';
import Constant  from './Constant';


import AOS from "aos";
import "aos/dist/aos.css";

AOS.init();

// watch(menu_number, () => {
//   AOS.refresh();
// });

const store = useStore();

if(localStorage.getItem(('token'))){
  console.log("user");
  
    store.dispatch(`user/${Constant.INITIALIZE_PROFILE}`);  
  
}
// else{
//   console.log("admin");
//   store.dispatch(`user/${Constant.INITIALIZE_PROFILE_ADMIN}`);
// }
</script>




