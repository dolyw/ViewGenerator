<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import ${basepackage}.dao.${className}Dao;
import ${basepackage}.dto.custom.${className}Dto;
import ${basepackage}.service.I${className}Service;
import java.util.List;

/**
 * ${className}ServiceImpl
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Service("${classNameLower}Service")
public class ${className}ServiceImpl extends ServiceImpl<${className}Dao,${className}Dto> implements I${className}Service {

    @Autowired
    private ${className}Dao ${classNameLower}Dao;

    /**
     * 列表
     * @param ${classNameLower}Dto
     * @return java.util.List<${basepackage}.dto.custom.${className}Dto;>
     * @author ${author}
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @Override
    public List<${className}Dto> findPageInfo(${className}Dto ${classNameLower}Dto) {
        return ${classNameLower}Dao.findPageInfo(${classNameLower}Dto);
    }
}