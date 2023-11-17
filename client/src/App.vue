<template>
   <HeaderVue />
  <router-view></router-view>  
 <FooterVue/>
</template>

<script setup>
import { RouterView } from 'vue-router'
import router from './router';
import FooterVue from './components/Footer.vue';
import HeaderVue from './components/Header.vue';

// export default{
//   components: { RouterView },
//   router
// }

</script>




