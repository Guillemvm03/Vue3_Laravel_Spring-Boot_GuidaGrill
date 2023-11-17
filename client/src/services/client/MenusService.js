import Api from "../Api";

const URL_SPRING = 'http://localhost:8080/api/'

export default {
    getTables(){
        return Api(URL_SPRING + 'menu').get()
    }
}