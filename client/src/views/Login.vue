<template>
    <LoginForm :isLogin="true" @sendLogin="login" @sendRegister="register" />
</template>

<script> 
import LoginForm from '../components/LoginForm.vue'
import { useStore } from 'vuex'
import Constant from '../Constant'


export default {
    components: {
        LoginForm
    },
    setup() {
        const store = useStore();

        const login = (data) => {
            store.dispatch(`user/${Constant.LOGIN}`, data);
        }
        const register = (data) => {
            store.dispatch(`user/${Constant.ADD_USER}`, data);
        }
        return {
            login,
            register
        }
    }
}
</script>

<style scoped>

</style>