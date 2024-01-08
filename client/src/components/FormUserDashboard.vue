<template>
  <div class="container">

    <h4 class="border-bottom pt-3">ADD USER <span class="badge badge-secondary mb-1">Form</span></h4>
    <p style="text-align: left; font-style: italic; font-weight: 100;">Please fill the form below...</p>

    <div id="form">

      <div class="mb-3">
        <label for="type" class="form-label">USERNAME</label>
        <input type="text" v-model="state.userLocal.username" id="type" class="form-control"
          placeholder="Please enter a valid name for the menu" required>
        <div class="invalid-feedback">
          Please enter Menu.
        </div>
      </div>

      <div class="mb-3">
        <label for="item" class="form-label">PASSOWRD</label>
        <input type="text" v-model="state.userLocal.password" class="form-control"
          placeholder="Please enter a valid IMG URL" required>
        <div class="invalid-feedback">
          Please enter a valid URL.
        </div>
      </div>

      <div class="mb-3">
        <label for="item" class="form-label">EMAIL</label>
        <input type="text" v-model="state.userLocal.email" class="form-control" placeholder="Please enter a valid IMG URL"
          required>
        <div class="invalid-feedback">
          Please enter a valid URL.
        </div>
      </div>

      <div class="mb-3">
        <label for="item" class="form-label">TYPE</label>
        <input type="text" v-model="state.userLocal.type" class="form-control" placeholder="Please enter a valid IMG URL"
          required>
        <div class="invalid-feedback">
          Please enter a valid URL.
        </div>
      </div>

      <div class="mb-3">
        <label for="item" class="form-label">IS ACTIVE</label>
        <input type="text" v-model="state.userLocal.is_active" class="form-control"
          placeholder="Please enter a valid IMG URL" required>
        <div class="invalid-feedback">
          Please enter a valid URL.
        </div>
      </div>

      <div class="mb-3">
        <label for="item" class="form-label">PHOTO</label>
        <input type="text" v-model="state.userLocal.photo" class="form-control" placeholder="Please enter a valid IMG URL"
          required>
        <div class="invalid-feedback">
          Please enter a valid URL.
        </div>
      </div>


      <a @click="sendData()" v-if="user" class="btn btn-primary">
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

    </div>
  </div>
  <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</template>

<script>
import { reactive, getCurrentInstance } from 'vue';
import { useRouter } from 'vue-router';

export default {

  props: {
    user: Object
  },
  emits: {
    data: Object
  },

  setup(props) {
    const router = useRouter();
    const { emit } = getCurrentInstance();
    const user_ = props.user ? props.user : { 'type': '', 'img_user': '' };

    const state = reactive({
      userLocal: { ...user_ }
    });

    const sendData = () => {
      emit('data', state.userLocal);
    }

    const cancel = () => {
      router.push('/Dashboard');
    }

    return { state, sendData, cancel };
  }

}
</script>

<style lang="scss" scoped>
</style>