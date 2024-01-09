import Vuex from "vuex";
import { table } from "./modules/client/table.js";
import { menu } from "./modules/client/menu.js";
import { tableDashboard } from "./modules/admin/tableDashboard.js";
import { menuDashboard } from "./modules/admin/menuDashboard.js";
import { user } from "./modules/client/user.js";
import { userDashboard } from "./modules/admin/UserDashboard.js";
import { booking } from "./modules/client/booking.js";
import { reservationDashboard } from "./modules/admin/reservationDashboard.js";

export default Vuex.createStore({
  modules: {
    tables: table,
    menus: menu,
    menuDashboard: menuDashboard,
    tableDashboard: tableDashboard,
    user: user,
    userDashboard: userDashboard,
    reservationDashboard: reservationDashboard,
    booking: booking,
  },
});
