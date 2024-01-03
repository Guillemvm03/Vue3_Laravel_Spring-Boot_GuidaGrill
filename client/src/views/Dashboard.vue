<template>
  <!-- <div class="container py-5">
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

    <div class="col-xs-6 col-sm-6 col-md-3 col-lg-2 p-2">
      <a href="/dashboard/users" class="text-decoration-none">
        <div class="card p-3 shadow bg-primary text-white text-center border-0">
          <div class="card-body">
            <p class="card-title lead"><router-link to="/dashboard/users" class="text-white">Users</router-link></p>
          </div>
        </div>
      </a>
    </div>

  </div>
</div>
<br><br><br><br><br><br>



<br><br><br><br><br><br> -->

  <nav>

    <div class="nav-left">
      <h2>Dashboard</h2>
    </div>
  </nav>

  <div class="container">
    <div class="row">
      <div class="col-3">
        <div class="left-sidebar">
          <div class="imp-links">
            <a href="/dashboard/users"><router-link to="/dashboard/users"></router-link><img
                src="https://github.com/sanketbodke/sbook/blob/main/Socialbook_img/setting.png?raw=true"
                alt="news">Users</a>
            <a href="/dashboard/tables"><router-link to="/dashboard/tables"></router-link><img
                src="https://github.com/sanketbodke/sbook/blob/main/Socialbook_img/setting.png?raw=true"
                alt="news">Tables</a>
            <a href="/dashboard/menus"><router-link to="/dashboard/menus"></router-link><img
                src="https://github.com/sanketbodke/sbook/blob/main/Socialbook_img/setting.png?raw=true"
                alt="news">Menus</a>
            <a><img src="https://github.com/sanketbodke/sbook/blob/main/Socialbook_img/marketplace.png?raw=true"
                alt="news">Reservations</a>
          </div>
        </div>
      </div>
      <div class="col-9">
      
      </div>
    </div>

  </div>

  <br><br><br><br><br><br>
</template>
<script>
export default {};
</script>
<style scoped>
/* body {
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
  } */
* {
  margin: 0;
  padding: 0;
  font-family: 'poppins', sans-serif;
  box-sizing: border-box;
}

body {
  background: #efefef;
}


/* /............Navbar............../ */


nav {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background: #f25d18;
  padding: 5px 5%;
  position: sticky;
  top: 0;
  z-index: 100;
}

.logo a {
  width: 160px;
  margin-right: 45px;
  color: #fff;
  text-decoration: none;
}


.nav-left ul li {
  list-style: none;
  display: inline-block;
}

.nav-left ul li img {
  width: 28px;
  margin: 0 15px;
}

.container {
  display: flex;
  justify-content: space-between;
  padding: 13px 5%;
}

.left-sidebar {
  flex-basis: 25%;
  position: sticky;
  top: 70px;
  align-self: flex-start;
}

.imp-links a {
  text-decoration: none;
  display: flex;
  align-items: center;
  margin-bottom: 30px;
  color: #e26a1a;
  width: fit-content;
}

.imp-links a img {
  width: 25px;
  margin-right: 15px;
}

.imp-links a:last-child {
  color: #f27a18;
}

.imp-links {
  border-bottom: 1px solid #ccc;
}

h2 {
  font-size: 2.5rem;
  color: #f7f5f4;
  padding: 1rem;
}

.container {
  margin-top: 5rem;
  width: 100%;
}







/* ///......media query....../// */


@media(min-width: 280px) and (max-width: 868px) {
  /* .nav-right .search-box{
       display: none;
   } */

  .nav-left .icons-nav {
    display: none;
  }


}
</style>

