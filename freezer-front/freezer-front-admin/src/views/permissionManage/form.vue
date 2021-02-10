<template>
<el-dialog :title="title" :visible.sync="isShown" width="800px">
    <div v-loading="loading">
        <el-form :model="formData" ref="formData" :rules="formRules" label-width="100px">
            <el-row>
                <el-col :span="10">
                    <el-form-item label="权限名" prop="permissionName">
                        <el-input v-model="formData.permissionName" auto-complete="off" placeholder="请输入" :disabled="isDisabled"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="10">
                    <el-form-item label="路由" prop="permissionRoute">
                        <el-input v-model="formData.permissionRoute" auto-complete="off" placeholder="请输入" :disabled="isDisabled"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="10">
                    <el-form-item label="类型" prop="type">
                        <el-select filterable placeholder="请选择" v-model="formQuery.type" clearable>
                            <el-option v-for="item in typeOptions" :key="item.id" :label="item.text" :value="item.id"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="10">
                    <el-form-item label="状态" prop="sex">
                        <el-radio-group v-model="formData.isDelete" :disabled="isDisabled">
                            <el-radio :label="0">开启</el-radio>
                            <el-radio :label="1">禁用</el-radio>
                        </el-radio-group>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
        <div class="mt-20 tr">
            <el-button type="primary" @click="onAddOrUpdate">保存</el-button>
            <el-button  @click="isShown=false">关闭</el-button>
        </div>
    </div>
</el-dialog>
</template>

<script>

const emptyFormData = {
    id:"0",
    permissionName: "",
    permissionRoute: "",
    type:"",
    isDelete:"0"
};
import * as R from "ramda";
import typeOptions from "../../options"
export default {
    name: "permission-form",
    data() {   
        return {
            title: "",
            loading: false,
            isShown: false,
            formData: emptyFormData,
            formRules: {
                permissionName: [{
                    required: true,
                    message: "请输入权限名称",
                    trigger: "blur"
                }],
                permissionRoute: [{
                    required: true,
                    message: "请输入权限路由",
                    trigger: "blur"
                }]
            }
        };
    },
    methods: {
        
        add() {
            this.formData = R.clone(emptyFormData);
            this.title = "新增权限";
            this.isShown = true;
        },
        edit(data) {
            this.formData=R.clone(data);
            this.title = "编辑权限";  
            this.isShown = true;
        },
        onAddOrUpdate() {   
            this.$refs["formData"].validate(valid => {
                this.cvalidate(valid2=>{
                    if (valid && valid2) {
                        this.addOrUpdate();
                    } else {
                        return false;
                    }
                });
            });
        },
        async addOrUpdate() {
            var _this = this;
            _this.loading = true;
            console.log(this.formData);
            let formObj=R.clone(this.formData);
            try {
                var requestDTO = R.clone(formObj);
                let result = await _this.axios.post(
                    "/permission/savePermission",
                    requestDTO
                );
                if (result && result.data && result.data.success) {
                    _this.isShown = false;
                    _this.$parent.onQueryPage();
                }
            } catch (err) {
                _this.$message.error("处理异常");
            } finally {
                _this.loading = false;
            }
        }
        
    }
};
</script>
