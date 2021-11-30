<#include "/macro.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import ${commonspackage}.annotation.Log;
import ${commonspackage}.domain.R;
import ${commonspackage}.enums.BusinessType;
import ${commonspackage}.base.controller.BaseController;
import ${commonspackage}.utils.poi.ExcelUtil;
import ${commonspackage}.validator.ValidatorUtils;
import ${commonspackage}.validator.group.AddGroup;
import ${commonspackage}.validator.group.DefaultGroup;
import ${commonspackage}.validator.group.UpdateGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import ${basepackage}.domain.dto.${className}Dto;
import ${basepackage}.service.${className}Service;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: template
 * @Create: ${now?string('yyyy-MM-dd HH:mm:ss')}
 **/
@Slf4j
@RestController
@RequestMapping("${classNameLower}")
@Api(tags="${table.tableAlias}")
public class ${className}Controller extends BaseController {


    @Autowired
    private ${className}Service ${classNameLower}Service;

    /**
     * 查询(主键)
     */
    @ApiOperation(value = "${table.tableAlias}-查询", notes = "${table.tableAlias}-查询")
    @GetMapping("/get")
    public R<${className}Dto> get(@RequestParam("id") java.math.BigInteger id) {
        return R.success(${classNameLower}Service.getDtoById(id));
    }

    /**
     * 分页列表
     */
    @ApiOperation(value = "${table.tableAlias}-分页列表查询", notes = "${table.tableAlias}-分页列表查询")
    @PostMapping("/page")
    public R<IPage<${className}Dto>> page(@RequestBody ${className}Dto ${classNameLower}Dto) {
        return R.success(${classNameLower}Service.pageDto(${classNameLower}Dto));
    }

    /**
     * 新增
     */
    @ApiOperation(value = "${table.tableAlias}-新增", notes = "${table.tableAlias}-新增")
    @Log(title = "${table.tableAlias}新增", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public R<Integer> add(@RequestBody ${className}Dto ${classNameLower}Dto) {
        ValidatorUtils.validateEntity(${classNameLower}Dto, AddGroup.class, DefaultGroup.class);
        return R.success(${classNameLower}Service.addDto(${classNameLower}Dto));
    }

    /**
     * 根据id修改
     */
    @ApiOperation(value = "${table.tableAlias}-修改", notes = "${table.tableAlias}-修改")
    @Log(title = "${table.tableAlias}修改", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public R<Integer> edit(@RequestBody ${className}Dto ${classNameLower}Dto) {
        ValidatorUtils.validateEntity(${classNameLower}Dto, UpdateGroup.class, DefaultGroup.class);
        return R.success(${classNameLower}Service.updateDtoById(${classNameLower}Dto));
    }

    /**
     * 删除
     */
    @ApiOperation(value = "${table.tableAlias}-删除", notes = "${table.tableAlias}-删除")
    @Transactional
    @Log(title = "${table.tableAlias}删除", businessType = BusinessType.DELETE)
    @PostMapping("/delete")
    public R<Boolean> delete(@RequestBody Map<String, List<String>> params) {
        // 主键非单列,需要重构该方法
        return R.success(${classNameLower}Service.removeByIds(params.get("ids")));
    }

    /**
     * 导出
     */
    @ApiOperation(value = "${table.tableAlias}-导出", notes = "${table.tableAlias}-导出")
    @Log(title = "${table.tableAlias}导出", businessType = BusinessType.EXPORT)
    @PostMapping("export")
    public R<?> export(@RequestBody ${className}Dto ${classNameLower}Dto) {
        ExcelUtil<${className}Dto> excel = new ExcelUtil<${className}Dto>(${className}Dto.class);
        return excel.exportExcel(${classNameLower}Service.listAllDto(${classNameLower}Dto), "${table.tableAlias}数据");
    }

}