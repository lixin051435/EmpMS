<template>
  <div>
    <el-dialog :title="isAdd ? '新增' : '编辑'" :visible.sync="dialog">
      <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="员工编号" prop="empNo">
          <el-input
            size="small"
            v-model="form.empNo"
            placeholder="请输入员工编号"
            disabled
          ></el-input>
        </el-form-item>
        <el-form-item label="员工姓名" prop="empName">
          <el-input size="small" disabled v-model="form.empName" placeholder="请输入员工姓名"></el-input>
        </el-form-item>
        <el-form-item label="休假开始时间">
          <el-date-picker
            type="date"
            placeholder="休假开始时间"
            v-model="form.beginTime"
            value-format="yyyy-MM-dd"
            style="width: 100%;"
          ></el-date-picker>
        </el-form-item>
        <el-form-item label="休假结束时间">
          <el-date-picker
            type="date"
            placeholder="休假结束时间"
            v-model="form.endTime"
            value-format="yyyy-MM-dd"
            style="width: 100%;"
          ></el-date-picker>
        </el-form-item>
        <el-form-item label="休假原因" prop="empNo">
          <el-input size="small" v-model="form.reason" placeholder="请输入休假原因"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button class="update-btn" type="primary" @click="doSubmit">提交</el-button>
        <el-button class="update-btn" @click="cancel">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import { add, update } from "@/api/vacation";
export default {
  props: {
    isAdd: {
      type: Boolean,
      required: true
    }
  },
  data() {
    return {
      form: {
        empNo: "",
        empName: "",
        beginTime: "",
        endTime: "",
        reason:""
      },
      dialog: false
    };
  },
  methods: {
    cancel() {
      this.reset();
    },
    reset() {
      this.dialog = false;
      this.form = {
        empNo: "",
        empName: "",
        beginTime: "",
        endTime: "",
        reason:""
      };
    },
    doSubmit() {
      if (this.isAdd) {
        this.add();
      } else {
        this.update();
      }
    },
    add() {
      let that = this;
      this.form.status = 0;
      add(this.form)
        .then(data => {
          if (data) {
            that.$parent.$alert("添加成功", "提示");
            that.reset();
            that.$parent.getData();
          } else {
            that.$parent.$alert("已经打卡，添加失败", "提示");
          }
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    update() {
      let that = this;
      update(this.form)
        .then(data => {
          that.$parent.$alert("修改成功", "提示");
          that.$parent.getData();
          that.reset();
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  }
};
</script>