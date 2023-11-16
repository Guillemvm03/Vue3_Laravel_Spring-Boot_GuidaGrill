import Constant from '../../../Constant'
import TableService from '../../../services/client/TablesService'

export const table =  {
    namespaced: true,
    mutations: {
        [Constant.INITIALIZE_TABLES](state, payload) {
            state.tables = payload
        }
    },
    actions: {
        [Constant.INITIALIZE_TABLES]: async (store) => {
            const response = await TableService.getTables();
                store.commit(Constant.INITIALIZE_TABLES, response.data);
        }
    },
    getters: {
        GetTables(state) {
            return state.tables;
        },        
    }
}