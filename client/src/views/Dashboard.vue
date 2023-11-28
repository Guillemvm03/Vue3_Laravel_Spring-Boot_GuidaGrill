<template>

<!-- NEW  -->

<!-- <div :class="{'nav-open': $sidebar.showSidebar}"></div> -->


<!--  -->








<div class="container py-5">
  <div class="row">
    <div class="col-lg-12 text-center">
      <h1><i class="fa fa-tachometer" aria-hidden="true"></i> Dashboard</h1>
      <hr class="my-4">
    </div>
  </div>
<br><br><br><br>
  <div class="row justify-content-center">
    <div class="col-xs-6 col-sm-6 col-md-3 col-lg-2 p-2">
      <a href="/dashboard/menus" class="text-decoration-none">
        <div class="card p-3 shadow bg-success text-white text-center border-0">
          <div class="card-body">
            <p class="card-title lead"><router-link to="/dashboard/menus" class="text-white">Menus</router-link></p>
          </div>
        </div>
      </a>
    </div>

    <div class="col-xs-6 col-sm-6 col-md-3 col-lg-2 p-2">
      <a href="/dashboard/tables" class="text-decoration-none">
        <div class="card p-3 shadow bg-primary text-white text-center border-0">
          <div class="card-body">
            <p class="card-title lead"><router-link to="/dashboard/tables" class="text-white">Tables</router-link></p>
          </div>
        </div>
      </a>
    </div>
  </div>
</div>
<br><br><br><br><br><br>



<br><br><br><br><br><br>
</template>
<script>
export default {};
</script>
<style scoped>
  body {
    font-family: 'Arial', sans-serif;
    background-color: #f8f9fa;
  }

  h1 {
    color: #343a40;
  }

  hr {
    border-top: 2px solid #727579;
    width: 25%;
    margin: 0 auto;
  }

  .card {
    transition: transform 0.3s, box-shadow 0.3s;
    border: none;
    position: relative;
  }

  .card:hover {
    transform: scale(1.05);
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
  }

  .card-body {
    padding: 20px;
  }

  .card-title {
    font-size: 1.5rem;
    margin-bottom: 0;
    text-decoration: none;
  }

  .text-decoration-none {
    text-decoration: none;
  }

  .bg-primary {
    background-color: #768594;
  }

  .text-white {
    color: #f0ecec;
    transition: transform 0.3s;
    text-decoration: none;
  }

  .text-white:hover {
    transform: scale(1.1);
  }
</style>

