<template>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
    integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
    crossorigin="anonymous" referrerpolicy="no-referrer">

  <section class="restaurants" id="restaurants">
    <div class="restaurants__block--container">
      <div class="card__restaurant--link" v-for="booking in state.bookings">
        <article class="card">
          <a href="#" v-if="booking.approved == true">
            <img class="card__restaurant--img"
              src="https://c8.alamy.com/compes/2bkwnxd/sello-reservado-signo-redondo-reservado-etiqueta-2bkwnxd.jpg"
              alt="Photo d'un plat au restaurant - Le délice des sens">
          </a>
          <a href="" v-else>
            <img class="card__restaurant--img" src="        https://imgs.search.brave.com/pWqKZ1Kq8PE8XlPW7jFgdMxA58UBbY4zkSPOxxonL00/rs:fit:500:0:0/g:ce/aHR0cHM6Ly90My5m/dGNkbi5uZXQvanBn/LzAyLzIyLzAxLzQw/LzM2MF9GXzIyMjAx/NDA5NF9qaDltY1pU/SHpzdzcxQWtoZWZP/RUd5UUgzNkVqalBM/Si5qcGc
            " alt="Photo d'un plat au restaurant - Le délice des sens">
          </a>
          <div class="card__restaurant--content">
            <h3 class="card__restaurant--title">Your Booking</h3>

            <p class="card__restaurant--subtitle"><b>Day: </b>{{ booking.reservationDay }}</p>
            <p class="card__restaurant--subtitle"><strong>Hour: </strong> {{ booking.reservationTime }}</p>
            <p class="card__restaurant--subtitle"><b>People: </b>{{ booking.capacity }}</p>

            <div class="icons">
              <i v-if="booking.approved == false" class="fa-solid fa-check" style="color: red;"> Pending approval </i>
              <i v-else class="fa-solid fa-check-double" style="color: green;"> APPROVED</i>
            </div>

            <div class="buttons" v-if="booking.approved == false">
              <button type="button" @click="deleteBooking(booking.id)" class="btn btn-danger">Cancel</button>
            </div>
          </div>
        </article>
      </div>
    </div>
  </section>
</template>
  
<script>
import { computed, reactive } from "vue";
import { useStore } from "vuex";
import { useRouter } from "vue-router";
import Constant from "../Constant";

export default {
  setup() {
    const store = useStore();
    const router = useRouter();

    const deleteBooking = (id) => {
      store.dispatch(`booking/${Constant.DELETE_USER_BOOKING}`, id);
      window.location.reload();
    };

    const updateBooking = (id) => {
      router.push({ name: "updateReservationUser", params: { id } })
    };

    store.dispatch(`booking/${Constant.INITIALIZE_USER_BOOKING}`);
    const state = reactive({
      bookings: computed(() => store.getters["booking/GetUserBooking"]),
    });

    return { state, deleteBooking, updateBooking };
  },
};
</script>
  
<style lang="scss" scoped>
.icons {
  position: absolute;
  top: 189px;
  right: 8px;
}

.buttons {
  position: absolute;
  top: 304px;
  right: 16px;
}

/*=============== GOOGLE FONT ===============*/
@import url("https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&family=Shrikhand&display=swap");

/*=============== VARIABLES CSS ===============*/
/*========== Theme colors ==========*/
$Primary-color: #9356dc;
$Secondary-color: #ff79da;
$Tertiary-color: #99e2d0;
$Badge-text-color: #008766;
$Background-color-body: #f6f6f6;

/*========== Button shadow colors ==========*/
$Color-shadows1-button: #00000040;
$Color-shadows2-button: #00000059;

/*========== typography ==========*/
$Body-font-title: Shrikhand;
$Body-font-text: Roboto;
$Color-typo: #e9e9e9;
$Footer-text-color: #fff;

/*========== Font weight ==========*/
$Font-size-small: 300;
$Font-size-normal: 400;
$Font-size-big: 500;
$Font-size-bigger: 700;

/*====== Screen width for "media queries" ======*/
$Tablet-width: 768px;
$Desktop-width: 1024px;
$Large-desktop-width: 1440px;

/*=============== MIXIN ===============*/

/*========== Flexbox ==========*/
@mixin flex($direction: initial,
  $justify: initial,
  $align: initial,
  $gap: initial) {
  display: flex;
  flex-direction: $direction;
  justify-content: $justify;
  align-items: $align;
  gap: $gap;
}

