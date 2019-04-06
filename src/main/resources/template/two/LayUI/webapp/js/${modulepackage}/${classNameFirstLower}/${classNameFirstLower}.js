<#assign className = table.className> 
<#assign classNameLower =className?uncap_first>
/* ------------------------------  LayUI已初始化  ------------------------------ */
/* ------------------------------  基础初始化 Start  ------------------------------ */
// 数据表格绑定
var ${classNameLower}Table = table.render({
    elem: '#${classNameLower}Table',
    url: contextPath + '${classNameLower}/list',
    id: '${classNameLower}Table',
    contentType: 'application/json',
    // 头部工具栏按钮绑定
    toolbar: '#${classNameLower}ToolBar',
    // 右上角筛选打印
    defaultToolbar: ['filter', 'print'],
    method : 'post',
    loading: true,
    // 查询条件
    where: {
        // 排序字段
        field: "created_date",
        // 排序方式
        order: "desc"
    },
    cols: [[
        {type: 'checkbox', align:'center'},
        <#list table.columns as column>
        <#if (column.columnNameLower=='invalidFlag')>
        {field: '${column.columnNameLower}', title: ${column.columnNameLower}Desc, align: 'center', sort: true, templet: function(obj) {
            if (obj.invalidFlag == 0) {
                return '有效';
            } else {
                return '无效';
            }
        }},
        <#else>
        {field: '${column.columnNameLower}', title: ${column.columnNameLower}Desc, align: 'center', sort: true},
        </#if>
        </#list>
        // 表格行工具栏按钮绑定
        {fixed: 'right', title:'操作', toolbar: '#${classNameLower}Bar', align:'center', minWidth: '180'}
    ]],
    page: true,
    limits: [10, 20, 30, 40, 50, 100, 150, 200, 300]
});

// 数据表格监听头部工具栏按钮触发事件
table.on('toolbar(${classNameLower}Table)', function(obj) {
    var checkStatus = table.checkStatus('${classNameLower}Table'), data = checkStatus.data;
    // data当前选中行数据数组
    switch(obj.event){
        case 'add':
            // 执行预新增方法
            prepareInsert();
            break;
        case 'del':
            // 执行预删除方法
            if (data.length < 1) {
                layer.msg('请最少选择一条数据');
            } else {
                prepareDelete(data);
            }
            break;
        case 'export':
            // 执行导出选中数据
            exportFile(data);
            break;
    };
});

// 数据表格行监听表格工具栏按钮触发事件
table.on('tool(${classNameLower}Table)', function(obj){
    // obj.data当前行数据，obj.event当前行点击事件
    if (obj.event === 'detail') {
        // 点击查看按钮触发事件
        viewDetail(obj.data);
    } else if (obj.event === 'edit') {
        // 点击修改按钮触发事件
        prepareUpdate(obj.data);
    } else if (obj.event === 'del') {
        // 点击删除按钮触发事件，将本身包装成数组调用批量删除方法
        var list = [];
        list.push(obj.data);
        prepareDelete(list);
    }
});

// 表单监听数据弹框提交事件
form.on('submit(${classNameLower}Form)', function(data) {
    // data.field为当前提交form数据
    // console.log(JSON.stringify(data.field));
    // 执行保存或更新
    deal${classNameLower}();
    // 返回false防止页面刷新
    return false;
});

// 表单向导初始化
$('#${classNameLower}SmartWizard').smartWizard({
    // 默认第一页
    selected: 0,
    // 主题
    theme: 'dots',
    // 下一步效果渐隐
    transitionEffect: 'fade',
    // 隐藏默认按钮，添加自定义按钮
    toolbarSettings: {
        showNextButton: false,
        showPreviousButton: false,
        toolbarExtraButtons: [
            $('<button id="prevBtn"></button>').text('上一步').addClass('layui-btn layui-btn-normal')
                .on('click', function(){ $('#${classNameLower}SmartWizard').smartWizard("prev"); }),
            $('<button id="nextBtn"></button>').text('下一步').addClass('layui-btn layui-btn-normal')
                .on('click', function(){ $('#${classNameLower}SmartWizard').smartWizard("next"); }),
            $('<button id="finishBtn"></button>').text('完成').addClass('layui-btn layui-btn-normal')
                .on('click', function(){ layer.closeAll(); }),
            $('<button id="resetBtn"></button>').text('重置').addClass('layui-btn layui-btn-danger')
                .on('click', function(){ cleanData(); })
        ]
    }
});

