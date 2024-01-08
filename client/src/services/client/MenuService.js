import Api from "../Api";

const URL_SPRING = 'http://localhost:8080/api/'
import secrets from '../../../secrets.example'

export default {
    getMenus(){
        return Api(URL_SPRING + 'menus').get()
    },
    GetmenusInfinite(page,menu_number, limit) {
        return Api(secrets.URL_SPRING).get('menus/menusInfinite', { params: { page: page, type: menu_number, limit: limit } });
    },//
    getOneMenu(id){
        return Api(URL_SPRING + 'menus/' + id).get()
    },
}