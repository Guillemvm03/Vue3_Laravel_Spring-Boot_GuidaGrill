<template>
  <body>
    <div class="wrapper" :class="{ 'flipped': !isLogin }">
      <div :class="{'content': !isLogin}">
        <h1>{{ isLogin ? 'Login' : 'Register' }}</h1>
<br>
        <errorList/>

      <div class="input-box" v-show="isLogin || !isLogin">
        <input type="text" placeholder="Username" v-model="state.userAdmin.username" required>
        <i class='bx bxs-user'></i>
      </div>

      <div class="input-box" v-show="isLogin || !isLogin">
        <input type="password" placeholder="Password" v-model="state.userAdmin.password" required>
        <i class='bx bxs-lock-alt'></i>
      </div>


      <!-- <button @click="isLogin ? login : register" class="btn">{{ isLogin ? 'Login' : 'Register' }}</button> -->
      <button v-if="isLogin" class="btn" @click="login">Login</button>
      <button v-else="!isLogin" class="btn">Register</button>
      <div class="register-link">
        <p>
          {{ isLogin ? "Don't have an account?" : "Already have an account?" }}
          <a @click="isLogin = !isLogin" href="#">
            {{ isLogin ? 'Register Here' : 'Login Here' }}
          </a>
        </p>
      </div>
    </div>
    </div>
  </body>
</template>
<script>

import errorList from './errorList.vue';

import { getCurrentInstance, reactive, ref } from 'vue';
import { useRouter } from 'vue-router';

export default {

  components: {
      errorList: errorList,
  },

  props: {
      isLogin: Boolean,
  },
  emits: {
      send: Object
  },

  setup(props) {
      const { emit } = getCurrentInstance();
      const router = useRouter();
    
      const isLogin = ref(props.isLogin);

      const state = reactive({
          userAdmin: {
              username: '',
              password: '',
          },
          useRegister:{
            username: '',
            email: '',
            password: '',
          }
      });

      const login = () => {

          const emit_data = state.userAdmin;            

          emit('send', emit_data);
      }


      const register = () => {
        const emit_data = state.useRegister;
        
        emit('send', emit_data);
        }
      return { state, login, register, isLogin };
  }
}

</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');

* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;

}

body {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background: url(https://i.blogs.es/a1940b/brooke-lark-4j059aga5s4-unsplash/1366_2000.jpg);
  background-size: cover;
  background-position: center;
}

.wrapper {
  position: relative;
  perspective: 1000px; 
  transition: transform 0.5s ease; 

  width: 420px;
  background: transparent;
  border: 2px solid rgba(255, 255, 255, .2);
  backdrop-filter: blur(20px);
  box-shadow: 0 0 10px rgba(0, 0, 0, .2);
  color: #fff;
  border-radius: 10px;
  padding: 30px 40px;
  position: relative;

}

.content{
  /* transform: rotateZ(180deg);  */
transform: rotate3d(0, 1, 0, 180deg);
}

.flipped {
  /* transform: rotateZ(180deg);  */
  transform: rotate3d(0, 1, 0, 180deg);
}

.wrapper h1 {
  font-size: 36px;
  text-align: center;
}

.wrapper .input-box {
  position: relative;
  width: 100%;
  height: 50px;
  margin: 30px 0;
}

.input-box input {
  width: 100%;
  height: 100%;
  background: transparent;
  border: none;
  outline: none;
  border: 2px solid rgba(255, 255, 255, .2);
  border-radius: 40px;
  font-size: 16px;
  color: #fff;
  padding: 20px 45px 20px 20px;
}

.input-box input::placeholder {
  color: #fff;
}

.input-box i {
  position: absolute;
  right: 20px;
  top: 50%;
  transform: translateY(-50%);
  font-size: 20px;

}

.wrapper .remember-forgot {
  display: flex;
  justify-content: space-between;
  font-size: 14.5px;
  margin: -15px 0 15px;
}

.remember-forgot label input {
  accent-color: #fff;
  margin-right: 3px;
}

.remember-forgot a {
  color: #fff;
  text-decoration: none;

}

.remember-forgot a:hover {
  text-decoration: underline;
}

.wrapper .btn {
  width: 100%;
  height: 45px;
  border-radius: 40px;
  border: none;
  outline: none;
  background: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, .1);
  cursor: pointer;
  font-size: 16px;
  color: #333;
  font-weight: 600;
}

.wrapper .register-link {
  text-align: center;
  font-size: 14.5px;
  margin: 20px 0 15px;
}

.register-link p a {
  color: #fff;
  text-decoration: none;
  font-weight: 600;

}

.register-link p a:hover {
  text-decoration: underline;
}
</style>