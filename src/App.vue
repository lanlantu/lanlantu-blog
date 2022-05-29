<template>
  <v-app id="app">
    <TopNavBar />
    <v-main>
      <router-view :key="$route.fullPath" />
    </v-main>
    <login-model />
    <Footer />
    <back-top />
  </v-app>
</template>

<script>
import BackTop from "./components/BackTop.vue";
import Footer from "./components/layout/Footer.vue";
import TopNavBar from "./components/layout/TopNavBar.vue";
import LoginModel from "./components/model/LoginModel.vue";
export default {
  name: "App",

  components: {
    TopNavBar,
    Footer,
    LoginModel,
    BackTop,
  },
  created() {
    // 获取博客信息
    this.getBlogInfo();

    //首次加载完成后移除动画
    let loadDOM = document.querySelector("#appLoading");
    if (loadDOM) {
      setTimeout(() => {
        document.body.removeChild(loadDOM);
      }, 1000);
    }
  },
  methods: {
    getBlogInfo() {
      this.axios.get("/api/").then(({ data }) => {
        console.log("我被调用 %O", data.data);
        this.$store.commit("checkBlogInfo", data.data);
      });
    },
  },
};
</script>
