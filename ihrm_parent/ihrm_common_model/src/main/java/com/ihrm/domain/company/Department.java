package com.ihrm.domain.company;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author wuzebin
 * @title: Department
 * @projectName ihrm_parent
 * @description: 部门表实体类
 * @date 2019/7/2221:47
 */
@Data
@TableName("co_department")
public class Department implements Serializable {

    private static final long serialVersionUID = 594829320797141219L;

    /**
     * 主键id
     */
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private String id;

    /**
     * 公司id
     */
    private String companyId;

    /**
     * 父级部门ID
     */
    private String parentId;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门编码
     */
    private String code;

    /**
     *  部门类别
     */
    private String category;

    /**
     * 负责人id
     */
    private String managerId;

    /**
     *  城市
     */
    private String city;

    /**
     *  部门负责人
     */
    private String manager;

    /**
     * 介绍
     */
    private String introduce;

    /**
     * 是否删除（0：已删除  1：未删除 ）
     */
    private String enable_status;

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 创建人
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createUserId;

    /**
     * 修改时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 修改人
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateUserId;

    /*********************不做数据库字段映射*************************/
    /**
     * 子节点
     */
    @TableField(exist = false)
    private List<Department> children = new ArrayList<>();
}