import Contant from "../../../Constant";
import UserService from "../../../services/admin/UserService.js";

export const userDashboard = {
  namespaced: true,
  actions: {
    [Contant.INITIALIZE_USERS]: async (store) => {
      try {
        const response = await UserService.getUsers();
        if (response.status === 200) {
          store.commit(Contant.INITIALIZE_USERS, response.data.data);
        }
      } catch (error) {
        console.error(error);
      }
    },
    [Contant.INITIALIZE_USER]: async (store, payload) => {
      try {
        const data = store.state.users ?? [];
        const index = data.findIndex((item) => item.id == payload);
        if (index === -1) {
          const response = await UserService.getUser(payload);
          store.commit(Contant.INITIALIZE_USER, response.data.data);
        } else {
          store.commit(Contant.INITIALIZE_USER, store.state.users[index]);
        }
      } catch (error) {
        console.error(error);
      }
    },
    [Contant.DELETE_USER]: async (store, payload) => {
      try {
        const response = await UserService.DeleteUser(payload);
        if (response.status === 200) {
          store.commit(Contant.DELETE_USER, payload);
        }
      } catch (error) {
        console.error(error);
      }
    },
    [Contant.ADD_USER]: async (store, payload) => {
      try {
        const response = await UserService.AddUser(payload);
        if (response.status === 200) {
          store.commit(Contant.ADD_USER, payload);
        }
      } catch (error) {
        console.error(error);
      }
    },
  },
  mutations: {
    [Contant.INITIALIZE_USERS](state, playload) {
      state.users = playload;
    },
    [Contant.GET_USER](state, playload) {
      state.user = playload;
    },
    [Contant.DELETE_USER](state, playload) {
      const index = state.users.findIndex((item) => item.id == playload);
      state.users.splice(index, 1);
    },
    [Contant.ADD_USER](state, playload) {
      state.users.push(playload);
    },
  },
  getters: {
    getUsers(state) {
      return state.users;
    },
    GetUser(state) {
      return state.user;
    },
  },
};
