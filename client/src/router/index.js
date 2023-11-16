import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
// import Bookings from "../views/Bookings.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
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
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
