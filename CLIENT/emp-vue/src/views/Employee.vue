<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-cascades"></i> 员工汇总
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-button
          v-if="checkPermission(['EMP_ADD'])"
          type="primary"
          icon="el-icon-plus"
          class="handle-del mr10"
          @click="toAdd"
        >新增</el-button>
        <el-input v-model="query.name" placeholder="员工姓名" class="handle-input mr10"></el-input>
        <el-input v-model="query.no" placeholder="员工编号" class="handle-input mr10"></el-input>
        <el-select v-model="query.deptId" placeholder="所在部门" class="handle-input mr10">
            <el-option
              v-for="item in deptTypes"
              :key="item.deptId"
              :label="item.deptName"
              :value="item.deptId"
            ></el-option>
          </el-select>
        <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
      </div>
      <el-table
        :data="tableData"
        border
        class="table"
        ref="multipleTable"
        header-cell-class-name="table-header"
      >
        <el-table-column prop="empNo" label="编号" width="70"></el-table-column>
        <el-table-column prop="empName" label="姓名" width="100"></el-table-column>
        <el-table-column prop="empGender" label="性别" width="50"></el-table-column>
        <el-table-column prop="empEmail" label="邮箱"></el-table-column>
        <el-table-column prop="deptName" label="部门" width="100"></el-table-column>
        <el-table-column prop="empPhone" label="联系电话"></el-table-column>
        <el-table-column prop="empStatus" label="员工类型">
          <template slot-scope="scope">
            <span>{{scope.row.empStatus == 1 ? '正式工' :'临时工'}}</span>
          </template>
        </el-table-column>
        <el-table-column v-if="checkPermission(['EMP_EDIT','EMP_DELETE'])" prop="empIdcard" label="身份证号"></el-table-column>
        <el-table-column v-if="checkPermission(['EMP_EDIT','EMP_DELETE'])" prop="empSalerycard" label="工资卡号"></el-table-column>
        <el-table-column label="操作" width="180" align="center" v-if="checkPermission(['EMP_EDIT','EMP_DELETE'])">
          <template slot-scope="scope" >
              <el-button
              v-if="checkPermission(['EMP_EDIT'])"
              @click="toEdit(scope.row)"
              type="primary"
              icon="el-icon-edit"
              size="small"
              circle
            ></el-button>
            <el-button
             v-if="checkPermission(['EMP_DELETE'])"
              @click="removeHandle(scope.row)"
              type="danger"
              icon="el-icon-delete"
              size="small"
              circle
            ></el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="pagination">
        <el-pagination
          background
          layout="total, prev, pager, next"
          :current-page="query.page"
          :page-size="query.size"
          :total="pageTotal"
          @current-change="handlePageChange"
        ></el-pagination>
      </div>
    </div>

    <EmployeeForm ref="form" :is-add="isAdd"></EmployeeForm>
  </div>
</template>

<script>
import {getAll,remove} from '@/api/employee';
import EmployeeForm from "@/components/EmployeeForm";
import {getAll as getDeptAll} from '@/api/department';
import { checkPermission } from "@/utils/permission";
export default {
  name: "basetable",
  components: {
    EmployeeForm
  },
  data() {
    return {
      query: {
        name: "",
        no:"",
        page:1,
        size:5,
        deptId:""
      },
      tableData: [],
      isAdd: true,
      deptTypes:[],
      pageTotal:0
    };
  },
  created() {
    this.getData();
    let that = this;
    getDeptAll("").then(data=>{
      that.deptTypes = data;
      that.deptTypes.push({
        deptId:"",
        deptName:"所有部门"
      });
    })
  },
  mounted(){
    if(sessionStorage.getItem("user") == undefined){
        this.$router.push("/login");
    }
  },
  methods: {
    checkPermission,
    toEdit(row) {
      this.isAdd = false;
      // 这里获取到了子组件，要传值可以直接通过这个指针
      const _this = this.$refs.form;
      _this.dialog = true;
      let temp =  JSON.parse(JSON.stringify(row));
      _this.form = temp;
    },
    toAdd() {
      this.isAdd = true;
      const _this = this.$refs.form;
      _this.form.empPassword = "000000";
      _this.dialog = true;
    },
    getData() {
      getAll(this.query).then(res => {
        this.tableData = res.list;
        this.pageTotal = res.total;
      });
    },
    // 触发搜索按钮
    handleSearch() {
      this.$set(this.query, "pageIndex", );
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
            remove(row.empId).then(res => {
            that.$parent.$alert("删除成功", "提示");
            that.$set(this.query, "page", 1);
            that.getData();
            });
        });
    },
    // 编辑操作
    handleEdit(index, row) {
      this.idx = index;
      this.form = row;
      this.editVisible = true;
    },
    handlePageChange(val) {
      this.$set(this.query, "page", val);
      this.getData();
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
  width: 150px;
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
