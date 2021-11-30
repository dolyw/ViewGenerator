<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.dto;

import ${commonspackage}.dto.entity.${className}Entity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * ${className}Dto
 *
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@ApiModel(value = "${table.tableAlias}对象", description = "${table.tableAlias}对象")
@Data
@TableName(value="${table.sqlName}")
public class ${className}Dto extends ${className}Entity {

    private static final long serialVersionUID = ${className}Dto.class.getName().hashCode();

}