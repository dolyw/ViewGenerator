<#include "/macro.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<template>
  <div>
    <!-- 查询表单 -->
    <el-form :inline="true" :model="searchForm" label-width="100px" size="small">

      <#list table.columns as column>
      <el-form-item label="${column.columnAlias!}">
        <el-input v-model.trim="searchForm.${column.columnNameLower}" placeholder="请输入${column.columnAlias!}" clearable />
      </el-form-item>
      </#list>

      <el-row type="flex">
        <el-form-item>
          <el-button type="primary" v-if="isAuth('${moduleName}:${classNameLower}:list')" icon="el-icon-search" @click="list(searchForm)">查询</el-button>
          <el-button type="primary" v-if="isAuth('${moduleName}:${classNameLower}:add')" icon="el-icon-plus" @click="preById(null)">新增</el-button>
        </el-form-item>
      </el-row>

    </el-form>

    <!-- 数据表格 -->
    <el-table :data="tableData" v-loading="tableLoading" border style="width: 100%">

      <#list table.columns as column>
      <el-table-column prop="${column.columnNameLower}" label="${column.columnAlias!}" align="center" min-width="100" show-overflow-tooltip />
      </#list>

      <el-table-column label="操作" align="center" fixed="right" min-width="100">
        <template slot-scope="scope">
          <el-button type="text" v-if="isAuth('${moduleName}:${classNameLower}:update')" @click="preById(scope.row.<#list table.columns as column><#if column.pk>${column.columnNameLower}</#if></#list>)">编辑</el-button>
          <el-button type="text" v-if="isAuth('${moduleName}:${classNameLower}:delete')" @click="delById(scope.row.<#list table.columns as column><#if column.pk>${column.columnNameLower}</#if></#list>)">删除</el-button>
        </template>
      </el-table-column>

    </el-table>

    <div align="right" style="margin-top:10px;">
      <el-pagination
        :current-page="searchForm.page"
        :page-sizes="[20, 40, 60, 80]"
        :page-size="searchForm.rows"
        :total="totalCount"
        layout="total, sizes, prev, pager, next, jumper"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"/>
    </div>

    <!-- 弹窗 -->
    <edit ref="edit" @refreshTableData="list(searchForm)"></edit>
  </div>
</template>

<script>
import Edit from './${classNameLower}Edit'
import * as ${classNameLower} from '@/api/${moduleName}/${classNameLower}'

export default {
  name: '${className}',
  data () {
    return {
      // 表格加载条控制
      tableLoading: false,
      // Table数据
      tableData: [],
      // Table数据总条数
      totalCount: 0,
      // 查询表单属性
      searchForm: {
        // 当前页
        page: 1,
        // 每页条数
        rows: 20,
        <#list table.columns as column>
        '${column.columnNameLower}': null<#if column_has_next>,</#if>
        </#list>
      }
    }
  },
  components: {
    Edit
  },
  // 启动时就执行
  mounted: function () {

  },
  // 获取活动窗口
  activated () {
    // 列表查询
    this.list(this.searchForm)
  },
  methods: {
    // 每页条数改变
    handleSizeChange: function (rows) {
      this.searchForm.rows = rows
      // 刷新列表
      this.list(this.searchForm)
    },
    // 当前页数改变
    handleCurrentChange: function (page) {
      this.searchForm.page = page
      // 刷新列表
      this.list(this.searchForm)
    },
    // 列表查询
    list: function (searchForm) {
      // 加载显示
      this.tableLoading = true
      ${classNameLower}.list(searchForm).then(response => {
        const data = response.data.data
        this.tableData = data.data
        this.totalCount = data.count
        // 加载完成
        this.tableLoading = false
      })
    },
    // 调用子组件的preById方法
    preById: function (<#list table.columns as column><#if column.pk>${column.columnNameLower}</#if></#list>) {
      // this.$nextTick Dom渲染完执行
      /* this.$nextTick(() => {
        this.$refs.edit.preById(<#list table.columns as column><#if column.pk>${column.columnNameLower}</#if></#list>)
      }) */
      this.$refs.edit.preById(<#list table.columns as column><#if column.pk>${column.columnNameLower}</#if></#list>)
    },
    // 删除
    delById: function (<#list table.columns as column><#if column.pk>${column.columnNameLower}</#if></#list>) {
      this.$confirm('是否确定删除？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // 确定执行删除
        ${classNameLower}.delById(<#list table.columns as column><#if column.pk>${column.columnNameLower}</#if></#list>).then(response => {
          const data = response.data
          this.$message({
            type: 'success',
            message: data.msg
          })
          // 刷新列表
          this.list(this.searchForm)
        })
      }).catch(() => {

      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>