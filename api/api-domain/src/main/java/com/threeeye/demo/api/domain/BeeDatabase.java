/*
*
* BeeDatabase.java
* Copyright(C) 2017-2020 sunmnet.com
* @date 2019-02-13
*/
package com.threeeye.demo.api.domain;

import com.threeeye.framework.domain.BaseModel;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "数据库配置表", description = "数据库配置表")
@Table(name = "bee_database")
public class BeeDatabase extends BaseModel {
    @ApiModelProperty(value = "主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "数据库连接")
    @Column(name = "db_url")
    private String dbUrl;

    @ApiModelProperty(value = "数据库名称")
    @Column(name = "db_name")
    private String dbName;

    @ApiModelProperty(value = "数据库系统名称")
    @Column(name = "db_sys_name")
    private String dbSysName;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Long createTime;

    @ApiModelProperty(value = "修改时间")
    @Column(name = "last_modify_time")
    private Long lastModifyTime;

    @ApiModelProperty(value = "创建人")
    private Long creator;

    @ApiModelProperty(value = "修改人")
    @Column(name = "last_modifer")
    private Long lastModifer;

    @ApiModelProperty(value = "状态1正常，2锁定，")
    private Short status;

    public BeeDatabase(Long id, String username, String password, String dbUrl, String dbName, String dbSysName, Long createTime, Long lastModifyTime, Long creator, Long lastModifer, Short status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.dbUrl = dbUrl;
        this.dbName = dbName;
        this.dbSysName = dbSysName;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
        this.creator = creator;
        this.lastModifer = lastModifer;
        this.status = status;
    }

    public BeeDatabase() {
        super();
    }

    /**
     * 主键
     * @return id 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户名
     * @return username 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 数据库连接
     * @return db_url 数据库连接
     */
    public String getDbUrl() {
        return dbUrl;
    }

    /**
     * 数据库连接
     * @param dbUrl 数据库连接
     */
    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl == null ? null : dbUrl.trim();
    }

    /**
     * 数据库名称
     * @return db_name 数据库名称
     */
    public String getDbName() {
        return dbName;
    }

    /**
     * 数据库名称
     * @param dbName 数据库名称
     */
    public void setDbName(String dbName) {
        this.dbName = dbName == null ? null : dbName.trim();
    }

    /**
     * 数据库系统名称
     * @return db_sys_name 数据库系统名称
     */
    public String getDbSysName() {
        return dbSysName;
    }

    /**
     * 数据库系统名称
     * @param dbSysName 数据库系统名称
     */
    public void setDbSysName(String dbSysName) {
        this.dbSysName = dbSysName == null ? null : dbSysName.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     * @return last_modify_time 修改时间
     */
    public Long getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 修改时间
     * @param lastModifyTime 修改时间
     */
    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * 创建人
     * @return creator 创建人
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 创建人
     * @param creator 创建人
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 修改人
     * @return last_modifer 修改人
     */
    public Long getLastModifer() {
        return lastModifer;
    }

    /**
     * 修改人
     * @param lastModifer 修改人
     */
    public void setLastModifer(Long lastModifer) {
        this.lastModifer = lastModifer;
    }

    /**
     * 状态1正常，2锁定，
     * @return status 状态1正常，2锁定，
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 状态1正常，2锁定，
     * @param status 状态1正常，2锁定，
     */
    public void setStatus(Short status) {
        this.status = status;
    }
}