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

const store = useStore();

if(localStorage.getItem('token')){
  store.dispatch(`user/${Constant.INITIALIZE_PROFILE}`);
}
// export default{
//   components: { RouterView },
//   router
// }

</script>




