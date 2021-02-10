<template>
<div>
    <sa-panel>
        <el-form ref="form" class="form-query" :inline="true" :model="formQuery" label-width="100px">
            <el-form-item label="参数名">
                <el-input placeholder="请输入" v-model="formQuery.cahrgeName"></el-input>
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
            <el-table-column prop="chargeName" label="收费标准名" width="200">
            </el-table-column>
            <el-table-column prop="chargeValue" label="收费标准值" width="200">
            </el-table-column>
            <el-table-column prop="operator" label="操作人员" width="200">
            </el-table-column>
            <el-table-column prop="createTime" label="创建时间" width="200">
            </el-table-column>
            <el-table-column prop="updateTime" label="修改时间" width="200">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button type="text" @click="onEdit(scope.row)">编辑</el-button>
                    <el-button type="text" @click="onDelete(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination class="paginator" @size-change="pageSizeChanged" @current-change="pageClick" :current-page="paginator.pageNumber" :page-sizes="paginator.pageSizes" :page-size="paginator.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="paginator.totalCount">
        </el-pagination>
    </sa-panel>
    <charge-form ref="chargeForm"></charge-form>
</div>
</template>

<script>
import chargeForm from "./form";
export default {
    name:"charge-list",
    components:{
        "charge-form": chargeForm
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
                chargeName: ""
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
            this.$refs.chargeForm.add(data);
        },
        //编辑
        onEdit(data){
            this.$refs.chargeForm.edit(data);
        },
        onDelete(data) {
            this.$confirm('此操作将删除收费信息, 是否继续?', '提示', {
                type: "warning"
            }).then(() => {
                this.deleteCharge(data);
                console.log("删除成功")
            }).catch(() => {
                this.$message({ 
                    type: 'info',
                    message: '已取消删除'
                });
            });
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
                
                let result = await this.axios.post("/charge/pageList", {
                    chargeName: this.formQuery.chargeName,
                    page: this.paginator.pageNumber,
                    pageSize: this.paginator.pageSize
                });
                if (result && result.data.data && result.data.success) {
                    this.tableData = result.data.data.chargeList;
                    this.paginator.totalCount = result.data.data.pager.totalCount;
                }
            } catch (err) {
                this.$message.error("获取收费列表信息异常");
            } finally {
                this.$stopSpinner();
            }
        },
        async deleteCharge(data) {
            let result = await this.axios.get("/charge/deleteCharge", {
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
