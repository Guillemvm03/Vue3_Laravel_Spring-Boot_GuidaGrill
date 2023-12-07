<template>
  <div class="container">

    <h4 class="border-bottom pt-3">Table Management <span class="badge badge-secondary mb-1">Form</span></h4>
    <p style="text-align: left; font-style: italic; font-weight: 100;">Please fill out the form below...</p>

    <div id="form">
      <div class="mb-3">
        <label for="tableNumber" class="form-label">Table Number</label>
        <input type="text" v-model="state.dataTable.table_number" id="tableNumber" class="form-control"
          placeholder="Enter a valid table number" required>
        <div class="invalid-feedback">
          Please enter a valid number.
        </div>
      </div>

      <div class="mb-3">
        <label for="capacity" class="form-label">Capacity</label>
        <input type="text" v-model="state.dataTable.capacity" class="form-control" placeholder="Enter a valid capacity"
          required>
        <div class="invalid-feedback">
          Please enter a valid capacity.
        </div>
      </div>

      <div class="mb-3">
        <label for="category" class="form-label">Category</label>
        <input type="text" v-model="state.dataTable.category" class="form-control" placeholder="Enter a valid category"
          required>
        <div class="invalid-feedback">
          Please enter a valid category.
        </div>
      </div>

      <div class="mb-3">
        <label for="available" class="form-label">Available</label>
        <div class="form-check">
          <input type="checkbox" v-model="state.dataTable.available" class="form-check-input">
          <label class="form-check-label" :style="{ backgroundColor: state.dataTable.available ? 'red' : 'green' }">
            {{ state.dataTable.available ? 'Not Available' : 'Available' }}
          </label>
        </div>
      </div>

      <div class="mb-3">
        <label for="status" class="form-label">Status</label>
        <div class="form-check">
          <input type="radio" id="occupied" v-model="state.dataTable.status" value="Occupied" class="form-check-input">
          <label for="occupied" class="form-check-label">Occupied</label>
        </div>
        <div class="form-check">
          <input type="radio" id="available" v-model="state.dataTable.status" value="Available" class="form-check-input">
          <label for="available" class="form-check-label">Available</label>
        </div>
        <div class="form-check">
          <input type="radio" id="reserved" v-model="state.dataTable.status" value="Reserved" class="form-check-input">
          <label for="reserved" class="form-check-label">Reserved</label>
        </div>
      </div>

      <div class="mb-3">
        <label for="imgTable" class="form-label">Image URL</label>
        <input type="text" v-model="state.dataTable.img_table" class="form-control" placeholder="Enter a valid image URL"
          required>
        <div class="invalid-feedback">
          Please enter a valid image URL.
        </div>
      </div>
      <div class="mb-3">

        <label class="form-label">Menu Types</label>
        <div class="form-check" v-for="menu in state.dataTable.menus" :key="menu.id">
          <input type="checkbox" v-model="menu.selected" class="form-check-input">
          <label class="form-check-label">{{ menu.type }}</label>
        </div>
      </div>


      <button @click="sendData()" v-if="table" class="btn btn-outline-primary">Update</button>
      <button @click="sendData()" v-else class="btn btn-outline-success">Create</button>
      <button @click="cancel()" class="btn btn-outline-danger">Cancel</button>

    </div>
  </div>
  <br><br>
</template>
<script>
import { createToaster } from "@meforma/vue-toaster";
import { useRouter } from 'vue-router';
import { useStore } from 'vuex';
import { reactive, getCurrentInstance, computed } from "vue";

export default {
  emits: {
    data: Object
  },
  props: {
    table: Object,
  },
  computed: {
    isEdit() {
      const path = this.$route.path.split('/')
      return path[path.length - 1] === 'Edit'
    }
  },
  setup(props) {
    const router = useRouter();
    const store = useStore();
    const toaster = createToaster({ position: "top-right" });
    const { emit } = getCurrentInstance();
    const table_ = props.table ? props.table : { table_number: '', capacity: '', category: '', available: '', status: '', img_table: '' };
    const state = reactive({
      dataTable: {
        ...table_,
        menus: [
          { id: 1, type: 'breakfast', selected: false },
          { id: 2, type: 'lunch', selected: false },
          { id: 3, type: 'dinner', selected: false },
          { id: 4, type: 'degustation', selected: false },
        ]
      }
    })

    const sendData = async () => {
      try {

        state.dataTable.available = state.dataTable.available ? 0 : 1;

        const selectedMenus = [];

        state.dataTable.menus.forEach(menu => {
          if (menu.selected) {
            selectedMenus.push(menu.type);
          }
        });

        state.dataTable.menus = selectedMenus;

        if (state.isEdit) {
          store.commit('updateTable', state.dataTable);
          toaster.success("Table updated successfully");
        } else {
          console.log(state.dataTable)

          store.commit('createTable', state.dataTable);
          toaster.success("Table created successfully");
        }


        emit('data', state.dataTable);

        router.push('/Dashboard/tables');
      } catch (error) {
        console.error("Error:", error);
        toaster.error("Error while saving data");
      }
    }

    const cancel = () => {
      router.push('/Dashboard/tables');
    }

    return { sendData, state, cancel }
  }
};



</script>

<style scoped>
body {
  font-family: 'Arial', sans-serif;
  background-color: #f8f9fa;
}

.container {
  max-width: 600px;
  margin: 50px auto;
  background-color: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h4 {
  color: #343a40;
}

.badge {
  background-color: #6c757d;
}

p {
  text-align: left;
  font-style: italic;
  font-weight: 100;
  color: #495057;
}

.form-label {
  color: #495057;
}

.form-control {
  margin-bottom: 15px;
}

.btn {
  margin-right: 10px;
}

.btn-outline-primary,
.btn-outline-success,
.btn-outline-danger {
  color: #fff;
}

.btn-outline-primary {
  border-color: #007bff;
  background-color: #007bff;
}

.btn-outline-success {
  border-color: #28a745;
  background-color: #28a745;
}

.btn-outline-danger {
  border-color: #dc3545;
  background-color: #dc3545;
}
</style>