<template>
  <div id="login-container">
    <h3 class="title">注册</h3>
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
      <el-form-item label="确认密码" prop="checkPass">
        <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input type="test" v-model="ruleForm.phone" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="验证码" prop="code">
        <el-input type="text" v-model="ruleForm.code" autocomplete="off" style="width:180px;"></el-input>
        <el-button @click="sendCode()" class="botton" :disabled="!show">
          <span v-if="show">发送验证码</span>
          <span v-if="!show">{{count}}</span>
        </el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm(ruleForm)">注册</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
        <el-button @click="gotoLogin">返回登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
 
<script>
export default {
  name: "Register",
  components: {},
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.ruleForm.checkPass !== "") {
          this.$refs.ruleForm.validateField("checkPass");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.ruleForm.pass) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    var validateUsername = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入用户名"));
      } else {
        callback();
      }
    };
    var validateCode = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入验证码"));
      } else {
        callback();
      }
    };
    var checkPhone = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("手机号不能为空"));
      } else {
        const reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
        console.log(reg.test(value));
        if (reg.test(value)) {
          callback();
        } else {
          return callback(new Error("请输入正确的手机号"));
        }
      }
    };
    return {
      ruleForm: {
        pass: "",
        username: "",
        code: "",
        checkPass: "",
        phone: ""
      },
      rules: {
        pass: [{ validator: validatePass, trigger: "blur" }],
        username: [{ validator: validateUsername, trigger: "blur" }],
        code: [{ validator: validateCode, trigger: "blur" }],
        checkPass: [{ validator: validatePass2, trigger: "blur" }],
        phone: [{ validator: checkPhone, trigger: "blur" }]
      },
      show: true,
      count: 60,
      timer: null
    };
  },
  methods: {
    submitForm(formName) {
      let _this = this;
      this.$http
        .get(
          `/register?username=${formName.username}&password=${formName.pass}&code=${formName.code}`
        )
        .then(resp => {
          console.log(resp);
          if (resp.data == "register success") {
            this.$message({
              type: "success",
              message: "注册成功"
            });
            _this.$router.push({ path: "/" });
          }else if(resp.data == "wrong code"){
            this.$message({
              type: "info",
              message: "验证码不正确"
            });
          }
        });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    gotoLogin() {
      this.$router.replace("/login");
    },
    sendCode() {
      if (this.ruleForm.phone === "") {
        alert("手机号不能为空！");
      } else {
        this.$http.get(`/send?phone=${this.ruleForm.phone}`).then(resp => {
          console.log(resp);
        });
        this.count = 60;
        this.show = false;
        this.timer = setInterval(() => {
          if (this.count > 0 && this.count <= 60) {
            this.count--;
          } else {
            this.show = true;
            clearInterval(this.timer);
            this.timer = null;
          }
        }, 1000);
      }
    }
  }
};
</script>
 
<style scoped>
body {
  margin: 0;
}
#login-container {
  width: 400px;
  height: 400px;
  background: #e5e9f2;
  position: absolute;
  left: 50%;
  top: 40%;
  margin-left: -220px;
  margin-top: -170px;
  border-radius: 5px;
  padding-top: 40px;
  padding-right: 40px;
}
.botton {
  width: 115px;
}
.title{
  text-align: center;
  margin-top: -20px;
}
</style>