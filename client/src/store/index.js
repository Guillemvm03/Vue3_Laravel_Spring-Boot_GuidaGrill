import Vuex from 'vuex';

import {table} from './modules/client/table.js';

export default Vuex.createStore({
    modules: {
        tables: table///////////
    }
});