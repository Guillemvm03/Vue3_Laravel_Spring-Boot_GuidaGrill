import { createRouter, createWebHistory } from "vue-router";


const routes = [
  {
    path: "/",
    name: "Home",
    redirect: { name: "home" }
  },
  {
    path: "/Home",
    name: "home",
    component: () => import('../views/Home.vue')
  },
  {
    path: "/Bookings",
    name: "Bookings",
    component: () => import('../views/Bookings.vue')
  },
  {
    path: "/Bookings/:id",
    name: "DetailsTable",
    component: () => import('../views/DetailsTable.vue')
  },
  {
    path: "/Dashboard",
    name: "Dashboard",
    component: () => import('../views/Dashboard.vue')
  },
  // TABLES
  {
    path: "/dashboard/tables",
    name: "DashboardTables",
    component: () => import('../views/Tables/tableList.vue')
  },
  // MENUS
  {
    path: "/dashboard/menus",
    name: "DashboardMenus",
    component: () => import('../views/Menus/menuList.vue')
  },
  {
    path: "/dashboard/menus/create",
    name: "CreateMenu",
    component: () => import('../views/Menus/menuCreate.vue')
  },
  {
    path: "/dashboard/menus/update/:id",
    name: "updateMenu",
    component: () => import('../views/Menus/menuUpdate.vue')
  },

];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
