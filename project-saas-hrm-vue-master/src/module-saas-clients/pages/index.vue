<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card shadow="never">
        <!--elementui的table组件
          data：数据模型
         -->
         <!-- 数据 -->
        <el-table :data="dataList"  fit highlight-current-row style="width: 100%" border>
          <el-table-column fixed prop="id" label="ID"  width="40" align="center"></el-table-column>
          <el-table-column fixed prop="name" label="企业名称"  width="150" align="center"></el-table-column>
          <el-table-column fixed prop="managerId" label="企业登录账号"  width="100" align="center"></el-table-column>
          <el-table-column fixed prop="renewalDate" label="续期时间"  width="100" align="center"></el-table-column>
          <el-table-column fixed prop="expirationDate" label="到期时间"  width="100" align="center"></el-table-column>
          <el-table-column fixed prop="companyAddress" label="公司地址"  width="200" align="center"></el-table-column>
          <el-table-column fixed prop="companyPhone" label="公司电话"  width="150" align="center"></el-table-column>
          <el-table-column fixed prop="mailbox" label="邮箱"  width="150" align="center"></el-table-column>
          <el-table-column fixed prop="industry" label="所属行业"  width="150" align="center"></el-table-column>
           <el-table-column fixed prop="balance" label="当前余额"  width="150" align="center"></el-table-column>
          <el-table-column fixed prop="companySize" label="公司规模"  width="50" align="center"></el-table-column>
          <el-table-column fixed prop="auditState" label="审核状态"  width="50" align="center"></el-table-column>
          <el-table-column fixed prop="state" label="状态"  width="50" align="center"></el-table-column>         
          <el-table-column fixed prop="remarks" label="备注"  width="200" align="center"></el-table-column>
          <el-table-column fixed prop="createTime" label="创建时间"  width="150" align="center"></el-table-column>
		  
		      <el-table-column fixed="right" label="操作" width="150">
              <template slot-scope="scope">
                <router-link :to="'/saas-clients/details/'+scope.row.id">查看</router-link>
              </template>
          </el-table-column>
        </el-table>
        <!-- end -->
      </el-card>
     </div>
  </div>
</template>

<script>
import {list} from '@/api/base/saasClient'
export default {
  name: 'saas-clients-index',
  data () {
    return {
      dataList:[]
    }
  },
  methods: {
    getList() {
      //调用API发起请求
      //res=响应数据
      list().then(res => {
        this.dataList = res.data.data
      })
    }
  },
  // 创建完毕状态
  created() {
    this.getList()
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.alert {
  margin: 10px 0px 0px 0px;
}
.pagination {
  margin-top: 10px;
  text-align: right;
}
</style>
