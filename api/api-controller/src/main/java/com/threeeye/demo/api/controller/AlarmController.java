package com.threeeye.demo.api.controller;

import com.threeeye.demo.api.domain.BeeElement;
import com.threeeye.demo.api.domain.Goods;
import com.threeeye.demo.service.GoodsServiceImpl;
import com.threeeye.expands.api.APIMapping;
import com.threeeye.framework.controller.BaseController;
import com.threeeye.framework.domain.JsonResult;
import com.threeeye.framework.exception.PlatformException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "预警处理控制器API",tags = {"预警处理","查询统计预警相关"})
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
    public JsonResult<Goods> addGoods(@RequestBody Goods goods,
                                      @RequestParam(value = "id",required = false)Integer id){
        return buildSuccJson(goodsService.addGoods(goods,id));
    }

    @APIMapping("getBeeElement")
    @ApiOperation(value = "测试获取Element")
    @RequestMapping(value = "/getBeeElement", method = {RequestMethod.GET})
    public BeeElement getBeeElement() throws PlatformException {
        try {
//            throw new PlatformException(HbtErrMsgEnum.NUMBER_NULL);
            String h = "1";
            if(!h.equals("2")){
                throw new PlatformException(HbtErrMsgEnum.NUMBER_NULL);
            }
        }catch (Exception ex){
            throw new PlatformException(HbtErrMsgEnum.NUMBER_NULL);
        }
        return goodsService.getBeeElement();
    }
}
