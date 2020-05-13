<template>
  <div>
    <el-form ref="loginForm" :model="form" :rules="rules" label-width="80px" class="login-box">
      <h3 class="login-title">欢迎登录</h3>
      <el-form-item label="账号" prop="empNo">
        <el-input type="text" placeholder="请输入账号" v-model="form.empNo" />
      </el-form-item>
      <el-form-item label="密码" prop="empPassword">
        <el-input type="password" placeholder="请输入密码" v-model="form.empPassword" />
      </el-form-item>
      <el-form-item label="验证码" style="height: 40px;margin-bottom: 20px;">
        <el-input class="input" maxlength="8" v-model="code" placeholder="请输入验证码"></el-input>
        <div class="divIdentifyingCode" @click="getIdentifyingCode(true)">
          <img
            id="imgIdentifyingCode"
            style="height:40px; width: 100px; cursor: pointer;"
            alt="点击更换"
            title="点击更换"
          />
        </div>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" v-on:click="onSubmit('loginForm')">登录</el-button>
        <el-button type="info" v-on:click="reset('loginForm')">重置</el-button>
      </el-form-item>
    </el-form>

    <el-dialog title="温馨提示" :visible.sync="dialogVisible" width="30%">
      <span>请输入账号和密码</span>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { login } from "@/api/admin";
import { getcode } from "@/api/code";
export default {
  name: "Login",
  created() {
    var that = this;
    document.onkeydown = function(e) {
      var key = window.event.keyCode;
      if (key == 13) {
        that.onSubmit("loginForm");
      }
    };
  },
  data() {
    return {
      form: {
        empNo: "",
        empPassword: ""
      },
      code:"",
      // 表单验证，需要在 el-form-item 元素中增加 prop 属性
      rules: {
        empNo: [
          { required: true, message: "账号不可为空", trigger: "blur" }
        ],
        empPassword: [
          { required: true, message: "密码不可为空", trigger: "blur" }
        ]
      },
      // 对话框显示和隐藏
      dialogVisible: false
    };
  },
  mounted() {
    this.getIdentifyingCode(true);
  },
  methods: {
    reset(formName) {
      this.form = {
        empNo: "",
        empPassword: ""
      };
      // 清除表单校验的提示
      if (this.$refs[formName]) {
        // 延时执行
        this.$nextTick(function() {
          this.$refs[formName].clearValidate();
        });
      }
    },
    onSubmit(formName) {
      let that = this;
      // 为表单绑定验证功能
      this.$refs[formName].validate(valid => {
        if (valid) {
          let checkcode = sessionStorage.getItem("code");
          if (that.code.toLowerCase() == checkcode.toLowerCase()) {
            login(that.form).then(data => {
              if (data != null && data != "") {
                let permissions = data.permissions.map(e=>{
                  return e.permissionName
                });
                console.log(permissions);
                data.permissions = permissions;
                sessionStorage.removeItem("user");
                sessionStorage.setItem("user", JSON.stringify(data));
                // 使用 vue-router 路由到指定页面，该方式称之为编程式导航
                this.$router.push("/employee");
              } else {
                that.$alert("用户名密码错误");
              }
            }).catch(err=>{
              console.log(err);
            });
          }else{
            that.$alert("验证码错误");
            that.getIdentifyingCode();
          }
        } else {
          this.dialogVisible = true;
          return false;
        }
      });
    },
    getIdentifyingCode(bRefresh) {
      getcode().then(data => {
        let objs = document.getElementById("imgIdentifyingCode");
        objs.src = data.base64;
        sessionStorage.setItem("code", data.code);
      });
    }
  }
};
</script>

<style scoped>
.login-box {
  border: 1px solid #dcdfe6;
  width: 350px;
  margin: 180px auto;
  padding: 35px 35px 15px 35px;
  border-radius: 5px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  box-shadow: 0 0 25px #909399;
}

.login-title {
  text-align: center;
  margin: 0 auto 40px auto;
  color: #303133;
}

.divIdentifyingCode {
  position: absolute;
  top: 0;
  right: 0;
  z-index: 5;
  width: 102px; /*设置图片显示的宽*/
  height: 40px; /*图片显示的高*/
  background: #e2e2e2;
  margin: 0;
}
</style>