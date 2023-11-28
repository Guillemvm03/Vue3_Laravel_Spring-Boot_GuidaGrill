import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router'
import store from './store'
import VueLazyLoad from 'vue3-lazyload';
import 'bootstrap/dist/css/bootstrap.min.css'
import Toastr from '@meforma/vue-toaster';

const app = createApp(App);
app.use(router);
app.use(store);
app.use(Toastr);
app.use(VueLazyLoad);
app.mount('#app');
import 'bootstrap/dist/js/bootstrap.min.js'
