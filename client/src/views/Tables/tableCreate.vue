<template>
    <Form_table_dash @data="create_emit"/>
</template>
<script>
import Form_table_dash from '../../components/form_table_dash.vue';
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
import Constant from '../../Constant';
import { createToaster } from "@meforma/vue-toaster";
export default {
    components: {
        Form_table_dash
    },
    setup() {
        const toaster = createToaster({ position: "top-right" });
        const store = useStore();
        const router = useRouter();
        const create_emit = (data) => {
            console.log(data);
            store.dispatch(`tableDashboard/${Constant.CREATE_TABLE}`, data)
            toaster.success("Table created")
            router.push("/Dashboard/tables")
        }
        return {
            create_emit
        }
    }
};

</script>