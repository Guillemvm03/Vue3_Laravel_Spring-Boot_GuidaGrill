import { ref } from "vue";
import MealsService from "../../services/client/MealsService";

export const useMealsInfinite = (page = 1, menu_number, limit = 3) => {
  const meals = ref([]);
  MealsService.GetMealsInfinite(page, menu_number, limit)
    .then((res) => (meals.value = res.data))
    .catch((error) => console.error(error));

  return meals;
};
