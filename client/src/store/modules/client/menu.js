import Constant from '../../../Constant';
import MenuService from '../../../services/client/MenuService';

export const menu = {
    namespaced: true,
    actions: {
        [Constant.INITIALIZE_MENU]: async ({ commit }, searchMeal) => {
          try {
            const response = await MenuService.getMenus();
      
            if (searchMeal) {
              const filteredMenus = response.data.filter(menu => {
                return menu.meals.some(meal => meal.name.includes(searchMeal));
              });
      
              commit(Constant.INITIALIZE_MENU, filteredMenus);
            } else {
              commit(Constant.INITIALIZE_MENU, response.data);
            }
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
        },
        GetMenuFiltered(state){
            return state.menuFiltered;
        }
    }
}