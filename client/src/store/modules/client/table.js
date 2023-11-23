import Constant from '../../../Constant'
import TableService from '../../../services/client/TablesService'

export const table =  {
    namespaced: true,
    mutations: {
        [Constant.INITIALIZE_TABLES](state, payload) {
            state.tables = payload
        },
        [Constant.INITIALIZE_ONE_STATE_TABLES]: (state, payload) => {
            state.OneTable = payload;
        },
    },
    actions: {
        [Constant.INITIALIZE_TABLES]: async (store) => {
            const response = await TableService.getTables();
                store.commit(Constant.INITIALIZE_TABLES, response.data);
        },
        [Constant.INITIALIZE_ONE_STATE_TABLES]: async (store, payload) => {
            const response = await TableService.GetTableById(payload);
            store.commit(Constant.INITIALIZE_ONE_STATE_TABLES, response.data);
             
    },
},
    getters: {
        GetTables(state) {
            return state.tables;
        }, 
        GetTableById: (state) => {
            return state.OneTable;;
        },       
    }
}