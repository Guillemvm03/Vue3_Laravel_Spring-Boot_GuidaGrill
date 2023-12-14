<template>
  <!-- ======= Hero Section ======= -->
  <section id="hero" class="hero d-flex align-items-center section-bg">
    <div class="container">
      <Search :menus="state.menus" @searchMealsValue="searchMeals" />

      <div class="row justify-content-between gy-5">
        <div
          class="col-lg-5 order-2 order-lg-1 d-flex flex-column justify-content-center align-items-center align-items-lg-start text-center text-lg-start"
        >
          <h2 data-aos="fade-up">Enjoy Your Healthy<br />Delicious Food</h2>
          <p data-aos="fade-up" data-aos-delay="100">
            Sed autem laudantium dolores. Voluptatem itaque ea consequatur eveniet. Eum
            quas beatae cumque eum quaerat.
          </p>

          <div class="d-flex" data-aos="fade-up" data-aos-delay="200">
            <a href="#book-a-table" class="btn-book-a-table">Book a Table</a>
          </div>
        </div>
        <div class="col-lg-5 order-1 order-lg-2 text-center text-lg-start">
          <CarouselVue :data="state.menus" @emitAction="redirectBookings" />
        </div>
      </div>
    </div>
  </section>
  <!-- End Hero -->

  <!-- <Card_meals v-if="state.menus" :data="state.menus" :dataMeals="state.menusInfinite" @page="addInfinite"/> -->
  <Card_meals
    v-if="state.menus"
    :data="state.menus"
    :dataMeals="state.mealsInfinite"
    @page="addInfinite"
    @menu_number="updateMenuNumber"
  />
  <!-- :dataMeals="state.menusInfinite" -->
</template>

<script>
import { computed, reactive, ref } from "vue";
import { useStore } from "vuex";
import Constant from "../Constant";
import { useRouter } from "vue-router";

import CarouselVue from "../components/Carousel.vue";
import Card_meals from "../components/Card_meals.vue";
import Search from "../components/Search.vue";
import { useMealsInfinite } from "../composables/meals/useMeals";

export default {
  components: { CarouselVue, Card_meals, Search },
  setup() {
    const router = useRouter();
    const store = useStore();

    const menuNumber = ref(1);

    store.dispatch(`menus/${Constant.INITIALIZE_MENU}`);

    const updateMenuNumber = (newMenuNumber) => {
      menuNumber.value = newMenuNumber;
      console.log(menuNumber.value);
      state.mealsInfinite = useMealsInfinite(1, menuNumber.value, 3);

      // Actualiza el valor
    };
    const state = reactive({
      menus: computed(() => store.getters["menus/GetMenu"]),

      // menusInfinite: useMenusInfinite(1, menuNumber.value, 3),

      mealsInfinite: useMealsInfinite(1, menuNumber.value, 3),
    });

    const redirectBookings = (item) => {
      const filters = {
        menus: [item.id],
        page: 1,
      };

      const filters_ = btoa(JSON.stringify(filters));
      router.push({ name: "bookingFilters", params: { filters: filters_ } });
    };

    const addInfinite = (page) => {
      state.mealsInfinite = useMealsInfinite(page, menuNumber.value, 3);
      console.log(state.mealsInfinite);
    };

    const searchMeals = (item) => {
      console.log(item);
      const filtersSearch = {
        meals: item,
      };
      console.log(filtersSearch);

      const filtersSearch_ = btoa(JSON.stringify(filtersSearch));
      router.push({ name: "bookingFilters", params: { filters: filtersSearch_ } });
    };

    // console.log(state.mealsInfinite);

    return {
      state,
      redirectBookings,
      addInfinite,
      updateMenuNumber,
      menuNumber: reactive(menuNumber),
      searchMeals
    };
  },
};
</script>


<style lang="scss" scoped>
/*--------------------------------------------------------------
# Hero Section
--------------------------------------------------------------*/
.hero {
  width: 100%;
  background-size: cover;
  position: relative;
  min-height: 60vh;
  padding: 160px 0 60px 0;
}

.hero h2 {
  font-size: 64px;
  font-weight: 700;
  margin-bottom: 20px;
  color: var(--color-secondary);
  font-family: var(--font-primary);
}

.hero h2 span {
  color: var(--color-primary);
}

.hero p {
  color: #4f4f5a;
  font-weight: 400;
  margin-bottom: 30px;
}

.hero .btn-book-a-table {
  font-weight: 500;
  font-size: 14px;
  letter-spacing: 1px;
  display: inline-block;
  padding: 12px 36px;
  border-radius: 50px;
  transition: 0.5s;
  color: #fff;
  background: var(--color-primary);
  box-shadow: 0 8px 28px rgba(206, 18, 18, 0.2);
}

.hero .btn-book-a-table:hover {
  background: rgba(206, 18, 18, 0.8);
  box-shadow: 0 8px 28px rgba(206, 18, 18, 0.45);
}

.hero .btn-watch-video {
  font-size: 16px;
  transition: 0.5s;
  margin-left: 25px;
  color: var(--font-secondary);
  font-weight: 600;
}

.hero .btn-watch-video i {
  color: var(--color-primary);
  font-size: 32px;
  transition: 0.3s;
  line-height: 0;
  margin-right: 8px;
}

.hero .btn-watch-video:hover {
  color: var(--color-primary);
}

.hero .btn-watch-video:hover i {
  color: rgba(206, 18, 18, 0.8);
}

@media (max-width: 640px) {
  .hero h2 {
    font-size: 36px;
  }

  .hero .btn-get-started,
  .hero .btn-watch-video {
    font-size: 14px;
  }
}

/*--------------------------------------------------------------
# Stats Counter Section
--------------------------------------------------------------*/
.stats-counter {
  background: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),
    url("../src/assets/img/stats-bg.jpg") center center;
  background-size: cover;
  padding: 100px 0;
}

@media (min-width: 1365px) {
  .stats-counter {
    background-attachment: fixed;
  }
}

.stats-counter .stats-item {
  padding: 30px;
  width: 100%;
}

.stats-counter .stats-item span {
  font-size: 48px;
  display: block;
  color: #fff;
  font-weight: 700;
}

.stats-counter .stats-item p {
  padding: 0;
  margin: 0;
  font-family: var(--font-secondary);
  font-size: 16px;
  font-weight: 700;
  color: rgba(255, 255, 255, 0.6);
}
</style>
