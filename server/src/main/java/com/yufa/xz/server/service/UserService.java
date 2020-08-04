package com.yufa.xz.server.service;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ly
 * @data 2020/7/31
 */
public class UserService {
    /**
     * 返回全部user列表
     *
     * @return 全部
     */
    public String listAll(){
        System.out.println("Method listAll called.");
        List<Map> userList = new ArrayList<>();
        Map<String, Object> userMap1 = new HashMap<>(3);
        userMap1.put("name", "AAA");
        userMap1.put("age", 111);
        userMap1.put("sex", 1);
        userList.add(userMap1);

        Map<String, Object> userMap2 = new HashMap<>(3);
        userMap2.put("name", "BBB");
        userMap2.put("age", 222);
        userMap2.put("sex", 1);
        userList.add(userMap2);

        Map<String, Object> userMap3 = new HashMap<>(3);
        userMap3.put("name", "CCC");
        userMap3.put("age", 333);
        userMap3.put("sex", 1);
        userList.add(userMap3);

        System.out.println("***********");

        return JSON.toJSONString(userList);
    }

    /**
     * 返回id对应user
     * @param id userId
     * @return user(Map示例)
     */
    public String listById(Integer id){
        System.out.println("Method listById called.");

        Map<String, Object> userMap = new HashMap<>(3);
        userMap.put("name", "AAA");
        userMap.put("age", 111);
        userMap.put("sex", 1);


        System.out.println("***********");

        return JSON.toJSONString(userMap);

    }

    /**
     * 添加user
     * @param name name
     * @param age age
     * @param sex sex
     * @return 0 or X
     */
    public Integer create(String name, Integer age, Integer sex){
        System.out.println("Method create called");
        System.out.println("name=" + name);
        System.out.println("age=" + age);
        System.out.println("sex=" + sex);
        System.out.println("*************************");

        return 1;
    }
}
