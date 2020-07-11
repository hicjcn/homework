<template>
    <div>
        <h1>班级列表</h1>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    fixed
                    prop="classId"
                    label="编号"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="className"
                    label="名称"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="teacherCode"
                    label="教师编号"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="teacherName"
                    label="教师"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="classDescribe"
                    label="班级描述">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small">申请加入</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    import request from "@/util/request";

    export default {
        name: "class",
        methods: {
            refreshData() {
                request.get('/class/getStudentClassList', null)
                    .then(res => {
                        if (res.code === '200') {
                            this.tableData = res.data
                        }
                    })
            },

            handleClick(row) {
                console.log(row);
                request.post('/classStudent/applyForClass', {
                    classId: row.classId
                }).then(res => {
                    if (res.code === '200') {
                        this.$message({
                            message: '申请成功，等待教师审核',
                            type: 'success'
                        });
                    }
                })
            }
        },

        data() {
            return {
                tableData: []
            }
        },

        created() {
            this.refreshData()
        }
    }
</script>

<style scoped>

</style>