<template>
  <div id="login-container">
    <h3 class="title">登录</h3>
    <el-form
      :model="ruleForm"
      status-icon
      :rules="rules"
      ref="ruleForm"
      label-width="100px"
      class="demo-ruleForm"
    >
      <el-form-item label="用户名" prop="username">
        <el-input type="text" v-model="ruleForm.username" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="pass">
        <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="验证码" prop="code">
        <el-input type="text" v-model="ruleForm.code" autocomplete="off" style="width:180px;"></el-input>
        <div class="code" @click="refreshCode">
          <SIdentify :identifyCode="identifyCode"></SIdentify>
        </div>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm(ruleForm)">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
        <el-button @click="gotoRegister()">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import SIdentify from '@/components/identify'
export default {
  name: 'Login',
  components: {
    SIdentify
  },
  data () {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        callback()
      }
    }
    var validateUsername = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户名'))
      } else {
        callback()
      }
    }
    var validateCode = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入验证码'))
      } else {
        callback()
      }
    }
    return {
      ruleForm: {
        pass: '',
        username: '',
        code: ''
      },
      rules: {
        pass: [{ validator: validatePass, trigger: 'blur' }],
        username: [{ validator: validateUsername, trigger: 'blur' }],
        code: [{ validator: validateCode, trigger: 'blur' }]
      },
      identifyCodes: '1234567890',
      identifyCode: ''
    }
  },
  mounted () {
    this.identifyCode = ''
    this.makeCode(this.identifyCodes, 4)
  },
  methods: {
    submitForm (formName) {
      let _this = this
      //   this.$refs[formName].validate(valid => {
      //       console.log(valid)
      //     if (valid) {
      //       sessionStorage.setItem("token", "true");
      //       _this.$router.push({ path: "/index/table" });
      //     } else {
      //       console.log("error submit!!");
      //       return false;
      //     }
      //   });
      this.$http
        .get(`/qlogin?username=${formName.username}&password=${formName.pass}`)
        .then(resp => {
          console.log(resp)
          if (formName.code != this.identifyCode) {
            this.$message({
              type: 'info',
              message: '验证码错误'
            })
          } else if (resp.data == 'success') {
            sessionStorage.setItem('token', 'true')
            sessionStorage.setItem('username', formName.username)
            sessionStorage.setItem('password', formName.pass)
            _this.$router.push({ path: '/' })
            this.$message({
              type: 'success',
              message: '登录成功'
            })
          } else if (resp.data == 'wrong password') {
            this.$message({
              type: 'info',
              message: '密码错误'
            })
            _this.$router.push({ path: '/login' })
          } else if (resp.data == 'no user') {
            this.$message({
              type: 'info',
              message: '用户名不存在'
            })
            _this.$router.push({ path: '/login' })
          }
        })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    gotoRegister () {
      this.$router.replace('/register')
    },
    randomNum (min, max) {
      return Math.floor(Math.random() * (max - min) + min)
    },
    refreshCode () {
      this.identifyCode = ''
      this.makeCode(this.identifyCodes, 4)
    },
    makeCode (o, l) {
      for (let i = 0; i < l; i++) {
        this.identifyCode += this.identifyCodes[
          this.randomNum(0, this.identifyCodes.length)
        ]
      }
      // console.log(this.identifyCode);
    }
  }
}
</script>

<style scoped>
body {
  margin: 0;
}
#login-container {
  width: 400px;
  height: 300px;
  background: #e5e9f2;
  position: absolute;
  left: 50%;
  top: 50%;
  margin-left: -220px;
  margin-top: -170px;
  border-radius: 5px;
  padding-top: 40px;
  padding-right: 40px;
}
.title {
  text-align: center;
  margin-top: -20px;
}
.code {
  float: right;
  width: 114px;
  height: 40px;
  border: 1px solid red;
}
</style>
