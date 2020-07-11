<template>
    <div>
        <h1>作业列表</h1>
        <el-button type="primary" @click="dialogVisible = true">添加作业</el-button>
        <el-dialog
                title="添加作业"
                :visible.sync="dialogVisible"
                width="50%">
            <el-form :model="formInline" class="demo-form-inline" label-width="100px">
                <el-form-item label="发布至班级">
                    <el-select v-model="formInline.classId" style="width: 100%" placeholder="请选择">
                        <el-option
                                v-for="item in classData"
                                :key="item.classId"
                                :label="item.className"
                                :value="item.classId">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="作业">
                    <el-input v-model="formInline.hTopic" type="textarea"
                              :rows="4" placeholder="作业描述"/>
                </el-form-item>
                <el-form-item label="截至时间">
                    <el-date-picker  style="width: 100%"
                            v-model="formInline.deadline"
                            type="datetime"
                            placeholder="选择日期时间">
                    </el-date-picker>
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
                    {{scope.row.fileName}}<el-link type="primary" :href="'/api/file/download?name=' + scope.row.fileName">下载</el-link>
                </template>
            </el-table-column>
            <el-table-column
                    prop="createTime"
                    label="创建时间"
                    width="180">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="150">
                <template slot-scope="scope">
                    <el-button @click="update(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="handleClick(scope.row)" type="text" size="small">查看提交情况</el-button>
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
                        this.classData = res.data
                    }
                })
                request.get('/homework/getHomeworkList', {
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
            handleClick(row) {
                console.log(row);
                // 跳转到学生列表
                this.$router.push({ name: "TListStudent", params: row })
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
                formData.append("hId", this.formInline.hId);
                formData.append("teacherCode", this.formInline.teacherCode);
                formData.append("classId", this.formInline.classId);
                formData.append("createTime", this.formInline.createTime);
                formData.append("deadline", this.$moment(this.formInline.deadline).format('YYYY-MM-DD HH:mm:ss'));
                formData.append("hTopic", this.formInline.hTopic);
                formData.append("file", this.formInline.file);
                request.post('/homework/releaseHomework', formData)
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