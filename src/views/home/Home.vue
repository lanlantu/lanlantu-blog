<template>
  <div>
   <!-- banner -->
    <div class="home-banner" >
      <div class="banner-container">
        <!-- 联系方式 -->
        <h1 class="blog-title animated zoomIn">
          联系方式
        </h1>
        <!-- 一言 -->
        <div class="blog-intro">
         一言 <span class="typed-cursor">|</span>
        </div>
        <!-- 联系方式 -->
        <div class="blog-contact">
          <a
            v-if="isShowSocial('qq')"
            class="mr-5 iconfont iconqq"
            target="_blank"
            :href="
              'http://wpa.qq.com/msgrd?v=3&uin=' +
                '&site=qq&menu=yes'
            "
          />
          <a
            v-if="isShowSocial('github')"
            target="_blank"
            class="mr-5 iconfont icongithub"
          />
          <a
            v-if="isShowSocial('gitee')"
            target="_blank"
            class="iconfont icongitee-fill-round"
          />
        </div>
      </div>
      <!-- 向下滚动 -->
      <div class="scroll-down" @click="scrollDown">
        <v-icon color="#fff" class="scroll-down-effects">
         aiaiai 
        </v-icon>
      </div>
    </div>
    
  </div>
</template>

<script>
export default {

data() {
  return {
    show:false
  }
},
computed: {
     isShowSocial() {
      return function(social) {
        return "github";
      };
    },
},
methods:{
   scrollDown() {
      window.scrollTo({
        behavior: "smooth",
        top: document.documentElement.clientHeight
      });
    },
}
}
</script>

<style scoped>
.home-banner {
  background-color: antiquewhite;
  position: absolute;
  left: 0;
  right: 0;
  height: 100vh;
  background-attachment: fixed;
  text-align: center;
  color: #fff !important;
  animation: header-effect 1s;
}

.banner-container {
  margin-top: 43vh;
  line-height: 1.5;
  color: #eee;
}
</style>