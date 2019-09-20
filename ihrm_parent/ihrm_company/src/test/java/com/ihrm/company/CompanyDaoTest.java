package com.ihrm.company;

import com.ihrm.company.dao.CompanyDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyDaoTest {
    @Autowired
    private CompanyDao companyDao;

//    @Test
//    public void test() {
//
//        DepartmentOrgin departmentOrgin = new DepartmentOrgin("1");
//        System.out.println(departmentOrgin);
//    }
}
