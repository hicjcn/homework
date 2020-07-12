<template>
    <div>
        <h1>作业提交列表-{{homeworkData.hTopic}}</h1>
        <el-table
                :data="tableData"
                border
                style="width: 100%; margin-top: 10px;">
            <el-table-column
                    fixed
                    prop="csId"
                    label="编号">
            </el-table-column>
            <el-table-column
                    prop="studentCode"
                    label="学生编号">
            </el-table-column>
            <el-table-column
                    prop="studentName"
                    label="学生">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="200">
                <template slot-scope="scope">
                    <span>
                        <el-input v-model="scope.row.grade" placeholder="请输入分数"/>
                        <el-button @click="handleClick(scope.row)" type="text" size="small">提交</el-button>
                    </span>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    import request from "@/util/request";

    export default {
        name: "ListStudent",
        methods: {
            refreshData() {
                request.get('/homeworkStudent/getStudentHomeworkList/' + this.homeworkData.hId, null)
                .then(res => {
                    if (res.code === '200') {
                        this.tableData = res.data
                    }
                })
            },
            handleClick(row) {
                console.log(row);
                request.get('/homeworkStudent/setHomeworkGrade', {
                    grade: row.grade,
                    hsId : row.hsId
                }).then(res => {
                    if (res.code === '200') {
                        this.$message({
                            message: '处理成功',
                            type: 'success'
                        })
                        this.refreshData()
                    }
                })
            }
        },
        data() {
            return {
                tableData: [],
                homeworkData: {}
            }
        },
        created() {
            this.homeworkData = this.$route.params
            this.refreshData()
        }
    }
</script>

<style scoped>

</style>