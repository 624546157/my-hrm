<template>
    <el-dialog title="编辑部门" :visible.sync="dialogFormVisible">
      <!-- model : 数据模型 -->
      <el-form :model="dept" label-width="120px">
        <el-form-item label="部门名称">
          <el-input v-model="dept.name" autocomplete="off"></el-input>
        </el-form-item>
                <el-form-item label="部门编码">
          <el-input v-model="dept.code" autocomplete="off"></el-input>
        </el-form-item>
                <el-form-item label="部门负责人">
          <el-input v-model="dept.manager" autocomplete="off"></el-input>
        </el-form-item>
                <el-form-item label="部门介绍">
          <el-input v-model="dept.introduce" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveDept">确 定</el-button>
      </div>
    </el-dialog>
</template>

<script>
import {organList,save,find,remove} from "@/api/base/dept"
export default {
 data () {
     return {
      //添加部门的模型
      parentId:'',
      dialogFormVisible:false,
      dept:{}
     }
 },
  methods: {
    saveDept() {
      this.dept.parentId = this.parentId
      save(this.dept).then(res => {
        this.$message({
          message: res.data.message,
          type: res.data.code==0?'success':'error'
        });
        //保存成功
        if(res.data.success) {
          alert(1)
          //如果成功
          location.reload();
        }
      })
    }
  }
}
</script>

<style>

</style>
