<template>
    <carousel :items-to-show="1" :autoplay="4000" :wrap-around="true">
        <slide v-for="item in data" :key="item.id">
            <carousel_itemVue class="carousel__item" :item="item" />

        </slide>
        <template #addons>
            <navigation />
            <pagination />
        </template>
    </carousel>


    <!-- <div id="carouselId" class="carousel slide" data-bs-ride="carousel" v-for="item in data" :key="item.id">
        <ol class="carousel-indicators">
            <li data-bs-target="#carouselId" data-bs-slide-to="0" class="active" aria-current="true" aria-label="First slide"></li>
            <li data-bs-target="#carouselId" data-bs-slide-to="1" aria-label="Second slide"></li>
            <li data-bs-target="#carouselId" data-bs-slide-to="2" aria-label="Third slide"></li>
        </ol>
        <div class="carousel-inner" role="listbox">

            <div class="carousel-item active">
            <carousel_itemVue class="carousel-item " :item="item" />
            </div>
            <div class="carousel-item active">
                <img src="https://imgs.search.brave.com/DDOtboE-Slq0Wlm2X0P8QmT0dtzeSJdMhLeAXpZoMk8/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9nZWVr/ZmxhcmUuY29tL3dw/LWNvbnRlbnQvdXBs/b2Fkcy8yMDIzLzAz/L2ltZy1wbGFjZWhv/bGRlci5wbmc" width="200" height="300" class="w-100 d-block" alt="First slide">
            </div>
            <div class="carousel-item">
                <img src="https://imgs.search.brave.com/DDOtboE-Slq0Wlm2X0P8QmT0dtzeSJdMhLeAXpZoMk8/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9nZWVr/ZmxhcmUuY29tL3dw/LWNvbnRlbnQvdXBs/b2Fkcy8yMDIzLzAz/L2ltZy1wbGFjZWhv/bGRlci5wbmc" width="200" height="300" class="w-100 d-block" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img src="https://imgs.search.brave.com/DDOtboE-Slq0Wlm2X0P8QmT0dtzeSJdMhLeAXpZoMk8/rs:fit:500:0:0/g:ce/aHR0cHM6Ly9nZWVr/ZmxhcmUuY29tL3dw/LWNvbnRlbnQvdXBs/b2Fkcy8yMDIzLzAz/L2ltZy1wbGFjZWhv/bGRlci5wbmc" width="200" height="300" class="w-100 d-block" alt="Third slide">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselId" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselId" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div> -->


</template>

<script>
// import 'vue3-carousel/dist/carousel.css';
import { Carousel, Slide, Pagination, Navigation } from 'vue3-carousel'
import carousel_itemVue from './carousel_item.vue';
export default {
    components: { carousel_itemVue, Carousel, Slide, Pagination, Navigation },
    props: {
        data: Object
    },
}
</script>

<style lang="scss">
@import 'vue3-carousel/dist/carousel.css';

.carousel__item {
    min-height: 200px;
    width: 100%;
    background-color: none;
    font-size: 20px;
    border-radius: 8px;
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>