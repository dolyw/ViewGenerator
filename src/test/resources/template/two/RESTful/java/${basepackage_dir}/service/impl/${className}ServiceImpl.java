<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sinosoft.core.service.impl.BaseServiceImpl;

import ${basepackage}.dao.${className}Dao;
import ${basepackage}.dto.custom.${className}Dto;
import ${basepackage}.service.I${className}Service;
import java.util.List;

/**
 * ${className}ServiceImpl
 * @author Generator
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Service("${classNameLower}Service")
public class ${className}ServiceImpl extends BaseServiceImpl<${className}Dto> implements I${className}Service {

    @Autowired
    private ${className}Dao ${classNameLower}Dao;

    @Override
    public List<${className}Dto> findPageInfo(${className}Dto ${classNameLower}Dto) {
        return ${classNameLower}Dao.findPageInfo(${classNameLower}Dto);
    }
}