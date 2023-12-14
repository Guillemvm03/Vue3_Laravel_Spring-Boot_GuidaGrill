import Api from "../Api";
import secrets from "../../../secrets.example";

export default {
    async register(user) {
        return Api(secrets.URL_SPRING).post("register", user);
    },
    async login(user) {
        console.log("entra a login");
        return Api(secrets.URL_SPRING).post("login", user);
    },
    async logout() {
        console.log("entra logout service");
        return Api(secrets.URL_SPRING).post("logout");
    },
    async login_admin(user) {
        console.log("entra a loginAdmin");
        return Api(secrets.URL_LARAVEL).post("login", user);
    },
    async logout_admin() {
        return Api(secrets.URL_LARAVEL).post("logout");
    },
    async profile(){
        console.log("entra profile service");
        return Api(secrets.URL_SPRING).get("profile");
    },
    async isAdmin(){
        return Api(secrets.URL_LARAVEL).get("isAdmin");
    }
}