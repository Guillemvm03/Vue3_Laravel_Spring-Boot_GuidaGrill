<template>
    <carousel :items-to-show="1" :autoplay="4000" :wrap-around="true" class="carousel slide">
        <slide v-for="item in data" :key="item.id">
            <carousel_itemVue class="carousel__item" :item="item" @emitAction="emitAction"/>
            <div class="overlay">{{ item.type }}</div>
        </slide>
        <template #addons>
            <navigation />
            <pagination />
        </template>
    </carousel>

</template>

<script>
// import 'vue3-carousel/dist/carousel.css';
import { Carousel, Slide, Pagination, Navigation } from 'vue3-carousel'
import carousel_itemVue from './carousel_item.vue';
import { getCurrentInstance } from 'vue';

export default {
    components: { carousel_itemVue, Carousel, Slide, Pagination, Navigation },
    props: {
        data: Object
    },
    emits: {
        emitAction: Object
    },

    setup(props) {
       
        const { emit } = getCurrentInstance();
        const emitAction = (item) => {
            emit('emitAction', item);
        }

        return { emitAction }
    }


}
</script>

<style lang="scss">
@import 'vue3-carousel/dist/carousel.css';

.carousel {
        position: relative;
        overflow: hidden;
        border-radius: 8px;
}

.carousel__item {
        height: 300px;
        width: 100%;
        background-color: #fff;
        font-size: 20px;
        border-radius: 8px;
        display: flex;
        justify-content: center;
        align-items: center;
        box-sizing: border-box;
}

.carousel__item img {
        max-width: 100%;
        max-height: 100%;
        object-fit: cover;
}

.carousel__item {
    position: relative;
}

.overlay {
    position: absolute;
    bottom: 0;
    left: 0;
    width: 100%;
    background: rgba(0, 0, 0, 0.5);
    color: #fff;
    padding: 8px;
    text-align: center;
    font-size: 14px;
}
</style>