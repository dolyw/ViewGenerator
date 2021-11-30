<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.dto.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonFormat;

import ${compackage}.common.dto.BaseDto;

/**
 * ${className}DtoBase
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public class ${className}DtoBase extends BaseDto implements Serializable {

    private static final long serialVersionUID = ${className}DtoBase.class.getName().hashCode();

    <@generateFieldsNew/>
    <@generateProperties/>

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    <#macro generateFieldsNew>
    <#--自定义函数，根据数据库中表字段生成java中的属性 -->
    <#list table.columns as column>
    /** ${column.columnAlias!} */
    <#if column.isDateTimeColumn>
    <#if (column.columnNameLower != 'inserttimeforhis')&&(column.columnNameLower != 'operatetimeforhis')>
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    <#elseif (column.columnNameLower == 'inserttimeforhis')>
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    <#elseif (column.columnNameLower == 'operatetimeforhis')>
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    <#else>
    </#if>
    private ${column.javaType} ${column.columnNameLower};

    <#else>
    <#if column.pk>
    @TableId
    </#if>
    private ${column.javaType} ${column.columnNameLower};

    </#if>
    </#list>
    </#macro>


    <#macro generateProperties>
    <#list table.columns as column>

    /**
     * 获取属性${column.columnAlias!}的值
     */
    public ${column.javaType} get${column.columnName}() {
        return this.${column.columnNameLower};
    }

    /**
     * 设置属性${column.columnAlias!}的值
     */
    public void set${column.columnName}(${column.javaType} ${column.columnNameLower}) {
        this.${column.columnNameLower} = ${column.columnNameLower};
    }
    </#list>
    </#macro>
}