package com.ihrm.domain.company;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author wuzebin
 * @title: Department
 * @projectName ihrm_parent
 * @description: 表实体类
 * @date 2019/7/2221:47
 */
@Data
@TableName("co_company")
public class Company implements Serializable {
    private static final long serialVersionUID = 594829320797158219L;
    //ID
    //value与数据库主键列名一致，若实体类属性名与表主键列名一致可省略value
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private String id;
    /**
     * 公司名称
     */
    private String name;
    /**
     * 企业登录账号ID
     */
    private String managerId;
    /**
     * 当前版本
     */
    private String version;
    /**
     * 续期时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date renewalDate;
    /**
     * 到期时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date expirationDate;
    /**
     * 公司地区
     */
    private String companyArea;
    /**
     * 公司地址
     */
    private String companyAddress;
    /**
     * 营业执照-图片ID
     */
    private String businessLicenseId;
    /**
     * 法人代表
     */
    private String legalRepresentative;
    /**
     * 公司电话
     */
    private String companyPhone;
    /**
     * 邮箱
     */
    private String mailbox;
    /**
     * 公司规模
     */
    private String companySize;
    /**
     * 所属行业
     */
    private String industry;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 审核状态
     */
    private String auditState;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 当前余额
     */
    private Double balance;
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

    /**
     * 是否删除（0：已删除  1：未删除 ）
     */
    private String enable_status;
}
