import { ref } from 'vue';
import MenuService from '../../services/client/MenuService';

export const useMenusInfinite = (page = 1, menu_number, limit = 3, ) => {
    const menus = ref([])
    console.log(menu_number);
    MenuService.GetmenusInfinite(page,menu_number, limit)
        .then(res => menus.value = res.data)
        .catch(error => console.error(error))

    return menus;
};