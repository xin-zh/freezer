<template>
<div>
    <sa-panel>
        <el-form ref="form" class="form-query" :inline="true" :model="formQuery" label-width="100px">
            <el-form-item label="客户账号">
                <el-input placeholder="请输入" v-model="formQuery.customerName"></el-input>
            </el-form-item>
            <el-form-item label="联系方式">
                <el-input placeholder="请输入" v-model="formQuery.customerTel"></el-input>
            </el-form-item>
            <el-form-item label="状态">
                <el-select filterable placeholder="请选择" v-model="formQuery.status" clearable>
                    <el-option v-for="item in statusOptions" :key="item.id" :label="item.text" :value="item.id"></el-option>
                </el-select>
            </el-form-item>
        </el-form>
        <div class="tc mt-10">
            <el-button type="primary" @click="onQueryPage">查询</el-button>
        </div>
    </sa-panel>
    <sa-panel>
        <el-table border :data="tableData" stripe style="width: 100%">
            <el-table-column prop="id" label="" width="30">
            </el-table-column>
            <el-table-column prop="inboundNo" label="入库水果批次号" width="200">
            </el-table-column>
            <el-table-column prop="inboundItems" label="入库水果" width="200">
                <template slot-scope="scope">
                    <el-button type="text" @click="fruitDetailDialog(scope.row)">查看</el-button>
                </template>
            </el-table-column>
            <el-table-column prop="customerName" label="客户账号" width="200">
            </el-table-column>
            <el-table-column prop="customerTel" label="联系方式" width="200">
            </el-table-column>
            <el-table-column prop="createTime" label="订单创建时间" width="200">
            </el-table-column>
            <el-table-column prop="status" label="状态" width="200">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button type="text" @click="onHandle(scope.row)">处理</el-button>
                    <el-button type="text" @click="onExport(scope.row)">导出</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination class="paginator" @size-change="pageSizeChanged" @current-change="pageClick" :current-page="paginator.pageNumber" :page-sizes="paginator.pageSizes" :page-size="paginator.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="paginator.totalCount">
        </el-pagination>
    </sa-panel>
    <inbound-info ref="inboundForm"></inbound-info>
    <!--入库水果详细信息-->
    <el-dialog title="入库水果详情" :visible.sync="fruitDetailDialogVisable" width="500px">
        <el-table border :data="tableData.inboundItems">
            <el-table-column prop="itemName" label="水果名称" width="100">
            </el-table-column>
            <el-table-column prop="inboundNum" label="入库数量" width="100">
            </el-table-column>
            <el-table-column prop="inventory" label="库存数量" width="100">
            </el-table-column>
            <el-table-column prop="createTime" label="入库时间" width="100">
            </el-table-column>
        </el-table>
        <div class="mt-20 tr">
            <el-button  @click="fruitDetailDialogVisable=false">关闭</el-button>
        </div>
    <el-dialog>
</div>

</template>


<script>
import {statusOptions} from "../../options";
import contactInfo from "../contact/contactinfo";
export default {
    name:"inbound-list",
    components:{
        "contact-info":contactInfo
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
                customerName: "",
                customerTel: "",
                status: "",
            },
            tableData: [],
            statusOptions: statusOptions,
            fruitDetailDialogVisable:false,
        };
    },
    mounted() {
        this.onQueryPage();
    },
    methods: {
        //处理入库请求
        onHandle(data){
            this.$refs.inboundForm.handle(data);
        },
        //导出合同
        onExport(data){
            this.$refs.contactForm;
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
                
                let result = await this.axios.post("/inbound/pageList", {
                    customerName: this.formQuery.customerName,
                    customerTel:this.formQuery.customerTel,
                    status: this.formQuery.status,
                    page: this.paginator.pageNumber,
                    pageSize: this.paginator.pageSize
                });
                if (result && result.data.data && result.data.success) {
                    this.tableData = result.data.data.inboundList;
                    this.paginator.totalCount = result.data.data.pager.totalCount;
                }
            } catch (err) {
                this.$message.error("获取入库列表信息异常");
            } finally {
                this.$stopSpinner();
            }
        },
        async fruitDetailDialog(){
            this.fruitDetailDialogVisable=true;
        }
    }
};
</script>
