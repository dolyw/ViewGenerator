<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.dto.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ${className}DtoBase
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public class ${className}DtoBase implements Serializable {

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
    <#if (column.columnNameLower != 'createdDate')&&(column.columnNameLower != 'updatedDate')>
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    <#elseif (column.columnNameLower == 'createdDate')>
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    <#elseif (column.columnNameLower == 'updatedDate')>
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    <#else>
    </#if>
    private ${column.javaType} ${column.columnNameLower};

    <#else>
    <#if column.pk>
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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