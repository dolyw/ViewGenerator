<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ${basepackage}.dto.${className}Dto;
import ${basepackage}.mapper.${className}Mapper;
import ${basepackage}.service.${className}Service;

/**
 * ${className}ServiceImpl
 *
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Service("${classNameLower}Service")
public class ${className}ServiceImpl extends ServiceImpl<${className}Mapper, ${className}Dto> implements ${className}Service {

    /**
     * logger
     */
    private final static Logger logger = LoggerFactory.getLogger(${className}ServiceImpl.class);

}