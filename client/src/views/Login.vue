<template>
    <LoginForm :isLogin="true" @send="login"  />
</template>

<script> 
import LoginForm from '../components/LoginForm.vue'
import { useStore } from 'vuex'
import Constant from '../Constant'
import UserService from '../services/client/UserService';


export default {
    components: {
        LoginForm
    },
    setup() {
        const store = useStore();

        const login = (data) => {
            // console.log(data);
            store.dispatch(`user/${Constant.LOGIN}`, data);
        }
        return {
            login
        }
    }
}
</script>

<style scoped>

</style>