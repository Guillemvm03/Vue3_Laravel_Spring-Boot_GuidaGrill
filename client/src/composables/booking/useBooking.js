import ref from 'vue';
import BookingService from '../../services/client/BookingService';

export const AddBooking = (params) => {
    console.log(params);
    const response = ref([])
    BookingService.addBooking(params)
        .then(res => {
            console.log(res)
        })
        .catch(error => console.error(error))
        return  response;
}