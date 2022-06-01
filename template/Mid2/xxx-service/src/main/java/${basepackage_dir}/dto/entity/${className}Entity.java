<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.dto.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import ${commonspackage}.core.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ${className}Entity
 *
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Data
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
    @ApiModelProperty(value = "${column.columnAlias!}")
    private ${column.javaType} ${column.columnNameLower};
    <#elseif (column.columnNameLower == 'createdTime')>
    <#elseif (column.columnNameLower == 'updatedTime')>
    <#else>
    </#if>
    <#else>
    <#if (column.columnNameLower != 'createdBy')&&(column.columnNameLower != 'updatedBy')&&(column.columnNameLower != 'invalidFlag') >

    /** ${column.columnAlias!} */
    <#if column.pk>
    <#if (column.javaType == 'String')>
    @TableId(type = IdType.INPUT)
    <#else>
    @TableId(type = IdType.AUTO)
    </#if>
    </#if>
    @ApiModelProperty(value = "${column.columnAlias!}")
    private ${column.javaType} ${column.columnNameLower};
    </#if>
    </#if>     
    </#list>
    </#macro>
}