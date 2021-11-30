<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.dto.custom;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import ${basepackage}.dto.domain.${className}DtoBase;

/**
 * ${className}Dto
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@TableName("${table.sqlName}")
public class ${className}Dto extends ${className}DtoBase implements Serializable {

    private static final long serialVersionUID = ${className}Dto.class.getName().hashCode();

}