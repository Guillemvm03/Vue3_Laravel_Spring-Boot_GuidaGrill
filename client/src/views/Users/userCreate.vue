<template>
    <FormUserDashboard @data="createUser" />
</template>

<script>
import { useStore } from 'vuex';
import Constant from '../../Constant';
import { useRouter } from 'vue-router';
import FormUserDashboard from '../../components/FormUserDashboard.vue';

export default {
    components: { FormUserDashboard },
    setup() {
        const store = useStore();
        const router = useRouter();

        const createUser = (data) => {

            store.dispatch(`userDashboard/${Constant.ADD_USER}`, data);
            router.push('/dashboard/users');
        }//createCategory
        return { createUser };
    }
}
</script>