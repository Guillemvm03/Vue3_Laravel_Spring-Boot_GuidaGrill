<template>
  <nav>

    <div class="nav-left">
      <h2>Dashboard</h2>
    </div>
  </nav>

  <div class="container">
    <div class="row">
      <div class="col-2">
        <div class="left-sidebar">
          <div class="imp-links">
            <a @click="instance = 'userList'"><img
                src="https://github.com/sanketbodke/sbook/blob/main/Socialbook_img/setting.png?raw=true"
                alt="news">Users</a>
            <a @click="instance = 'tableList'"><img
                src="https://github.com/sanketbodke/sbook/blob/main/Socialbook_img/setting.png?raw=true"
                alt="news">Tables</a>
            <a @click="instance = 'menuList'"><img
                src="https://github.com/sanketbodke/sbook/blob/main/Socialbook_img/setting.png?raw=true"
                alt="news">Menus</a>
            <a @click="instance = 'reservation'"><img
                src="https://github.com/sanketbodke/sbook/blob/main/Socialbook_img/marketplace.png?raw=true"
                alt="news">Reservations</a>
          </div>
        </div>
      </div>
      <div class="col-10">
        <tableList v-if="instance == 'tableList'" />
        <userList v-if="instance == 'userList'" />
        <menuList v-if="instance == 'menuList'" />
        <ReservationList v-if="instance == 'reservation'" />
      </div>
    </div>

  </div>

  <br><br><br><br><br><br>
</template>
<script>
import tableList from "../views/Tables/tableList.vue";
import userList from "../views/Users/userList.vue";
import menuList from "../views/Menus/menuList.vue";
import ReservationList from "../views/Reservation/ReservationList.vue";
import { ref } from "vue";
export default {
  components: { tableList, userList, menuList, ReservationList },
  setup() {
    const instance = ref('userList')
    return { instance }
  }
};
</script>
<style scoped>
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
  justify-content: center;
  height: 100%;
  padding: 2% 1%;
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
  color: #080808;
  width: fit-content;
}

.imp-links a img {
  width: 25px;
  margin-right: 15px;
}

a:hover {
  cursor: pointer;
}

.imp-links {
  border-bottom: 1px solid #ccc;
}

h2 {
  font-size: 2.5rem;
  color: #f7f5f4;
  padding: 1rem;
}
.row{
  height: 100%;
  
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

