import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    component: resolve => require(["../views/home/Home.vue"], resolve)
  },

  {
    path: "/articles/:articleId",
    component: resolve => require(["../views/article/Article.vue"], resolve)
  },
  {
    path: "/categories",
    component: resolve => require(["../views/category/Category.vue"], resolve),
    meta: {
      title: "分类"
    }
  },
  {
    path: "/tags",
    component: resolve => require(["../views/tag/Tag.vue"], resolve),
    meta: {
      title: "标签"
    }
  },
  {
    path: "/albums",
    component: resolve => require(["../views/album/Album.vue"], resolve),
    meta: {
      title: "相册"
    }
  },
  {
    path: "/albums/:albumId",
    component: resolve => require(["../views/album/Photo.vue"], resolve)
  },
  {
    path: "/login",
    component: resolve => require(["../components/model/LoginModel.vue"], resolve)
  }
  
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
