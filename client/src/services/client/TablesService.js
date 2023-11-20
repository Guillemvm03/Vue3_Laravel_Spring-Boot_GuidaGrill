import Api from '../Api'

// import { URL_SPRING } from '../../../secrets.example'
const URL_SPRING = 'http://localhost:8080/api/'

export default {
    getTables(){
        return Api(URL_SPRING + 'tables').get()
    },
    GetTableById(id) {
        console.log(id);
        return Api(URL_SPRING + 'tables/' + id).get();
    }
}