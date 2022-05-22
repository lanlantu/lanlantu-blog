import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import router from "./router";
import store from "./store";
import axios from "@/axios/axios";


import Toast from "./components/toast/index";
import 'animate.css';
import "./assets/css/iconfont.css";
import "./assets/css/index.css";


Vue.config.productionTip = false
Vue.use(Toast);
Vue.prototype.$axios = axios;

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
