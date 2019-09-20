package com.ihrm.company.service;

import com.ihrm.domain.company.Company;

import java.util.List;

/**
 * @author wuzebin
 * @title: CompanyService
 * @projectName ihrm_parent
 * @description: TODO
 * @date 2019/8/2910:46
 */
public interface CompanyService {


    List<Company> findAll();

    Company findById(String id);

    void add(Company company);

    void deleteById(String id);

    void update(Company company);
}
