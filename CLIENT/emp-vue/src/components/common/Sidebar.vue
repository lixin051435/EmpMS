<template>
  <div class="sidebar">
    <el-menu
      class="sidebar-el-menu"
      :default-active="onRoutes"
      :collapse="collapse"
      background-color="#324157"
      text-color="#bfcbd9"
      active-text-color="#20a0ff"
      unique-opened
      router
    >
      <template v-for="item in items">
        <template v-if="item.role">
          <template v-if="item.subs">
            <el-submenu :index="item.index" :key="item.index">
              <template slot="title">
                <i :class="item.icon"></i>
                <span slot="title">{{ item.title }}</span>
              </template>
              <template v-for="subItem in item.subs">
                <template v-if="subItem.role">
                  <el-submenu v-if="subItem.subs" :index="subItem.index" :key="subItem.index">
                    <template slot="title">{{ subItem.title }}</template>
                    <el-menu-item
                      v-for="(threeItem,i) in subItem.subs"
                      :key="i"
                      :index="threeItem.index"
                    >{{ threeItem.title }}</el-menu-item>
                  </el-submenu>
                  <el-menu-item
                    v-else
                    :index="subItem.index"
                    :key="subItem.index"
                  >{{ subItem.title }}</el-menu-item>
                </template>
              </template>
            </el-submenu>
          </template>
          <template v-else>
            <el-menu-item :index="item.index" :key="item.index">
              <i :class="item.icon"></i>
              <span slot="title">{{ item.title }}</span>
            </el-menu-item>
          </template>
        </template>
      </template>
    </el-menu>
  </div>
</template>

<script>
import bus from "../common/bus";
import { checkPermission } from "@/utils/permission";
export default {
  data() {
    return {
      collapse: false,
      items: [
        {
          icon: "el-icon-share",
          index: "employee",
          title: "员工汇总",
          role: checkPermission([
            "EMP_ADD",
            "EMP_EDIT",
            "EMP_DELETE",
            "EMP_SELECT"
          ])
        },
        {
          icon: "el-icon-s-data",
          index: "role",
          title: "权限控制",
          role: checkPermission([
            "ROLE_ADD",
            "ROLE_EDIT",
            "ROLE_DELETE",
            "ROLE_SELECT"
          ]),
          subs: [
            {
              icon: "el-icon-s-data",
              index: "role",
              title: "角色管理",
              role: true
            },
            {
              icon: "el-icon-bell",
              index: "permission",
              title: "权限分配",
              role: true
            }
          ]
        },
        {
          icon: "el-icon-tickets",
          index: "department",
          title: "部门汇总",
          role: checkPermission([
            "DEPT_ADD",
            "DEPT_EDIT",
            "DEPT_DELETE",
            "DEPT_SELECT"
          ])
        },
        {
          icon: "el-icon-time",
          title: "考勤管理",
          role: true,
          subs: [
            {
              index: "attend",
              title: "考勤汇总",
              role: checkPermission([
                "ATTEND_ADD",
                "ATTEND_EDIT",
                "ATTEND_DELETE",
                "ATTEND_SELECT"
              ])
            },
            {
              index: "daka",
              title: "上下班打卡",
              role: true
            }
          ]
        },
        {
          icon: "el-icon-document",
          index: "vacation",
          title: "休假管理",
          role: true,
          subs: [
            {
              index: "vacation",
              title: "休假汇总",
              role: checkPermission([
                "VACATION_ADD",
                "VACATION_EDIT",
                "VACATION_DELETE",
                "VACATION_SELECT"
              ])
            },
            {
              index: "vacationprocess",
              title: "休假处理",
              role: checkPermission(["VACATION_EDIT"])
            },
            {
              index: "myvacation",
              title: "我的休假",
              role: true
            }
          ]
        },
        {
          icon: "el-icon-lock",
          index: "salery",
          title: "工资管理",
          role: true,
          subs: [
            {
              index: "salery",
              title: "工资汇总",
              role: checkPermission(["PAY_ADD", "PAY_EDIT", "PAY_DELETE"])
            },
            {
              index: "mysalery",
              title: "我的工资",
              role: true
            }
          ]
        },
        {
          icon: "el-icon-s-tools",
          index: "log",
          title: "日志汇总",
          role: checkPermission(["LOG_DELETE", "LOG_SELECT"])
        },
        {
          icon: "el-icon-message",
          index: "repass",
          title: "修改密码",
          role: true
        }
      ]
    };
  },
  computed: {
    onRoutes() {
      return this.$route.path.replace("/", "");
    }
  },
  created() {
    // 通过 Event Bus 进行组件间通信，来折叠侧边栏
    bus.$on("collapse", msg => {
      this.collapse = msg;
      bus.$emit("collapse-content", msg);
    });
  },
  methods: {
    checkPermission
  }
};
</script>

<style scoped>
.sidebar {
  display: block;
  position: absolute;
  left: 0;
  top: 70px;
  bottom: 0;
  overflow-y: scroll;
}
.sidebar::-webkit-scrollbar {
  width: 0;
}
.sidebar-el-menu:not(.el-menu--collapse) {
  width: 250px;
}
.sidebar > ul {
  height: 100%;
}
</style>
