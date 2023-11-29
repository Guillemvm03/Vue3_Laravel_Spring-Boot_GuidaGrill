import { ref } from 'vue';
import TableService from '../../services/client/TablesService';

export const useTableFilters = (filters = {}) => {
    // filters.limit = 9;
    const tables = ref([])
    TableService.getTables(filters)
        .then(res => { tables.value = res.data })
        .catch(error => console.error(error))
    return tables;
};

// export const useMesaPaginate = (filters = {}) => {

//     const totalPages = ref(0)
//     TableService.GetMesasPaginate(filters)
//         .then(res => {
//             const limit = filters.limit ?? 9;
//             const total = res.data;
//             const pages = Math.ceil(total / limit);
//             totalPages.value = pages;
//         })
//         .catch(error => console.error(error))
//     return totalPages;
// };

// export const useMesaInfinite = (page = 1, limit = 3) => {
//     const mesas = ref([])
//     TableService.GetMesasInfinite(page, limit)
//         .then(res => mesas.value = res.data)
//         .catch(error => console.error(error))
//     return mesas;
// };
