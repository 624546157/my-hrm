package com.ihrm.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ihrm.company.dao.DepartmentDao;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.CompanyOrgin;
import com.ihrm.domain.company.Department;
import constant.EnableStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuzebin
 * @title: DepartmentService
 * @projectName ihrm_parent
 * @description: TODO
 * @date 2019/9/617:59
 */
@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    String departRoot = "0";

    /**
     * 获取组织树
     *
     * @param company
     * @return
     */
    @Override
    public CompanyOrgin getDepartOrangize(Company company) {
        log.info("获取组织树>>>>>>>>service参数为：" + company.toString());

        QueryWrapper wr = new QueryWrapper<Department>().eq("company_id", company.getId()).eq("enable_status", 1);
        List<Department> list = departmentDao.selectList(wr);

        List<Department> deptTree = makeTree(list, departRoot);
        CompanyOrgin companyOrgin = new CompanyOrgin(company,deptTree);

        return companyOrgin;
    }


    /**
     * 保存企业
     *
     * @param department
     */
    @Override
    @Transactional
    public int save(Department department) {
        log.info("保存部门service>>>>>>>>service参数为：" + department.toString());
        department.setCreateTime(new Date());
        department.setEnable_status(EnableStatusEnum.ALREADY_ENABLE.getCode());
        Integer num = departmentDao.insert(department);

        return num;
    }

    /**
     * 根据id查询部门详情
     *
     * @param id
     */
    @Override
    public Department findById(String id) {
        log.info("根据id查询部门service>>>>>>>>service参数为：" + id.toString());

        Department department = departmentDao.selectById(id);
        return department;
    }

    /**
     * 根据id更新部门信息
     *
     * @param department
     */
    @Override
    @Transactional
    public int update(Department department) {
        log.info("更新部门信息service>>>>>>>>service参数为：" + department.toString());

        int num = departmentDao.updateById(department);
        return num;
    }

    /**
     * 根据id更新部门信息
     *
     * @param ids
     */
    @Transactional
    public int deteleByIds(List<String> ids) {
        log.info("删除部门信息service>>>>>>>>service参数为：" + ids.toString());

        int num = 0;
        for (String id : ids) {
            Department department = departmentDao.selectById(id);
            department.setEnable_status("");
            departmentDao.updateById(department);
            num ++;
        }
        return num;
    }

    /**
     * 部门组织树构建
     *
     * @param departmentList
     * @param rootId
     * @return
     */
    private static List<Department> makeTree(List<Department> departmentList, String rootId) {

        //子类
        List<Department> children = departmentList.stream().filter(x -> x.getParentId().equals(rootId)).collect(Collectors.toList());

        //后辈中的非子类
        List<Department> successor = departmentList.stream().filter(x -> !x.getParentId().equals(rootId)).collect(Collectors.toList());

        children.forEach(x ->
                {
                    makeTree(successor, x.getId()).forEach(
                            y -> x.getChildren().add(y)
                    );
                }
        );

        return children;

    }
}
