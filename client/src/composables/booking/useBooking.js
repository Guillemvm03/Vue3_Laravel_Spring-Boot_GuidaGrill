import ref from "vue";
import BookingService from "../../services/client/BookingService";

export const AddBooking = (params) => {
  const response = ref([]);
  BookingService.addBooking(params)
    .then((res) => {
    })
    .catch((error) => console.error(error));
  return response;
};
