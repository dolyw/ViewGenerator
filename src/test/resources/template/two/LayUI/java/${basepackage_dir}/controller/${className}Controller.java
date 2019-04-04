<#include "/java_copyright.include"> 
<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import ${commonspackage}.dto.JsonRequest;
import com.mybatis.pagehelper.PageInfo;

import ${basepackage}.dto.custom.${className}Dto;
import ${basepackage}.service.${className}Service;

/**
 * ${className}Controller
 * @author Generator
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Controller
@RequestMapping("${classNameLower}")
public class ${className}Controller {

    @Autowired
    private ${className}Service ${classNameLower}Service;

    /**
     * 主页面
     * @author Generator
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @RequestMapping
    public String index(HttpServletRequest request) {
        return "${modulepackage}/${classNameLower}/${classNameLower}";
    }

    /**
     * 列表
     * @author Generator
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody ${className}Dto ${classNameLower}Dto) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        PageInfo<${className}Dto> pageInfo = ${classNameLower}Service.findPageInfo(${classNameLower}Dto.getPage(),
                ${classNameLower}Dto.getLimit(), ${classNameLower}Dto, ${classNameLower}Dto.getField() + " " + ${classNameLower}Dto.getOrder());
        resultMap.put("code", "0");
        resultMap.put("count", pageInfo.getTotal());
        resultMap.put("data", pageInfo.getList());
        return resultMap;
    }

    /**
     * 预新增
     * @author Generator
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @ResponseBody
    @RequestMapping(value = "/prepareInsert", method = RequestMethod.POST)
    public Map<String, Object> prepareInsert(@RequestBody ${className}Dto ${classNameLower}Dto) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        ${classNameLower}Dto = new ${className}Dto();
        resultMap.put("${classNameLower}Dto", ${classNameLower}Dto);
        return resultMap;
    }

    /**
     * 新增
     * @author Generator
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody ${className}Dto ${classNameLower}Dto) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        ${classNameLower}Service.insertNotNull(${classNameLower}Dto);
        resultMap.put("flag", "Y");
        resultMap.put("msg", "保存成功");
        return resultMap;
    }

    /**
     * 预修改
     * @author Generator
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @ResponseBody
    @RequestMapping(value = "/prepareUpdate", method = RequestMethod.POST)
    public Map<String, Object> prepareUpdate(@RequestBody ${className}Dto ${classNameLower}Dto) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        ${classNameLower}Dto = ${classNameLower}Service.selectByPrimaryKey(${classNameLower}Dto);
        resultMap.put("${classNameLower}Dto", ${classNameLower}Dto);
        return resultMap;
    }

    /**
     * 修改
     * @author Generator
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody ${className}Dto ${classNameLower}Dto) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        ${classNameLower}Service.updateByPrimaryKey(${classNameLower}Dto);
        resultMap.put("flag", "Y");
        resultMap.put("msg", "修改成功");
        return resultMap;
    }

    /**
     * 删除
     * @author Generator
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @ResponseBody
    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody JsonRequest<${className}Dto> jsonRequest) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        List<${className}Dto>  ${classNameLower}List = JSON.parseArray((jsonRequest.getExtend().get("${classNameLower}List")), ${className}Dto.class);
        for(${className}Dto ${classNameLower}Dto : ${classNameLower}List) {
            ${classNameLower}Service.deleteByPrimaryKey(${classNameLower}Dto);
        }
        resultMap.put("flag", "Y");
        resultMap.put("msg", "删除成功");
        return resultMap;
    }
}