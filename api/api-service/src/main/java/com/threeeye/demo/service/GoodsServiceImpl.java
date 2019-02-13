package com.threeeye.demo.service;

import com.threeeye.demo.api.domain.BeeElement;
import com.threeeye.demo.api.domain.Goods;
import com.threeeye.expends.mybatis.mapper.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GoodsServiceImpl {

    public Goods addGoods(Goods goods, Integer id){
        return goods;
    }


    @Autowired
    private SqlMapper sqlMapper;


    public BeeElement getBeeElement(){
        Map<String,Object> param = new HashMap<>();
        param.put("id",1);
        String sql = "<script> select * from bee_element where 1=1  <if test=\"id != null\"> and id = #{id} </if></script> ";
        return sqlMapper.selectOne(sql,param,BeeElement.class);
    }

}
