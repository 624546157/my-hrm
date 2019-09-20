package com.ihrm.domain.company;

import lombok.Data;

import java.util.List;

/**
 * @author wuzebin
 * @title: CompanyOrgin
 * @projectName ihrm_parent
 * @description: TODO
 * @date 2019/9/1715:44
 */
@Data
public class CompanyOrgin {

    private String companyId;
    private String companyName;
    private String companyManage;//公司联系人
    private List<Department> depts;

    public CompanyOrgin() {
    }

    public CompanyOrgin(Company company, List depts) {
        this.companyId = company.getId();
        this.companyName = company.getName();
        this.companyManage = company.getLegalRepresentative();//公司联系人
        this.depts = depts;
    }
}
