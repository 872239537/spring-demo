package com.sunmnet.bigdata.web.model;


import java.io.Serializable;

public class Goods implements Serializable {
    private String goodsName;
    private String goodsId;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
