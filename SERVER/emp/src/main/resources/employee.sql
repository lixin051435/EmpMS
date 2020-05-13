/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : employee

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-02-28 11:26:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for r_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `r_role_permission`;
CREATE TABLE `r_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(8) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `r_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`),
  CONSTRAINT `r_role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `tb_permission` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of r_role_permission
-- ----------------------------
INSERT INTO `r_role_permission` VALUES ('13', '02', '1');
INSERT INTO `r_role_permission` VALUES ('14', '02', '2');
INSERT INTO `r_role_permission` VALUES ('15', '02', '3');
INSERT INTO `r_role_permission` VALUES ('16', '02', '4');
INSERT INTO `r_role_permission` VALUES ('17', '02', '5');
INSERT INTO `r_role_permission` VALUES ('18', '02', '6');
INSERT INTO `r_role_permission` VALUES ('19', '02', '7');
INSERT INTO `r_role_permission` VALUES ('20', '02', '8');
INSERT INTO `r_role_permission` VALUES ('21', '02', '9');
INSERT INTO `r_role_permission` VALUES ('22', '02', '10');
INSERT INTO `r_role_permission` VALUES ('23', '02', '11');
INSERT INTO `r_role_permission` VALUES ('24', '02', '12');
INSERT INTO `r_role_permission` VALUES ('29', '03', '5');
INSERT INTO `r_role_permission` VALUES ('30', '03', '6');
INSERT INTO `r_role_permission` VALUES ('31', '03', '7');
INSERT INTO `r_role_permission` VALUES ('32', '03', '8');
INSERT INTO `r_role_permission` VALUES ('33', '03', '9');
INSERT INTO `r_role_permission` VALUES ('34', '03', '10');
INSERT INTO `r_role_permission` VALUES ('35', '03', '11');
INSERT INTO `r_role_permission` VALUES ('36', '03', '12');
INSERT INTO `r_role_permission` VALUES ('37', '04', '5');
INSERT INTO `r_role_permission` VALUES ('38', '04', '6');
INSERT INTO `r_role_permission` VALUES ('39', '04', '7');
INSERT INTO `r_role_permission` VALUES ('40', '04', '8');
INSERT INTO `r_role_permission` VALUES ('41', '04', '13');
INSERT INTO `r_role_permission` VALUES ('42', '04', '14');
INSERT INTO `r_role_permission` VALUES ('43', '04', '15');
INSERT INTO `r_role_permission` VALUES ('44', '04', '16');
INSERT INTO `r_role_permission` VALUES ('49', '05', '4');
INSERT INTO `r_role_permission` VALUES ('50', '05', '8');
INSERT INTO `r_role_permission` VALUES ('51', '05', '20');
INSERT INTO `r_role_permission` VALUES ('56', '01', '1');
INSERT INTO `r_role_permission` VALUES ('57', '01', '2');
INSERT INTO `r_role_permission` VALUES ('58', '01', '3');
INSERT INTO `r_role_permission` VALUES ('59', '01', '4');
INSERT INTO `r_role_permission` VALUES ('60', '01', '5');
INSERT INTO `r_role_permission` VALUES ('61', '01', '6');
INSERT INTO `r_role_permission` VALUES ('62', '01', '7');
INSERT INTO `r_role_permission` VALUES ('63', '01', '8');
INSERT INTO `r_role_permission` VALUES ('64', '01', '9');
INSERT INTO `r_role_permission` VALUES ('65', '01', '10');
INSERT INTO `r_role_permission` VALUES ('66', '01', '11');
INSERT INTO `r_role_permission` VALUES ('67', '01', '12');
INSERT INTO `r_role_permission` VALUES ('68', '01', '13');
INSERT INTO `r_role_permission` VALUES ('69', '01', '14');
INSERT INTO `r_role_permission` VALUES ('70', '01', '15');
INSERT INTO `r_role_permission` VALUES ('71', '01', '16');
INSERT INTO `r_role_permission` VALUES ('72', '01', '17');
INSERT INTO `r_role_permission` VALUES ('73', '01', '18');
INSERT INTO `r_role_permission` VALUES ('74', '01', '16');
INSERT INTO `r_role_permission` VALUES ('75', '01', '20');
INSERT INTO `r_role_permission` VALUES ('76', '01', '21');
INSERT INTO `r_role_permission` VALUES ('77', '01', '22');
INSERT INTO `r_role_permission` VALUES ('78', '01', '23');
INSERT INTO `r_role_permission` VALUES ('79', '01', '24');
INSERT INTO `r_role_permission` VALUES ('80', '01', '25');
INSERT INTO `r_role_permission` VALUES ('81', '01', '26');

