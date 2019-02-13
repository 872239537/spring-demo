/*
*
* Ggg.java
* Copyright(C) 2017-2020 sunmnet.com
* @date 2019-02-13
*/
package com.threeeye.demo.api.domain;

import com.threeeye.framework.domain.BaseModel;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "", description = "")
public class Ggg extends BaseModel {
    @ApiModelProperty(value = "")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Ggg(Long id) {
        this.id = id;
    }

    public Ggg() {
        super();
    }

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }
}