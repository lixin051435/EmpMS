<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-cascades"></i> 日志汇总
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box"></div>
      <el-table
        :data="tableData"
        border
        class="table"
        ref="multipleTable"
        header-cell-class-name="table-header"
      >
        <el-table-column prop="createDate" label="请求时间"></el-table-column>
        <el-table-column prop="requestMethod" label="HTTP方法类型"></el-table-column>
        <el-table-column prop="method" label="请求方法"></el-table-column>
        <el-table-column prop="host" label="主机IP"></el-table-column>
        <el-table-column prop="address" label="请求地址"></el-table-column>
        <el-table-column prop="params" label="请求参数"></el-table-column>
        <el-table-column
          label="操作"
          width="180"
          align="center"
          v-if="checkPermission(['LOG_DELETE'])"
        >
          <template slot-scope="scope">
            <el-button
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

  </div>
</template>

<script>
import { getAll, remove } from "@/api/logger";
import { checkPermission } from "@/utils/permission";
export default {
  name: "basetable",
  data() {
    return {
      query: {
        page: 1,
        size: 5
      },
      tableData: [],
      isAdd: true,
      deptTypes: [],
      pageTotal: 0
    };
  },
  mounted() {
    this.getData();
  },
  methods: {
    checkPermission,
    getData() {
      getAll(this.query).then(res => {
        this.tableData = res.list;
        this.pageTotal = res.total;
      });
    },
    // 删除操作
    removeHandle(row) {
      let that = this;
      this.$confirm("此操作将删除该数据, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        remove(row.id).then(res => {
          that.$parent.$alert("删除成功", "提示");
          that.$set(this.query, "page", 1);
          that.getData();
        });
      });
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
