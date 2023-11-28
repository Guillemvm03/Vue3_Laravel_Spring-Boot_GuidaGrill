<template>
    <FormMenuDashboard @data="createMenu" />
</template>

<script>
import { useStore } from 'vuex';
// import { createToaster } from "@meforma/vue-toaster";
import Constant from '../../Constant';
import { useRouter } from 'vue-router';
import FormMenuDashboard from '../../components/FormMenuDashboard.vue';
export default {
    components: { FormMenuDashboard },
    setup() {
        // const toaster = createToaster({ "position": "top-right", "duration": 1500 });
        const store = useStore();
        const router = useRouter();

        const createMenu = (data) => {
            
            store.dispatch(`menuDashboard/${Constant.ADD_MENU}`, data);
            // toaster.success('Category added');
            router.push('/dashboard/menus');
        }//createCategory


        return { createMenu };
    }
}
</script>