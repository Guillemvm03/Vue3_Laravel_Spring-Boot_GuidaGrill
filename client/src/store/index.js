import Vuex from 'vuex';

import {table} from './modules/client/table.js';
import {menu} from './modules/client/menu.js';
import {menuDashboard} from './modules/admin/menuDashboard.js';

export default Vuex.createStore({
    modules: {
        tables: table,
        //////////////
        menus: menu,
        menuDashboard: menuDashboard,
    

    }
});