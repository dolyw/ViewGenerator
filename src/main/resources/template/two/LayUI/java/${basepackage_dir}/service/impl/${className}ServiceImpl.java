<#include "/java_copyright.include">
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${commonspackage}.mybatis.pagehelper.PageHelper;
import ${commonspackage}.mybatis.pagehelper.PageInfo;
import ${commonspackage}.service.BaseService;

import ${basepackage}.dao.${className}Dao;
import ${basepackage}.dto.custom.${className}Dto;
import ${basepackage}.service.${className}Service;

/**
 * ${className}ServiceImpl
 * @author Generator
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Service("${classNameLower}Service")
public class ${className}ServiceImpl extends BaseService<${className}Dto> implements ${className}Service {

    @Autowired
    private ${className}Dao ${classNameLower}Dao;

    @Override
    public PageInfo<${className}Dto> findPageInfo(int page, int rows, ${className}Dto ${classNameLower}Dto, String orderBy) {
        PageHelper.startPage(page, rows, orderBy);
        List<${className}Dto> list = ${classNameLower}Dao.findPageInfo(${classNameLower}Dto);
        return new PageInfo<${className}Dto>(list);
    }

}