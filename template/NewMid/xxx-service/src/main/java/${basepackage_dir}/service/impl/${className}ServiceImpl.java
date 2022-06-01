<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import ${basepackage}.dto.${className}Dto;
import ${basepackage}.mapper.${className}Mapper;
import ${basepackage}.service.${className}Service;

/**
 * ${className}ServiceImpl
 *
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Slf4j
@Service("${classNameLower}Service")
public class ${className}ServiceImpl extends ServiceImpl<${className}Mapper, ${className}Dto> implements ${className}Service {

}