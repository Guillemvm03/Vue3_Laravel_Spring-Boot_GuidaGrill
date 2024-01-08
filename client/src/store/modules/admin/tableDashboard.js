import Constant from "../../../Constant.js";
import tableServiceDashboard from "../../../services/admin/tableServiceDashboard.js";

export const tableDashboard = {
  namespaced: true,
  mutations: {
    [Constant.INITIALIZE_TABLES](state, payload) {
      state.tables = payload;
    },
    [Constant.DELETE_TABLE](state, payload) {
      state.tables = state.tables.filter(
        (itemTable) => itemTable.id !== payload
      );
    },
    [Constant.CREATE_TABLE]: (state, payload) => {
      state.tables.push({ ...payload });
    },
    [Constant.INITIALIZE_ONE_STATE_TABLES](state, payload) {
      state.OneTable = payload;
    },
    [Constant.UPDATE_TABLE]: (state, payload) => {
      state.tables = payload;
    },
  },
  actions: {
    [Constant.INITIALIZE_TABLES]: async (store) => {
      const response = await tableServiceDashboard.getTables();
      store.commit(Constant.INITIALIZE_TABLES, response.data);
    },
    [Constant.INITIALIZE_ONE_STATE_TABLES]: async (store, payload) => {
      const response = await tableServiceDashboard.getTableById(payload);
      store.commit(Constant.INITIALIZE_ONE_STATE_TABLES, response.data.data);
    },

    [Constant.DELETE_TABLE]: async (store, payload) => {
      await tableServiceDashboard.deteleTable(payload);
      store.commit(Constant.DELETE_TABLE, payload);
    },
    [Constant.CREATE_TABLE]: async (store, payload) => {
      const response = await tableServiceDashboard.createTable(payload);
      store.commit(Constant.CREATE_TABLE, response.data);
    },
    [Constant.UPDATE_TABLE]: async (store, payload) => {
      const response = await tableServiceDashboard.UpdateTable(payload);
      store.commit(Constant.UPDATE_TABLE, response.data);
    },
  },
  getters: {
    getTables(state) {
      return state.tables;
    },
    getOneTable(state) {
      return state.OneTable;
    },
  },
};
