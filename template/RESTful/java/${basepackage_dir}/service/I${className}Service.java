<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import ${basepackage}.common.IBaseService;
import ${basepackage}.dto.custom.${className}Dto;
import java.util.List;

/**
 * I${className}Service
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public interface I${className}Service extends IBaseService<${className}Dto> {

    /**
     * 列表
     * @param ${classNameLower}Dto
     * @return java.util.List<${basepackage}.dto.custom.${className}Dto;>
     * @author ${author}
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    public List<${className}Dto> findPageInfo(${className}Dto ${classNameLower}Dto);
}