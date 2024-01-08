<template>
  <div>
    <footer id="footer" class="footer">

<div class="container">
  <div class="row gy-3">
    <div class="col-lg-3 col-md-6 d-flex">
      <i class="bi bi-geo-alt icon"></i>
      <div>
        <h4>Authors</h4>
        <p>
          Guillem Vicent <br>
          David Moreno<br>
        </p>
      </div>

    </div>

    <div class="col-lg-3 col-md-6 footer-links d-flex">
      <i class="bi bi-telephone icon"></i>
      <div>
        <h4>Emails</h4>
        <p>
           guillemvicent33@gmail.com<br>
           davidmpenades@gmail.com<br>
        </p>
      </div>
    </div>

    <div class="col-lg-3 col-md-6 footer-links d-flex">
      <i class="bi bi-clock icon"></i>
      <div>
        <h4>Education Center</h4>
        <p>
          IES L'Estacio<br>
          2º DAW
        </p>
      </div>
    </div>

    <div class="col-lg-3 col-md-6 footer-links">
      <h4>Follow Us</h4>
      <div class="social-links d-flex">
        
        <a href="https://www.linkedin.com/in/gvicentmarti/" class="social-links"><img src="../assets/img/linkedin.svg"></a>
        <a href="https://github.com/Guillemvm03" class="social-links"><img src="../assets/img/github.svg"></a>
        
        <a href="https://www.linkedin.com/in/david-moreno-1675a4248/" class="Linkedin"><img src="../assets/img/linkedin.svg"></a>
        <a href="https://github.com/davidmpenades" class="social-links"><img src="../assets/img/github.svg"></a>
        

        <!-- <a href=""><i class="bi bi-github"></i></a> -->
      </div>
    </div>

  </div>
</div>

<div class="container">
  <div class="copyright">
    &copy; Copyright <strong><span>GUIDA GRILL</span></strong>. All Rights Reserved
  </div>
  <div class="credits">
    Designed by <a href="http://localhost:5173/Bookings">GUIDA</a>
  </div>
</div>

</footer>
  </div>
</template>



<script>

export default {
  name: "Test",
  created() {},
  data() {
    return {};
  },
  props: {},
  methods: {},
};
</script>




<style lang="scss" >

.footer {
  font-size: 14px;
  background-color: #1f1f24;
  padding: 50px 0;
  color: rgba(255, 255, 255, 0.7);
}

.footer .icon {
  margin-right: 15px;
  font-size: 24px;
  line-height: 0;
}

.footer h4 {
  font-size: 16px;
  font-weight: bold;
  position: relative;
  padding-bottom: 5px;
  color: #fff;
}

.footer .footer-links {
  margin-bottom: 30px;
}

.footer .footer-links ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.footer .footer-links ul li {
  padding: 10px 0;
  display: flex;
  align-items: center;
}

.footer .footer-links ul li:first-child {
  padding-top: 0;
}

.footer .footer-links ul a {
  color: rgba(255, 255, 255, 0.6);
  transition: 0.3s;
  display: inline-block;
  line-height: 1;
}

.footer .footer-links ul a:hover {
  color: #363434;
}

.footer .social-links img{
  display: flex;
  align-items: center;
  justify-content: center;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  border: 1px solid rgba(255, 255, 255, 0.2);
  font-size: 16px;
  color: rgba(44, 42, 42, 0.7);
  margin-right: 10px;
  transition: 0.3s;
}

.footer .social-links a:hover {
  color: #181717;
  border-color: #201f1f;
}

.footer .copyright {
  text-align: center;
  padding-top: 30px;
  border-top: 1px solid rgba(255, 255, 255, 0.1);
}

.footer .credits {
  padding-top: 4px;
  text-align: center;
  font-size: 13px;
}

.footer .credits a {
  color: #fff;
}
</style>