<template>
  <div>
    <el-dialog :title="isAdd ? '新增' : '编辑'" :visible.sync="dialog">
      <el-form ref="form" :model="form"  label-width="100px">
        <el-form-item label="部门编号" prop="deptId">
          <el-input
            size="small"
            v-model="form.deptId"
            placeholder="请输入部门编号"
            :disabled="isAdd == false"
          ></el-input>
        </el-form-item>
        <el-form-item label="部门名称" prop="deptName">
          <el-input size="small" v-model="form.deptName" placeholder="请输入部门名称"></el-input>
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
import { add, update } from "@/api/department";
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
        "deptId": "",
        "deptName": ""
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
        "deptId": "",
        "deptName": ""
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
      add(this.form)
        .then(data => {
          that.$parent.$alert("添加成功", "提示");
          that.reset();
          that.$parent.getData();
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