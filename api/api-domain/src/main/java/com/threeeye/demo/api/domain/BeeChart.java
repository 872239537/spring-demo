/*
*
* BeeChart.java
* Copyright(C) 2017-2020 sunmnet.com
* @date 2019-02-13
*/
package com.threeeye.demo.api.domain;

import com.threeeye.framework.domain.BaseModel;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "图表分类管理", description = "图表分类管理")
@Table(name = "bee_chart")
public class BeeChart extends BaseModel {
    @ApiModelProperty(value = "主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "图表类型")
    @Column(name = "chart_type")
    private String chartType;

    @ApiModelProperty(value = "图表分类")
    @Column(name = "chart_category")
    private String chartCategory;

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

    public BeeChart(Long id, String chartType, String chartCategory, Long createTime, Long lastModifyTime, Long creator, Long lastModifer, Short status) {
        this.id = id;
        this.chartType = chartType;
        this.chartCategory = chartCategory;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
        this.creator = creator;
        this.lastModifer = lastModifer;
        this.status = status;
    }

    public BeeChart() {
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
     * 图表类型
     * @return chart_type 图表类型
     */
    public String getChartType() {
        return chartType;
    }

    /**
     * 图表类型
     * @param chartType 图表类型
     */
    public void setChartType(String chartType) {
        this.chartType = chartType == null ? null : chartType.trim();
    }

    /**
     * 图表分类
     * @return chart_category 图表分类
     */
    public String getChartCategory() {
        return chartCategory;
    }

    /**
     * 图表分类
     * @param chartCategory 图表分类
     */
    public void setChartCategory(String chartCategory) {
        this.chartCategory = chartCategory == null ? null : chartCategory.trim();
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