import Constant from '../../../Constant';
import MenuServiceDashboard from '../../../services/admin/MenuServiceDashboard';

export const menuDashboard = {
    namespaced: true,
    actions: {

        [Constant.INITIALIZE_MENU]: async (store) => {
            try {
                const response = await MenuServiceDashboard.GetMenus();
                store.commit(Constant.INITIALIZE_MENU, response.data.data);
                console.log(response.data.data);
            } catch (error) {   
                console.error(error);
            }
        },
        [Constant.INITIALIZE_ONE_MENU]: async (store, payload) => {
            try {
                const data = store.state.menus ?? [];
                const index = data.findIndex(item => item.id == payload);
                if (index === -1) {
                    const response = await MenuServiceDashboard.GetMenu(payload);
                    store.commit(Constant.INITIALIZE_ONE_MENU, response.data.data);
                } else {
                    store.commit(Constant.INITIALIZE_ONE_MENU, store.state.menus[index]);
                }
            } catch (error) {
                console.error(error);
            }
        },
        [Constant.ADD_MENU]: async (store, payload) => {
            try {
                const response = await MenuServiceDashboard.CreateMenu(payload);
                if (response.status === 201) {
                    store.commit(Constant.ADD_MENU, response.data.data);
                }
            } catch (error) {
                console.error(error);
            }
        },
        [Constant.DELETE_MENU]: async (store, payload) => {
            try {
                const response = await MenuServiceDashboard.DeleteMenu(payload);
                if (response.status === 200) {
                    store.commit(Constant.DELETE_MENU, payload);
                }
            } catch (error) {
                console.error(error);
            }
        },
        [Constant.UPDATE_MENU]: async (store, payload) => {
            try {
                const response = await MenuServiceDashboard.UpdateMenu(payload);
                if (response.status === 200) {
                    store.commit(Constant.UPDATE_MENU, payload);
                }
            } catch (error) {
                console.error(error);
            }
        },

    },//actions
    mutations: {

        [Constant.INITIALIZE_MENU]: (state, payload) => {
            if (payload) {
                console.log(payload);
                state.menu = payload;
            }
        },
        [Constant.INITIALIZE_ONE_MENU]: (state, payload) => {
            if (payload) {
                state.menus = payload;
            }
        },
        [Constant.ADD_MENU]: (state, payload) => {
            if (payload) {
                state.menu.push(payload);
            }
        },
        [Constant.DELETE_MENU]: (state, payload) => {
            if (payload) {
                state.menu = state.menu.filter(item => item.id !== payload);
            }
        },
        [Constant.UPDATE_MENU]: (state, payload) => {
            const index = (state.menu ?? []).findIndex(item => item.id == payload.id);
            if (index !== -1) {
                state.menu[index] = payload;
            }
        },
       
    },//mutations
    getters: {

        GetMenus(state) {
            return state.menu;
        },
           GetMenu(state) {
            return state.menus;
        },
        
    }//getters

}//export

