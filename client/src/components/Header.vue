<template>


<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">
    <div class="container d-flex align-items-center justify-content-between">

      <a href="index.html" class="logo d-flex align-items-center me-auto me-lg-0">
        <!-- Uncomment the line below if you also wish to use an image logo -->
        <img src="../assets/img/logoletra.png" alt="">
        <!-- <h1>GUIDA GRILL<span>.</span></h1> -->
      </a>

      <nav id="navbar" class="navbar">
        <ul>
          <li>
            <router-link to="/home" class="link">
              <a class="nav-link">Home</a>
            </router-link>
          </li>

          <li>
            <router-link to="/Bookings" class="link">
              <a class="nav-link">Bookings</a>
            </router-link>
          </li>

          <!-- <li>
            <router-link to="/Dashboard" class="link">
              <a class="nav-link">Dashboard</a>
            </router-link>
          </li> -->

          <!-- <li><a href="#menu">Menu</a></li>
          <li><a href="#events">Events</a></li>
          <li><a href="#chefs">Chefs</a></li>
          <li><a href="#gallery">Gallery</a></li> -->
          <!-- <li><a href="#contact">Contact</a></li> -->

        </ul>
      </nav><!-- .navbar -->

      
      <router-link to="/Dashboard" class="link">
        <a class="btn-book-a-table">Dashboard</a>
            </router-link>


      <!-- <i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
      <i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i> -->

    </div>
  </header><!-- End Header -->

<br><br><br><br>

</template>


<script>

export default {
   }

</script>



<style lang="scss">



/*--------------------------------------------------------------
# Header
--------------------------------------------------------------*/
.header {
  background: #fff;
  transition: all 0.5s;
  z-index: 997;
  height: 90px;
  border-bottom: 1px solid #fff;
}

@media (max-width: 575px) {
  .header {
    height: 70px;
  }
}

.header.sticked {
  border-color: #fff;
  border-color: #eee;
}

.header .logo img {
  max-height: 40px;
  margin-right: 6px;
}

.header .logo h1 {
  font-size: 28px;
  font-weight: 700;
  color: #000;
  margin: 0;
  font-family: var(--font-secondary);
}

.header .logo h1 span {
  color: var(--color-primary);
}

.header .btn-book-a-table,
.header .btn-book-a-table:focus {
  font-size: 14px;
  color: #fff;
  background: var(--color-primary);
  padding: 8px 20px;
  margin-left: 30px;
  border-radius: 50px;
  transition: 0.3s;
}

.header .btn-book-a-table:hover,
.header .btn-book-a-table:focus:hover {
  color: #fff;
  background: rgba(206, 18, 18, 0.8);
}

section {
  scroll-margin-top: 90px;
}

/*--------------------------------------------------------------
# Desktop Navigation
--------------------------------------------------------------*/
@media (min-width: 1280px) {
  .navbar {
    padding: 0;
  }

  .navbar ul {
    margin: 0;
    padding: 0;
    display: flex;
    list-style: none;
    align-items: center;
  }

  .navbar li {
    position: relative;
  }

  .navbar>ul>li {
    white-space: nowrap;
    padding: 10px 0 10px 28px;
  }

  .navbar a,
  .navbar a:focus {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 3px;
    font-family: var(--font-secondary);
    font-size: 16px;
    font-weight: 600;
    color: #7f7f90;
    white-space: nowrap;
    transition: 0.3s;
    position: relative;
  }

  .navbar a i,
  .navbar a:focus i {
    font-size: 12px;
    line-height: 0;
    margin-left: 5px;
  }

  .navbar>ul>li>a:before {
    content: "";
    position: absolute;
    width: 100%;
    height: 2px;
    bottom: -6px;
    left: 0;
    background-color: var(--color-primary);
    visibility: hidden;
    width: 0px;
    transition: all 0.3s ease-in-out 0s;
  }

  .navbar a:hover:before,
  .navbar li:hover>a:before,
  .navbar .active:before {
    visibility: visible;
    width: 100%;
  }

  .navbar a:hover,
  .navbar .active,
  .navbar .active:focus,
  .navbar li:hover>a {
    color: #000;
  }

  .navbar .dropdown ul {
    display: block;
    position: absolute;
    left: 28px;
    top: calc(100% + 30px);
    margin: 0;
    padding: 10px 0;
    z-index: 99;
    opacity: 0;
    visibility: hidden;
    background: #fff;
    box-shadow: 0px 0px 30px rgba(127, 137, 161, 0.25);
    transition: 0.3s;
    border-radius: 4px;
  }

  .navbar .dropdown ul li {
    min-width: 200px;
  }

  .navbar .dropdown ul a {
    padding: 10px 20px;
    font-size: 15px;
    text-transform: none;
    font-weight: 600;
  }

  .navbar .dropdown ul a i {
    font-size: 12px;
  }

  .navbar .dropdown ul a:hover,
  .navbar .dropdown ul .active:hover,
  .navbar .dropdown ul li:hover>a {
    color: var(--color-primary);
  }

  .navbar .dropdown:hover>ul {
    opacity: 1;
    top: 100%;
    visibility: visible;
  }

  .navbar .dropdown .dropdown ul {
    top: 0;
    left: calc(100% - 30px);
    visibility: hidden;
  }

  .navbar .dropdown .dropdown:hover>ul {
    opacity: 1;
    top: 0;
    left: 100%;
    visibility: visible;
  }
}

@media (min-width: 1280px) and (max-width: 1366px) {
  .navbar .dropdown .dropdown ul {
    left: -90%;
  }

  .navbar .dropdown .dropdown:hover>ul {
    left: -100%;
  }
}

@media (min-width: 1280px) {

  .mobile-nav-show,
  .mobile-nav-hide {
    display: none;
  }
}



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
      color: #ffffff;
      text-decoration: none;
    }

    .nav-link:hover {
      color: #000;
    }
    img{
      width: 150px;
      border-radius: 5px;
    }

    
</style>