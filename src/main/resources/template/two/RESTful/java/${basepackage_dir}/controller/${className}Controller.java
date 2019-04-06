<#include "/java_copyright.include"> 
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import ${basepackage}.dto.custom.${className}Dto;
import ${basepackage}.service.I${className}Service;
import ${basepackage}.common.ResponseBean;
import ${basepackage}.exception.CustomException;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ${className}Controller
 * @author Generator
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@RestController
@RequestMapping("${classNameLower}")
public class ${className}Controller {

    private final I${className}Service ${classNameLower}Service;

    @Autowired
    public ${className}Controller (I${className}Service ${classNameLower}Service) {
        this.${classNameLower}Service = ${classNameLower}Service;
    }

    /**
     * 列表
     * @author Generator
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @GetMapping
    public ResponseBean list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {
        if (page <= 0 || rows <= 0) {
            page = 1;
            rows = 10;
        }
        PageHelper.startPage(page, rows);
        List<${className}Dto> list = ${classNameLower}Service.selectAll();
        if (list == null || list.size() <= 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        PageInfo<${className}Dto> pageInfo = new PageInfo<${className}Dto>(list);
        Map<String, Object> result = new HashMap<String, Object>(16);
        result.put("count", pageInfo.getTotal());
        result.put("data", pageInfo.getList());
        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", result);
    }

    /**
     * 查询
     * @author Generator
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @GetMapping("/{id}")
    public ResponseBean findById(@PathVariable("id") Integer id) {
        ${className}Dto ${classNameLower}Dto = ${classNameLower}Service.selectByPrimaryKey(id);
        if (${classNameLower}Dto == null) {
            throw new CustomException("查询失败(Query Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", ${classNameLower}Dto);
    }

    /**
     * 新增
     * @author Generator
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @PostMapping
    public ResponseBean add(@RequestBody ${className}Dto ${classNameLower}Dto) {
        int count = ${classNameLower}Service.insert(${classNameLower}Dto);
        // 操作数量小于0
        if (count <= 0) {
            throw new CustomException("新增失败(Insert Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "新增成功(Insert Success)", ${classNameLower}Dto);
    }

    /**
     * 更新
     * @author Generator
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @PutMapping
    public ResponseBean update(@RequestBody ${className}Dto ${classNameLower}Dto) {
        int count = ${classNameLower}Service.updateByPrimaryKeySelective(${classNameLower}Dto);
        // 操作数量小于0
        if (count <= 0) {
            throw new CustomException("更新失败(Update Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "更新成功(Update Success)", ${classNameLower}Dto);
    }

    /**
     * 删除
     * @author Generator
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @DeleteMapping("/{id}")
    public ResponseBean delete(@PathVariable("id") Integer id) {
        int count = ${classNameLower}Service.deleteByPrimaryKey(id);
        // 操作数量小于0
        if (count <= 0) {
            throw new CustomException("删除失败，ID不存在(Deletion Failed. ID does not exist.)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "删除成功(Delete Success)", null);
    }

}