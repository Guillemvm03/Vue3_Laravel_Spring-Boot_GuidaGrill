<template>
    <FormUserDashboard @data="createUser" />
</template>

<script>
import { useStore } from 'vuex';
// import { createToaster } from "@meforma/vue-toaster";
import Constant from '../../Constant';
import { useRouter } from 'vue-router';
import FormUserDashboard from '../../components/FormUserDashboard.vue';

export default {
    components: { FormUserDashboard },
    setup() {
        // const toaster = createToaster({ "position": "top-right", "duration": 1500 });
        const store = useStore();
        const router = useRouter();

        const createUser = (data) => {
            
            store.dispatch(`userDashboard/${Constant.ADD_USER}`, data);
            // toaster.success('Category added');
            router.push('/dashboard/users');
        }//createCategory


        return { createUser };
    }
}
</script>