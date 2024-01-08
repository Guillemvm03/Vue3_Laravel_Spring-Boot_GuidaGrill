import Api from '../Api'
import secrets from '../../../secrets.example'

export default {

    GetMealsInfinite(page, id_menu, limit) {
        return Api(secrets.URL_SPRING).get('meals/mealsInfinite', { params: { page: page,id_menu: id_menu, limit: limit } });
    },//


}