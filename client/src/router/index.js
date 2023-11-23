import { createRouter, createWebHistory } from "vue-router";


const routes = [
  ////////////////////////////CLIENT//////////////////////////////////
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
   ///////////////////////////DASHBOARD//////////////////////////////
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
  {
    path: "/Dashboard/Tables/tableCreate",
    name: "tableCreate",
    component: () => import('../views/Tables/tableCreate.vue')
  },
  {
    path: "/Dashboard/Tables/tableEdit/:id",
    name: "tableEdit",
    component: () => import('../views/Tables/tableEdit.vue')
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
