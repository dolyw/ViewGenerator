<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import java.util.List;
import java.io.Serializable;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import ${basepackage}.entity.${className}Entity;
import ${basepackage}.domain.dto.${className}Dto;

/**
 * @Description:
 * @Author: template
 * @Create: ${now?string('yyyy-MM-dd HH:mm:ss')}
 **/

public interface ${className}Service extends IService<${className}Entity> {

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    ${className}Dto getDtoById(Serializable id);

    /**
     * 分页列表
     *
     * @param ${classNameLower}Dto
     * @return
     */
    IPage<${className}Dto> pageDto(${className}Dto ${classNameLower}Dto);

    /**
     * 条件列表
     *
     * @param ${classNameLower}Dto
     * @return
     */
    List<${className}Dto> listAllDto(${className}Dto ${classNameLower}Dto);

    /**
     * 新增
     *
     * @param ${classNameLower}Dto
     */
    int addDto(${className}Dto ${classNameLower}Dto);


    /**
     * 根据id更新
     *
     * @param ${classNameLower}Dto
     * @return
     */
    int updateDtoById(${className}Dto ${classNameLower}Dto);

    /**
     * 删除
     *
     * @param ${classNameLower}Dto
     * @return
     */
    int removeDto(${className}Dto ${classNameLower}Dto);

}