// 表单向导操作按钮显示
$("#${classNameLower}SmartWizard").on("showStep", function(e, anchorObject, stepNumber, stepDirection, stepPosition) {
    // stepNumber当前是第几页，从0开始
    // stepDirection行为描述，点击下一步为forward，上一步为backward
    // stepPosition第一页是first，最后一页是final，中间页为middle
    // 第一页和最后一页上下步按钮控制是否可用，完成按钮只有最后一页可见
    if (stepPosition === 'first') {
        $("#prevBtn").removeClass('layui-btn-normal').addClass('layui-btn-disabled');
        $("#nextBtn").removeClass('layui-btn-disabled').addClass('layui-btn-normal');
        $("#finishBtn").hide();
    } else if (stepPosition === 'final') {
        $("#prevBtn").removeClass('layui-btn-disabled').addClass('layui-btn-normal');
        $("#nextBtn").removeClass('layui-btn-normal').addClass('layui-btn-disabled');
        $("#finishBtn").show();
    } else {
        $("#prevBtn").removeClass('layui-btn-disabled').addClass('layui-btn-normal');
        $("#nextBtn").removeClass('layui-btn-disabled').addClass('layui-btn-normal');
        $("#finishBtn").hide();
    }
});

// 表单向导操作按钮事件
$("#${classNameLower}SmartWizard").on("leaveStep", function(e, anchorObject, stepNumber, stepDirection) {
    // stepNumber当前是第几页，从0开始
    // stepDirection行为描述，点击下一步为forward，上一步为backward
    // 行为类型actionType不为查看
    if ($("#actionType").val() != "V") {
        // 第1页点击下一步事件
        if (stepNumber == "0" && stepDirection == "forward") {
            // 校验表单
            $("#${classNameLower}FormVerify").trigger("click");
            // 判断是否校验通过，校验红框数大于0说明校验不通过
            if ($("input.layui-form-danger").length > 0) {
                return false;
            } else {
                return true;
            }
        }
    }
});

// 数据表格查询按钮绑定事件
$('#${classNameLower}TableQuery').on('click', function() {
    // 调用查询(数据表格重载)方法
    reloadTable();
});
/* ------------------------------  基础初始化 End  ------------------------------ */

/* ------------------------------  自定义初始化 Start  ------------------------------ */

// 自定义初始化代码.....

/* ------------------------------  自定义初始化 End  ------------------------------ */

/* ------------------------------  基础执行方法 Start  ------------------------------ */
/**
 * 查询(数据表格重载)方法
 */
function reloadTable() {
    ${classNameLower}Table = table.reload('${classNameLower}Table', {
        page: {
            // 重新定位当前页
            // curr: userTable.config.page.curr
            // 重新定位第一页
            curr: 1
        },
        where: {
            // 排序字段
            field: "created_date",
            // 排序方式
            order: "desc",
            // 查询条件
            <#list table.columns as column>
            "${column.columnNameLower}": $.trim($("#search${column.columnName}").val())<#if column_has_next>,</#if>
            </#list>
        }
    });
}

/**
 * 预新增方法
 */
function prepareInsert() {
    $("#actionType").val("I");
    // 新增数据弹框打开
    var prepareInsertOpen = layer.open({
        type: 1,
        title: '新增',
        area: ['992px', '480px'],
        content: $('#${classNameLower}Content'),
        // 关闭窗口隐藏数据弹框内容，防止显示出来
        end: function(index, layero){
            $('#${classNameLower}Content').hide();
        }
    });
    // 最大化窗口
    layer.full(prepareInsertOpen);
    // 清除数据弹框数据
    cleanData();
    // 重置表单向导
    $('#${classNameLower}SmartWizard').smartWizard("reset");
}

/**
 * 预修改方法
 */
function prepareUpdate(data) {
    $("#actionType").val("U");
    // 修改数据弹框打开
    var prepareUpdateOpen = layer.open({
        type: 1,
        title: '修改',
        area: ['992px', '480px'],
        content: $('#${classNameLower}Content'),
        // 关闭窗口隐藏数据弹框内容，防止显示出来
        end: function(index, layero){
            $('#${classNameLower}Content').hide();
        }
    });
    // 最大化窗口
    layer.full(prepareUpdateOpen);
    // 清除数据弹框数据
    cleanData();
    // 写入数据弹框数据
    writeData(data);
    // 表单向导重置
    $('#${classNameLower}SmartWizard').smartWizard("reset");
    // 表单向导开启全部可点击，获取当前可li下所有同胞元素添加done移除disabled即可点击
    $("#${classNameLower}SmartWizard ul li[class='active']").siblings().addClass("done").removeClass("disabled");
}

/**
 * 查看方法
 */
function viewDetail(data) {
    $("#actionType").val("V");
    // 查看数据弹框打开
    var viewDetailOpen = layer.open({
        type: 1,
        title: '查看',
        area: ['992px', '480px'],
        content: $('#${classNameLower}Content'),
        // 关闭窗口隐藏数据弹框内容，防止显示出来
        end: function(index, layero){
            $('#${classNameLower}Content').hide();
        }
    });
    // 最大化窗口
    layer.full(viewDetailOpen);
    // 清除数据弹框数据
    cleanData();
    // 写入数据弹框数据
    writeData(data);
    // 使数据弹框数据只读
    lockData();
    // 表单向导重置
    $('#${classNameLower}SmartWizard').smartWizard("reset");
    // 表单向导开启全部可点击，获取当前可li下所有同胞元素添加done移除disabled即可点击
    $("#${classNameLower}SmartWizard ul li[class='active']").siblings().addClass("done").removeClass("disabled");
    // 隐藏表单向导操作按钮
    $("#${classNameLower}SmartWizard nav").hide();

}

