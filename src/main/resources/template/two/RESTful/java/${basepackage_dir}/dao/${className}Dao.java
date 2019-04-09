<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

import ${basepackage}.dto.custom.${className}Dto;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

/**
 * ${className}Dao
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Repository
public interface ${className}Dao extends Mapper<${className}Dto> {

    /**
     * 列表
     * @param ${classNameLower}Dto
     * @return java.util.List<${basepackage}.dto.custom.${className}Dto;>
     * @author ${author}
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    public List<${className}Dto> findPageInfo(${className}Dto ${classNameLower}Dto);
}