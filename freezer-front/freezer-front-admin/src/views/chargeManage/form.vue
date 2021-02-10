<template>
<el-dialog :title="title" :visible.sync="isShown" width="800px">
    <div v-loading="loading">
        <el-form :model="formData" ref="formData" :rules="formRules" label-width="100px">
            <el-row>
                <el-col :span="10">
                    <el-form-item label="收费标准名" prop="chargeName">
                        <el-input v-model="formData.chargeName" auto-complete="off" placeholder="请输入" ></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="10">
                    <el-form-item label="收费标准值" prop="sex">
                        <el-input v-model="formData.chargeValue" auto-complete="off" placeholder="请输入" ></el-input>
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

import * as R from 'ramda'
const emptyFormData = {
  id: '0',
  chargeName: ''
}

export default {
  name: 'charge-form',
  data () {
    return {
      title: '',
      loading: false,
      isShown: false,
      formData: emptyFormData,
      formRules: {
        chargeName: [{
          required: true,
          message: '请输入收费标准名称',
          trigger: 'blur'
        }],
        chargeValue: [{
          required: true,
          message: '请输入相应的收费标准值',
          trigger: 'blur'
        }]
      }
    }
  },
  methods: {

    add () {
      this.formData = R.clone(emptyFormData)
      this.title = '新增收费信息'
      this.isShown = true
    },
    edit (data) {
      this.formData = R.clone(data)
      this.title = '编辑收费信息'
      this.isShown = true
    },
    onAddOrUpdate () {
      this.$refs['formData'].validate(valid => {
        this.cvalidate(valid2 => {
          if (valid && valid2) {
            this.addOrUpdate()
          } else {
            return false
          }
        })
      })
    },
    async addOrUpdate () {
      var _this = this
      _this.loading = true
      let formObj = R.clone(this.formData)
      formObj.createTime = null
      formObj.updateTime = null
      try {
        var requestDTO = R.clone(formObj)
        let result = await _this.axios.post(
          '/charge/saveCharge',
          requestDTO
        )
        if (result && result.data && result.data.success) {
          _this.isShown = false
          _this.$parent.onQueryPage()
        }
      } catch (err) {
        _this.$message.error('处理异常')
      } finally {
        _this.loading = false
      }
    }

  }
}
</script>
