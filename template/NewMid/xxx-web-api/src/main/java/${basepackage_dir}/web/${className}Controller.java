<#include "/macro.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${basepackage}.core.common.dto.PageQuery;
import ${basepackage}.core.common.dto.ResponseMessage;
import ${basepackage}.dto.${className}Dto;
import ${basepackage}.service.${className}Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Slf4j
@Tag(name = "${table.tableAlias}")
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
    @Operation(summary = "${table.tableAlias}-列表", description = "列表查询")
    @GetMapping("/list")
    public ResponseMessage<IPage<${className}Dto>> list(PageQuery pageQuery, ${className}Dto ${classNameLower}Dto) {
        Page<${className}Dto> page = Page.of(pageQuery.getPageNum(), pageQuery.getPageSize());
        return ResponseMessage.success(${classNameLower}Service.page(page, Wrappers.lambdaQuery(${classNameLower}Dto)));
    }

    /**
     * 查询
     *
     * @author ${author}
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @Operation(summary = "${table.tableAlias}-查询", description = "ID查询")
    @GetMapping("/{id}")
    public ResponseMessage get(
            @Parameter(description = "${table.tableAlias}Id", required = true) @PathVariable("id") Long id) {
        return ResponseMessage.success(${classNameLower}Service.getById(id));
    }

    /**
     * 新增
     *
     * @author ${author}
     * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
     */
    @Operation(summary = "${table.tableAlias}-新增", description = "数据新增")
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
    @Operation(summary = "${table.tableAlias}-更新", description = "数据更新")
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
    @Operation(summary = "${table.tableAlias}-删除", description = "数据删除")
    @PostMapping("/delete")
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage delete(
            @Parameter(description = "${table.tableAlias}Id列表", required = true) @RequestBody List<String> ids) {
        return ResponseMessage.success(${classNameLower}Service.removeByIds(ids));
    }

}