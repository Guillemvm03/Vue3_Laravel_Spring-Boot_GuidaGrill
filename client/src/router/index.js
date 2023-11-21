import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
import Bookings from "../views/Bookings.vue";
import DetailsTable from "../views/DetailsTable.vue";
import Dashboard from "../views/Dashboard.vue";
import DashboardTables from "../views/Tables/tableList.vue";
// import DashboardMenus from "../views/Menus/MenusList.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/Home",
    name: "home",
    component: Home,
  },
  {
    path: "/Bookings",
    name: "Bookings",
    component: Bookings,
  },
  {
    path: "/Bookings/:id",
    name: "DetailsTable",
    component: DetailsTable,
  },
  {
    path: "/Dashboard",
    name: "Dashboard",
    component: Dashboard
  },
  {
    path: "/Dashboard/tables",
    name: "DashboardTables",
    component: DashboardTables
  },
  // {
  //   path: "Dashboard/menus",
  //   name: "DashboardMenus",
  //   component: DashboardMenus
  // }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
