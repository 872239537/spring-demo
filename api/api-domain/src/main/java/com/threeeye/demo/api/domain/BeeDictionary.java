/*
*
* BeeDictionary.java
* Copyright(C) 2017-2020 sunmnet.com
* @date 2019-02-13
*/
package com.threeeye.demo.api.domain;

import com.threeeye.framework.domain.BaseModel;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "字典表", description = "字典表")
@Table(name = "bee_dictionary")
public class BeeDictionary extends BaseModel {
    @ApiModelProperty(value = "主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "分类")
    private String type;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "编号")
    private String code;

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

    public BeeDictionary(Long id, String type, String name, String code, Long createTime, Long lastModifyTime, Long creator, Long lastModifer, Short status) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.code = code;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
        this.creator = creator;
        this.lastModifer = lastModifer;
        this.status = status;
    }

    public BeeDictionary() {
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
     * 分类
     * @return type 分类
     */
    public String getType() {
        return type;
    }

    /**
     * 分类
     * @param type 分类
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 名称
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 编号
     * @return code 编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 编号
     * @param code 编号
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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