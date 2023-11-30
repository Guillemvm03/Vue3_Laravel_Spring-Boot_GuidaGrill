import Api from "../Api";
import secrets from "../../../secrets.example";

export default {

    GetMenus() {
        return Api(secrets.URL_LARAVEL).get('menu');
    },//GetMenus

    GetMenu(id) {
        return Api(secrets.URL_LARAVEL).get(`menu/${id}`);
    },//Getmenu

    DeleteMenu(id) {
   
        return Api(secrets.URL_LARAVEL).delete(`menu/${id}`);
    },//Deletemenu

    CreateMenu(data) {
        return Api(secrets.URL_LARAVEL).post('menu', data);
    },//Createmenu

    UpdateMenu(data) {
        return Api(secrets.URL_LARAVEL).put(`menu/${data.id}`, data);
    },//UpdateMenu

}//export