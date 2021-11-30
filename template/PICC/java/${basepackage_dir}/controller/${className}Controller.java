<#include "/java_copyright.include"> 
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import ${commonspackage}.sys.controller.AbstractController;
import ${basepackage}.dto.custom.${className}Dto;
import ${basepackage}.service.I${className}Service;

import io.piccsz.common.dto.ResponseBean;
import io.piccsz.common.exception.CustomException;
import io.piccsz.modules.sys.controller.AbstractController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpStatus;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ${className}Controller
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@RestController
@RequestMapping("${moduleName}/${classNameLower}")
public class ${className}Controller extends AbstractController{

    private final I${className}Service ${classNameLower}Service;

    @Autowired
    public ${className}Controller (I${className}Service ${classNameLower}Service) {
        this.${classNameLower}Service = ${classNameLower}Service;
    }

    /**
     * 列表
     * @author ${author}
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @GetMapping
    public ResponseBean list(${className}Dto ${classNameLower}Dto){
        PageHelper.startPage(${classNameLower}Dto.getPage(),${classNameLower}Dto.getRows(),"g.operatetimeforhis "+${classNameLower}Dto.getSord());
        ${classNameLower}Dto.setOperateStatus("1");
        List<${className}Dto> ${classNameLower}DtoList = ${classNameLower}Service.findPageInfo(${classNameLower}Dto);
        PageInfo selectPage = new PageInfo(${classNameLower}DtoList);
        Map<String, Object> result = new HashMap<String, Object>(16);
        result.put("count", selectPage.getTotal());
        result.put("data", selectPage.getList());
        return new ResponseBean(HttpStatus.OK.value(),"查询成功(Query was successful)", result);
    }


    /**
     * 信息
     * @author ${author}
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @GetMapping("/{id}")
    public ResponseBean info(@PathVariable("id") String id){
        ${className}Dto ${classNameLower}Dto = ${classNameLower}Service.selectById(id);
        if (${classNameLower}Dto == null) {
             throw new CustomException("查询失败(Query Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", ${classNameLower}Dto);
    }


    /**
     * 新增
     * @author ${author}
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @PostMapping
    public ResponseBean save(@RequestBody ${className}Dto ${classNameLower}Dto){
        Boolean flag  = ${classNameLower}Service.insert(${classNameLower}Dto);
        if (!flag) {
            throw new CustomException("新增失败(Insert Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "新增成功(Add was successful)", ${classNameLower}Dto);
    }


    /**
     * 更新
     * @author ${author}
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @PutMapping
    public ResponseBean update(@RequestBody ${className}Dto ${classNameLower}Dto){
        Boolean flag = ${classNameLower}Service.updateById(${classNameLower}Dto);
        if (!flag) {
            throw new CustomException("更新失败(Update Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "更新成功(Update was successful)", ${classNameLower}Dto);
    }


    /**
     * 删除(逻辑)
     * @author ${author}
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @DeleteMapping("/{id}")
    public ResponseBean delete(@PathVariable("id") String id){
        ${className}Dto ${classNameLower}Dto = ${classNameLower}Service.selectById(id);
        // 查询对象为空
        if (${classNameLower}Dto == null) {
            throw new CustomException("删除失败，ID不存在(Deletion Failed. ID does not exist.)");
        }
        ${classNameLower}Dto.setOperateStatus("0");
        Boolean flag = ${classNameLower}Service.updateById(${classNameLower}Dto);
        if (!flag) {
            throw new CustomException("删除失败，ID不存在(Deletion Failed. ID does not exist.)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "删除成功(Delete Success)", null);
    }

}