<template>
  <div class="card" tabindex="0" @click="$event => showDetails(table.id)">
    <img class="card-img-top" :src="table.img_table" alt="">
    <div class="card-body" >
      <h4 class="card-title">número de mesa: {{table.table_number}}</h4>
      <p class="card-text">Descripción: {{ table.category }}</p>
      <p class="card-text">Estado: {{ table.status }}</p>
    </div>
  </div>
</template>

<script>
  import {useRouter} from 'vue-router'

  export default {
    props: {
        table: Object        
    },
    setup() {

        const router = useRouter();
     
        const showDetails = (id) => {
            router.push({ name: "DetailsTable", params: { id } })
        }
        return { showDetails }
    }
}

</script>

<style lang="scss" scoped>

.card {
  padding: 2em;
}

</style>