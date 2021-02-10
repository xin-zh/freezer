<template>
  <div class="box">
    <h1 class="title">智慧包权限管理Demo</h1>
    <el-tabs v-model="activeName" type="border-card">
      
      <el-tab-pane label="个人信息" name="message">
        <el-button type="warning" @click="logout()">退出系统</el-button>
        <section>
          <el-table
            :show-header="false"
            :data="tableData"
            :span-method="objectSpanMethod"
            border
            :cell-style="columnStyle"
            style="width: 100%; margin-top: 20px"
          >
            <el-table-column prop="id" label="ID" width="240">
              <div class="block">
                <el-avatar shape="square" :size="150" :src="squareUrl"></el-avatar>
              </div>
            </el-table-column>
            <el-table-column prop="name" width="180"></el-table-column>
            <el-table-column prop="amount"></el-table-column>
          </el-table>
        </section>
      </el-tab-pane>

      <el-tab-pane label="角色管理" name="role">
        <div v-if="!hasAuth" class="noauth">
          <h1 class="authcontent">宝贝，你没有权限</h1>
        </div>
        <div v-if="hasAuth">
          <el-button icon="el-icon-circle-plus-outline" circle @click="addRole"></el-button>
          <el-dialog title="请填写要添加的角色信息" :visible.sync="addFormVisible">
            <el-form :model="addRoleForm">
              <el-form-item label="角色名称" :label-width="formLabelWidth">
                <el-input v-model="addRoleForm.roleName" autocomplete="off"></el-input>
              </el-form-item>
              <label class="permissionLable">拥有的权限</label>
              <el-card class="box-card">
                <el-checkbox
                  :indeterminate="isIndeterminate"
                  v-model="checkAll"
                  @change="handleCheckAllChange"
                >全选</el-checkbox>
                <div style="margin: 15px 0;"></div>
                <el-checkbox-group v-model="checkedCities" @change="handleCheckedCitiesChange">
                  <el-checkbox v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox>
                </el-checkbox-group>
              </el-card>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="editFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="submitAddRole()">确 定</el-button>
            </div>
          </el-dialog>
          <el-table :data="roleData" style="width: 100%">
            <el-table-column label="角色ID" width="180">
              <template slot-scope="scope">
                <i class="el-icon-user"></i>
                <span style="margin-left: 10px">{{ scope.row.id }}</span>
              </template>
            </el-table-column>
            <el-table-column label="角色名称" width="180">
              <template slot-scope="scope">
                <div slot="reference" class="name-wrapper">
                  <el-tag size="medium">{{ scope.row.name }}</el-tag>
                </div>
              </template>
            </el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button size="mini" type="info" @click="editRole(scope.row)">编辑</el-button>
                <el-dialog title="请填写要修改的角色信息" :visible.sync="editFormVisible">
                  <el-form :model="form">
                    <el-form-item label="角色名称" :label-width="formLabelWidth">
                      <el-input v-model="form.roleName" autocomplete="off"></el-input>
                    </el-form-item>
                    <label class="permissionLable">拥有的权限</label>
                    <el-card class="box-card">
                      <el-checkbox
                        :indeterminate="isIndeterminate"
                        v-model="checkAll"
                        @change="handleCheckAllChange"
                      >全选</el-checkbox>
                      <div style="margin: 15px 0;"></div>
                      <el-checkbox-group
                        v-model="checkedCities"
                        @change="handleCheckedCitiesChange"
                      >
                        <el-checkbox v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox>
                      </el-checkbox-group>
                    </el-card>
                  </el-form>
                  <div slot="footer" class="dialog-footer">
                    <el-button @click="editFormVisible = false">取 消</el-button>
                    <el-button type="primary" @click="submitEidtRole()">确 定</el-button>
                  </div>
                </el-dialog>
                <el-button size="mini" type="danger" @click="deleteRole(scope.row)">删除</el-button>
                <el-button size="mini" type="success" @click="showRole(scope.row)">查看详情</el-button>
                <el-dialog title="角色详情" :visible.sync="dialogFormVisible">
                  <el-form :model="form">
                    <el-form-item label="角色Id" :label-width="formLabelWidth">
                      <el-input v-model="form.roleId" autocomplete="off" readonly></el-input>
                    </el-form-item>
                    <el-form-item label="角色名称" :label-width="formLabelWidth">
                      <el-input v-model="form.roleName" autocomplete="off" readonly></el-input>
                    </el-form-item>
                    <label class="permissionLable">拥有的权限</label>
                    <el-card class="box-card">
                      <div v-for="o in form.permissionSet" :key="o" class="text item">
                        <el-button type="primary" round plain>{{o}}</el-button>
                      </div>
                    </el-card>
                  </el-form>
                </el-dialog>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-tab-pane>

      <el-tab-pane label="权限管理" name="permission">
        <div v-if="!hasAuth" class="noauth">
          <h1 class="authcontent">宝贝，你没有权限</h1>
        </div>
        <div v-if="hasAuth">
          <el-button icon="el-icon-circle-plus-outline" circle @click="addPermission"></el-button>
          <el-table :data="permissionData" style="width: 100%">
            <el-table-column label="权限ID" width="180">
              <template slot-scope="scope">
                <i class="el-icon-coordinate"></i>
                <span style="margin-left: 10px">{{ scope.row.id }}</span>
              </template>
            </el-table-column>
            <el-table-column label="权限名称" width="180">
              <template slot-scope="scope">
                <div slot="reference" class="name-wrapper">
                  <el-tag size="medium">{{ scope.row.name }}</el-tag>
                </div>
              </template>
            </el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="info"
                  @click="editPermission(scope.$index, scope.row)"
                >编辑</el-button>
                <el-button
                  size="mini"
                  type="danger"
                  @click="deletePermission(scope.$index, scope.row)"
                >删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-tab-pane>
      <el-tab-pane label="用户管理" name="person">
        <div v-if="!hasAuth" class="noauth">
          <h1 class="authcontent">宝贝，你没有权限</h1>
        </div>
        <div v-if="hasAuth">
          <el-table :data="userData" style="width: 100%">
            <el-table-column label="用户ID" width="180">
              <template slot-scope="scope">
                <i class="el-icon-coordinate"></i>
                <span style="margin-left: 10px">{{ scope.row.userId }}</span>
              </template>
            </el-table-column>
            <el-table-column label="用户名" width="180">
              <template slot-scope="scope">
                <div slot="reference" class="name-wrapper">
                  <el-tag size="medium">{{ scope.row.userName }}</el-tag>
                </div>
              </template>
            </el-table-column>
            <el-table-column label="用户角色" width="230">
              <template slot-scope="scope">
                <div slot="reference" class="name-wrapper">
                  <el-tag size="medium">{{ scope.row.userRoles }}</el-tag>
                </div>
              </template>
            </el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button size="mini" type="info" @click="editUser(scope.row)">编辑</el-button>
                <el-dialog title="请填写要修改的用户信息" :visible.sync="userEditFormVisible">
                  <el-form :model="userForm">
                    <el-form-item label="用户ID" :label-width="formLabelWidth">
                      <el-input v-model="userForm.userId" autocomplete="off" readonly></el-input>
                    </el-form-item>
                    <el-form-item label="用户名" :label-width="formLabelWidth">
                      <el-input v-model="userForm.userName" autocomplete="off" readonly></el-input>
                    </el-form-item>
                    <el-form-item label="用户角色" :label-width="formLabelWidth">
                      <el-select v-model="chooseUserRole" multiple placeholder="请选择">
                        <el-option
                          v-for="item in options"
                          :key="item.id"
                          :label="item.name"
                          :value="item.id"
                        ></el-option>
                      </el-select>
                    </el-form-item>
                  </el-form>
                  <div slot="footer" class="dialog-footer">
                    <el-button @click="editFormVisible = false">取 消</el-button>
                    <el-button type="primary" @click="submitEidtUser(scope.row)">确 定</el-button>
                  </div>
                </el-dialog>
                <el-button size="mini" type="danger" @click="deleteUser(scope.row)">删除</el-button>
              </template>
            </el-table-column>
            <!-- <el-table-column label="是否冻结" width="230">
              <template slot-scope="scope">
                <div slot="reference" class="name-wrapper">
                  <el-switch v-model="isUseable" active-color="#13ce66" inactive-color="#ff4949"></el-switch>
                </div>
              </template>
            </el-table-column> -->
          </el-table>
        </div>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
