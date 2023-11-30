import Api from "../Api";

const URL_SPRING = 'http://localhost:8080/api/'

export default {
    getMenus(){
        return Api(URL_SPRING + 'menus').get()
    }
}