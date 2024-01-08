import Api from "../Api";
import secrets from "../../../secrets.example";

export default {
  async register(user) {
    return Api(secrets.URL_SPRING).post("register", user);
  },
  async login(user) {
    return Api(secrets.URL_SPRING).post("login", user);
  },
  async logout() {
    return Api(secrets.URL_SPRING).post("logout");
  },
  async login_admin(user) {
    return Api(secrets.URL_LARAVEL).post("login", user);
  },
  async logout_admin() {
    return Api(secrets.URL_LARAVEL).post("logout");
  },
  async profile() {
    return Api(secrets.URL_SPRING).get("profile");
  },
  async profile_admin() {
    return Api(secrets.URL_LARAVEL).get("profile");
  },
  async isAdmin() {
    return Api(secrets.URL_LARAVEL).get("isAdmin");
  },
};
