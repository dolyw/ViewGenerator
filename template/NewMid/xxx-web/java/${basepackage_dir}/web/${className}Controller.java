<#include "/macro.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${basepackage}.core.common.dto.PageQuery;
import ${basepackage}.core.common.dto.ResponseMessage;
import ${basepackage}.dto.${className}Dto;
import ${basepackage}.service.${className}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ${className}Controller
 *
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Api(tags = "${table.tableAlias}", description = "${table.tableAlias}信息操作")
@Slf4j
@RestController
@RequestMapping("/${classNameLower}")
public class ${className}Controller {

    private final ${className}Service ${classNameLower}Service;

    @Autowired
    public ${className}Controller(${className}Service ${classNameLower}Service) {
        this.${classNameLower}Service = ${classNameLower}Service;
    }

    /**
     * 列表
     *
     * @author ${author}
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @ApiOperation(value = "${table.tableAlias}-列表", notes = "${table.tableAlias}-列表")
    @GetMapping("/list")
    public ResponseMessage<IPage<${className}Dto>> list(PageQuery pageQuery, ${className}Dto ${classNameLower}Dto) {
        Page<${className}Dto> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        QueryWrapper<${className}Dto> ${classNameLower}DtoQueryWrapper = Wrappers.query(${classNameLower}Dto);
        return ResponseMessage.success(${classNameLower}Service.page(page, ${classNameLower}DtoQueryWrapper));
    }

    /**
     * 查询
     *
     * @author ${author}
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @ApiOperation(value = "${table.tableAlias}-查询", notes = "${table.tableAlias}-查询")
    @GetMapping("/{id}")
    public ResponseMessage get(@ApiParam(name = "id", value = "${table.tableAlias}Id", required = true) @PathVariable("id") Long id) {
        return ResponseMessage.success(${classNameLower}Service.getById(id));
    }

    /**
     * 新增
     *
     * @author ${author}
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @ApiOperation(value = "${table.tableAlias}-新增", notes = "${table.tableAlias}-新增")
    @PostMapping("/add")
    public ResponseMessage add(@RequestBody ${className}Dto ${classNameLower}Dto) {
        return ResponseMessage.success(${classNameLower}Service.save(${classNameLower}Dto));
    }

    /**
     * 更新
     *
     * @author ${author}
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @ApiOperation(value = "${table.tableAlias}-修改", notes = "${table.tableAlias}-修改")
    @PostMapping("/update")
    public ResponseMessage update(@RequestBody ${className}Dto ${classNameLower}Dto) {
        return ResponseMessage.success(${classNameLower}Service.updateById(${classNameLower}Dto));
    }

    /**
     * 删除
     *
     * @author ${author}
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @ApiOperation(value = "${table.tableAlias}-删除", notes = "${table.tableAlias}-删除")
    @PostMapping("/delete")
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage delete(@ApiParam(name = "ids", value = "${table.tableAlias}Id列表", required = true) @RequestBody List<String> ids) {
        return ResponseMessage.success(${classNameLower}Service.removeByIds(ids));
    }

}