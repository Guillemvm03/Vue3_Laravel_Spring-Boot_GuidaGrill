<template>
  <div class="container-search">
    <input type="text" placeholder="Search..." v-model="state.searchMeal" @keydown.enter="searchMeals">
    <div class="search"></div>
  </div>
</template>

<script>
import { computed, reactive } from 'vue';
import { useStore } from 'vuex';
import Constant from '../Constant';
import { getCurrentInstance } from 'vue';

export default {
  emits: {
    searchMealsValue: String,
  },
  setup() {
    const store = useStore();
    const { emit } = getCurrentInstance();
    const state = reactive({
      searchMeal: "",
      // meals: computed(() => store.getters['menu/GetMenu']),
      // mealsFiltered: computed(() => store.getters['menu/getMenuFiltered']),
    });

    const searchMeals = () => {
      console.log(state.searchMeal);
      emit('searchMealsValue', state.searchMeal);
    }

    return { state, searchMeals }
  }
};
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css?family=Inconsolata:700');

.container-search {
  position: relative;
  margin: auto;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  width: 300px;
  height: 100px;

  .search {
    position: absolute;
    margin: auto;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    width: 80px;
    height: 80px;
    background: rgb(220, 20, 47);
    border-radius: 50%;
    transition: all 1s;
    z-index: 1;
    box-shadow: 0 0 25px 0 rgba(0, 0, 0, 0.4);

    // box-shadow: 0 0 25px 0 crimson;
    &:hover {
      cursor: pointer;
    }

    &::before {
      content: "";
      position: absolute;
      margin: auto;
      top: 22px;
      right: 0;
      bottom: 0;
      left: 22px;
      width: 12px;
      height: 2px;
      background: white;
      transform: rotate(45deg);
      transition: all .5s;
    }

    &::after {
      content: "";
      position: absolute;
      margin: auto;
      top: -5px;
      right: 0;
      bottom: 0;
      left: -5px;
      width: 25px;
      height: 25px;
      border-radius: 50%;
      border: 2px solid white;
      transition: all .5s;
    }
  }

  input {
    font-family: 'Inconsolata', monospace;
    position: absolute;
    margin: auto;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    width: 50px;
    height: 50px;
    outline: none;
    border: none;
    // border-bottom: 1px solid rgba(255, 255, 255, 0.2);
    background: crimson;
    color: white;
    text-shadow: 0 0 10px crimson;
    padding: 0 80px 0 20px;
    border-radius: 30px;
    box-shadow: 0 0 25px 0 crimson,
      0 20px 25px 0 rgba(0, 0, 0, 0.2);
    // box-shadow: inset 0 0 25px 0 rgba(0, 0, 0, 0.5);
    transition: all 1s;
    opacity: 0;
    z-index: 5;
    font-weight: bolder;
    letter-spacing: 0.1em;

    &:hover {
      cursor: pointer;
    }

    &:focus {
      width: 300px;
      opacity: 1;
      cursor: text;
    }

    &:focus~.search {
      right: -250px;
      background: #151515;
      z-index: 6;

      &::before {
        top: 0;
        left: 0;
        width: 25px;
      }

      &::after {
        top: 0;
        left: 0;
        width: 25px;
        height: 2px;
        border: none;
        background: white;
        border-radius: 0%;
        transform: rotate(-45deg);
      }
    }

    &::placeholder {
      color: white;
      opacity: 0.5;
      font-weight: bolder;
    }
  }
}
</style>