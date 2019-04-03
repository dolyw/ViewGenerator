<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

import java.util.List;

import ${basepackage}.dto.custom.${className}Dto;
import ${commonspackage}.dao.BaseDao;

/**
 * ${className}Dao
 * @author Generator
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public interface ${className}Dao extends BaseDao<${className}Dto> {

    public List<${className}Dto> findPageInfo(${className}Dto ${classNameLower}Dto);

}