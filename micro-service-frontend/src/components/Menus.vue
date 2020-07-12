<template>
    <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b">
        <el-menu-item index="1" disabled style="opacity: 100%;"> 网 课 系 统 </el-menu-item>
        <el-menu-item index="2">首页</el-menu-item>
        <el-menu-item index="3">班级管理</el-menu-item>
        <el-menu-item index="4">作业管理</el-menu-item>
        <el-menu-item index="5" @click="logout">退出</el-menu-item>
    </el-menu>
</template>

<script>
    export default {
        name: "Menus",
        data() {
            return {
                activeIndex: '2'
            };
        },
        methods: {
            logout() {
                // 移除用户信息
                this.$cookies.remove('username')
                this.$cookies.remove('usertype')
                // 转到登录界面
                this.$router.push({ name: "Login" })
            },
            handleSelect(key) {
                console.log(key, this.$cookies.get("usertype"))
                if ("0" === this.$cookies.get("usertype")) {
                    if (key === '2') {
                        this.$router.push({name: "SHome"})
                    } else if (key === '3') {
                        this.$router.push({name: "SClass"})
                    } else if (key === '4') {
                        this.$router.push({name: "SHomework"})
                    }
                } else {
                    if (key === '2') {
                        this.$router.push({name: "THome"})
                    } else if (key === '3') {
                        this.$router.push({name: "TClass"})
                    } else if (key === '4') {
                        this.$router.push({name: "THomework"})
                    }
                }
            }
        }
    }
</script>

<style scoped>

</style>