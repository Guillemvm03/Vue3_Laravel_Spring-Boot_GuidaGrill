<template>
    <LoginForm :isLogin="true" @sendLogin="login" @sendRegister="register" />
</template>

<script>
import LoginForm from '../components/LoginForm.vue'
import { useStore } from 'vuex'
import Constant from '../Constant'
import { createToaster } from "@meforma/vue-toaster";

const toaster = createToaster({ "position": "top-right", "duration": 1200 });



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
            toaster.success('Register successfully');
            setTimeout(() => {
                store.dispatch(`user/${Constant.ADD_USER}`, data);
            }, 1500);
        }
        return {
            login,
            register
        }
    }
}
</script>

<style scoped></style>