package com.ihrm.company.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ihrm.domain.company.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * 自定义dao接口继承
 *      JpaRepository<实体类，主键>
 *      JpaSpecificationExecutor<实体类>
 */
@Mapper
public interface DepartmentDao extends BaseMapper<Department> {
}
