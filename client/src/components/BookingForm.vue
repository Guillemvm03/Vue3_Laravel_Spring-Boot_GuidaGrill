<template>

  <!-- ======= Book A Table Section ======= -->
  <section id="book-a-table" class="book-a-table">
    <div class="container" data-aos="fade-up">
      <div class="section-header">
        <h2>Book A Table</h2>
        <p>Book <span>Your Stay</span> With Us</p>
      </div>

      <div class="row g-0">
        <div
          class="col-lg-4 reservation-img"
          :style="{ backgroundImage: 'url(' + tables.img_table + ')' }"
          data-aos="zoom-out"
          data-aos-delay="200"
        ></div>
        <div class="col-lg-8 d-flex align-items-center reservation-form-bg">
          <form
            action="forms/book-a-table.php"
            method="post"
            role="form"
            class="php-email-form"
            data-aos="fade-up"
            data-aos-delay="100"
          >
            <div class="row gy-4">
              <div class="col-lg-4 col-md-6">
                <input
                  type="text"
                  name="name"
                  class="form-control"
                  id="name"
                  placeholder="Your Name"
                  data-rule="minlen:4"
                  data-msg="Please enter at least 4 chars"
                />
                <div class="validate"></div>
              </div>
              <div class="col-lg-4 col-md-6">
                <select
                  class="form-select"
                  name="people"
                  id="people"
                  data-rule="minlen:1"
                  data-msg="Please select an option"
                >
                  <option
                    v-for="menu in tables.menu"
                    :key="menu.id"
                    :value="menu.id"
                  >
                    {{ menu.type }}
                  </option>
                </select>
                <div class="validate"></div>
              </div>
              <div class="col-lg-4 col-md-6">
                <VueDatePicker
                  v-model="date"
                  :disabled-dates="disableDates"
                ></VueDatePicker>
              </div>
              <div class="col-lg-4 col-md-6">
                <input
                  type="email"
                  class="form-control"
                  name="email"
                  id="email"
                  placeholder="Your Email"
                  data-rule="email"
                  data-msg="Please enter a valid email"
                />
                <div class="validate"></div>
              </div>
              <div class="col-lg-4 col-md-6">
                <input
                  type="text"
                  class="form-control"
                  name="phone"
                  id="phone"
                  placeholder="Your Phone"
                  data-rule="minlen:4"
                  data-msg="Please enter at least 4 chars"
                />
                <div class="validate"></div>
              </div>

              <!-- <div class="col-lg-4 col-md-6">
                  <input type="text" name="date" class="form-control" id="date" placeholder="Date" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
                  <div class="validate"></div>
                </div>
                <div class="col-lg-4 col-md-6">
                  <input type="text" class="form-control" name="time" id="time" placeholder="Time" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
                  <div class="validate"></div>
                </div> -->

              <div class="col-lg-4 col-md-6">
                <input
                  type="number"
                  class="form-control"
                  name="people"
                  id="people"
                  placeholder="# of people"
                  data-rule="minlen:1"
                  data-msg="Please enter at least 1 chars"
                  :max="tables.capacity"
                />
                <div class="validate"></div>
              </div>
            </div>
            <div class="form-group mt-3">
              <textarea
                class="form-control"
                name="message"
                rows="5"
                placeholder="Message"
              ></textarea>
              <div class="validate"></div>
            </div>
            <div class="mb-3">
              <div class="loading">Loading</div>
              <div class="error-message"></div>
              <div class="sent-message">
                Your booking request was sent. We will call back or send an Email to
                confirm your reservation. Thank you!
              </div>
            </div>
            <div class="text-center"><button @click="sendData" type="submit">Book a Table</button></div>
          </form>
        </div>
      </div>
    </div>
  </section>

</template>

<script>

import { computed, reactive, ref } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import { getCurrentInstance } from "vue";


import VueDatePicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";


export default {

components: { VueDatePicker },

props: {
    tables: Object
},

data() {
    return {
      date: null,
    };
  },

  methods: {
    disableDates(date) {
      const today = new Date();
      const oneWeekLater = new Date();
      oneWeekLater.setDate(today.getDate() + 7);
      // console.log(date);
      return date < today || date > oneWeekLater;
    },

    // disableHours(date) {
    //   const hour = date.getHours();
    //   return hour < 9 || hour >= 20;
    // },
  },
    
setup() {

const {emit} = getCurrentInstance();

    const sendData = () => {
            // emit('data', state.menuLocal);

        }

}

}
</script>

<style scoped>


/*--------------------------------------------------------------
# Book A Table Section
--------------------------------------------------------------*/
.book-a-table .reservation-img {
  min-height: 500px;
  background-size: cover;
  background-position: center;
}

.book-a-table .reservation-form-bg {
  background: rgba(55, 55, 63, 0.04);
}

.book-a-table .php-email-form {
  padding: 40px;
}

@media (max-width: 575px) {
  .book-a-table .php-email-form {
    padding: 20px;
  }
}

.book-a-table .php-email-form h3 {
  font-size: 14px;
  font-weight: 700;
  text-transform: uppercase;
  letter-spacing: 1px;
}

.book-a-table .php-email-form h4 {
  font-size: 14px;
  font-weight: 700;
  text-transform: uppercase;
  letter-spacing: 1px;
  margin: 20px 0 0 0;
}

.book-a-table .php-email-form p {
  font-size: 14px;
  margin-bottom: 20px;
}

.book-a-table .php-email-form .error-message {
  display: none;
  color: #fff;
  background: #df1529;
  text-align: left;
  padding: 15px;
  margin-bottom: 24px;
  font-weight: 600;
}

.book-a-table .php-email-form .sent-message {
  display: none;
  color: #fff;
  background: #059652;
  text-align: center;
  padding: 15px;
  margin-bottom: 24px;
  font-weight: 600;
}

.book-a-table .php-email-form .loading {
  display: none;
  background: #fff;
  text-align: center;
  padding: 15px;
  margin-bottom: 24px;
}

.book-a-table .php-email-form .loading:before {
  content: "";
  display: inline-block;
  border-radius: 50%;
  width: 24px;
  height: 24px;
  margin: 0 10px -6px 0;
  border: 3px solid #059652;
  border-top-color: #fff;
  animation: animate-loading 1s linear infinite;
}

.book-a-table .php-email-form input,
.book-a-table .php-email-form textarea {
  border-radius: 0;
  box-shadow: none;
  font-size: 14px;
  border-radius: 0;
}

.book-a-table .php-email-form input:focus,
.book-a-table .php-email-form textarea:focus {
  border-color: var(--color-primary);
}

.book-a-table .php-email-form input {
  padding: 12px 15px;
}

.book-a-table .php-email-form textarea {
  padding: 12px 15px;
}

.book-a-table .php-email-form button[type="submit"] {
  background: var(--color-primary);
  border: 0;
  padding: 14px 60px;
  color: #fff;
  transition: 0.4s;
  border-radius: 50px;
}

.book-a-table .php-email-form button[type="submit"]:hover {
  background: #ec2727;
}

@keyframes animate-loading {
  0% {
    transform: rotate(0deg);
  }

  100% {
    transform: rotate(360deg);
  }
}


</style>