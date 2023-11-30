import Constant from '../../../Constant';
import MenuService from '../../../services/client/MenuService';

export const menu = {
    namespaced: true,
    actions: {
        [Constant.INITIALIZE_MENU]: async (store) => {
            try {
                const response = await MenuService.getMenus();
                store.commit(Constant.INITIALIZE_MENU, response.data);
            } catch (error) {
                console.error(error);
            }
        },

    },
    mutations: {
        [Constant.INITIALIZE_MENU]: (state, payload) => {
            if (payload) {
                state.menu = payload;
            }
        }
    },
    getters: {
        GetMenu(state) {
            return state.menu;
        }
    }
}