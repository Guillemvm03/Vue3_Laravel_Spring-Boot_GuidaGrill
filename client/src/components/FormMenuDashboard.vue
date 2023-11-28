<template>

    <div class="container"> <!-- Start CONTAINER -->
      
      <h4 class="border-bottom pt-3">ADD MENU <span class="badge badge-secondary mb-1">Form</span></h4>
      <p style="text-align: left; font-style: italic; font-weight: 100;">Please fill the form below...</p>
      
      <div id="form"> <!-- Start FORM -->  
        <div class="mb-3">
          <label for="type" class="form-label">TYPE</label>
          <input type="text" v-model="state.menuLocal.type" id="type"  class="form-control" placeholder="Please enter a valid name for the menu" required >
          <div class="invalid-feedback">
            Please enter Menu.
          </div>
        </div>

        <div class="mb-3">
          <label for="item" class="form-label">IMG MENU</label>
          <input type="text" v-model="state.menuLocal.img_Menu" class="form-control" placeholder="Please enter a valid IMG URL" required>
          <div class="invalid-feedback">
           Please enter a valid URL.
          </div>
        </div>


        <a @click="sendData()" v-if="menu" class="btn btn-primary">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Update
            </a>
            <a @click="sendData()" v-else class="btn btn-primary">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Create
            </a>
            <a @click="cancel()" class="btn btn-secondary">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Cancel
            </a>
                       
      </div> <!-- CLOSE  FORM -->
    </div> <!-- Close CONTAINER -->

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

    
</template>

<script>
import { reactive, getCurrentInstance } from 'vue';
import { useRouter } from 'vue-router';

export default {

    props: {
        menu: Object
    },
    emits: {
        data: Object
    },

    setup(props) {
        const router = useRouter();
        const { emit } = getCurrentInstance();
        const menu_ = props.menu ? props.menu : { 'type': '', 'img_Menu': '' };

        const state = reactive({
            menuLocal: { ...menu_ }
        });
console.log(state.menuLocal);
        const sendData = () => {
            emit('data', state.menuLocal);
        }

        const cancel = () => {
            router.push('/menus');
        }

        return { state, sendData, cancel };
    }

}
</script>

<style lang="scss" scoped>
// .container {
//           min-width: 100%!important;
//           padding: 10px 0px;
//         }
        
        // #form {
        //   width: 100%;
        //   max-width: 100%;
        //   padding: 15px;
        //   margin: auto;
        //   border-radius: 5px;
        //   background-color: #f2f2f2;
        // }
</style>