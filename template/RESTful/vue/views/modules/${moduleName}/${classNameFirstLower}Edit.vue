<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableAlias = table.tableAlias>
<template>
  <div>
    <!-- 弹出框 -->
    <el-dialog :title="!isEdit ? '新增' : '修改'" :close-on-click-modal="false"
        :visible.sync="dialogVisible" width="30%" :before-close="handleClose">

      <el-form v-loading="submitLoading" :model="${classNameLower}Dto" :rules="${classNameLower}DtoRules" ref="${classNameLower}Dto" label-width="100px" status-icon>

        <#list table.columns as column>
        <el-form-item label="${column.columnAlias!}" prop="${column.columnNameLower}">
          <el-input v-model.trim="${classNameLower}Dto.${column.columnNameLower}" <#if column.pk>:disabled="!isEdit ? false : true"</#if> placeholder="请输入${column.columnAlias!}"></el-input>
        </el-form-item>
        </#list>

      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button @click="resetForm">取 消</el-button>
        <el-button type="primary" @click="submitForm">提 交</el-button>
      </div>

    </el-dialog>
  </div>
</template>

<script>
import * as ${classNameLower} from '@/api/${moduleName}/${classNameLower}'

export default {
  data () {
    return {
      // 提交按钮加载
      submitLoading: false,
      // 弹出框是否显示
      dialogVisible: false,
      // 是否修改
      isEdit: false,
      // 表单新增编辑属性
      ${classNameLower}Dto: {
        <#list table.columns as column>
        '${column.columnNameLower}': null<#if column_has_next>,</#if>
        </#list>
      },
      // 表单检验规则
      ${classNameLower}DtoRules: {
      <#list table.columns as column>
        ${column.columnNameLower}: [
            { required: true, message: '请输入${column.columnAlias!}', trigger: 'blur' }
        ]<#if column_has_next>,</#if>
      </#list>
      }
    }
  },
  // 启动时就执行
  mounted: function () {

  },
  methods: {
    // 提交新增或更新
    submitForm () {
      this.submitLoading = true
      this.$refs.${classNameLower}Dto.validate((valid) => {
        if (valid) {
          if (this.isEdit) {
            ${classNameLower}.update(this.${classNameLower}Dto).then(response => {
              // 执行成功重置表单且弹出提示信息
              this.resetForm()
              this.$message({
                type: 'success',
                message: response.data.msg
              })
            }).catch(error => {
              console.log(error)
            }).then(() => {
              // always executed 类似finally
              this.submitLoading = false
            })
          } else {
            ${classNameLower}.add(this.${classNameLower}Dto).then(response => {
              // 执行成功重置表单且弹出提示信息
              this.resetForm()
              this.$message({
                type: 'success',
                message: response.data.msg
              })
            }).catch(error => {
              console.log(error)
            }).then(() => {
              // always executed 类似finally
              this.submitLoading = false
            })
          }
        } else {
          this.submitLoading = false
          return false
        }
      })
    },
    // 重置
    resetForm () {
      // 清空表单
      this.$refs.${classNameLower}Dto.resetFields()
      // 关闭弹窗
      this.dialogVisible = false
      // 刷新父组件列表
      // this.$parent.list(this.$parent.searchForm)
      // 父子组件事件监听刷新父组件列表
      this.$emit('refreshTableData')
      this.submitLoading = false
    },
    // 准备新增或更新
    preById: function (<#list table.columns as column><#if column.pk>${column.columnNameLower}</#if></#list>) {
      // id不为空更新
      if (<#list table.columns as column><#if column.pk>${column.columnNameLower}</#if></#list>) {
        this.submitLoading = true
        this.${classNameLower}Dto.<#list table.columns as column><#if column.pk>${column.columnNameLower}</#if></#list> = <#list table.columns as column><#if column.pk>${column.columnNameLower}</#if></#list>
        ${classNameLower}.findById(<#list table.columns as column><#if column.pk>${column.columnNameLower}</#if></#list>).then(response => {
          const data = response.data.data
          this.${classNameLower}Dto = data
        }).catch(error => {
          console.log(error)
        }).then(() => {
          // always executed 类似finally
          this.submitLoading = false
          this.isEdit = true
        })
      } else {
        // id为空新增清空表单(this.$nextTick Dom渲染完执行)
        this.isEdit = false
        this.${classNameLower}Dto.<#list table.columns as column><#if column.pk>${column.columnNameLower}</#if></#list> = null
        this.$nextTick(() => {
          this.$refs.${classNameLower}Dto.resetFields()
        })
      }
      // 显示弹出框
      this.dialogVisible = true
    },
    // 弹窗关闭事件方法
    handleClose (done) {
      // 重置表单
      this.resetForm()
      done()
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>