<template>
  <div :class="{ card: true, disabled: !table.available }" tabindex="0" @click="($event) => showDetails(table.id)">
    <div v-if="!table.available">Not Available</div>
    <img class="card-img-top" :class="[!table.available ? overlay : '']" :src="table.img_table" alt="" />
    <div class="card-body">
      <h4 class="card-title">Número de mesa: {{ table.table_number }}</h4>
      <p class="card-text">Descripción: {{ table.category }}</p>
      <p class="card-text">Estado: {{ table.status }}</p>
    </div>
  </div>
</template>

<script>
import { useRouter } from "vue-router";

export default {
  props: {
    table: Object,
  },
  setup(props) {
    const router = useRouter();

    const showDetails = (id) => {
      if (props.table.available) {
        router.push({ name: "DetailsTable", params: { id } });
      }
    };

    return { showDetails };
  },
};
</script>

<style lang="scss" scoped>
.card {
  transition: transform 0.3s, box-shadow 0.3s;
  border: none;
  position: relative;
  overflow: hidden;
}

.card:hover {
  transform: scale(1.05);
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.disabled {
  opacity: 0.5;
  pointer-events: none;
}
</style>
