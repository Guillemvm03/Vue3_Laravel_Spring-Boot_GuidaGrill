<template>
    <tableDash :tables="state.tables" />
</template>
<script >
import { reactive, computed } from 'vue';
import tableDash from '../../components/tableDash.vue';
import { useStore } from 'vuex';
import Constant from '../../Constant.js';

export default {
    components: {
        tableDash
    },
    setup() {
        const store = useStore();

        store.dispatch(`tableDashboard/${Constant.INITIALIZE_TABLES}`);

        const state = reactive({
            tables: computed(() => store.getters[`tableDashboard/getTables`]),
        });
        return { state }
    }
}

</script>