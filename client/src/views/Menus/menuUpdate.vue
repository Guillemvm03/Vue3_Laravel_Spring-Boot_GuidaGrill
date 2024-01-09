<template>
    <FormMenuDashboard :menu="state.menu" :key="state.menu?.id" @data="updateMenu" />
</template>

<script>
import { reactive, computed } from 'vue';
import { useStore } from 'vuex';
import Constant from '../../Constant';
import { useRouter } from 'vue-router';
import { useRoute } from 'vue-router';
import FormMenuDashboard from '../../components/FormMenuDashboard.vue';

export default {
    components: { FormMenuDashboard },
    setup() {
        const store = useStore();
        const route = useRoute();
        const router = useRouter();

        store.dispatch(`menuDashboard/${Constant.INITIALIZE_ONE_MENU}`, route.params.id);

        const state = reactive({
            menu: computed(() => store.getters['menuDashboard/GetMenu'])
        });

        const updateMenu = (data) => {
            store.dispatch(`menuDashboard/${Constant.UPDATE_MENU}`, data);
            // toaster.success('Category updated');
            router.push('/dashboard');
        }//updateCategory
        return { state, updateMenu };
    }
}
</script>