import Api from "../Api";
import secret from "../../../secrets.example";

export default {
    async getUsers() {
        return await Api(secret.URL_LARAVEL).get("users");
    },
    async getUser(id) {
        return await Api(secret.URL_LARAVEL).get(`/users/${id}`);
    },
    async DeleteUser(id) {
        return await Api(secret.URL_LARAVEL).delete(`/users/${id}`);
    },
    async AddUser(payload) {
        return await Api(secret.URL_LARAVEL).post(`/users`, payload);
    },
}