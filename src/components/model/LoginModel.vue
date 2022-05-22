<template>
    <div class="login">
          <!-- 用户名 -->
        <v-text-field
          v-model="username"
          label="邮箱号"
          placeholder="请输入您的邮箱号"
          clearable
          @keyup.enter="login"
        />
        <!-- 密码 -->
        <v-text-field
          v-model="password"
          class="mt-7"
          label="密码"
          placeholder="请输入您的密码"
          @keyup.enter="login"
        />
        <!-- 按钮 -->
        <v-btn
          class="mt-7"
          block
          color="blue"
          style="color:#fff"
          @click="login"
        >
          登录
        </v-btn>
    </div>
</template>

<script>
export default {
  data() {
    return {
      username:"",
      password:""
    }
  },
  methods: {
   login() {
      // var reg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
      // if (!reg.test(this.username)) {
      //   this.$toast({ type: "error", message: "邮箱格式不正确" });
      //   return false;
      // }
      if (this.password.trim().length == 0) {
        this.$toast({ type: "error", message: "密码不能为空" });
        return false;
      }
      const that = this;

          //发送登录请求
          let param = new URLSearchParams();
          param.append("username", that.username);
          param.append("password", that.password);
          that.$axios.post("/api/login", param).then(( data ) => {
            console.log(data);

            if (data.code==200) {
              that.username = "";
              that.password = "";
              that.$toast({ type: "success", message: data.message });
            } else {
              that.$toast({ type: "error", message: data.message });
            }
          })
          // .catch(()=>{
          //   that.$toast({ type: "error", message:"请求错误" });
          // });
        
     
    
    },
  },

}
</script>

<style>
.login{
  position:absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  height: 400px;
  transform: translate(-200px,-200px);
  background-color: antiquewhite;
}
</style>