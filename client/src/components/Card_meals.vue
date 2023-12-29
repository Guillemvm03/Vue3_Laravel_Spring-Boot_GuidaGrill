<template>
  <section id="menu" class="menu">
    <div class="container" data-aos="fade-up">
      <div class="section-header">
        <h2>Our Menu</h2>
        <p>Check Our <span>Guida Menu</span></p>
      </div>

      <ul
        class="nav nav-tabs d-flex justify-content-center"
        data-aos="fade-up"
        data-aos-delay="200"
      >
        <li
          v-for="nav in data"
          :key="nav.id"
          class="nav-item"
          @click="
            restartscroll();
            menu_number = nav.id;
            $emit('menu_number', menu_number);
          "
        >
          <a
            class="nav-link"
            :class="{ active: menu_number === nav.id }"
            data-bs-toggle="tab"
          >
            <h4>{{ nav.type }}</h4>
          </a>
        </li>
      </ul>

      <ul></ul>

      <div class="tab-content" data-aos="fade-up" data-aos-delay="300">
        <div class="tab-pane fade active show" id="menu-starters">
          <div class="tab-header text-center">
            <p>Menu</p>
          </div>

          <!-- <div class="tab-pane fade" id="menu-dinner"> -->

          <div class="tab-header text-center">
            <!-- <h3>{{data.type}}</h3> -->
          </div>

          <div class="row gy-5">
            <div class="col-lg-4 menu-item" v-for="meals in dataMeals" :key="meals.id">
              <!-- v-for="meals in data[menu_number - 1].meals" -->

              <!-- <div class="col-lg-4 menu-item" v-for="meals in dataMeals[(menu_number -1)].meals" :key="meals.id"> -->

              <a href="" class="glightbox"
                ><img :src="meals.img_meal" class="menu-img img-fluid" alt=""
              /></a>
              <h4>{{ meals.name }}</h4>
              <p class="ingredients">
                {{ meals.description }}
              </p>

              <p class="price">{{ meals.price }}€</p>
            </div>
            <InfiniteLoading @infinite="scroll" :distance="1" />
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- End Menu Section -->
</template>

<script>
import { ref, watch } from "vue";
import AOS from "aos";
import "aos/dist/aos.css";
import InfiniteLoading from "v3-infinite-loading";
import { getCurrentInstance } from "vue";

export default {
  components: {
    InfiniteLoading,
  },
  emits: {
    page: Number,
  },
  props: {
    data: Object,
    dataMeals: Object,
  },

  setup(props) {
    const menu_number = ref(1);

    const { emit } = getCurrentInstance();

    AOS.init();

    watch(menu_number, () => {
      AOS.refresh();
    });

    let page = 1;
    const scroll = ($state) => {
      page++;
      if (page <= 3) {
        emit("page", page);
      } else {
        // $state.loaded();
      }
    };

    const restartscroll = () => {
      page = 1;
    };

    return { scroll, menu_number, restartscroll };
  },
};
</script>

<style lang="scss" scoped>
@import "v3-infinite-loading/lib/style.css";

/* --------------------------------------------------------------
# Menu Section
--------------------------------------------------------------*/

.nav-link h4 {
  text-transform: capitalize;
}

.menu-img {
  width: 200px;
  height: 200px;
  /* Ajusta la altura según tus necesidades */
  border-radius: 50%;

  object-fit: cover;
  /* Ajusta el comportamiento de la imagen */
  margin-bottom: 10px;
  /* Ajusta el margen inferior según tus necesidades */
  transition: transform 0.3s ease-in-out;
  /* Agrega transición */
}

.menu-img:hover {
  transform: scale(1.1);
  /* Ajusta la escala según tus necesidades */
}

//

.menu .nav-tabs {
  border: 0;
}

.menu .nav-link {
  margin: 0 10px;
  padding: 10px 5px;
  transition: 0.3s;
  color: var(--color-secondary);
  border-radius: 0;
  cursor: pointer;
  height: 100%;
  border: 0;
  border-bottom: 2px solid #b6b6bf;
}

@media (max-width: 575px) {
  .menu .nav-link {
    margin: 0 10px;
    padding: 10px 0;
  }
}

.menu .nav-link i {
  padding-right: 15px;
  font-size: 48px;
}

.menu .nav-link h4 {
  font-size: 18px;
  font-weight: 400;
  margin: 0;
  font-family: var(--font-secondary);
}

@media (max-width: 575px) {
  .menu .nav-link h4 {
    font-size: 16px;
  }
}

.menu .nav-link:hover {
  color: var(--color-primary);
}

.menu .nav-link.active {
  color: var(--color-primary);
  border-color: var(--color-primary);
}

.menu .tab-content .tab-header {
  padding: 30px 0;
}

.menu .tab-content .tab-header p {
  font-size: 14px;
  text-transform: uppercase;
  color: #676775;
  margin-bottom: 0;
}

.menu .tab-content .tab-header h3 {
  font-size: 36px;
  font-weight: 600;
  color: var(--color-primary);
}

.menu .tab-content .menu-item {
  -moz-text-align-last: center;
  text-align-last: center;
}

.-col-lg-4 .menu-img {
  padding: 0 60px;
  margin-bottom: 15px;
}

.menu .tab-content .menu-item h4 {
  font-size: 22px;
  font-weight: 500;
  color: var(--color-secondary);
  font-family: var(--font-secondary);
  font-weight: 30px;
  margin-bottom: 5px;
}

.menu .tab-content .menu-item .ingredients {
  font-family: var(--font-secondary);
  color: #8d8d9b;
  margin-bottom: 5px;
}

.menu .tab-content .menu-item .price {
  font-size: 24px;
  font-weight: 700;
  color: var(--color-primary);
}
</style>
