import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import router from "./router";
import store from "./store";
import axios from "axios";
import VueAxios from 'vue-axios';
import InfiniteLoading from "vue-infinite-loading";
import dayjs from "dayjs";

import VueImageSwipe from "vue-image-swipe";
import "vue-image-swipe/dist/vue-image-swipe.css";

import Toast from "./components/toast/index";
import 'animate.css';
import "./assets/css/iconfont.css";
import "./assets/css/index.css";
import "./assets/css/markdown.css";


Vue.config.productionTip = false
Vue.use(Toast);
Vue.use(VueAxios,axios);
Vue.use(VueImageSwipe);

Vue.use(InfiniteLoading);


Vue.filter("date", function(value) {
  return dayjs(value).format("YYYY-MM-DD");
});

Vue.filter("year", function(value) {
  return dayjs(value).format("YYYY");
});

Vue.filter("hour", function(value) {
  return dayjs(value).format("HH:mm:ss");
});

Vue.filter("time", function(value) {
  return dayjs(value).format("YYYY-MM-DD HH:mm:ss");
});

Vue.filter("num", function(value) {
  if (value >= 1000) {
    return (value / 1000).toFixed(1) + "k";
  }
  return value;
});


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