-- ----------------------------
-- Table structure for sys_logger
-- ----------------------------
DROP TABLE IF EXISTS `sys_logger`;
CREATE TABLE `sys_logger` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `request_method` varchar(64) NOT NULL DEFAULT '' COMMENT 'HTTP请求方法类型',
  `method` varchar(255) NOT NULL DEFAULT '' COMMENT '执行的方法-类全命名.方法',
  `params` text NOT NULL COMMENT '传入的参数',
  `host` varchar(64) NOT NULL COMMENT '客户端主机',
  `address` varchar(255) NOT NULL DEFAULT '' COMMENT 'URL地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sys_logger
-- ----------------------------
INSERT INTO `sys_logger` VALUES ('1', '2020-02-28 10:50:41', 'GET', 'com.lx.emp.service.DepartmentService.findAll', '[null]', '0:0:0:0:0:0:0:1', 'http://localhost:9000/emp/department/list');
INSERT INTO `sys_logger` VALUES ('2', '2020-02-28 11:20:26', 'GET', 'com.lx.emp.service.EmployeeService.findAll', '[1, 5, , , ]', '0:0:0:0:0:0:0:1', 'http://localhost:9000/emp/employee/list');
INSERT INTO `sys_logger` VALUES ('3', '2020-02-28 11:22:06', 'GET', 'com.lx.emp.service.EmployeeService.findAll', '[1, 5, , , ]', '127.0.0.1', 'http://127.0.0.1:9000/emp/employee/list');
INSERT INTO `sys_logger` VALUES ('4', '2020-02-28 11:22:06', 'GET', 'com.lx.emp.service.DepartmentService.findAll', '[]', '127.0.0.1', 'http://127.0.0.1:9000/emp/department/list');
INSERT INTO `sys_logger` VALUES ('6', '2020-02-28 11:23:30', 'POST', 'com.lx.emp.service.EmployeeService.findByNO', '[00000]', '127.0.0.1', 'http://127.0.0.1:9000/emp/employee/login');
INSERT INTO `sys_logger` VALUES ('7', '2020-02-28 11:23:32', 'POST', 'com.lx.emp.service.PermissionService.findByRoleId', '[01]', '127.0.0.1', 'http://127.0.0.1:9000/emp/employee/login');
INSERT INTO `sys_logger` VALUES ('8', '2020-02-28 11:23:32', 'POST', 'com.lx.emp.service.PermissionService.findByRoleId', '[01]', '127.0.0.1', 'http://127.0.0.1:9000/emp/employee/login');
INSERT INTO `sys_logger` VALUES ('9', '2020-02-28 11:23:36', 'GET', 'com.lx.emp.service.EmployeeService.findAll', '[1, 5, , , ]', '127.0.0.1', 'http://127.0.0.1:9000/emp/employee/list');
INSERT INTO `sys_logger` VALUES ('10', '2020-02-28 11:23:36', 'GET', 'com.lx.emp.service.DepartmentService.findAll', '[]', '127.0.0.1', 'http://127.0.0.1:9000/emp/department/list');
INSERT INTO `sys_logger` VALUES ('11', '2020-02-28 11:23:37', 'GET', 'com.lx.emp.service.RoleService.findAll', '[]', '127.0.0.1', 'http://127.0.0.1:9000/emp/role/list');
INSERT INTO `sys_logger` VALUES ('12', '2020-02-28 11:23:38', 'GET', 'com.lx.emp.service.DepartmentService.findAll', '[]', '127.0.0.1', 'http://127.0.0.1:9000/emp/department/list');
INSERT INTO `sys_logger` VALUES ('13', '2020-02-28 11:23:48', 'GET', 'com.lx.emp.service.RoleService.findAll', '[]', '127.0.0.1', 'http://127.0.0.1:9000/emp/role/list');
INSERT INTO `sys_logger` VALUES ('15', '2020-02-28 11:23:56', 'GET', 'com.lx.emp.service.DepartmentService.findAll', '[]', '127.0.0.1', 'http://127.0.0.1:9000/emp/department/list');
INSERT INTO `sys_logger` VALUES ('16', '2020-02-28 11:23:56', 'GET', 'com.lx.emp.service.RoleService.findAll', '[]', '127.0.0.1', 'http://127.0.0.1:9000/emp/role/list');
INSERT INTO `sys_logger` VALUES ('17', '2020-02-28 11:23:56', 'GET', 'com.lx.emp.service.VacationService.findAll', '[1, 5, , ]', '127.0.0.1', 'http://127.0.0.1:9000/emp/vacation/list');
INSERT INTO `sys_logger` VALUES ('18', '2020-02-28 11:23:58', 'GET', 'com.lx.emp.service.SaleryService.findAll', '[1, 5, , ]', '127.0.0.1', 'http://127.0.0.1:9000/emp/salery/list');
INSERT INTO `sys_logger` VALUES ('19', '2020-02-28 11:23:59', 'GET', 'com.lx.emp.service.SaleryService.findAll', '[1, 5, , 00000]', '127.0.0.1', 'http://127.0.0.1:9000/emp/salery/list');

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `admin_name` varchar(11) NOT NULL,
  `admin_password` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`admin_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('root', '111');

-- ----------------------------
-- Table structure for tb_attend
-- ----------------------------
DROP TABLE IF EXISTS `tb_attend`;
CREATE TABLE `tb_attend` (
  `attend_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_no` varchar(11) NOT NULL COMMENT '员工编号',
  `emp_name` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `attend_begin_time` timestamp NULL DEFAULT NULL COMMENT '上班打卡时间',
  `attend_end_time` timestamp NULL DEFAULT NULL COMMENT '下班打卡时间',
  PRIMARY KEY (`attend_id`),
  KEY `emp_no` (`emp_no`),
  CONSTRAINT `tb_attend_ibfk_1` FOREIGN KEY (`emp_no`) REFERENCES `tb_emp` (`emp_no`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_attend
-- ----------------------------
INSERT INTO `tb_attend` VALUES ('2', '00002', '后羿', '2020-02-22 20:38:39', '2020-02-22 23:00:00');
INSERT INTO `tb_attend` VALUES ('6', '00005', '诸葛亮', '2020-02-22 20:41:07', null);
INSERT INTO `tb_attend` VALUES ('7', '00006', '刘备', '2020-02-22 20:41:13', null);
INSERT INTO `tb_attend` VALUES ('8', '00010', '孙悟空', '2020-02-22 20:41:19', null);
INSERT INTO `tb_attend` VALUES ('9', '00003', '孙尚香', '2020-02-22 00:00:00', null);
INSERT INTO `tb_attend` VALUES ('12', '00009', '公孙离', '2020-02-22 22:05:27', '2020-02-22 22:05:43');
INSERT INTO `tb_attend` VALUES ('13', '00009', '公孙离', '2020-02-23 08:56:28', '2020-02-23 08:56:59');
INSERT INTO `tb_attend` VALUES ('14', '00002', '后羿', '2020-02-23 09:21:50', '2020-02-23 09:22:04');
INSERT INTO `tb_attend` VALUES ('16', '00000', 'root', '2020-02-27 16:33:05', '2020-02-27 16:33:53');

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept` (
  `dept_id` varchar(10) NOT NULL COMMENT '部门编号',
  `dept_name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `dept_create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '部门创建时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_dept
-- ----------------------------
INSERT INTO `tb_dept` VALUES ('01', '开发部', '2020-02-22 13:43:15');
INSERT INTO `tb_dept` VALUES ('02', '产品部', '2020-02-22 13:43:20');
INSERT INTO `tb_dept` VALUES ('03', '销售部', '2020-02-22 13:43:23');
INSERT INTO `tb_dept` VALUES ('04', '测试部', '2020-02-22 13:43:26');
INSERT INTO `tb_dept` VALUES ('05', '行政部', '2020-02-22 13:43:31');
INSERT INTO `tb_dept` VALUES ('06', '后勤部', '2020-02-22 13:43:37');
INSERT INTO `tb_dept` VALUES ('07', '党政机关部', '2020-02-22 13:43:46');
INSERT INTO `tb_dept` VALUES ('08', '机电部', '2020-02-22 13:43:52');

-- ----------------------------
-- Table structure for tb_emp
-- ----------------------------
DROP TABLE IF EXISTS `tb_emp`;
CREATE TABLE `tb_emp` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工主键',
  `emp_no` varchar(11) DEFAULT NULL COMMENT '员工工号，唯一',
  `emp_name` varchar(255) NOT NULL COMMENT '员工姓名',
  `emp_password` varchar(255) DEFAULT NULL,
  `emp_idcard` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `emp_salerycard` varchar(255) DEFAULT NULL COMMENT '工资卡号',
  `emp_gender` varchar(255) DEFAULT NULL COMMENT '员工性别',
  `emp_phone` varchar(255) DEFAULT NULL COMMENT '员工电话',
  `emp_email` varchar(255) DEFAULT NULL COMMENT '员工邮箱',
  `emp_status` int(11) DEFAULT NULL COMMENT '员工状态，1表示已转正，0表示没转正',
  `emp_type` varchar(8) DEFAULT NULL COMMENT '员工角色',
  `dept_id` varchar(10) DEFAULT NULL COMMENT '部门编号',
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `emp_no` (`emp_no`),
  KEY `dept_id` (`dept_id`),
  KEY `emp_type` (`emp_type`),
  CONSTRAINT `tb_emp_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `tb_dept` (`dept_id`),
  CONSTRAINT `tb_emp_ibfk_2` FOREIGN KEY (`emp_type`) REFERENCES `tb_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_emp
-- ----------------------------
INSERT INTO `tb_emp` VALUES ('155', '00001', '鲁班七号', '000000', '130285365489652365', '6212260402001329956', '男', '15469856421', 'lubanqihao@163.com', '1', '02', '07');
INSERT INTO `tb_emp` VALUES ('156', '00002', '后羿', '111111', '130285365489652361', '6212260402001329954', '男', '12365485467', 'houyi@163.com', '1', '03', '02');
INSERT INTO `tb_emp` VALUES ('157', '00003', '孙尚香', '000000', '130285365489652362', '6212260402001329957', '女', '65954865941', 'sunshangxiang@163.com', '1', '04', '03');
INSERT INTO `tb_emp` VALUES ('158', '00004', '张飞', '000000', '130285365489652363', '6212260402001329958', '男', '13654896541', 'zhangfei@163.com', '1', '05', '04');
INSERT INTO `tb_emp` VALUES ('159', '00005', '诸葛亮', '000000', '130285365489652364', '6212260402001329959', '男', '15684526546', 'zhugeliang@163.com', '1', '05', '01');
INSERT INTO `tb_emp` VALUES ('160', '00006', '刘备', '000000', '130285365489652366', '6212260402001329960', '男', '15684563252', 'liubei@163.com', '1', '05', '01');
INSERT INTO `tb_emp` VALUES ('161', '00007', '关羽', '000000', '130285365489652367', '6212260402001329961', '男', '15896532656', 'guanyu@163.com', '1', '05', '05');
INSERT INTO `tb_emp` VALUES ('162', '00008', '钟馗', '000000', '130285365489652368', '6212260402001329962', '男', '15568965487', 'zhongkui@163.com', '1', '05', '02');
INSERT INTO `tb_emp` VALUES ('163', '00009', '公孙离', '000000', '130285365489652369', '6212260402001329963', '女', '15236987456', 'gongsunli@163.com', '1', '05', '03');
INSERT INTO `tb_emp` VALUES ('164', '00010', '孙悟空', '000000', '130285365489652312', '6212260402001329964', '男', '12365489753', 'sunwukong@163.com', '1', '05', '01');
INSERT INTO `tb_emp` VALUES ('165', '00011', '猪八戒', '000000', '130285365489652313', '6212260402001329965', '男', '16987456236', 'zhubajie@163.com', '1', '05', '02');
INSERT INTO `tb_emp` VALUES ('166', '00012', '上官婉儿', '000000', '130285365489652314', '6212260402001329966', '女', '15649875646', 'shangguanwaner@163.com', '1', '05', '02');
INSERT INTO `tb_emp` VALUES ('167', '00013', '武则天', '000000', '130285365489652315', '6212260402001329967', '女', '15876549855', 'wuzetian@163.com', '1', '05', '03');
INSERT INTO `tb_emp` VALUES ('168', '00014', '王昭君', '000000', '130285365489652317', '6212260402001329968', '女', '15569879821', 'wangzhaojun@163.com', '1', '05', '04');
INSERT INTO `tb_emp` VALUES ('169', '00000', 'root', 'root', '130285365489652318', '6212260402001329969', '男', '12365489544', null, '1', '01', '01');
INSERT INTO `tb_emp` VALUES ('170', '00015', '关羽', '000000', '130265985648523659', '6215456236985625569', '男', '12478523452', 'guanyu@1613.com', '1', null, '02');

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) DEFAULT NULL,
  `permission_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------
INSERT INTO `tb_permission` VALUES ('1', 'DEPT_ADD', '增加部门');
INSERT INTO `tb_permission` VALUES ('2', 'DEPT_EDIT', '编辑部门');
INSERT INTO `tb_permission` VALUES ('3', 'DEPT_DELETE', '删除部门');
INSERT INTO `tb_permission` VALUES ('4', 'DEPT_SELECT', '查询部门');
INSERT INTO `tb_permission` VALUES ('5', 'EMP_ADD', '增加员工');
INSERT INTO `tb_permission` VALUES ('6', 'EMP_EDIT', '编辑员工');
INSERT INTO `tb_permission` VALUES ('7', 'EMP_DELETE', '删除员工');
INSERT INTO `tb_permission` VALUES ('8', 'EMP_SELECT', '查询员工');
INSERT INTO `tb_permission` VALUES ('9', 'VACATION_ADD', '增加休假信息');
INSERT INTO `tb_permission` VALUES ('10', 'VACATION_EDIT', '编辑休假信息');
INSERT INTO `tb_permission` VALUES ('11', 'VACATION_DELETE', '删除休假信息');
INSERT INTO `tb_permission` VALUES ('12', 'VACATION_SELECT', '查询休假信息');
INSERT INTO `tb_permission` VALUES ('13', 'PAY_ADD', '增加工资');
INSERT INTO `tb_permission` VALUES ('14', 'PAY_EDIT', '编辑工资');
INSERT INTO `tb_permission` VALUES ('15', 'PAY_DELETE', '删除工资');
INSERT INTO `tb_permission` VALUES ('16', 'PAY_SELECT', '查询工资');
INSERT INTO `tb_permission` VALUES ('17', 'ATTEND_ADD', '增加考勤');
INSERT INTO `tb_permission` VALUES ('18', 'ATTEND_EDIT', '编辑考勤');
INSERT INTO `tb_permission` VALUES ('19', 'ATTEND_DELETE', '删除考勤');
INSERT INTO `tb_permission` VALUES ('20', 'ATTEND_SELECT', '查询考勤');
INSERT INTO `tb_permission` VALUES ('21', 'ROLE_ADD', '增加角色');
INSERT INTO `tb_permission` VALUES ('22', 'ROLE_EDIT', '编辑角色');
INSERT INTO `tb_permission` VALUES ('23', 'ROLE_DELETE', '删除角色');
INSERT INTO `tb_permission` VALUES ('24', 'ROLE_SELECT', '查询角色');
INSERT INTO `tb_permission` VALUES ('25', 'LOG_SELECT', '查询日志');
INSERT INTO `tb_permission` VALUES ('26', 'LOG_DELETE', '删除日志');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `role_id` varchar(8) NOT NULL,
  `role_name` varchar(255) NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_description` varchar(255) DEFAULT '',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('01', '超级管理员', '啥都能干');
