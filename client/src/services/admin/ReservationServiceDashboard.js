import Api from "../Api";
import secrets from "../../../secrets.example";

export default {
  GetReservations() {
    return Api(secrets.URL_LARAVEL).get("/reservations");
  }, //GetReservations

  GetReservation(id) {
    return Api(secrets.URL_LARAVEL).get(`reservations/${id}`);
  }, //GetReservation

  DeleteReservation(id) {
    return Api(secrets.URL_LARAVEL).delete(`reservations/${id}`);
  }, //DeleteReservation

  CreateReservation(data) {
    return Api(secrets.URL_LARAVEL).post("reservations", data);
  }, //CreateReservation

  UpdateReservation(id) {
    return Api(secrets.URL_LARAVEL).put(`reservations/${id}`);
  }, //UpdateReservation
};
