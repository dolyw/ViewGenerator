<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import ${commonspackage}.service.IBaseService;
import ${commonspackage}.mybatis.pagehelper.PageInfo;
import ${basepackage}.dto.custom.${className}Dto;

/**
 * ${className}Service
 * @author Generator
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public interface ${className}Service extends IBaseService<${className}Dto> {

    /**
     * 列表
     * @param ${classNameLower}Dto
     * @return java.util.List<${basepackage}.dto.custom.${className}Dto;>
     * @author Generator
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    public PageInfo<${className}Dto> findPageInfo(int page, int rows, ${className}Dto ${classNameLower}Dto, String orderBy);

}