INSERT INTO `tb_role` VALUES ('02', '总经理', '除了工资管理都可以干');
INSERT INTO `tb_role` VALUES ('03', '部门经理', '除了部门管理和工资管理都可以干');
INSERT INTO `tb_role` VALUES ('04', '人事经理', '只有员工管理和工资管理');
INSERT INTO `tb_role` VALUES ('05', '普通员工啊', '部门查询、员工查询');

-- ----------------------------
-- Table structure for tb_salery
-- ----------------------------
DROP TABLE IF EXISTS `tb_salery`;
CREATE TABLE `tb_salery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_no` varchar(11) DEFAULT NULL,
  `emp_name` varchar(255) DEFAULT NULL,
  `work_salery` decimal(10,2) DEFAULT NULL COMMENT '岗位工资',
  `allowance` decimal(10,2) DEFAULT NULL COMMENT '综合补贴',
  `vacation` decimal(10,2) DEFAULT NULL COMMENT '请假扣的钱',
  `reward` decimal(10,2) DEFAULT NULL COMMENT '奖金',
  `absent` decimal(10,2) DEFAULT NULL COMMENT '旷工扣的钱',
  `total` decimal(10,2) DEFAULT NULL COMMENT '工资总额',
  `createtime` date DEFAULT NULL COMMENT '发放日期',
  PRIMARY KEY (`id`),
  KEY `emp_no` (`emp_no`),
  CONSTRAINT `tb_salery_ibfk_1` FOREIGN KEY (`emp_no`) REFERENCES `tb_emp` (`emp_no`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_salery
-- ----------------------------
INSERT INTO `tb_salery` VALUES ('1', '00001', '鲁班七号', '8000.00', '200.00', '300.00', '500.00', '100.00', '8300.00', '2020-02-27');
INSERT INTO `tb_salery` VALUES ('3', '00003', '孙尚香', '5000.00', '100.00', '0.00', '10.00', '200.00', '4910.00', '2020-02-27');
INSERT INTO `tb_salery` VALUES ('4', '00002', '后羿', '5000.00', '0.00', '0.00', '0.00', '100.00', '4900.00', '2020-02-27');
INSERT INTO `tb_salery` VALUES ('5', '00004', '张飞', '5600.00', '0.00', '0.00', '0.00', '0.00', '5600.00', '2020-02-27');
INSERT INTO `tb_salery` VALUES ('6', '00005', '诸葛亮', '3223.00', '0.00', '10.00', '0.00', '20.00', '3193.00', '2020-02-27');
INSERT INTO `tb_salery` VALUES ('7', '00006', '刘备', '8000.00', '232.00', '32.00', '32.00', '32.00', '8200.00', '2020-02-27');
INSERT INTO `tb_salery` VALUES ('8', '00008', '钟馗', '15000.00', '2500.00', '200.00', '500.00', '0.00', '17800.00', '2020-02-27');

-- ----------------------------
-- Table structure for tb_vacation
-- ----------------------------
DROP TABLE IF EXISTS `tb_vacation`;
CREATE TABLE `tb_vacation` (
  `vacation_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_no` varchar(11) DEFAULT NULL COMMENT '员工编号',
  `emp_name` varchar(128) DEFAULT NULL,
  `begin_time` date DEFAULT NULL COMMENT '开始时间',
  `end_time` date DEFAULT NULL COMMENT '结束时间',
  `reason` varchar(128) DEFAULT NULL COMMENT '请假原因',
  `approve_name` varchar(128) DEFAULT NULL COMMENT '处理人名称',
  `approve_no` varchar(11) DEFAULT NULL COMMENT '处理人工号',
  `status` tinyint(4) DEFAULT NULL COMMENT '0-已申请，1-已批准，2-被驳回，-1自己撤回',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`vacation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_vacation
-- ----------------------------
INSERT INTO `tb_vacation` VALUES ('1', '00001', '鲁班七号', '2020-02-26', '2020-02-29', '想回家看看', 'root', '00000', '2', '公司项目紧急，不批假');
INSERT INTO `tb_vacation` VALUES ('3', '00000', 'root', '2020-01-31', '2020-02-21', '121221', 'root', '00000', '1', null);
INSERT INTO `tb_vacation` VALUES ('4', '00000', 'root', '2020-01-31', '2020-02-28', '43432', 'root', '00000', '2', null);
INSERT INTO `tb_vacation` VALUES ('5', '00000', 'root', '2020-01-31', '2020-02-28', '111111', 'root', '00000', '2', '不批准');
INSERT INTO `tb_vacation` VALUES ('6', '00000', 'root', '2020-01-31', '2020-02-28', '22222222', '后羿', '00002', '1', null);
INSERT INTO `tb_vacation` VALUES ('7', '00014', '王昭君', '2020-02-01', '2020-02-29', '22222', null, null, '0', null);
INSERT INTO `tb_vacation` VALUES ('8', '00014', '王昭君', '2020-01-31', '2020-02-21', '333333333', null, null, '-1', null);
INSERT INTO `tb_vacation` VALUES ('9', '00014', '王昭君', '2020-02-07', '2020-02-27', '22222', '后羿', '00002', '2', '发发送到');
INSERT INTO `tb_vacation` VALUES ('10', '00014', '王昭君', '2020-02-07', '2020-02-28', '4444444', '后羿', '00002', '2', '发送到电风扇');
INSERT INTO `tb_vacation` VALUES ('11', '00012', '上官婉儿', '2020-02-01', '2020-02-22', '656', null, null, '0', null);
INSERT INTO `tb_vacation` VALUES ('12', '00012', '上官婉儿', '2020-02-07', '2020-02-21', '43432', '后羿', '00002', '1', null);
INSERT INTO `tb_vacation` VALUES ('13', '00004', '张飞', '2020-02-01', '2020-02-29', '两节课加快了', null, null, '0', null);
INSERT INTO `tb_vacation` VALUES ('14', '00001', '鲁班七号', '2020-02-26', '2020-02-29', '想回家看看', null, null, '0', null);
