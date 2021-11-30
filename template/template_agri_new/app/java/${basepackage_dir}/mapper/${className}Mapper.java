<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${basepackage}.entity.${className}Entity;

/**
 * @Description:
 * @Author: template
 * @Create: ${now?string('yyyy-MM-dd HH:mm:ss')}
 **/

public interface ${className}Mapper extends BaseMapper<${className}Entity> {


}