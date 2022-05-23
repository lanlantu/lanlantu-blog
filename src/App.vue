<template>
  <v-app id="app">
    <TopNavBar />
    <v-main>
      <router-view :key="$route.fullPath" />
    </v-main>
    <Footer />
  </v-app>
</template>

<script>
import Footer from "./components/layout/Footer.vue";
import TopNavBar from "./components/layout/TopNavBar.vue";
export default {
  name: "App",

  components: {
    TopNavBar,
    Footer,
  },
  created() {
    // 获取博客信息
    this.getBlogInfo();
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
