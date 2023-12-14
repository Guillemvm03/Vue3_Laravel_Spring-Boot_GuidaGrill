import axios from "axios";
import { createToaster } from "@meforma/vue-toaster";

import { useStore } from "vuex";
import { useRoute } from "vue-router";
import Constant from "../Constant";
import secrets from "../../secrets.example";

export default (URL) => {
  const toaster = createToaster({ position: "top-right", duration: 1500 });
  const store = useStore();
  const router = useRoute();

  const api = axios.create({
    baseURL: URL,
  });

  const token =
    URL === secrets.URL_LARAVEL
      ? localStorage.getItem("token_admin")
      : localStorage.getItem("token");
  if (token) {
    console.log('token',token);
    api.defaults.headers.common.Authorization = `Bearer ${token}`;
  }

  api.interceptors.response.use(
    (response) => response,
    (error) => {
      console.error(error);
      if (error.response.status === 401) {
        toaster.error("Forced logout. Unauthorized action");
        store.dispatch(`user/${Constant.LOGOUT}`);
        router.push({ name: "home" });
      }
      return Promise.reject(error);
    }
  );

  return api;
};
