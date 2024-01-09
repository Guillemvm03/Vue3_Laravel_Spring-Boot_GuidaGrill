<template>
    <FormMenuDashboard @data="createMenu" />
</template>

<script>
import { useStore } from 'vuex';
import Constant from '../../Constant';
import { useRouter } from 'vue-router';
import FormMenuDashboard from '../../components/FormMenuDashboard.vue';
export default {
    components: { FormMenuDashboard },
    setup() {
        const store = useStore();
        const router = useRouter();

        const createMenu = (data) => {

            store.dispatch(`menuDashboard/${Constant.ADD_MENU}`, data);
            // toaster.success('Category added');
            router.push('/dashboard');
        }//createCategory


        return { createMenu };
    }
}
</script>