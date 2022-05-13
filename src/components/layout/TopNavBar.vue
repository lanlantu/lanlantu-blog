<template>
  <v-app-bar app :class="navClass" hide-on-scroll flat height="60">
    <!-- 手机端导航栏 -->

    <!-- 电脑导航栏 -->
    <div class="nav-container">
      <div class="float-left blog-title animated fadeIn">
        <router-link to="/"> 兰兰兔 </router-link>
      </div>
      <div class="float-right nav-title">
        <div class="menus-item">
          <a class="menu-btn"> <i class="iconfont iconsousuo" /> 搜索 </a>
        </div>
        <div class="menus-item">
          <router-link class="menu-btn" to="/">
            <i class="iconfont iconzhuye" /> 首页
          </router-link>
        </div>
        <div class="menus-item">
          <a class="menu-btn">
            <i class="iconfont iconfaxian" /> 发现
            <i class="iconfont iconxiangxia2 expand" />
          </a>
          <ul class="menus-submenu">
            <li>
              <router-link to="/archives">
                <i class="iconfont iconguidang" /> 归档
              </router-link>
            </li>
            <li>
              <router-link to="/categories">
                <i class="iconfont iconfenlei" /> 分类
              </router-link>
            </li>
            <li>
              <router-link to="/tags">
                <i class="iconfont iconbiaoqian" /> 标签
              </router-link>
            </li>
          </ul>
        </div>
        <div class="menus-item">
          <a class="menu-btn">
            <i class="iconfont iconqita" /> 娱乐
            <i class="iconfont iconxiangxia2 expand" />
          </a>
          <ul class="menus-submenu">
            <li>
              <router-link to="/albums">
                <i class="iconfont iconxiangce1" /> 相册
              </router-link>
            </li>
            <li>
              <router-link to="/talks">
                <i class="iconfont iconpinglun" /> 说说
              </router-link>
            </li>
          </ul>
        </div>
        <div class="menus-item">
          <router-link class="menu-btn" to="/links">
            <i class="iconfont iconlianjie" /> 友链
          </router-link>
        </div>
        <div class="menus-item">
          <router-link class="menu-btn" to="/about">
            <i class="iconfont iconzhifeiji" /> 关于
          </router-link>
        </div>
        <div class="menus-item">
          <router-link class="menu-btn" to="/message">
            <i class="iconfont iconpinglunzu" /> 留言
          </router-link>
        </div>
      </div>
    </div>
  </v-app-bar>
</template>

<script>
export default {
  mounted() {
    window.addEventListener("scroll", this.scroll);
  },
  data: function () {
    return {
      navClass: "",
    };
  },

  methods: {
    scroll() {
      const that = this;
      let scrollTop =
        window.pageYOffset ||
        document.documentElement.scrollTop ||
        document.body.scrollTop;
      that.scrollTop = scrollTop;
      if (that.scrollTop > 60) {
        that.navClass = "nav-fixed";
      } else {
        that.navClass = "nav";
      }
    },
  },
};
</script>

<style scoped>
ul {
  list-style: none;
}

.nav-container {
  font-size: 14px;
  width: 100%;
  height: 100%;
}

.blog-title a {
  font-size: 18px;
  font-weight: bold;
}

.menus-item {
  position: relative;
  display: inline-block;
  margin: 0 0 0 0.875rem;
}

.menus-item a {
  transition: all 0.2s;
}
.nav-fixed .menu-btn:hover {
  color: #49b1f5 !important;
}
.menu-btn:hover:after {
  width: 100%;
}
.menus-item a:after {
  position: absolute;
  bottom: -5px;
  left: 0;
  z-index: -1;
  width: 0;
  height: 3px;
  background-color: #80c8f8;
  content: "";
  transition: all 0.3s ease-in-out;
}

.blog-title,
.nav-title {
  display: flex;
  align-items: center;
  height: 100%;
}
/* .blog-title {
  float: left;
}
.nav-title {
  float: right;
} */
.menus-item:hover .menus-submenu {
  display: block;
}
.menus-submenu {
  position: absolute;
  display: none;
  right: 0;
  width: max-content;
  margin-top: 8px;
  box-shadow: 0 5px 20px -4px rgba(0, 0, 0, 0.5);
  background-color: #fff;
  animation: submenu 1s 0.1s ease both;
}
.menus-submenu:before {
  position: absolute;
  top: -8px;
  left: 0;
  width: 100%;
  height: 20px;
  content: "";
}

.menus-submenu a {
  line-height: 2;
  color: #4c4948 !important;
  text-shadow: none;
  display: block;
  padding: 6px 14px;
}
.menus-submenu a:hover {
  background: #4ab1f4;
}

.fadeIn {
  animation-duration: 1.8s;
  animation-delay: 0s;
  animation-iteration-count: infinite;
}
@keyframes submenu {
  0% {
    opacity: 0;
    filter: alpha(opacity=0);
    transform: translateY(100px);
  }
  100% {
    opacity: 1;
    filter: none;
    transform: translateY(0);
  }
}
</style>
