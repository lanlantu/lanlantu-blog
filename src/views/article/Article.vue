<template>
  <div>
    <div class="banner" :style="articleCover">hahah</div>
    <v-row class="article-container">
           <article
            id="write"
            class="article-content markdown-body"
            v-html="article.articleContent"
            ref="article"
          />
    </v-row>
  </div>
</template>

<script>
import Clipboard from "clipboard";
import tocbot from "tocbot";
export default {
  data() {
    return {
      article: {
        nextArticle: {
          id: 0,
          articleCover: "",
        },
        lastArticle: {
          id: 0,
          articleCover: "",
        },
        recommendArticleList: [],
        newestArticleList: [],
      },
    };
  },
  computed: {
    articleCover() {
    
      return (
        "background: url(" +
        this.article.articleCover +
        ") center center / cover no-repeat"
      );
    },
  },
  created() {
    this.getArticle();
  },
  methods: {
    getArticle() {
      //查询文章
      console.log(this.$route);
      this.axios.get("/api" + this.$route.path).then(({ data }) => {
        document.title = data.data.articleTitle;

        //将markdown转换为Html
        this.markdownToHtml(data.data);
      });
    },
    markdownToHtml(article) {
      const MarkdownIt = require("markdown-it");
      const hljs = require("highlight.js");
      const md = new MarkdownIt({
        html: true,
        linkify: true,
        typographer: true,
        breaks: true,
        highlight: function (str, lang) {
          // 当前时间加随机数生成唯一的id标识
          var d = new Date().getTime();
          if (
            window.performance &&
            typeof window.performance.now === "function"
          ) {
            d += performance.now();
          }
          const codeIndex = "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(
            /[xy]/g,
            function (c) {
              var r = (d + Math.random() * 16) % 16 | 0;
              d = Math.floor(d / 16);
              return (c == "x" ? r : (r & 0x3) | 0x8).toString(16);
            }
          );
          // 复制功能主要使用的是 clipboard.js
          let html = `<button class="copy-btn iconfont iconfuzhi" type="button" data-clipboard-action="copy" data-clipboard-target="#copy${codeIndex}"></button>`;
          const linesLength = str.split(/\n/).length - 1;
          // 生成行号
          let linesNum = '<span aria-hidden="true" class="line-numbers-rows">';
          for (let index = 0; index < linesLength; index++) {
            linesNum = linesNum + "<span></span>";
          }
          linesNum += "</span>";
          if (lang == null) {
            lang = "java";
          }
          if (lang && hljs.getLanguage(lang)) {
            // highlight.js 高亮代码
            const preCode = hljs.highlight(lang, str, true).value;
            html = html + preCode;
            if (linesLength) {
              html += '<b class="name">' + lang + "</b>";
            }
            // 将代码包裹在 textarea 中，由于防止textarea渲染出现问题，这里将 "<" 用 "<" 代替，不影响复制功能
            return `<pre class="hljs"><code>${html}</code>${linesNum}</pre><textarea style="position: absolute;top: -9999px;left: -9999px;z-index: -9999;" id="copy${codeIndex}">${str.replace(
              /<\/textarea>/g,
              "</textarea>"
            )}</textarea>`;
          }
        },
      });
      // 将markdown替换为html标签
      article.articleContent = md.render(article.articleContent);
      this.article = article;
    },
  },
};
</script>

<style>
</style>