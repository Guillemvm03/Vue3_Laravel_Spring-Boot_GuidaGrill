import { ref } from 'vue';
import TableService from '../../services/client/TablesService';

export const useTableFilters = (filters = {}) => {
    
    filters.limit = 3;
    
    const tables = ref([])
    TableService.getTables(filters)
        .then(res => { tables.value = res.data })
        .catch(error => console.error(error))
    return tables;
};

export const useTablePaginate = (filters = {}) => {

    const totalPages = ref(0)
    TableService.GetTablesPaginate(filters)
        .then(res => {
            const limit = filters.limit ?? 3;
            const total = res.data;
            const pages = Math.ceil(total / limit);
            totalPages.value = pages;
        })
        .catch(error => console.error(error))
    return totalPages;
};


