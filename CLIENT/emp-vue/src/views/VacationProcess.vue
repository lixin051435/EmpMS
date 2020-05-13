<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-cascades"></i> 休假处理
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-input v-model="query.name" placeholder="员工姓名" class="handle-input mr10"></el-input>
        <el-input v-model="query.no" placeholder="员工编号" class="handle-input mr10"></el-input>
        <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
      </div>
      <el-table
        :data="tableData"
        border
        class="table"
        ref="multipleTable"
        header-cell-class-name="table-header"
      >
        <el-table-column prop="empNo" label="工号" width="70"></el-table-column>
        <el-table-column prop="empName" label="姓名" width="100"></el-table-column>
        <el-table-column prop="beginTime" label="开始时间"></el-table-column>
        <el-table-column prop="endTime" label="结束时间"></el-table-column>
        <el-table-column prop="reason" label="休假原因"></el-table-column>
        <!-- <el-table-column prop="approveName" label="审批人姓名"></el-table-column> -->
        <!-- <el-table-column prop="approveNo" label="审批人编号"></el-table-column> -->
        <el-table-column
          label="操作"
          width="250"
          align="center"
          v-if="checkPermission(['VACATION_EDIT','VACATION_DELETE'])"
        >
          <template slot-scope="scope">
            <el-button
              @click="toEdit(scope.row)"
              type="primary"
              icon="el-icon-check"
              size="small"
            >批准</el-button>
            <el-button
              @click="removeHandle(scope.row)"
              type="danger"
              icon="el-icon-close"
              size="small"
            >拒绝</el-button>
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
  </div>
</template>

<script>
import { getProcessAll, remove, update } from "@/api/vacation";
import { checkPermission } from "@/utils/permission";
export default {
  name: "basetable",
  data() {
    return {
      query: {
        name: "",
        no: "",
        page: 1,
        size: 5,
        deptId: ""
      },
      tableData: [],
      isAdd: true,
      deptTypes: [],
      pageTotal: 0
    };
  },
  mounted() {
    if (sessionStorage.getItem("user") == undefined) {
      this.$router.push("/login");
    }
    this.getData();
  },
  methods: {
    checkPermission,
    toEdit(row) {
      let that = this;
      let user = JSON.parse(sessionStorage.getItem("user"));
      row.approveNo = user.empNo;
      row.approveName = user.empName;
      row.status = 1;
      update(row).then(data => {
        that.$alert("已批准", "提示");
        that.$set(that.query, "page", 1);
        that.getData();
      });
    },
    toAdd() {
      this.isAdd = true;
      const _this = this.$refs.form;
      _this.form.empPassword = "000000";
      _this.dialog = true;
    },
    getData() {
      getProcessAll(this.query).then(res => {
        this.tableData = res.list;
        this.pageTotal = res.total;
      });
    },
    // 触发搜索按钮
    handleSearch() {
      this.$set(this.query, "pageIndex");
      this.getData();
    },
    // 删除操作
    removeHandle(row) {
      let that = this;
      let user = JSON.parse(sessionStorage.getItem("user"));
      row.approveNo = user.empNo;
      row.approveName = user.empName;
      row.status = 2;
      this.$prompt("请输入拒绝原因", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消"
      }).then(res => {
        row.remark = res.value;
        update(row).then(data => {
          that.$alert("已拒绝", "提示");
          that.$set(that.query, "page", 1);
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
