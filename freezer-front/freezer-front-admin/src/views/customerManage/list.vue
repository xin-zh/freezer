<template>
<div>
    <sa-panel>
        <el-form ref="form" class="form-query" :inline="true" :model="formQuery" label-width="100px">
            <el-form-item label="客户账号">
                <el-input placeholder="请输入" v-model="formQuery.customerName"></el-input>
            </el-form-item>
            <el-form-item label="客户姓名">
                <el-input placeholder="请输入" v-model="formQuery.realName"></el-input>
            </el-form-item>
            <el-form-item label="联系方式">
                <el-input placeholder="请输入" v-model="formQuery.customerTel"></el-input>
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
            <el-table-column prop="customerName" label="客户账号" width="200">
            </el-table-column>
            <el-table-column prop="realName" label="客户姓名" width="200">
            </el-table-column>
            <el-table-column prop="sex" label="性别" width="200">
            </el-table-column>
            <el-table-column prop="identify" label="证件号" width="200">
            </el-table-column>
            <el-table-column prop="customerTel" label="联系方式" width="200">
            </el-table-column>
            <el-table-column prop="createTime" label="注册时间" width="200">
            </el-table-column>
        </el-table>
        <el-pagination class="paginator" @size-change="pageSizeChanged" @current-change="pageClick" :current-page="paginator.pageNumber" :page-sizes="paginator.pageSizes" :page-size="paginator.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="paginator.totalCount">
        </el-pagination>
    </sa-panel>
</div>
</template>

<script>
export default {
  name: 'customer-list',
  data () {
    return {
      paginator: {
        pageNumber: 1,
        pageSize: 10,
        totalCount: 0,
        pageSizes: [10, 20, 50]
      },
      formQuery: {
        customerName: '',
        realName: '',
        customerTel: ''
      },
      tableData: []
    }
  },
  mounted () {
    this.onQueryPage()
  },
  methods: {

    pageSizeChanged (val) {
      this.paginator.pageSize = val
      this.paginator.pageNumber = 1
      this.onQueryPage()
    },
    pageClick (val) {
      this.paginator.pageNumber = val
      this.onQueryPage()
    },
    async onQueryPage () {
      this.$spinner()
      try {
        let result = await this.axios.post('/customer/pageList', {
          customerName: this.formQuery.customerName,
          customerTel: this.formQuery.customerTel,
          realName: this.formQuery.realName,
          page: this.paginator.pageNumber,
          pageSize: this.paginator.pageSize
        })
        if (result && result.data.data && result.data.success) {
          this.tableData = result.data.data.customerList
          this.paginator.totalCount = result.data.data.pager.totalCount
        }
      } catch (err) {
        this.$message.error('获取客户列表信息异常')
      } finally {
        this.$stopSpinner()
      }
    }
  }
}
</script>
