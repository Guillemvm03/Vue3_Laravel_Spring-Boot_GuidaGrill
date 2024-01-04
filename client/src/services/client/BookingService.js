import Api from "../Api";
import secrets from '../../../secrets.example'

export default {

    addBooking(params) {
        return Api(secrets.URL_SPRING).post('reservations', params);
    }

}