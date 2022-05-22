<template>
  <v-app id="app">
    <TopNavBar />
     <v-main>
      <router-view :key="$route.fullPath" />
    </v-main>
    <Footer/>
  </v-app>
</template>

<script>
import Footer from './components/layout/Footer.vue';
import TopNavBar from "./components/layout/TopNavBar.vue";
export default {
  name: "App",

  components: {
    TopNavBar,
    Footer,
  },

  data: () => ({
    //
  }),
};
</script>
