<template>
<div>
    <sa-panel>
        <el-form ref="form" class="form-query" :inline="true" :model="formQuery" label-width="100px">
            <el-form-item label="员工账号">
                <el-input placeholder="请输入" v-model="formQuery.userName"></el-input>
            </el-form-item>
            <el-form-item label="员工姓名">
                <el-input placeholder="请输入" v-model="formQuery.realName"></el-input>
            </el-form-item>
            <el-form-item label="联系方式">
                <el-input placeholder="请输入" v-model="formQuery.userTel"></el-input>
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
            <el-table-column prop="userName" label="员工账号" width="200">
            </el-table-column>
            <el-table-column prop="realName" label="员工姓名" width="200">
            </el-table-column>
            <el-table-column prop="roleId" label="角色" width="200">
                <template slot-scope="scope">
                    {{getRoleText(scope.row.roleId)}}
                </template>
            </el-table-column>
            <el-table-column prop="age" label="年龄" width="200">
            </el-table-column>
            <el-table-column prop="sex" label="性别" width="200">
            </el-table-column>
            <el-table-column prop="address" label="家庭住址" width="200">
            </el-table-column>
            <el-table-column prop="userTel" label="联系方式" width="200">
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
    <user-form ref="userForm"></user-form>
</div>
</template>

<script>
import userForm from './form'
export default {
  name: 'user-list',
  components: {
    'user-form': userForm
  },
  data () {
    return {
      paginator: {
        pageNumber: 1,
        pageSize: 10,
        totalCount: 0,
        pageSizes: [10, 20, 50]
      },
      formQuery: {
        userName: '',
        realName: '',
        userTel: ''
      },
      tableData: [],
    }
  },
  mounted () {
    this.onQueryPage()
  },
  methods: {
    // 新增
    onAdd (data) {
      this.$refs.userForm.add(data)
    },
    // 编辑
    onEdit (data) {
      this.$refs.userForm.edit(data)
    },
    onDelete (data) {
      this.$confirm('此操作将删除员工信息, 是否继续?', '提示', {
        type: 'warning'
      }).then(() => {
        this.deleteUser(data)
        console.log('删除成功')
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    getRoleText (roleId) {
      var name = ''
      this.roleOptions.forEach(function (data) {
        if (roleId == data.id) {
          name = data.roleName
          return false
        }
      })
      return name
    },
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
        let result = await this.axios.post('/user/pageList', {
          userName: this.formQuery.userName,
          realName: this.formQuery.realName,
          userTel: this.formQuery.userTel,
          page: this.paginator.pageNumber,
          pageSize: this.paginator.pageSize
        })
        if (result && result.data.data && result.data.success) {
          this.tableData = result.data.data.userList
          this.paginator.totalCount = result.data.data.pager.totalCount
        }
      } catch (err) {
        this.$message.error('获取员工列表信息异常')
      } finally {
        this.$stopSpinner()
      }
    },
    async deleteUser (data) {
      let result = await this.axios.get('/user/deleteUser', {
        params: {
          id: data.id
        }
      })
      if (result && result.data && result.data.success) {
        this.onQueryPage()
      }
    }

  }
}
</script>
