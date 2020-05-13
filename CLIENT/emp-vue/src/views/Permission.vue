<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i> 权限分配
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="form-box">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="角色">
            <el-select v-model="form.roleId" placeholder="请选择角色">
              <el-option
                v-for="item in roles"
                :key="item.roleId"
                :label="item.roleName"
                :value="item.roleId"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="权限">
            <el-select v-model="form.permissionIds" multiple placeholder="请选择角色">
              <el-option
                v-for="item in permissions"
                :key="item.permissionId"
                :label="item.permissionDescription"
                :value="item.permissionId"
              ></el-option>
            </el-select>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="onSubmit">提交</el-button>
            <el-button @click="reset">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import { getAll, addPermission } from "@/api/role";
import { getAll as getPermissionAll } from "@/api/permission";
export default {
  name: "baseform",
  data() {
    return {
      form: {
        roleId: "",
        permissionIds: []
      },
      roles: [],
      permissions: []
    };
  },
  mounted() {
    let that = this;
    getAll().then(data => {
      that.roles = data;
    });

    getPermissionAll().then(data => {
      that.permissions = data;
    });
  },
  methods: {
    onSubmit() {
      let that = this;
      addPermission(this.form).then(data => {
        that.$alert("提交成功！", "提示");
        that.reset();
      });
    },
    reset() {
      this.form = {
        roleId: "",
        permissionIds: []
      };
    }
  }
};
</script>