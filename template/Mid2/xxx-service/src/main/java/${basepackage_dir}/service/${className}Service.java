<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ${basepackage}.dto.${className}Dto;

/**
 * ${className}Service
 *
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public interface ${className}Service extends IService<${className}Dto> {

}