import Api from "../Api";
import secrets from "../../../secrets.example";

export default {
  addBooking(params) {
    return Api(secrets.URL_SPRING).post("reservations", params);
  },
  getTablesBooking(id) {
    return Api(secrets.URL_SPRING).get("reservations/table/" + id);
  },
  getUserBooking() {
    return Api(secrets.URL_SPRING).get("reservations/user");
  },
  deleteUserBooking(id) {
    return Api(secrets.URL_SPRING).delete("reservations/" + id);
  },
  getOneBooking(id) {
    return Api(secrets.URL_SPRING).get("reservations/" + id);
  },
  updateUserBooking(id, params) {
    return Api(secrets.URL_SPRING).put("reservations/" + id, params);
  },
};
