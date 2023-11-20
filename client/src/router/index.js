import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
import Bookings from "../views/Bookings.vue";
import DetailsTable from "../views/DetailsTable.vue";

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
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
