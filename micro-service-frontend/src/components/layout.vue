<template>
    <el-container>
        <el-header>
            <Menus/>
        </el-header>
        <el-main>
            <router-view/>
        </el-main>
    </el-container>
</template>

<script>
    import Menus from "@/components/Menus";
    export default {
        name: "layout",
        components: {Menus}
    }
</script>

<style scoped>
    .el-container{
        position: absolute;
        width: 100%;
        top: 0px ;
        left: 0 ;
        bottom: 0;
    }
    .el-header{
        padding: 0;
        z-index: 1000;
    }

    .el-header .fr{
        float: right;
    }
    .el-header .el-menu{
        border-bottom: none;
    }
    .el-aside, .el-main{
        padding-top: 60px;
    }
    .el-aside{
        background: #545c64;
    }
    .el-aside .el-menu{
        border-right: none;
    }

</style>