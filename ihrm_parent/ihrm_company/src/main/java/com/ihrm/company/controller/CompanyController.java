package com.ihrm.company.controller;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultEnum;
import com.ihrm.company.service.CompanyService;
import com.ihrm.domain.company.Company;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "企业管理")
@RestController
@RequestMapping(value="/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //查询全部企业列表
    @ApiOperation("查询全部企业列表")
    @RequestMapping(value="/findAll",method = RequestMethod.GET)
    public Result findAll() {
        List<Company> list = companyService.findAll();
        Result result = new Result(ResultEnum.SUCCESS);
        return result.SUCCESS(list);
    }

    //根据id查询企业
    @ApiOperation("根据id查询企业")
    @RequestMapping(value="/findById",method = RequestMethod.GET)
    public Result findById(@RequestParam String id) {
        Company company = companyService.findById(id);
        return Result.SUCCESS(company);
    }

    //保存企业
    @ApiOperation("保存企业")
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public Result save(@RequestBody Company company)  {
        //业务操作
        companyService.add(company);
        return Result.SUCCESS();
    }

    //根据id删除企业
    @ApiOperation("根据id删除企业")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(@RequestParam String id) {
        companyService.deleteById(id);
        return Result.SUCCESS();
    }


    //根据id更新企业
    @ApiOperation("根据id更新企业")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody @Valid Company company ) {
        //业务操作
        companyService.update(company);
        return Result.SUCCESS();
    }
}
