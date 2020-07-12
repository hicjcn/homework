<template>
    <div>
        <h1>作业列表</h1>
        <el-dialog
                title="提交作业"
                :visible.sync="dialogVisible"
                width="50%">
            <el-form :model="formInline" class="demo-form-inline" label-width="100px">
                <el-form-item label="作业">
                    <el-input v-model="formInline.hsDescribe" type="textarea"
                              :rows="4" placeholder="提交作业的描述"/>
                </el-form-item>
                <el-form-item label="已提交文件">
                    {{formInline.hsFileName}}
                </el-form-item>
                <el-form-item label="附件">
                    <input @change="getFile($event)" type="file" placeholder="附件"/>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="onSubmit">确 定</el-button>
            </span>
        </el-dialog>
        <el-select style="margin-left: 10px;" v-model="selectedClassId" placeholder="请选择" @change="refreshData">
            <el-option
                    v-for="item in classData"
                    :key="item.classId"
                    :label="item.className"
                    :value="item.classId">
            </el-option>
        </el-select>
        <el-table
                :data="tableData"
                border
                style="width: 100%; margin-top: 10px;">
            <el-table-column
                    fixed
                    prop="hId"
                    label="编号"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="hTopic"
                    label="作业"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="deadline"
                    label="截止时间"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="fileName"
                    label="附件">
                <template slot-scope="scope">
                    {{scope.row.fileName}}<el-link v-if="scope.row.fileName" type="primary" :href="'/api/file/download?name=' + scope.row.fileName">下载</el-link>
                </template>
            </el-table-column>
            <el-table-column
                    prop="className"
                    label="班级名称"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="teacherName"
                    label="教师"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="hstatus"
                    label="是否提交"
                    width="180">
                <template slot-scope="scope">
                    {{scope.row.hstatus === 1 ? '已提交' : '未提交'}}
                </template>
            </el-table-column>
            <el-table-column
                    prop="grade"
                    label="分数"
                    width="80">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="150">
                <template slot-scope="scope">
                    <el-button @click="update(scope.row)" type="text" size="small">提交作业</el-button>
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
                        this.classData = res.data
                    }
                })
                request.get('/homework/getHomeworkListForStu', {
                    classId: this.selectedClassId
                })
                .then(res => {
                    if (res.code === '200') {
                        this.tableData = res.data
                    }
                })
            },
            getFile(event) {
                this.formInline.file = event.target.files[0];//获取文件
            },
            update(row) {
                this.formInline = row
                this.dialogVisible = true
            },
            onSubmit() {
                if (!this.formInline.classId) {
                    this.$message({
                        message: '请选择发布至的班级！',
                        type: 'warning'
                    });
                    return
                }
                if (!this.formInline.hTopic) {
                    this.$message({
                        message: '请填写发布的作业描述！',
                        type: 'warning'
                    });
                    return
                }
                if (!this.formInline.deadline) {
                    this.$message({
                        message: '请填写截至时间！',
                        type: 'warning'
                    });
                    return
                }
                let formData = new FormData();
                if (this.formInline.hsId) {
                    formData.append("hsId", this.formInline.hsId);
                }
                formData.append("hId", this.formInline.hId);
                formData.append("hsDescribe", this.formInline.hsDescribe);
                formData.append("file", this.formInline.file);
                request.post('/homeworkStudent/submitHomework', formData)
                .then(res => {
                    if (res.code === '200') {
                        this.$message({
                            message: '提交成功',
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
                classData: [],
                tableData: [],
                selectedClassId: '',
                dialogVisible: false,
                formInline: {
                    classId: '',
                    file: '',
                    deadline: '',
                    hTopic: '',
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