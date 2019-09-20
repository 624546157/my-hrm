package com.ihrm.company.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ihrm.domain.company.Company;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 自定义dao接口继承
 *      JpaRepository<实体类，主键>
 *      JpaSpecificationExecutor<实体类>
 */
@Component
public interface CompanyDao extends BaseMapper<Company> {
}
