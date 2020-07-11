<template>
    <div>
        <h1>班级学生列表-{{classData.className}}</h1>
        <el-select v-model="selectedType" placeholder="请选择" @change="refreshData">
            <el-option label="通过" value="0"/>
            <el-option label="驳回" value="2"/>
            <el-option label="审核中" value="1"/>
        </el-select>
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
                    width="100">
                <template slot-scope="scope">
                    <span>
                        <el-button @click="handleClick(scope.row, true)" type="text" size="small">通过</el-button>
                        <el-button @click="handleClick(scope.row, false)" type="text" size="small">驳回</el-button>
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
                request.get('/classStudent/getClassStudentList', {
                    classId: this.classData.classId,
                    type: this.selectedType
                })
                .then(res => {
                    if (res.code === '200') {
                        this.tableData = res.data
                    }
                })
            },
            handleClick(row, pass) {
                console.log(row, pass);
                let url = '/classStudent/disagreeApply'
                if (pass) {
                    url = '/classStudent/agreeApply'
                }
                request.get(url, { id: row.csId }).then(res => {
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
                classData: {},
                selectedType: '0'
            }
        },
        created() {
            this.classData = this.$route.params
            this.refreshData()
        }
    }
</script>

<style scoped>

</style>