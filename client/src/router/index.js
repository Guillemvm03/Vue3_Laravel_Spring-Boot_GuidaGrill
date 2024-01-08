import { createRouter, createWebHistory } from "vue-router";
import AuthGuards from "../services/guards/AuthGuards";

const routes = [
  ////////////////////////////CLIENT//////////////////////////////////
  {
    path: "/",
    name: "Home",
    redirect: { name: "home" },
  },
  {
    path: "/Home",
    name: "home",
    component: () => import("../views/Home.vue"),
  },
  {
    path: "/Bookings",
    name: "Bookings",
    component: () => import("../views/Bookings.vue"),
  },
  {
    path: "/Booking/:id",
    name: "DetailsTable",
    component: () => import("../views/DetailsTable.vue"),
  },
  {
    path: "/Bookings/:filters",
    name: "bookingFilters",
    component: () => import("../views/Bookings.vue"),
  },
  ////////////////////////////LOGIN//////////////////////////////////
  {
    path: "/Login",
    name: "Login",
    component: () => import("../views/Login.vue"),
    beforeEnter: AuthGuards.noAuthGuard,
    meta: { requiresAuth: true },
  },
  ////////////////////////////PROFILE//////////////////////////////////
  {
    path: "/Profile",
    name: "Profile",
    component: () => import("../views/Profile.vue"),
    beforeEnter: AuthGuards.AuthGuard,
    meta: { requiresAuth: true },
  },
  ///////////////////////////DASHBOARD//////////////////////////////
  {
    path: "/Dashboard",
    name: "Dashboard",
    component: () => import("../views/Dashboard.vue"),
    beforeEnter: AuthGuards.authGuardAdmin,
    meta: { requiresAuth: true },
  },
  // TABLES
  {
    path: "/dashboard/tables",
    name: "DashboardTables",
    component: () => import("../views/Tables/tableList.vue"),
    beforeEnter: AuthGuards.authGuardAdmin,
    meta: { requiresAuth: true },
  },
  // MENUS
  {
    path: "/dashboard/menus",
    name: "DashboardMenus",
    component: () => import("../views/Menus/menuList.vue"),
    beforeEnter: AuthGuards.authGuardAdmin,
    meta: { requiresAuth: true },
  },
  {
    path: "/dashboard/users",
    name: "DashboardUsers",
    component: () => import("../views/Users/userList.vue"),
    beforeEnter: AuthGuards.authGuardAdmin,
    meta: { requiresAuth: true },
  },
  {
    path: "/dashboard/users/create",
    name: "CreateUser",
    component: () => import("../views/Users/userCreate.vue"),
    beforeEnter: AuthGuards.authGuardAdmin,
    meta: { requiresAuth: true },
  },
  {
    path: "/dashboard/menus/create",
    name: "CreateMenu",
    component: () => import("../views/Menus/menuCreate.vue"),
    beforeEnter: AuthGuards.authGuardAdmin,
    meta: { requiresAuth: true },
  },
  {
    path: "/dashboard/menus/update/:id",
    name: "updateMenu",
    component: () => import("../views/Menus/menuUpdate.vue"),
    beforeEnter: AuthGuards.authGuardAdmin,
    meta: { requiresAuth: true },
  },
  {
    path: "/Dashboard/Tables/tableCreate",
    name: "tableCreate",
    component: () => import("../views/Tables/tableCreate.vue"),
    beforeEnter: AuthGuards.authGuardAdmin,
    meta: { requiresAuth: true },
  },
  {
    path: "/Dashboard/Tables/tableEdit/:id",
    name: "tableEdit",
    component: () => import("../views/Tables/tableEdit.vue"),
    beforeEnter: AuthGuards.authGuardAdmin,
    meta: { requiresAuth: true },
  },
  {
    path: "/profile",
    name: "profile",
    component: () => import("../views/Profile.vue"),
    beforeEnter: AuthGuards.authGuardAdmin,
    meta: { requiresAuth: true },
  },
  {
    path: "/Dashboard/Reservation/reservationList",
    name: "reservationList",
    component: () => import("../views/Reservation/ReservationList.vue"),
    beforeEnter: AuthGuards.authGuardAdmin,
    meta: { requiresAuth: true },
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
