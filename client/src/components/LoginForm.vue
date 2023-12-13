<template>
    <body>
        <div class="wrapper">
            <form action="">
                <h1>Login</h1>
                <div class="input-box">
                    <input type="text" placeholder="Username" v-model="state.userAdmin.username" required>
                    <i class='bx bxs-user'></i>
                </div>
                <div class="input-box">
                    <input type="password" placeholder="password" v-model="state.userAdmin.password" required>
                    <i class='bx bxs-lock-alt'></i>
                </div>
                <div class="remember-forgot">
                    <label><input type="checkbox">Remember me
                    </label>
                    <a href="#">Forgot password?</a>
                </div>
                <button type="button" @click="login" class="btn">Login</button>
                <!-- <div class="register-link">
                <p>Dont't have an account? <a href="#">
                        Register
                    </a></p>
            </div> -->
            </form>
        </div>
    </body>
</template>
<script>
import { getCurrentInstance, reactive } from 'vue';
import { useRouter } from 'vue-router';

export default {
    props: {
        isLogin: Boolean,
    },
    emits: {
        send: Object
    },

    setup() {
        const { emit } = getCurrentInstance();
        const router = useRouter();

        
        const state = reactive({
            userAdmin: {
                username: '',
                password: '',
            }
        });
        // state.userAdmin.is_active = Boolean(state.userAdmin.is_active);

        const login = () => {
            const emit_data = state.userAdmin;            
            // Object.entries(emit_data).forEach(item => {
            //     if (!item[1] && item[0] !== 'is_active') { delete (emit_data[item[0]]); }
            // });
            emit('send', emit_data);
        }

        return { state, login };
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
    width: 420px;
    background: transparent;
    border: 2px solid rgba(255, 255, 255, .2);
    backdrop-filter: blur(20px);
    box-shadow: 0 0 10px rgba(0, 0, 0, .2);
    color: #fff;
    border-radius: 10px;
    padding: 30px 40px;

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