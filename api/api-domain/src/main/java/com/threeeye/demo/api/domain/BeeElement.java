/*
*
* BeeElement.java
* Copyright(C) 2017-2020 sunmnet.com
* @date 2019-02-13
*/
package com.threeeye.demo.api.domain;

import com.threeeye.framework.domain.BaseModel;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "页面元素表", description = "页面元素表")
@Table(name = "bee_element")
public class BeeElement extends BaseModel {
    @ApiModelProperty(value = "主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "元素分类")
    @Column(name = "element_type")
    private String elementType;

    @ApiModelProperty(value = "元素类别")
    @Column(name = "element_category")
    private String elementCategory;

    @ApiModelProperty(value = "标题")
    @Column(name = "element_title")
    private String elementTitle;

    @ApiModelProperty(value = "值")
    @Column(name = "element_value")
    private String elementValue;

    @ApiModelProperty(value = "名称")
    @Column(name = "element_name")
    private String elementName;

    @ApiModelProperty(value = "默认值")
    @Column(name = "default_value")
    private String defaultValue;

    @ApiModelProperty(value = "页面id")
    @Column(name = "page_id")
    private String pageId;

    @ApiModelProperty(value = "换行")
    @Column(name = "line_feed")
    private String lineFeed;

    @ApiModelProperty(value = "优先级")
    private String priority;

    @ApiModelProperty(value = "图表id")
    @Column(name = "chart_id")
    private String chartId;

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

    public BeeElement(Long id, String elementType, String elementCategory, String elementTitle, String elementValue, String elementName, String defaultValue, String pageId, String lineFeed, String priority, String chartId, Long createTime, Long lastModifyTime, Long creator, Long lastModifer, Short status) {
        this.id = id;
        this.elementType = elementType;
        this.elementCategory = elementCategory;
        this.elementTitle = elementTitle;
        this.elementValue = elementValue;
        this.elementName = elementName;
        this.defaultValue = defaultValue;
        this.pageId = pageId;
        this.lineFeed = lineFeed;
        this.priority = priority;
        this.chartId = chartId;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
        this.creator = creator;
        this.lastModifer = lastModifer;
        this.status = status;
    }

    public BeeElement() {
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
     * 元素分类
     * @return element_type 元素分类
     */
    public String getElementType() {
        return elementType;
    }

    /**
     * 元素分类
     * @param elementType 元素分类
     */
    public void setElementType(String elementType) {
        this.elementType = elementType == null ? null : elementType.trim();
    }

    /**
     * 元素类别
     * @return element_category 元素类别
     */
    public String getElementCategory() {
        return elementCategory;
    }

    /**
     * 元素类别
     * @param elementCategory 元素类别
     */
    public void setElementCategory(String elementCategory) {
        this.elementCategory = elementCategory == null ? null : elementCategory.trim();
    }

    /**
     * 标题
     * @return element_title 标题
     */
    public String getElementTitle() {
        return elementTitle;
    }

    /**
     * 标题
     * @param elementTitle 标题
     */
    public void setElementTitle(String elementTitle) {
        this.elementTitle = elementTitle == null ? null : elementTitle.trim();
    }

    /**
     * 值
     * @return element_value 值
     */
    public String getElementValue() {
        return elementValue;
    }

    /**
     * 值
     * @param elementValue 值
     */
    public void setElementValue(String elementValue) {
        this.elementValue = elementValue == null ? null : elementValue.trim();
    }

    /**
     * 名称
     * @return element_name 名称
     */
    public String getElementName() {
        return elementName;
    }

    /**
     * 名称
     * @param elementName 名称
     */
    public void setElementName(String elementName) {
        this.elementName = elementName == null ? null : elementName.trim();
    }

    /**
     * 默认值
     * @return default_value 默认值
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * 默认值
     * @param defaultValue 默认值
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    /**
     * 页面id
     * @return page_id 页面id
     */
    public String getPageId() {
        return pageId;
    }

    /**
     * 页面id
     * @param pageId 页面id
     */
    public void setPageId(String pageId) {
        this.pageId = pageId == null ? null : pageId.trim();
    }

    /**
     * 换行
     * @return line_feed 换行
     */
    public String getLineFeed() {
        return lineFeed;
    }

    /**
     * 换行
     * @param lineFeed 换行
     */
    public void setLineFeed(String lineFeed) {
        this.lineFeed = lineFeed == null ? null : lineFeed.trim();
    }

    /**
     * 优先级
     * @return priority 优先级
     */
    public String getPriority() {
        return priority;
    }

    /**
     * 优先级
     * @param priority 优先级
     */
    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    /**
     * 图表id
     * @return chart_id 图表id
     */
    public String getChartId() {
        return chartId;
    }

    /**
     * 图表id
     * @param chartId 图表id
     */
    public void setChartId(String chartId) {
        this.chartId = chartId == null ? null : chartId.trim();
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