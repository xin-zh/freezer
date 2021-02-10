<template>
<div>
    <sa-panel>
        <el-form ref="form" class="form-query" :inline="true" :model="formQuery" label-width="100px">
            <el-form-item label="角色名">
                <el-input placeholder="请输入" v-model="formQuery.roleName"></el-input>
            </el-form-item>
        </el-form>
        <div class="tc mt-10">
            <el-button type="primary" @click="onQueryPage">查询</el-button>
            <el-button type="primary" @click="onAdd">新增</el-button>
        </div>
    </sa-panel>
    <sa-panel>
        <el-table border :data="tableData" stripe style="width: 100%">
            <el-table-column prop="id" label="" width="30">
            </el-table-column>
            <el-table-column prop="roleName" label="角色名" width="200">
            </el-table-column>
            <el-table-column prop="permissionList" label="角色权限" width="200">
                <template slot-scope="scope">
                    <el-button type="text" @click="onCheck(scope.row)">查看</el-button>
                </template>
            </el-table-column>
            <el-table-column prop="operator" label="操作人" width="200">
            </el-table-column>
            <el-table-column prop="createTime" label="创建时间" width="200">
            </el-table-column>
            <el-table-column prop="updateTime" label="修改时间" width="200">
            </el-table-column>
            <el-table-column prop="isDelete" label="状态" width="200">
                <template slot-scope="scope">
                    {{getStatusText(scope.row.isDelete)}}
                </template>
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button type="text" @click="onEdit(scope.row)">编辑</el-button>
                    <el-button type="text" @click="onForbid(scope.row)">禁用</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination class="paginator" @size-change="pageSizeChanged" @current-change="pageClick" :current-page="paginator.pageNumber" :page-sizes="paginator.pageSizes" :page-size="paginator.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="paginator.totalCount">
        </el-pagination>
    </sa-panel>
    <role-form ref="roleForm"></role-form>
    <role-info ref="roleInfo"></role-info> 
</div>
</template>

<script>
import roleForm from "./form";
import roleInfo from "./roleinfo";
export default {
    name:"role-list",
    components: {
        "role-form": roleForm,
        "role-info": roleInfo
    },
    data() {
        return {
            paginator: {
                pageNumber: 1,
                pageSize: 10,
                totalCount: 0,
                pageSizes: [10, 20, 50]
            },
            formQuery: {
                roleName: ""
            },
            tableData: [],
        };
    },
    mounted() {
        this.onQueryPage();
    },
    methods: {
        //新增
        onAdd(data){
            this.$refs.roleForm.add(data);
        },
        //编辑
        onEdit(data){
            this.$refs.roleForm.edit(data);
        },
        //查看角色的权限信息
        onCheck(data){
            this.$refs.roleInfo.check(data.id);
        },
        //禁用
        onForbid(data) {
            this.$confirm('此操作将禁用该角色信息, 是否继续?', '提示', {
                type: "warning"
            }).then(() => {
                this.forbidRole(data);
                console.log("禁用成功")
            }).catch(() => {
                this.$message({ 
                    type: 'info',
                    message: '已取消禁用'
                });
            });
        },
        getTypeText(type) {
            var name = "";
            this.typeOptions.forEach(function (data) {
                if (type == data.id) {
                    name = data.text;
                    return false;
                }
            });
            return name;
        },
        pageSizeChanged(val) {
            this.paginator.pageSize = val;
            this.paginator.pageNumber = 1;
            this.onQueryPage();
        },
        pageClick(val) {
            this.paginator.pageNumber = val;
            this.onQueryPage();
        },
        async onQueryPage() {
            this.$spinner();
            try {
                
                let result = await this.axios.post("/permission/pageList", {
                    permissionName: this.formQuery.permissionName,
                    page: this.paginator.pageNumber,
                    pageSize: this.paginator.pageSize
                });
                if (result && result.data.data && result.data.success) {
                    this.tableData = result.data.data.permissionList;
                    this.paginator.totalCount = result.data.data.pager.totalCount;
                }
            } catch (err) {
                this.$message.error("获取员工列表信息异常");
            } finally {
                this.$stopSpinner();
            }
        },
        async forbidPermission(data) {
            let result = await this.axios.get("/permission/forbidPermission", {
                params: {
                    id: data.id
                }
            });
            if (result && result.data && result.data.success) {
                this.onQueryPage();
            }
        }
    }
};
</script>
