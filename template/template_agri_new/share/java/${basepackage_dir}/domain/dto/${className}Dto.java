<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ${commonspackage}.annotation.Excel;
import ${commonspackage}.domain.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;
import java.util.Date;

/**
 * @Description: ${table.sqlName}-${table.tableAlias}的数据传输对象基类,直接与表对应<br>
 * @Author: template
 * @Create: ${now?string('yyyy-MM-dd HH:mm:ss')}
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="${table.tableAlias}数据传输对象", description="${table.tableAlias}数据传输对象")
public class ${className}Dto extends BaseDto {

    private static final long serialVersionUID = 1L;
    <@generateFieldsNew/>

    <#macro generateFieldsNew>
    <#--自定义函数，根据数据库中表字段生成java中的属性 -->
    <#list table.columns as column>
    <#if column.isDateTimeColumn>
    <#if (column.columnNameLower != 'createdTime')&&(column.columnNameLower != 'updatedTime')>

    /** ${column.columnAlias!} */
    @Excel(name = "${column.columnAlias!}", dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "${column.columnAlias!}")
    private ${column.javaType} ${column.columnNameLower};
    <#elseif (column.columnNameLower == 'createdTime')>
    <#elseif (column.columnNameLower == 'updatedTime')>
    <#else>
    </#if>
    <#else>
    <#if (column.columnNameLower != 'createdBy')&&(column.columnNameLower != 'updatedBy')&&(column.columnNameLower != 'deletedInd') >

    /** ${column.columnAlias!} */
    @Excel(name = "${column.columnAlias!}")
    @ApiModelProperty(value = "${column.columnAlias!}")
    private ${column.javaType} ${column.columnNameLower};
    </#if>
    </#if>     
    </#list>
    </#macro>
}