<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-cascades"></i> 角色管理
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-button
          v-if="checkPermission(['DEPT_ADD'])"
          type="primary"
          icon="el-icon-plus"
          class="handle-del mr10"
          @click="toAdd"
        >新增</el-button>
      </div>
      <el-table
        :data="tableData"
        border
        class="table"
        ref="multipleTable"
        header-cell-class-name="table-header"
      >
        <el-table-column prop="roleId" label="角色编号"></el-table-column>
        <el-table-column prop="roleName" label="角色名称"></el-table-column>
        <el-table-column prop="roleDescription" label="角色描述"></el-table-column>
        <el-table-column
          label="操作"
          width="180"
          align="center"
          v-if="checkPermission(['DEPT_EDIT','DEPT_DELETE'])"
        >
          <template slot-scope="scope">
            <el-button
              v-if="checkPermission(['DEPT_EDIT'])"
              @click="toEdit(scope.row)"
              type="primary"
              icon="el-icon-edit"
              size="small"
              circle
            ></el-button>
            <el-button
              v-if="checkPermission(['DEPT_DELETE'])"
              @click="removeHandle(scope.row)"
              type="danger"
              icon="el-icon-delete"
              size="small"
              circle
            ></el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <RoleForm ref="form" :is-add="isAdd"></RoleForm>
  </div>
</template>

<script>
import { getAll, remove } from "@/api/role";
import RoleForm from "@/components/RoleForm";
import { checkPermission } from "@/utils/permission";
export default {
  name: "basetable",
  components: {
    RoleForm
  },
  data() {
    return {
      tableData: [],
      isAdd: true
    };
  },
  created() {
    this.getData();
  },
  methods: {
    checkPermission,
    toEdit(row) {
      this.isAdd = false;
      // 这里获取到了子组件，要传值可以直接通过这个指针
      const _this = this.$refs.form;
      _this.dialog = true;
      let temp = JSON.parse(JSON.stringify(row));
      _this.form = temp;
    },
    toAdd() {
      this.isAdd = true;
      const _this = this.$refs.form;
      _this.dialog = true;
    },
    getData() {
      getAll().then(res => {
        this.tableData = res;
      });
    },
    // 触发搜索按钮
    handleSearch() {
      this.getData();
    },
    // 删除操作
    removeHandle(row) {
      let that = this;
      this.$confirm("此操作将删除该数据, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        remove(row.roleId)
          .then(res => {
            that.$parent.$alert("删除成功", "提示");
            that.getData();
          })
          .catch(e => {
            that.$parent.$alert("外键约束，删除失败", "提示");
            that.getData();
          });
      });
    },
    // 编辑操作
    handleEdit(index, row) {
      this.idx = index;
      this.form = row;
      this.editVisible = true;
    }
  }
};
</script>

<style scoped>
.handle-box {
  margin-bottom: 20px;
}

.handle-select {
  width: 120px;
}

.handle-input {
  width: 300px;
  display: inline-block;
}
.table {
  width: 100%;
  font-size: 14px;
}
.red {
  color: #ff0000;
}
.mr10 {
  margin-right: 10px;
}
.table-td-thumb {
  display: block;
  margin: auto;
  width: 40px;
  height: 40px;
}
</style>
