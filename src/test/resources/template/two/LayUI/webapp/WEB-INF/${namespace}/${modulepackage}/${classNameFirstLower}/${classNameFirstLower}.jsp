<#assign className = table.className> 
<#assign classNameLower =className?uncap_first>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title></title>
	<%@ include file="/WEB-INF/jsp/head-layui.jsp"%>
</head>

<body style="background-color: #ECECEC;">

<div class="layui-fluid">
	<!-- 头部间距 -->
	<div class="layui-card"></div>
	<!-- 查询条件 -->
	<div class="layui-card">
		<div class="layui-card-header"><s:message code='${className}Dto.queryTitle'/></div>
		<div class="layui-card-body">
			<form class="layui-form layui-form-pane">
				<!-- 12格栅格布局 layui-row一行 layui-col-md4代表4格 所以一行三个 -->
			<#list table.columns as column>
				<#if (column_index==0)>
				<div class="layui-row layui-form-item">
					<div class="layui-col-md4">
						<label class="layui-form-label"><s:message code="${className}Dto.${column.columnNameLower}" /></label>
						<div class="layui-input-block">
							<input type="text" id="search${column.columnName}" name="search${column.columnName}" class="layui-input" placeholder="<s:message code='commom.input.placeholder' />"/>
						</div>
					</div>
					<#elseif ((column_index%3)!=0)&&(column_has_next)>
					<div class="layui-col-md4">
						<label class="layui-form-label"><s:message code="${className}Dto.${column.columnNameLower}" /></label>
						<div class="layui-input-block">
							<input type="text" id="search${column.columnName}" name="search${column.columnName}" class="layui-input" placeholder="<s:message code='commom.input.placeholder' />"/>
						</div>
					</div>
					<#elseif ((column_index%3)==0)&&(column_has_next)>
				</div>
				<div class="layui-row layui-form-item">
					<div class="layui-col-md4">
						<label class="layui-form-label"><s:message code="${className}Dto.${column.columnNameLower}" /></label>
						<div class="layui-input-block">
							<input type="text" id="search${column.columnName}" name="search${column.columnName}" class="layui-input" placeholder="<s:message code='commom.input.placeholder' />"/>
						</div>
					</div>
					<#elseif ((column_index%3)==0)&&(!column_has_next)>
				</div>
				<div class="layui-row layui-form-item">
					<div class="layui-col-md4">
						<label class="layui-form-label"><s:message code="${className}Dto.${column.columnNameLower}" /></label>
						<div class="layui-input-block">
							<input type="text" id="search${column.columnName}" name="search${column.columnName}" class="layui-input" placeholder="<s:message code='commom.input.placeholder' />"/>
						</div>
					</div>
				</div>
					<#elseif ((column_index%3)!=0)&&(!column_has_next)&&((column_index%3)==1)>
					<div class="layui-col-md4">
						<label class="layui-form-label"><s:message code="${className}Dto.${column.columnNameLower}" /></label>
						<div class="layui-input-block">
							<input type="text" id="search${column.columnName}" name="search${column.columnName}" class="layui-input" placeholder="<s:message code='commom.input.placeholder' />"/>
						</div>
					</div>
				</div>
					<#elseif ((column_index%3)!=0)&&(!column_has_next)&&((column_index%3)==2)>
					<div class="layui-col-md4">
						<label class="layui-form-label"><s:message code="${className}Dto.${column.columnNameLower}" /></label>
						<div class="layui-input-block">
							<input type="text" id="search${column.columnName}" name="search${column.columnName}" class="layui-input" placeholder="<s:message code='commom.input.placeholder' />"/>
						</div>
					</div>
				</div>
				<#else>
				</#if>
			</#list>

				<div class="layui-row layui-form-item">
					<div class="layui-col-md2 layui-col-md-offset5" >
						<button id="${classNameLower}TableQuery" type="button" class="layui-btn layui-btn-normal"><s:message code="common.button.query" /></button>
						<button id="${classNameLower}TableReset" type="reset" class="layui-btn layui-btn-danger"><s:message code="common.button.reset" /></button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- 数据表格 -->
	<div class="layui-card">
		<div class="layui-card-header"><s:message code='${className}Dto.manage'/></div>
		<div class="layui-card-body">
			<table class="layui-hide" id="${classNameLower}Table" lay-filter="${classNameLower}Table"></table>
		</div>
	</div>
	<!-- 尾部间距 -->
	<div class="layui-card"></div>
</div>
			
<!-- 头部工具栏按钮 -->
<script type="text/html" id="${classNameLower}ToolBar">
	<div class="layui-btn-container">
		<button class="layui-btn" lay-event="add">新增</button>
		<button class="layui-btn" lay-event="del">删除</button>
		<button class="layui-btn" lay-event="export">导出</button>
	</div>
</script>

<!-- 表格工具栏按钮 -->
<script type="text/html" id="${classNameLower}Bar">
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
	<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit">修改</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<!-- 数据弹框 -->
