<template>
  <div>
    <el-dialog :title="isAdd ? '新增' : '编辑'" :visible.sync="dialog">
      <el-form ref="form" :model="form"  label-width="100px">
        <el-form-item label="员工编号" prop="empNo">
          <el-input
            size="small"
            v-model="form.empNo"
            placeholder="请输入员工编号"
            :disabled="isAdd == false"
          ></el-input>
        </el-form-item>
        <el-form-item label="上班打卡时间">
                <el-date-picker
                    type="datetime"
                    placeholder="上班打卡时间"
                    v-model="form.attendBeginTime"
                    value-format="yyyy-MM-dd HH:mm:ss"
                    style="width: 100%;"
                ></el-date-picker>
        </el-form-item>
        <el-form-item label="下班打卡时间">
                <el-date-picker
                    type="datetime"
                    placeholder="下班打卡时间"
                    v-model="form.attendEndTime"
                    value-format="yyyy-MM-dd HH:mm:ss"
                    style="width: 100%;"
                ></el-date-picker>
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
import { add, update } from "@/api/attend";
import {getAll} from '@/api/department';
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
        "attendId":"",
        "attendBeginTime": "",
        "attendEndTime": "",
        "empNo":""
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
        "attendId":"",
        "attendBeginTime": "",
        "attendEndTime": "",
        "empNo":""
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
          if(data){
            that.$parent.$alert("添加成功", "提示");
            that.reset();
            that.$parent.getData();
          }else{
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