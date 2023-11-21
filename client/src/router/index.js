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
  {
    path: "/Dashboard/tables",
    name: "DashboardTables",
    component: () => import('../views/Tables/tableList.vue')
  },
  // {
  //   path: "Dashboard/menus",
  //   name: "DashboardMenus",
  //   component: () => import('../views/Menus/MenuList.vue')
  // }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
