import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import router from "./router";
import store from "./store";
import axios from "axios";
import VueAxios from 'vue-axios';
import InfiniteLoading from "vue-infinite-loading";


import Toast from "./components/toast/index";
import 'animate.css';
import "./assets/css/iconfont.css";
import "./assets/css/index.css";


Vue.config.productionTip = false
Vue.use(Toast);
Vue.use(VueAxios,axios);

Vue.use(InfiniteLoading);


axios.interceptors.response.use(
  function(response) {
    switch (response.data.code) {
      case 50000:
        Vue.prototype.$toast({ type: "error", message: "系统异常" });
    }
    return response;
  },
  function(error) {
    return Promise.reject(error);
  }
);

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
