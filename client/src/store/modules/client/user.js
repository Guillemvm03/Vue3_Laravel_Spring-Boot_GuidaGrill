import Constant from '../../../Constant';
import UserService from '../../../services/client/UserService';
import { createToaster } from "@meforma/vue-toaster";
import router from '../../../router/index.js'

const toaster = createToaster({ "position": "top-right", "duration": 2000 });
export const user = {
    namespaced: true,
    state: {
        user: {},
        isAuth: false,
        isAdmin: false
    },
    actions: {
        [Constant.LOGIN]: async (store, payload) => {
            console.log(payload);
            try {
                const response = await UserService.login_admin(payload);///cambiar a login cuando este springboot
                store.commit(Constant.LOGIN_ADMIN, response);

                console.log(response);
                // if (response.status === 200) {
                //     store.commit(Constant.LOGIN, response.data);
                //     if (response.data.user.type == "admin") {
                //         const response_admin = await UserService.login_admin(payload);
                //         if (response_admin.status === 200) {
                //             store.commit(Constant.LOGIN_ADMIN, response_admin.data);
                //         }
                //     }
                // }
            } catch (error) {
                toaster.error('Username or password incorrect');
            }
        },

        [Constant.LOGOUT]: async (store) => {
            console.log("logout store");
            try {
                const response = await UserService.logout();
                let data = { status: response.status };
                // if (store.state.isAdmin) {
                    const response_admin = await UserService.logout_admin();
                    data.status_admin = response_admin.status;
                // }
                store.commit(Constant.LOGOUT, data);
            } catch (error) {
                toaster.error('Logout error');
                store.commit(Constant.LOGOUT, { status: null, status_admin: null });
            }
        },

        [Constant.ADD_USER]: async (store, payload) => {
            try {
                const response = await UserService.register(payload);
                if (response.status === 201) {
                    store.commit(Constant.ADD_USER, true);
                }
            } catch (error) {
                toaster.error('Register error');
            }
        },

        [Constant.INITIALIZE_PROFILE]: async (store) => {
            console.log("entra profile");
            console.log(store);
            try {
                const response = await UserService.profile();

                if (response.status === 200) {
                    store.commit(Constant.INITIALIZE_PROFILE, response.data);
                }
            } catch (error) {
                console.error(error);
            }
        },

    },
    mutations: {
        [Constant.LOGIN]: (state, payload) => {
            console.log(payload);
            if (payload) {
                toaster.success('Login successfuly');
                localStorage.setItem("token", payload.token);
                localStorage.setItem("isAuth", true);
                state.user = payload.user;
                state.isAuth = true;
                router.push({ name: 'home' });
            }
        },
        [Constant.LOGIN_ADMIN]: (state, payload) => {
            console.log(payload);
            if (payload) {
                toaster.success('Login admin successfuly');
                localStorage.setItem("token_admin", payload.data.token);
                localStorage.setItem("isAdmin", true);
                state.user = payload.user;
                state.isAdmin = true;
                router.push({ name: 'home' });
            }
        },
        [Constant.ADD_USER]: (state, payload) => {
            if (payload) {
                toaster.success('Register successfuly');
                router.push({ name: 'login' });
            }
        },
        [Constant.INITIALIZE_PROFILE]: (state, payload) => {
            if (payload) {
                state.user = payload;
                state.isAuth = true;
                state.isAdmin = payload.type === 'admin';
                localStorage.setItem("isAuth", true);
                localStorage.setItem("isAdmin", payload.type === 'admin');
            }
        },

        [Constant.LOGOUT]: (state, payload) => {
            console.log("payload", payload);
            state.user = {};
            state.isAuth = false;
            state.isAdmin = false;
            localStorage.removeItem('token');
            localStorage.removeItem('token_admin');
            localStorage.removeItem('isAuth');
            localStorage.removeItem('isAdmin');
            router.push({ name: 'home' });

            if (payload.status === 200) {
                toaster.success('Logout successfuly')
            }
            if (payload.status_admin === 200) {
                toaster.success('Logout admin successfuly')
            }

        },
    },
    getters: {
        GetProfile: (state) => {
            return state.user;
        },
        GetIsAuth: (state) => {
            return state.isAuth;
        },
        GetIsAdmin: (state) => {
            return state.isAdmin;
        },

    }
}