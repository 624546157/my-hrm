package com.ihrm.company.controller;

import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.Result;
import com.ihrm.common.utils.EnumUtil;
import com.ihrm.company.service.CompanyService;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.CompanyOrgin;
import com.ihrm.domain.company.Department;
import constant.EnableStatusEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "部门管理")
@RestController
@RequestMapping(value = "/company/deparment")
public class DepartmentController extends BaseController {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    CompanyService companyService;

    @ApiOperation("获取企业的部门组织树")
    @RequestMapping(value = "/getOrgin", method = RequestMethod.GET)
    public Result getOrgin() {
        //1.指定企业id
        Company company = companyService.findById(companyId);

        CompanyOrgin companyOrgin = departmentService.getDepartOrangize(company);

        return Result.SUCCESS(companyOrgin);
    }

    /**
     * 保存
     */
    @ApiOperation("保存企业部门")
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public Result save(@RequestBody Department department) {

        //1.设置保存的企业id
        /**
         * 企业id：目前使用固定值1，以后会解决
         */
        department.setCompanyId(companyId);
        //2.调用service完成保存企业
        departmentService.save(department);

        //3.构造返回结果
        return Result.SUCCESS();
    }

    /**
     * 根据ID查询department
     */
    @ApiOperation("根据ID查询部门详情")
    @RequestMapping(value="/findById",method = RequestMethod.GET)
    public Result findById(String id) {

        Department department = departmentService.findById(id);

        return Result.SUCCESS(department);
    }



    /**
     * 修改Department
     */
    @ApiOperation("修改部门")
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Result update(@RequestBody Department department) {

        //1.设置修改的部门id
        department.setCompanyId(companyId);
        //2.调用service更新
        departmentService.update(department);

        return Result.SUCCESS();
    }

    /**
     * 根据id删除
     */
    @ApiOperation("根据id删除")
    @RequestMapping(value="/deteleByIds",method = RequestMethod.POST)
    public Result deteleByIds(ArrayList<String> ids) {

        Integer num = departmentService.deteleByIds(ids);

        return Result.SUCCESS(num);
    }

//    public static void main(String[] args) {
//        String msg = EnumUtil.getByCode(EnableStatusEnum.ALREADY_ENABLE.getCode(), EnableStatusEnum.class);
//        System.out.println(msg);
//    }

}
