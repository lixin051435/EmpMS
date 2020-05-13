<template>
  <div class="daka-box">
    <el-form label-width="80px" style="width:100%;">
      <el-form-item>
        <el-button style="width:100%;" :disabled="canShangban" type="primary" @click="shangbanClick">上班打卡</el-button>
      </el-form-item>
      <el-form-item>
        <el-button style="width:100%;" :disabled="canXiaban" type="primary" @click="xiabanClick">下班打卡</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { canshangban, shangban, canxiaban, xiaban } from "@/api/attend";
export default {
  name: "baseform",
  data() {
    return {
      canShangban: false,
      canXiaban: false,
      no: ""
    };
  },
  mounted() {
    let user = JSON.parse(sessionStorage.getItem("user"));
    this.no = user.empNo;
    canshangban(this.no).then(res => {
      this.canShangban = !res;
    });
    canxiaban(this.no).then(res => {
      this.canXiaban = !res;
    });
  },
  methods: {
    shangbanClick() {
      shangban(this.no).then(res => {
        if (res) {
          this.$alert("上班打卡成功");
        } else {
          this.$alert("您已打卡，上班打卡失败");
        }
        location.reload();
      });
    },
    xiabanClick() {
      xiaban(this.no).then(res => {
        if (res) {
          this.$alert("下班打卡成功");
        } else {
          this.$alert("您已打卡，下班打卡失败");
        }
        location.reload();
      });
    }
  }
};
</script>
<style>
.daka-box {
  width: 300px;
  margin-top: 80px;
}
</style>