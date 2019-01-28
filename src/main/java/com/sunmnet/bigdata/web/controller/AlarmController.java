package com.sunmnet.bigdata.web.controller;

import com.alibaba.fastjson.JSON;
import com.sunmnet.bigdata.web.core.APIMapping;
import com.sunmnet.bigdata.web.model.Goods;
import com.sunmnet.bigdata.web.service.GoodsServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

//@Api(value = "预警处理控制器API",tags = {"预警处理","查询统计预警相关"})
@RestController
@RequestMapping(value = "/alarm")
public class AlarmController extends BaseController {

    @Autowired
    private GoodsServiceImpl goodsService;

    @APIMapping("getGoods")
    @ApiOperation(value = "综合预警|学业预警概览")
    @ResponseBody
    @RequestMapping(value = "/getGoods", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goods",value = "学校代码",
                    required = false,paramType = "body",dataType = "Goods"),
            @ApiImplicitParam(name = "id",value = "学院代码",
                    required = false,paramType = "query",dataType = "Integer")
    })
    public Goods addGoods(@RequestBody Goods goods,
                          @RequestParam(value = "id",required = false)Integer id){
        return goodsService.addGoods(goods,id);
    }
}
