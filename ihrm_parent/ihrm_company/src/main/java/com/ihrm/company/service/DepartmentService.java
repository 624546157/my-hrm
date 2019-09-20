package com.ihrm.company.service;

import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.CompanyOrgin;
import com.ihrm.domain.company.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuzebin
 * @title: DepartmentService
 * @projectName ihrm_parent
 * @description: TODO
 * @date 2019/9/617:59
 */
public interface DepartmentService {
    /**
     * 获取组织树
     * @param company
     * @return
     */
    CompanyOrgin getDepartOrangize(Company company);

    /**
     * 保存企业
     * @param department
     */
    int save(Department department);

    /**
     * 根据id查询部门详情
     * @param id
     */
    Department findById(String id);

    /**
     * 根据id更新部门信息
     * @param department
     */
    int update(Department department);

    /**
     * 根据id更新部门信息
     * @param ids
     */
    int deteleByIds(List<String> ids);
}
