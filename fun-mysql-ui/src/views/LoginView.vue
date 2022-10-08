<template>
  <div id="container">
    <div class="login-box">
      <h1>登录</h1>
      <el-form :model="loginForm" size="large" class="form-box">
        <el-form-item>
          <el-input v-model="loginForm.account"/>
        </el-form-item>
        <el-form-item>
          <el-input v-model="loginForm.password" type="password"/>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%;" type="primary" @click="doLogin">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import {ElMessage} from "element-plus";

export default {
  name: "LoginView",
  data() {
    return {
      loginForm: {
        account: 'admin',
        password: 'admin'
      }
    }
  },
  methods: {
    doLogin() {
      const _this = this
      fetch('http://localhost:9001/user/doLogin', {
        method: 'POST',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json'
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(this.loginForm)
      }).then(res => res.json())
          .then(data => {
            if (data.code === 0) {
              ElMessage.success("登录成功～")
              window.localStorage.setItem('token', data.t)
              _this.$router.push({
                path: '/dataSource',
                query: {account: _this.loginForm.account}
              })
            } else {
              ElMessage.error(data.msg)
              window.localStorage.setItem('token', '')
            }
          })
    }
  }
}
</script>

<style scoped>
#container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

#container .login-box {
  width: 350px;
  height: 350px;
  border-radius: 10px;
  border: 1px solid lightgray;
}

#container .login-box h1 {
  text-align: center;
  margin-top: 12px;
  margin-bottom: 15px;
}

#container .login-box .form-box {
  padding-left: 20px;
  padding-right: 20px;
}
</style>