<div id="${classNameLower}Content" style="display: none;">
	<!-- 头部间距 -->
	<div class="layui-card"></div>
	<!-- 表单向导 -->
	<div id="${classNameLower}SmartWizard" class="layui-fluid">
		<ul>
			<li><a href="#${classNameLower}Step-1">Step 1<br/><small>开始配置信息</small></a></li>
			<li><a href="#${classNameLower}Step-2">Step 2<br/><small>信息配置完成</small></a></li>
		</ul>
		<br/>
		<div id="${classNameLower}Step">
			<div id="${classNameLower}Step-1">
				<form class="layui-form layui-form-pane" id="${classNameLower}Form">
					<!-- 12格栅格布局 layui-row一行 layui-col-md4代表4格 所以一行三个 -->
					<div class="layui-row layui-form-item" style="display: none;">
						<!-- 隐藏属性值行为类型actionType -->
						<input type="hidden" id="actionType" name="actionType"/>
						<!-- 隐藏表单校验按钮 lay-submit不可少 lay-filter对应form的ID -->
						<input type="button" id="${classNameLower}FormVerify" lay-submit lay-filter="${classNameLower}Form" />
					</div>
					<#list table.columns as column>
					<#if (column_index==0)>
					<div class="layui-row layui-form-item">
						<div class="layui-col-md4">
							<label class="layui-form-label"><s:message code="${className}Dto.${column.columnNameLower}" /></label>
							<div class="layui-input-block">
								<input type="text" id="${column.columnNameLower}" name="${column.columnNameLower}" lay-verType="tips" lay-verify="required" class="layui-input" placeholder="<s:message code='commom.input.placeholder' />"/>
							</div>
						</div>
						<#elseif ((column_index%3)!=0)&&(column_has_next)>
						<div class="layui-col-md4">
							<label class="layui-form-label"><s:message code="${className}Dto.${column.columnNameLower}" /></label>
							<div class="layui-input-block">
								<input type="text" id="${column.columnNameLower}" name="${column.columnNameLower}" lay-verType="tips" lay-verify="required" class="layui-input" placeholder="<s:message code='commom.input.placeholder' />"/>
							</div>
						</div>
						<#elseif ((column_index%3)==0)&&(column_has_next)>
					</div>
					<div class="layui-row layui-form-item">
						<div class="layui-col-md4">
							<label class="layui-form-label"><s:message code="${className}Dto.${column.columnNameLower}" /></label>
							<div class="layui-input-block">
								<input type="text" id="${column.columnNameLower}" name="${column.columnNameLower}" lay-verType="tips" lay-verify="required" class="layui-input" placeholder="<s:message code='commom.input.placeholder' />"/>
							</div>
						</div>
						<#elseif ((column_index%3)==0)&&(!column_has_next)>
					</div>
					<div class="layui-row layui-form-item">
						<div class="layui-col-md4">
							<label class="layui-form-label"><s:message code="${className}Dto.${column.columnNameLower}" /></label>
							<div class="layui-input-block">
								<input type="text" id="${column.columnNameLower}" name="${column.columnNameLower}" lay-verType="tips" lay-verify="required" class="layui-input" placeholder="<s:message code='commom.input.placeholder' />"/>
							</div>
						</div>
					</div>
						<#elseif ((column_index%3)!=0)&&(!column_has_next)&&((column_index%3)==1)>
						<div class="layui-col-md4">
							<label class="layui-form-label"><s:message code="${className}Dto.${column.columnNameLower}" /></label>
							<div class="layui-input-block">
								<input type="text" id="${column.columnNameLower}" name="${column.columnNameLower}" lay-verType="tips" lay-verify="required" class="layui-input" placeholder="<s:message code='commom.input.placeholder' />"/>
							</div>
						</div>
					</div> 
						<#elseif ((column_index%3)!=0)&&(!column_has_next)&&((column_index%3)==2)>
						<div class="layui-col-md4">
							<label class="layui-form-label"><s:message code="${className}Dto.${column.columnNameLower}" /></label>
							<div class="layui-input-block">
								<input type="text" id="${column.columnNameLower}" name="${column.columnNameLower}" lay-verType="tips" lay-verify="required" class="layui-input" placeholder="<s:message code='commom.input.placeholder' />"/>
							</div>
						</div>
					</div>
					<#else>
					</#if>
				</#list>
				</form>
			</div>
			<div id="${classNameLower}Step-2">
				配置完成页面
			</div>
		</div>
	</div>
</div>
	
<script type="text/javascript">
<#list table.columns as column>
	var ${column.columnNameLower}Desc='<s:message code="${className}Dto.${column.columnNameLower}" />';
</#list>
</script>
<script language="Javascript" src="${r'${'}ctx${r'}'}/js/${modulepackage}/${classNameLower}/${classNameLower}.js"></script>
</body>

</html>