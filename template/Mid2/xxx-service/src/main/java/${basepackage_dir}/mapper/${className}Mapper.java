<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${basepackage}.dto.${className}Dto;
import org.springframework.stereotype.Repository;

/**
 * ${className}Mapper
 *
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Repository
public interface ${className}Mapper extends BaseMapper<${className}Dto> {

}