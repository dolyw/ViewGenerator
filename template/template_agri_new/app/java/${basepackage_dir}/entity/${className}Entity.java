<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import ${commonspackage}.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Description:
 * @Author: template
 * @Create: ${now?string('yyyy-MM-dd HH:mm:ss')}
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value="${table.sqlName}")
public class ${className}Entity extends BaseEntity {

    private static final long serialVersionUID = 1L;
    <@generateFieldsNew/>

    <#macro generateFieldsNew>
    <#--自定义函数，根据数据库中表字段生成java中的属性 -->
    <#list table.columns as column>
    <#if column.isDateTimeColumn>
    <#if (column.columnNameLower != 'createdTime')&&(column.columnNameLower != 'updatedTime')>

    /** ${column.columnAlias!} */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private ${column.javaType} ${column.columnNameLower};
    <#elseif (column.columnNameLower == 'createdTime')>
    <#elseif (column.columnNameLower == 'updatedTime')>
    <#else>
    </#if>
    <#else>
    <#if (column.columnNameLower != 'createdBy')&&(column.columnNameLower != 'updatedBy')&&(column.columnNameLower != 'deletedInd') >

    /** ${column.columnAlias!} */
    <#if column.pk>
    <#if (column.javaType == 'String')>
    @TableId(type = IdType.INPUT)
    <#else>
    @TableId(type = IdType.AUTO)
    </#if>
    </#if>
    private ${column.javaType} ${column.columnNameLower};
    </#if>
    </#if>     
    </#list>
    </#macro>
}