// let cityOptions = ["上海", "北京", "广州", "深圳"];
export default {
  name: "Home",
  data() {
    return {
      hasAuth: false,
      isUseable: true,
      activeName: "message",
      squareUrl:
        "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
      dataForm: {
        // userId: "",
        // userName: "",
        // userRoles: [],
        // userPermissons: [],
        // headImg: ""
      },
      roleData: [],
      permissionData: [],
      userData: [],
      dialogTableVisible: false,
      editFormVisible: false,
      dialogFormVisible: false,
      addFormVisible: false,
      userEditFormVisible: false,
      val: false,
      options: [],
      chooseUserRole: [],
      form: {
        roleId: "",
        roleName: "",
        permissionSet: []
      },
      addRoleForm: {
        roleName: "",
        permissionSet: []
      },
      userForm: {
        userId: "",
        userName: "",
        roleSet: ""
      },
      formLabelWidth: "120px",
      checkAll: false,
      checkedCities: [],
      cities: ["上海", "北京", "广州", "深圳"],
      isIndeterminate: true,
      editRoleRow: ""
    };
  },
  created() {
    this.login();
    this.getUserInfo();
    this.getRoleInfo();
    this.getPermissionInfo();
    this.findAllUserInfo();
    this.getPermissonName();
  },
  methods: {
    logout() {
      this.$confirm("是否确认退出?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          sessionStorage.setItem("token", "false");
          location.reload();
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消操作"
          });
        });
    },
    // useable(){
    //   this.isUseable = !this.isUseable
    // },
    // 自定义列背景色
    columnStyle({ row, column, rowIndex, columnIndex }) {
      if (columnIndex == 0 || columnIndex == 1 || columnIndex == 3) {
        //第三第四列的背景色就改变了2和3都是列数的下标
        return "background:#f3f6fc;";
      } else {
        return "background:#ffffff;";
      }
    },
    // 和并列
    objectSpanMethod({ row, column, rowIndex, columnIndex }) {
      if (columnIndex === 0) {
        if (rowIndex % 4 === 0) {
          return {
            rowspan: 4,
            colspan: 1
          };
        } else {
          return {
            rowspan: 0,
            colspan: 0
          };
        }
      }
    },
    getUserInfo() {
      this.$http.get("/getUserInfo").then(resp => {
        this.dataForm = resp.data;
        console.log(this.dataForm);
        for (let i = 0; i < this.dataForm.userRoles.length; i++) {
          if (this.dataForm.userRoles[i] == "admin") {
            this.hasAuth = true;
            break;
          }
        }
      });
    },
    getRoleInfo() {
      this.$http.get("/getRoleInfo").then(resp => {
        this.roleData = resp.data;
        this.options = resp.data;
      });
    },
    getPermissonName() {
      this.$http.get("/getPermissionName").then(resp => {
        this.cities = resp.data;
      });
    },
    getPermissionInfo() {
      this.$http.get("/getPermissionInfo").then(resp => {
        this.permissionData = resp.data;
      });
    },
    findAllUserInfo() {
      this.$http.get("/findAllUserInfo").then(resp => {
        this.userData = resp.data;
      });
    },
    login() {
      console.log(sessionStorage.getItem("username"));
      this.$http
        .get(
          `/login?username=${sessionStorage.getItem(
            "username"
          )}&password=${sessionStorage.getItem("password")}`
        )
        .then(result => {});
      //this.$http.get("/login?username=hniit&password=12345").then(result => {});
    },
    editUser(row) {
      console.log(row);
      this.userEditFormVisible = true;
      this.userForm.userId = row.userId;
      this.userForm.userName = row.userName;
      // this.userForm.roleSet = row.roleSet
    },
    deleteUser(row) {
      alert(row.userId);
      this.$confirm("是否确认删除?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
        center: true
      })
        .then(() => {
          this.$http.get(`/deleteUserByUserId/${row.userId}`).then(resp => {
            this.$message({
              type: "success",
              message: "删除成功!"
            });
            // this.activeName = 'permission'
            // console.log('active:',this.activeName)
            // window.location.reload()
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },
    editPermission(index, row) {
      this.$prompt("请输入要修改的权限名", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消"
      })
        .then(({ value }) => {
          this.$http
            .get(`/updatePermissionById/${row.id}/${value}`)
            .then(resp => {
              this.$message({
                type: "success",
                message: "修改成功!"
              });
              // this.activeName = 'permission'
              // console.log('active:',this.activeName)
              // window.location.reload()
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消输入"
          });
        });
    },
    deletePermission(index, row) {
      this.$confirm("是否确认删除?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
        center: true
      })
        .then(() => {
          this.$http.get(`/deletePermissionById/${row.id}`).then(resp => {
            this.$message({
              type: "success",
              message: "删除成功!"
            });
            // this.activeName = 'permission'
            // console.log('active:',this.activeName)
            // window.location.reload()
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },
    addPermission() {
      this.$prompt("请输入要添加的权限名", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消"
      })
        .then(({ value }) => {
          this.$http.get(`/addPermission/${value}`).then(resp => {
            this.$message({
              type: "success",
              message: "添加成功!"
            });
            // this.activeName = 'permission'
            // console.log('active:',this.activeName)
            // window.location.reload()
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消输入"
          });
        });
    },
    deleteRole(row) {
      this.$confirm("是否确认删除?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
        center: true
      })
        .then(() => {
          this.$http.get(`/deleteRoleById/${row.id}`).then(resp => {
            this.$message({
              type: "success",
              message: "删除成功!"
            });
            // this.activeName = 'permission'
            // console.log('active:',this.activeName)
            // window.location.reload()
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },
    addRole() {
      this.addFormVisible = true
      this.checkedCities = []
      this.addRoleForm.roleName = ''
    },
    submitAddRole() {
      // console.log(this.addRoleForm.roleName);
      alert(this.checkedCities)
      if (this.checkedCities.length === 0) {

            this.$message({
              type: "info",
              message: "角色至少拥有一个权限"
            });

      } else {
        this.$http
          .get(
            `/addRoleAndPermission/${this.addRoleForm.roleName}/${this.checkedCities}`
          )
          .then(resp => {
            this.$message({
              type: "success",
              message: "添加成功!"
            });
          });
      }
      this.addFormVisible = false
    },
    showRole(row) {
      this.dialogFormVisible = true;
      this.$http.get(`/getPermissionByRoleId/${row.id}`).then(resp => {
        this.form.permissionSet = resp.data;
        this.form.roleId = row.id;
        this.form.roleName = row.name;
      });
    },
    editRole(row) {
      this.editFormVisible = true;
      this.editRoleRow = row.id;
      this.form.roleName = row.name;
      this.checkedCities = [];
      this.$http.get(`/getPermissionByRoleId/${row.id}`).then(resp => {
        for (let p = 0; p < resp.data.length; p++) {
          this.checkedCities.push(resp.data[p]);
        }
        this.dataForm = resp.data;
      });
    },
    handleCheckAllChange(val) {
      this.checkedCities = val ? this.cities : [];
      this.isIndeterminate = false;
      if (val) {
        this.form.permissionSet = this.cities;
      } else {
        this.form.permissionSet = [];
      }
    },
    handleCheckedCitiesChange(value) {
      let checkedCount = value.length;
      this.checkAll = checkedCount === this.cities.length;
      this.isIndeterminate =
        checkedCount > 0 && checkedCount < this.cities.length;
      this.form.permissionSet = value;
      // alert(this.form.permissionSet)
    },
    submitEidtRole() {
      alert(this.form.permissionSet);
      console.log(this.form);
      if (this.form.permissionSet.length === 0) {
        // this.val = false
        this.$http
          .get(
            `/updateAllPermissionForRole/${this.form.roleName}/${this.editRoleRow}`
          )
          .then(resp => {
            this.$message({
              type: "success",
              message: "修改成功!"
            });
          });
      } else {
        this.$http
          .get(
            `/updatePermissionForRole/${this.form.permissionSet}/${this.form.roleName}/${this.editRoleRow}`
          )
          .then(resp => {
            this.$message({
              type: "success",
              message: "修改成功!"
            });
          });
      }
      this.editFormVisible = false;
    },
    submitEidtUser() {
      if (this.chooseUserRole.length === 0) {
        this.$message({
          type: "warning",
          message: "用户至少拥有一个角色!"
        });
      } else {
        this.$http
          .get(`/updateUserRole/${this.userForm.userId}/${this.chooseUserRole}`)
          .then(resp => {
            this.$message({
              type: "success",
              message: "修改成功!"
            });
          });
        this.userEditFormVisible = false;
      }
    }
  },

  computed: {
    //因为数据用到了dataform中的数据，所以写在了computed中
    tableData() {
      return [
        {
          id: this.dataForm.headImg,
          name: "用户ID",
          amount: this.dataForm.userId
        },
        {
          id: this.dataForm.headImg,
          name: "用户名",
          amount: this.dataForm.userName
        },
        {
          id: this.dataForm.headImg,
          name: "拥有的角色",
          amount: this.dataForm.userRoles
        },
        {
          id: this.dataForm.headImg,
          name: "拥有的权限",
          amount: this.dataForm.userPermissons
        }
      ];
    }
  }
};
</script>

<style scoped>
.el-row {
  margin-bottom: 20px;
  &:last-child {
    margin-bottom: 0;
  }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
.box {
  margin: 100px;
}
.title {
  text-align: center;
  margin-top: -50px;
  margin-bottom: 50px;
}
.block {
  text-align: center;
}
.permissionLable {
  margin-left: 40px;
  float: left;
}
.text {
  font-size: 14px;
}

.item {
  margin-right: 10px;
  margin-bottom: 20px;
  float: left;
}

.box-card {
  margin-left: 120px;
}
.noauth {
  height: 300px;
}
.authcontent {
  text-align: center;
  line-height: 300px;
}
</style>