/*========== Media Queries ==========*/
@mixin tablet {
  @media (min-width: #{$Tablet-width}) {
    @content;
  }
}

@mixin desktop {
  @media (min-width: #{$Desktop-width}) {
    @content;
  }
}

@mixin large-desktop {
  @media (min-width: #{$Large-desktop-width}) {
    @content;
  }
}

/*=============== BASE ===============*/
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  background-color: $Background-color-body;
  position: relative;
  width: 100%;
  margin: auto;
}

main {
  z-index: 0;
  margin: auto;
}

a {
  text-decoration: none;
  color: inherit;
}

button,
input {
  border: none;
}

h1 {
  font-family: $Body-font-title;
}

h2,
p {
  font-family: $Body-font-text;
}

/*=============== HEART STYLE ===============*/
/* Déclaration de "dégradé de couleur" */
%color-heart {
  background: linear-gradient($Primary-color, $Secondary-color);
  background-clip: text;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

/*=============== PAGE RESTAURANTS ===============*/
/* Style de l'ensemble de la section restaurants */
.restaurants {
  @include flex(column, center, center, 1.62rem);
  padding: 3.37rem 1.09rem 4.12rem 1.09rem;

  @include desktop {
    padding-top: 1.87rem;
  }

  /* Style du titre de la section "Restaurants" */
  &__title {
    padding-left: 0.18rem;
    width: 100%;
    max-width: 67.5rem;
  }

  /* Style de l'ensemble du conteneur regroupant toutes les cards */
  &__block--container {
    @include flex(row, center, center, 1.12rem);
    flex-wrap: wrap;
    width: 100%;
    max-width: 67.5rem;

    @include tablet {
      gap: 1.25rem;
    }

    @include desktop {
      justify-content: space-between;
      gap: 3.12rem;
    }
  }
}

/*=============== CARD STYLE "INDEX" ===============*/
/* Style de design de card */
.card {
  @include flex($direction: column, $gap: 1rem);
  width: 100%;
  border-radius: 0.93rem;
  background-color: white;
  box-shadow: 0 0.25rem 0.93rem rgba(0, 0, 0, 0.1);
  transition: box-shadow, transform, 0.5s;

  &:hover {
    box-shadow: 0 0.25rem 1.25rem $Color-shadows2-button;
  }

  /* Style de design pour le badge "nouveau"*/
  &__restaurant--new {
    &:hover::before {
      box-shadow: 0.06rem 0.25rem 1.25rem rgba($Badge-text-color, 0.3);
    }

    &:hover::before {
      background-color: $Tertiary-color;
    }

    &::before {
      content: "Nouveau";
      font-family: $Body-font-text;
      position: absolute;
      right: 3.53%;
      top: 5.18%;
      width: 5rem;
      height: 1.81rem;
      line-height: 1.81rem;
      text-align: center;
      background-color: $Tertiary-color;
      color: $Badge-text-color;
      border-radius: 0.12rem;
      box-shadow: 0rem 0.12rem 0.25rem $Color-shadows1-button;
      transition: box-shadow, transform, 0.5s;
    }
  }

  /* Largeur et positionnement de card */
  &__restaurant--link {
    width: 100%;
    position: relative;

    @include tablet {
      width: calc((100% - 1.25rem) / 2);
    }

    @include desktop {
      width: calc((100% - 3.12rem) / 2);
      max-width: 30.6rem;
    }
  }

  /* Redimensionnement de taille de l'image de card */
  &__restaurant--img {
    border-radius: 0.93rem 0.93rem 0 0;
    height: calc(15.6rem - 4.81rem);
    width: 100%;
    object-fit: cover;
  }

  /* Style du contenu "titre et description" de card */
  &__restaurant--content {
    @include flex($direction: column, $gap: 0.31rem);
    padding: 0 1.4rem 0 1.4rem;
  }

  /* Style du titre de card */
  &__restaurant--title {
    font-family: $Body-font-text;
    padding-left: 0.18rem;
    margin-top: -0.3rem;
    width: 100%;
  }

  /* Style du sous-titre de card */
  &__restaurant--subtitle {
    font-weight: $Font-size-small;
    padding-left: 0.18rem;
    padding-bottom: 1rem;
  }

  /* Positionnement de l'icône de card */
  &__restaurant--icon {
    position: absolute;
    right: 1.4rem;
    bottom: 2rem;
  }
}
</style>
  