import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/Login'
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/dashboard'
    },
    {
      path: '/',
      component: () => import('@/components/common/Home.vue'),
      meta: { title: '自述文件' },
      children: [
        {
          path: '/dashboard',
          component: () => import('@/views/Employee.vue'),
          meta: { title: '系统首页' }
        },
        {
          path: '/department',
          component: () => import('@/views/Department.vue'),
          meta: { title: '部门管理' }
        },
        {
          path: '/employee',
          component: () => import('@/views/Employee.vue'),
          meta: { title: '员工管理' }
        },
        {
          path: '/attend',
          component: () => import('@/views/Attend.vue'),
          meta: { title: '考勤管理' }
        },
        {
          path: '/vacation',
          component: () => import('@/views/Vacation.vue'),
          meta: { title: '休假管理' }
        }, {
          path: '/myvacation',
          component: () => import('@/views/MyVacation.vue'),
          meta: { title: '我的休假' }
        }, {
          path: '/vacationprocess',
          component: () => import('@/views/VacationProcess.vue'),
          meta: { title: '休假处理' }
        }, {
          path: '/role',
          component: () => import('@/views/Role.vue'),
          meta: { title: '角色处理' }
        }, {
          path: '/permission',
          component: () => import('@/views/Permission.vue'),
          meta: { title: '权限分配' }
        }, {
          path: '/salery',
          component: () => import('@/views/Salery.vue'),
          meta: { title: '工资管理' }
        }, {
          path: '/mysalery',
          component: () => import('@/views/MySalery.vue'),
          meta: { title: '我的工资' }
        }, {
          path: '/log',
          component: () => import('@/views/Log.vue'),
          meta: { title: '日志汇总' }
        },
        {
          path: '/daka',
          component: () => import('@/components/Daka.vue'),
          meta: { title: '打卡' }
        },
        {
          path: '/404',
          component: () => import('@/components/page/404.vue'),
          meta: { title: '404' }
        },
        {
          path: '/403',
          component: () => import('@/components/page/403.vue'),
          meta: { title: '403' }
        },
        {
          path: '/repass',
          component: () => import('@/components/RePass.vue'),
          meta: { title: '密码修改' }
        }

      ]
    },
    {
      path: '/login',
      component: () => import('@/views/Login.vue'),
      meta: { title: '登录' }
    },
    {
      path: '/daka',
      component: () => import('@/components/Daka.vue')
    },
    {
      path: '*',
      redirect: '/404'
    }
  ]
})
