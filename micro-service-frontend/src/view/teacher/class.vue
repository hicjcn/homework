<template>
    <div>
        <h1>班级列表</h1>
        <el-button type="primary" @click="dialogVisible = true">添加班级</el-button>
        <el-dialog
                title="添加班级"
                :visible.sync="dialogVisible"
                width="40%">
            <el-form :model="formInline" class="demo-form-inline" label-width="80px">
                <el-form-item label="班级名称">
                    <el-input v-model="formInline.className" placeholder="班级名称"/>
                </el-form-item>
                <el-form-item label="班级描述">
                    <el-input v-model="formInline.classDescribe" type="textarea"
                              :rows="4" placeholder="班级描述"/>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="onSubmit">确 定</el-button>
            </span>
        </el-dialog>
        <el-table
                :data="tableData"
                border
                style="width: 100%; margin-top: 10px;">
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
                    width="150">
                <template slot-scope="scope">
                    <el-button @click="update(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="handleClick(scope.row)" type="text" size="small">查看学生列表</el-button>
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
                request.get('/class/getTeacherClassList', null)
                .then(res => {
                    if (res.code === '200') {
                        this.tableData = res.data
                    }
                })
            },
            update(row) {
                this.formInline = row
                this.dialogVisible = true
            },
            handleClick(row) {
                console.log(row);
                // 跳转到学生列表
                this.$router.push({ name: "TListStudent", params: row })
            },
            onSubmit() {
                if (!this.formInline.className) {
                    this.$message({
                        message: '请填写班级名称！',
                        type: 'warning'
                    });
                    return
                }
                request.post('/class/createClass', this.formInline)
                .then(res => {
                    if (res.code === '200') {
                        this.$message({
                            message: '添加成功',
                            type: 'success'
                        });
                        this.dialogVisible = false
                        this.refreshData()
                    }
                })
            }
        },
        data() {
            return {
                tableData: [],
                dialogVisible: false,
                formInline: {
                    className: '',
                    classDescribe: ''
                }
            }
        },
        created() {
            this.refreshData()
        }
    }
</script>

<style scoped>

</style>