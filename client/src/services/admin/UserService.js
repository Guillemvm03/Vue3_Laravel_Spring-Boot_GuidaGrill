import Api from "../Api";
import secret from "../../secret";

export default {
    async getUsers() {
        return await Api(secret.URL_LARAVEL).get("/users");
    },
    async getUser(id) {
        return await Api(secret.URL_LARAVEL).get(`/users/${id}`);
    },
}