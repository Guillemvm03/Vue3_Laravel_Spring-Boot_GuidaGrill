import Vuex from "vuex";

import { table } from "./modules/client/table.js";
import { menu } from "./modules/client/menu.js";
import { tableDashboard } from "./modules/admin/tableDashboard.js";

export default Vuex.createStore({
  modules: {
    tables: table,
    menus: menu,
    tableDashboard: tableDashboard,
  },
});
