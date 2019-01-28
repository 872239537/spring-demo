package com.sunmnet.bigdata.web.service;

import com.sunmnet.bigdata.web.core.APIMapping;
import com.sunmnet.bigdata.web.model.Goods;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@Service
public class GoodsServiceImpl {

    public Goods addGoods(Goods goods, Integer id){
        return goods;
    }

}
