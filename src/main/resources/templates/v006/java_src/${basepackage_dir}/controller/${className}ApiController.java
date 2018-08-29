<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sscf.education.common.entity.PageResult;
import com.sscf.education.common.entity.Result;
import com.sscf.education.common.util.ResultUtil;
import com.sscf.education.user.controller.BaseController;

import ${basepackage}.dto.${className}Dto;
import ${basepackage}.entity.${className};
import ${basepackage}.service.${className}Service;

<#include "/java_imports.include">
@RestController
@RequestMapping(value = "/api")
public class ${className}ApiController extends BaseController {

    /** The ${camelToSpace(className)} service . */
    @Autowired
    private ${className}Service ${classNameLower}Service;

    /**
     * 查询 ${className} .
     *
     * @param dto 查询对象
     * @return 响应结果
     */ 
    @RequestMapping(value = "/qry${className}")
    @ResponseBody
    public Result qry${className}(@RequestBody(required = false) ${className}Dto dto) {
        List<${className}> list = ${classNameLower}Service.qryApi${className}(dto);
        PageResult<${className}> page = new PageResult<>(list);
        return ResultUtil.success(page);
    }
    

}
