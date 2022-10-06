<template>
  <div id="container">
    <div class="login-box">
      <h1>登录</h1>
      <el-form :model="loginForm" size="large" class="form-box">
        <el-form-item>
          <el-input v-model="loginForm.username" />
        </el-form-item>
        <el-form-item>
          <el-input v-model="loginForm.password" type="password" />
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%;" type="primary" @click="doLogin">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return{
      loginForm: {
        username: 'admin',
        password: 'admin'
      }
    }
  },
  methods: {
    doLogin(){

    }
  }
}
</script>

<style scoped>
#container{
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
#container .login-box{
  width: 350px;
  height: 350px;
  border-radius: 10px;
  border: 1px solid lightgray;
}
#container .login-box h1{
  text-align: center;
  margin-top: 12px;
  margin-bottom: 15px;
}
#container .login-box .form-box{
  padding-left: 20px;
  padding-right: 20px;
}
</style>