<template>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <i class="fab fa-github fa-2x mx-3 ps-1"></i>
    </a>
    <button class="navbar-toggler" type="button" data-mdb-toggle="collapse"
      data-mdb-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
      aria-label="Toggle navigation">
      <i class="fas fa-bars"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <form class="me-3">
        <div class="form-white input-group" style="width: 250px;">

        </div>
      </form>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">

        <li class="nav-item">
          <router-link to="/home" class="link">
          <a class="nav-link" href="#">Home</a>
        </router-link>
        </li>
        <li class="nav-item">
          <router-link to="/Bookings" class="link">
          <a class="nav-link" href="#">Bookings</a>
        </router-link>
        </li>
        <li class="nav-item">
          <router-link to="/Dashboard" class="link">
          <a class="nav-link">Dashboard</a>
        </router-link>
        </li>

      </ul>

    </div>
  </div>
</nav>
<!-- Navbar -->


</template>


<script>

export default {
   }

</script>



<style lang="scss">

/* HEADER */

.form-white.input-group>.form-control:focus {
  border-color: #fff;
  box-shadow: inset 0 0 0 1px #fff;
}

.navbar-dark .navbar-nav .nav-link {
  color: #fff;
}

.navbar-dark .navbar-nav .nav-link:hover,
.navbar-dark .navbar-nav .nav-link:focus {
  color: rgba(255, 255, 255, 0.75);
}



</style>