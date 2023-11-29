<template>
    <!-- <div class="carousel-item">
        <img :src="item.img_Menu" />
    </div> -->
    <div class="carousel_item"  @click="emitAction()">
    <img :src="item.img_Menu"  class="w-100 d-block" alt="First slide">
    </div>

</template>



<script>
import { getCurrentInstance } from 'vue';
export default {
    props: {
        item: Object
    },
    emits: {
        emitAction: Object
    },

    setup(props) {
       
        const { emit } = getCurrentInstance();
        const emitAction = () => {
            emit('emitAction', props.item);
        }

        return { emitAction }
    }

}



</script>

<style lang="scss">
.carusel_item {
    img {
        width: 30%;
        height: auto;
    }
}
</style>