/**
 * 新增或修改方法
 */
function deal${classNameLower}() {
    // 判断是新增或修改
    var url = null;
    if ($("#actionType").val() == "I") {
        url = contextPath + "${classNameLower}/insert";
    } else {
        url = contextPath + "${classNameLower}/update";
    }
    var data = getData();
    // 请求后台
    axios.post(url, data).then(function (response) {
        var data = response.data;
        if (data.flag == "N") {
            layer.alert(data.msg);
        } else {
            // 提示信息
            layer.msg(data.msg);
            reloadTable();
        }
    }).catch(function (error) {
        layer.alert(error.toString());
        console.log(error);
    });
}

/**
 * 预删除方法
 */
function prepareDelete(list) {
    layer.confirm('确定删除吗', function(index){
        deleteSure(list);
        layer.close(index);
    });
}

/**
 * 删除方法
 */
function deleteSure(list) {
    // 请求后台
    axios.post(contextPath + '${classNameLower}/delete', {
        "extend" : {
            "${classNameLower}List" : JSON.stringify(list)
        }
    }).then(function (response) {
        var data = response.data;
        if (data.flag == "N") {
            layer.alert(data.msg);
        } else {
            layer.msg(data.msg);
            reloadTable();
        }
    }).catch(function (error) {
        layer.alert(error.toString());
        console.log(error);
    });
}

/**
 * 导出数据方法
 */
function exportFile(data) {
    layui.use(['excel', 'xlsx', 'FileSaver'], function() {
        // 初始化excel模块
        var excel = layui.excel;
        try {
            // 判断数据是否大于0
            if (data.length > 0) {
                // 1. 数组头部新增表头
                data.unshift({
                    <#list table.columns as column>
                    ${column.columnNameLower}: ${column.columnNameLower}Desc<#if column_has_next>,</#if>
                    </#list>
                });
                // 2. 如果需要调整顺序，请执行梳理函数
                var excelData = excel.filterExportData(data, [
                    <#list table.columns as column>
                    "${column.columnNameLower}"<#if column_has_next>,</#if>
                    </#list>
                ]);
                // 3. 执行导出函数，系统会弹出弹框
                excel.exportExcel({
                    sheet1: excelData
                }, '${className}.xlsx', 'xlsx');
                layer.msg('导出成功');
            } else {
                layer.msg("请最少选择一条数据");
            }
        } catch (e) {
            layer.alert('导出错误:' + e.toString());
        }
    });
}
/* ------------------------------  基础执行方法 End  ------------------------------ */

/* ------------------------------  基础通用方法 Start  ------------------------------ */
/**
 * 获取数据弹框数据方法
 */
function getData() {
    return {
        <#list table.columns as column>
        "${column.columnNameLower}": $.trim($("#${column.columnNameLower}").val())<#if column_has_next>,</#if>
        </#list>
    }
}

/**
 * 清除数据弹框数据方法
 */
function cleanData() {
    <#list table.columns as column>
    $('#${column.columnNameLower}').prop("disabled", false).val('');
    </#list>
}

/**
 * 写入数据弹框数据方法
 */
function writeData(data) {
    // 显示加载
    $('#${classNameLower}Content').loading("show");
    // 请求后台
    axios.post(contextPath + '${classNameLower}/prepareUpdate', {
        <#list table.compositeIdColumns as column>
        '${column.columnNameLower}': data.${column.columnNameLower}<#if column_has_next>,</#if>
        </#list>
    }).then(function (response) {
        var data = response.data;
        if (data.flag == "N") {
            layer.alert(data.msg);
        } else {
            var ${classNameLower}Dto = data.${classNameLower}Dto;
            <#list table.columns as column>
            $('#${column.columnNameLower}').val(${classNameLower}Dto.${column.columnNameLower});
            </#list>
            // 关闭加载
            $('#${classNameLower}Content').loading("destroy");
        }
    }).catch(function (error) {
        layer.alert(error.toString());
        console.log(error);
    });
}

/**
 * 使数据弹框数据只读方法
 */
function lockData() {
    <#list table.columns as column>
    $('#${column.columnNameLower}').prop("disabled", true);
    </#list>
}

/* ------------------------------  基础通用方法 End  ------------------------------ */

/* ------------------------------  自定义方法 Start  ------------------------------ */

// 自定义方法.....

/* ------------------------------  自定义方法 End  ------------------------------ */