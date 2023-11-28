<template>

<!-- Navbar 
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
 Navbar -->
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="/">
        <!-- <i class="fab fa-github fa-2x mx-3 ps-1"></i> -->
        <img src="../assets/logo.png" alt="">
      </a>
      <button class="navbar-toggler" type="button" data-mdb-toggle="collapse"
        data-mdb-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
        aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <form class="me-3">
          <div class="form-white input-group" style="width: 250px;"></div>
        </form>
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <router-link to="/home" class="link">
              <a class="nav-link">Home</a>
            </router-link>
          </li>
          <li class="nav-item">
            <router-link to="/Bookings" class="link">
              <a class="nav-link">Bookings</a>
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

</template>


<script>

export default {
   }

</script>



<style lang="scss">

/* HEADER */

// .form-white.input-group>.form-control:focus {
//   border-color: #fff;
//   box-shadow: inset 0 0 0 1px #fff;
// }

// .navbar-dark .navbar-nav .nav-link {
//   color: #fff;
// }

// .navbar-dark .navbar-nav .nav-link:hover,
// .navbar-dark .navbar-nav .nav-link:focus {
//   color: rgba(255, 255, 255, 0.75);
// }

body {
      font-family: 'Arial', sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f8f9fa; 
    }

    header {
      background-color: #000; 
      color: #fff; 
      padding: 15px 20px;
      text-align: center;
      position: relative;
      display: flex;
      align-items: center;
      justify-content: space-between;
    }

    header a {
      text-decoration: none; 
      color: #fff; 
      padding: 8px 12px;
      display: inline-block;
      border-radius: 5px; 
      transition: background-color 0.3s, color 0.3s;
    }

    header a:hover {
      background-color: #fff; 
      color: #000;
    }

    .navbar-toggler {
      border: none;
      background-color: transparent;
      color: #fff;
      font-size: 1.5rem;
    }

    .navbar-toggler:focus {
      outline: none;
    }

    .navbar-toggler-icon {
      background-color: #fff;
      height: 2px;
      width: 20px;
    }

    .navbar-nav {
      display: flex;
      gap: 15px;
      align-items: center;
    }

    .nav-link {
      color: #fff;
      text-decoration: none;
    }

    .nav-link:hover {
      color: #000;
    }
    img{
      width: 100px;
      border-radius: 5px;
    }
</style>