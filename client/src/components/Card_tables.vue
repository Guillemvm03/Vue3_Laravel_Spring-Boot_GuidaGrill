<template>
  <div class="card">
    <img class="card-img-top" src="holder.js/100x180/" alt="">
    <div class="card-body">
      <h4 class="card-title">número de mesa: {{table.table_number}}</h4>
      <p class="card-text">Descripción: {{ table.category }}</p>
    </div>
  </div>
</template>

<script>
  // import {useRouter} from 'vue-router'

  export default {
    props: {
        table: Object        
    },
    setup() {
      // console.log(props.table);
        // const router = useRouter();
        // const showDetails = (id) => {
            // router.push({ name: "details", params: { id } })
        // }
        // return { showDetails }
    }
}

</script>

<style lang="scss" scoped></style>