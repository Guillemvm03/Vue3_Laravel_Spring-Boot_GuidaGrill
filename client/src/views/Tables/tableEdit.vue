<template>
    <form_table_dashVue :table="stateOneTable.table" :key="stateOneTable.table?.id" @data="updateTable"/>
</template>
<script>
import Form_table_dash from '../../components/form_table_dash.vue';
import { createToaster } from "@meforma/vue-toaster";
import Constant from '../../Constant';
import { useRouter, useRoute } from 'vue-router';
import { useStore } from 'vuex';
import { reactive, computed } from "vue";
import form_table_dashVue from '../../components/form_table_dash.vue';
export default {
    components: {
        form_table_dashVue
    },
    setup() {
        const toaster = createToaster({ position: "top-right" });
        const router = useRouter();
        const store = useStore();
        const route = useRoute();
        const id = route.params.id;

        store.dispatch(`tableDashboard/${Constant.INITIALIZE_ONE_STATE_TABLES}`, id);

        const stateOneTable = reactive( {
            table: computed(() => store.getters['tableDashboard/getOneTable'])
        });

        const updateTable = (table) => {
            store.dispatch(`tableDashboard/${Constant.UPDATE_TABLE}`, table)
            toaster.success("Table updated")
            router.push("/Dashboard/tables")
            // window.location.reload();
        }
        return { updateTable, stateOneTable }
    }
}
</script>