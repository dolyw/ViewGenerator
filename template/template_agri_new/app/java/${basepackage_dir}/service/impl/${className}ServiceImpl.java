<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import java.io.Serializable;
import java.util.List;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${commonspackage}.core.page.PageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import ${basepackage}.entity.${className}Entity;
import ${basepackage}.mapper.${className}Mapper;
import ${basepackage}.service.${className}Service;
import ${basepackage}.domain.dto.${className}Dto;

/**
 * @Description:
 * @Author: template
 * @Create: ${now?string('yyyy-MM-dd HH:mm:ss')}
 **/

@Slf4j
@Service("${classNameLower}Service")
public class ${className}ServiceImpl extends ServiceImpl<${className}Mapper, ${className}Entity> implements ${className}Service {

    @Override
    public ${className}Dto getDtoById(Serializable id) {
        ${className}Entity ${classNameLower}Entity = baseMapper.selectById(id);
        ${className}Dto ${classNameLower}Dto = new ${className}Dto();
        BeanUtil.copyProperties(${classNameLower}Entity, ${classNameLower}Dto);
        return ${classNameLower}Dto;
    }

    @Override
    public IPage<${className}Dto> pageDto(${className}Dto ${classNameLower}Dto) {
        Page<${className}Entity> page = new Page<>();
        PageHandler.startPage(${classNameLower}Dto, page);
        ${className}Entity ${classNameLower}Entity = new ${className}Entity();
        BeanUtil.copyProperties(${classNameLower}Dto, ${classNameLower}Entity);
        // 根据对象非空字段构造等值查询条件queryWrapper
        QueryWrapper<${className}Entity> queryWrapper = Wrappers.query(${classNameLower}Entity);
        // 其他查询条件需要根据业务情况在此处自行添加
        page = baseMapper.selectPage(page, queryWrapper);
        IPage<${className}Dto> dtoPage = new Page<>();
        BeanUtil.copyProperties(page, dtoPage);
        List<${className}Entity> ${classNameLower}EntityList = page.getRecords();
        List<${className}Dto> ${classNameLower}DtoList = Convert.toList(${className}Dto.class, ${classNameLower}EntityList);
        dtoPage.setRecords(${classNameLower}DtoList);
        return dtoPage;
    }

    @Override
    public List<${className}Dto> listAllDto(${className}Dto ${classNameLower}Dto) {
        ${className}Entity ${classNameLower}Entity = new ${className}Entity();
        BeanUtil.copyProperties(${classNameLower}Dto, ${classNameLower}Entity);
        // 根据对象非空字段构造等值查询条件queryWrapper
        QueryWrapper<${className}Entity> queryWrapper = Wrappers.query(${classNameLower}Entity);
        // 其他查询条件需要根据业务情况在此处自行添加
        List<${className}Entity> ${classNameLower}EntityList = baseMapper.selectList(queryWrapper);
        List<${className}Dto> ${classNameLower}DtoList = Convert.toList(${className}Dto.class, ${classNameLower}EntityList);
        return ${classNameLower}DtoList;
    }

    @Override
    public int addDto(${className}Dto ${classNameLower}Dto) {
        ${className}Entity ${classNameLower}Entity = new ${className}Entity();
        BeanUtil.copyProperties(${classNameLower}Dto, ${classNameLower}Entity);
        return baseMapper.insert(${classNameLower}Entity);
    }

    @Override
    public int updateDtoById(${className}Dto ${classNameLower}Dto) {
        ${className}Entity ${classNameLower}Entity = new ${className}Entity();
        BeanUtil.copyProperties(${classNameLower}Dto, ${classNameLower}Entity);
        return baseMapper.updateById(${classNameLower}Entity);
    }

    @Override
    public int removeDto(${className}Dto ${classNameLower}Dto) {
        ${className}Entity ${classNameLower}Entity = new ${className}Entity();
        BeanUtil.copyProperties(${classNameLower}Dto, ${classNameLower}Entity);
        QueryWrapper<${className}Entity> queryWrapper = Wrappers.query(${classNameLower}Entity);
        return baseMapper.delete(queryWrapper);
    }
}