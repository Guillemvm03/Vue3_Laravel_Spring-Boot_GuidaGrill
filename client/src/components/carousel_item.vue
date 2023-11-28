<template>
    <!-- <div class="carousel-item">
        <img :src="item.img_Menu" />
    </div> -->
    <div class="carousel_item">
    <img :src="item.img_Menu"  class="w-100 d-block" alt="First slide">
    </div>

</template>

<script>
export default {
    props: {
        item: Object
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