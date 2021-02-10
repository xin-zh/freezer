<template>
<el-dialog :title="title" :visible.sync="isShown" width="800px">
    <div v-loading="loading">
        <el-form :model="formData" ref="formData" label-width="100px">
            <el-row>
                <el-col :span="10">
                    <el-form-item label="角色名称" prop="roleName">
                        <el-input v-model="formData.roleName" auto-complete="off" :disabled="true"></el-input >
                    </el-form-item>
                </el-col>
                <el-col :span="10">
                    <el-form-item label="角色权限" prop="rolePermission">
                        <el-input v-model="formData.rolePermission" auto-complete="off" :disabled="true"></el-input >
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
        <div class="mt-20 tr">
            <el-button  @click="isShown=false">关闭</el-button>
        </div>
    </div>
    </el-dialog>
</template>
<script>
    const emptyFormData = {
        roleName: "",
        rolePermission:""
    };
    import * as R from "ramda";
    export default {
        name: "role-info",
        data(){
            return {
                title: "查看角色权限",
                loading: false,
                isShown: false,
                formData: emptyFormData
            }
        },
        methods:{

            check(id) {
                this.formData = R.clone(emptyFormData);
                this.title = "查看角色权限";
                this.isShown = true;
                this.getRoleInfo(id);
            },
            async getRoleInfo(id){
                this.loading = true;
                try {
                    let result = await this.axios.get("/role/getRoleInfo", {
                        params: {
                            id: id
                        }
                    });
                    if (result && result.data && result.data.success) {
                        this.formData = result.data.data;
                    }
                } catch (err) {
                    this.$message.error("获取角色权限信息异常");
                } finally {
                    this.loading = false;
                }
            }
        }
        
    }
</script>
