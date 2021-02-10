<template>
<el-dialog :title="title" :visible.sync="isShown" width="800px">
    <div v-loading="loading">
        <el-form :model="formData" ref="formData" :rules="formRules" label-width="100px">
            <el-row :aria-disabled="isDisabled">
                <el-tag v-model="formData.id" :disabled="true"/>
                <el-col :span="10">
                    <el-form-item label="员工账号" prop="userName" >
                        <el-input v-model="formData.userName" auto-complete="off" ></el-input >
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="10">
                    <el-form-item label="员工姓名" prop="realName">
                        <el-input v-model="formData.realName" auto-complete="off" placeholder="请输入" :disabled="isDisabled"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="10">
                    <el-form-item label="性别" prop="sex">
                        <el-radio-group v-model="formData.sex" :disabled="isDisabled">
                            <el-radio :label="1">男</el-radio>
                            <el-radio :label="2">女</el-radio>
                        </el-radio-group>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="10">
                    <el-form-item label="身份证号" prop="identify">
                        <el-input v-model="formData.identify" auto-complete="off" placeholder="请输入" :disabled="isDisabled"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="10">
                    <el-form-item label="联系方式" prop="userTel">
                        <el-input v-model="formData.userTel" auto-complete="off" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="10">
                    <el-form-item label="角色" prop="roleId">
                        <el-select filterable placeholder="请选择" v-model="formQuery.roleId" clearable>
                            <el-option v-for="item in roleOptions" :key="item.id" :label="item.text" :value="item.id"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="10">
                    <el-form-item label="家庭住址" prop="address"> 
                        <el-input v-model="formData.address" auto-complete="off" placeholder="请输入"></el-input>
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
    userName: "",
    realName: "",
    sex:"",
    identify:"",
    userTel:"",
    roleId:"",
    address:""
};
import {roleOptions} from "../../options";
import * as R from "ramda";

export default {
    name: "user-form",
    data() {   
        return {
            title: "",
            loading: false,
            isShown: false,
            formData: emptyFormData,
            isDisabled:true,
            formRules: {
                realName: [{
                    required: true,
                    message: "请输入员工姓名",
                    trigger: "blur"
                }],
                userTel: [{
                    required: true,
                    message: "请输入联系方式",
                    trigger: "blur"
                }],
                roleId:[{
                    required: true,
                    message: "请选择一种角色",
                    trigger: "blur"
                }]
            },
            sexOptions:sexOptions,
            roleOptions:roleOptions,
        };
    },
    methods: {
        
        add() {
            this.formData = R.clone(emptyFormData);
            this.title = "新增员工信息";
            this.isShown = true;
            this.isDisabled = false;
        },
        edit(data) {
            this.formData=R.clone(data);
            this.title = "修改员工信息";  
            this.isShown = true;
            this.isDisabled = true;
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
            formObj.createTime=null;
            formObj.updateTime=null;
            try {
                var requestDTO = R.clone(formObj);
                let result = await _this.axios.post(
                    "/user/saveUser",
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
