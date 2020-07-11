<template>
    <el-card style="width: 40%; margin-left: 30%; margin-top: 20%;">
        <h3>网课系统-登录</h3>
        <el-form :model="formInline" class="demo-form-inline" label-width="80px">
            <el-form-item label="用户名">
                <el-input v-model="formInline.userCode" placeholder="用户名"/>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="formInline.password" placeholder="密码"/>
            </el-form-item>
            <el-form-item label="类型">
                <el-select style="width: 100%" v-model="formInline.userType" placeholder="类型">
                    <el-option label="学生" value="0"/>
                    <el-option label="教师" value="1"/>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">登录</el-button>
                <el-button type="primary" @click="goReg">注册</el-button>
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
                    password: '',
                    userType: '0'
                }
            }
        },
        methods: {
            onSubmit() {
                this.$cookies.set("username", '123123123',60 * 60 * 24)
                this.$cookies.set("usertype", 's',60 * 60 * 24)
                console.log(this.formInline);
                request.post("/user/login", this.formInline)
                .then(res => {
                    if (res.code === '200') {
                        this.$cookies.set("username", this.formInline.userCode,60 * 60 * 24)
                        this.$cookies.set("usertype", this.formInline.userType,60 * 60 * 24)
                        if (this.formInline.userType === '1') {
                            // 教师跳转

                        } else {
                            // 学生跳转
                            this.$router.push({ name: "SHome" })
                        }
                    }
                })
            },
            goReg() {
                this.$router.push({ name: "Register" })
            }
        }
    }
</script>

<style scoped>

</style>