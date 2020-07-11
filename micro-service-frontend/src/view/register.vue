<template>
    <el-card style="width: 40%; margin-left: 30%; margin-top: 10%;">
        <h3>网课系统-注册</h3>
        <el-form :model="formInline" class="demo-form-inline" label-width="80px">
            <el-form-item label="用户名">
                <el-input v-model="formInline.userCode" placeholder="用户名" required/>
            </el-form-item>
            <el-form-item label="姓名">
                <el-input v-model="formInline.name" placeholder="姓名"/>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="formInline.password" placeholder="密码" show-password/>
            </el-form-item>
            <el-form-item label="重复密码">
                <el-input v-model="formInline.password1" placeholder="重复密码" show-password/>
            </el-form-item>
            <el-form-item label="类型">
                <el-select style="width: 100%" v-model="formInline.userType" placeholder="类型">
                    <el-option label="学生" value="0"/>
                    <el-option label="教师" value="1"/>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">注册</el-button>
                <el-button type="primary" @click="goReg">登录</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import request from "@/util/request";

    export default {
        name: "login",
        data() {
            return {
                formInline: {
                    userCode: '',
                    name: '',
                    password: '',
                    password1: '',
                    userType: '0'
                }
            }
        },
        methods: {
            onSubmit() {
                console.log(this.formInline);
                if (this.formInline.password !== this.formInline.password1) {
                    this.$message({
                        message: '两次密码输入不一致',
                        type: 'warning'
                    });
                    return
                }
                request.post("/user/registry", this.formInline)
                    .then(res => {
                        if (res.code === '200') {
                            // 注册成功去登录界面
                            this.$message({
                                message: '注册成功，请登录',
                                type: 'success'
                            });

                            this.$router.push({ name: "Login" })
                        }
                    })

            },
            goReg() {
                this.$router.push({ name: "Login" })
            }
        }
    }
</script>

<style scoped>

</style>