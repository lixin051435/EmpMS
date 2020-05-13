<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-calendar"></i> 修改密码
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="form-box">
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="新密码">
                        <el-input v-model="form.adminPassword"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">密码修改</el-button>
                        <el-button @click="reset">取消</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
import { changePass } from '@/api/admin';
export default {
    name: 'baseform',
    data() {
        return {
           
            form: {
                adminName: '',
                adminPassword:''
            }
        };
    },
    methods: {
        onSubmit() {
            this.form.adminName = JSON.parse(sessionStorage.getItem("user")).adminName;
            changePass(this.form).then(res=>{
                if(res){
                    this.$alert("密码修改成功");
                }else{
                    this.$alert("密码修改失败");
                }
                
            })
        },
        reset(){
            this.form  = {
                adminName: '',
                adminPassword:''
            };
        }
    }
};
</script>