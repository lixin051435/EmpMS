<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-cascades"></i> 我的工资
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <!-- <div class="handle-box">
        <el-input v-model="query.name" placeholder="员工姓名" class="handle-input mr10"></el-input>
        <el-input v-model="query.no" placeholder="员工编号" class="handle-input mr10"></el-input>
        <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
      </div> -->
      <el-table
        :data="tableData"
        border
        class="table"
        ref="multipleTable"
        header-cell-class-name="table-header"
      >
        <el-table-column prop="empNo" label="工号" width="70"></el-table-column>
        <el-table-column prop="empName" label="姓名" width="100"></el-table-column>
        <el-table-column prop="workSalery" label="岗位工资"></el-table-column>
        <el-table-column prop="allowance" label="补贴"></el-table-column>
        <el-table-column prop="vacation" label="休假扣除" width="100"></el-table-column>
        <el-table-column prop="reward" label="奖金"></el-table-column>
        <el-table-column prop="absent" label="离岗扣除"></el-table-column>
        <el-table-column prop="total" label="工资总额"></el-table-column>
        <el-table-column prop="createtime" label="发放时间"></el-table-column>
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
import {getAll} from '@/api/salery';
export default {
  name: "basetable",
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
  mounted(){
    if(sessionStorage.getItem("user") == undefined){
        this.$router.push("/login");
    }
    let user = JSON.parse(sessionStorage.getItem("user"));
    this.query.no = user.empNo;
    this.getData();
  },
  methods: {
    toEdit(row) {
      this.isAdd = false;
      // 这里获取到了子组件，要传值可以直接通过这个指针
      const _this = this.$refs.form;
      _this.dialog = true;
      let temp =  JSON.parse(JSON.stringify(row));
      _this.form = temp;
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
