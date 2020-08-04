package com.yufa.xz.server;

import com.alibaba.fastjson.JSON;
import com.yufa.xz.server.controller.ServerController;
import com.yufa.xz.server.rpc.Result;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ServerApplicationTests {

    @Autowired
    private ServerController serverController;

    @Test
    void contextLoads() {
    }

    @Test
    void rpcMethodTest(){
        Result result = serverController.rpcMethod("com.yufa.xz.server.service.UserService",
                "listAll",
                "[]", "null");
        System.out.println("result: "+result);
    }

    @Test
    void listByIdTest(){
        Result result = serverController.rpcMethod("com.yufa.xz.server.service.UserService",
                "listById",
                "[\"java.lang.Integer\"]", "[1]");
        System.out.println("result: "+result);
    }

    @Test
    void createTest(){
        Result result = serverController.rpcMethod("com.yufa.xz.server.service.UserService",
                "create",
                "[\"java.lang.String\",\"java.lang.Integer\",\"java.lang.Integer\"]",
                "[\"Tom\", 222, 333]");
        System.out.println("result: "+result);
    }

    @Test
    void toArrayTest(){

        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            stringList.add("string: " + i);
        }
//        Object[] objects = stringList.toArray();

        String[] a = new String[5];
        String[] strings1 = stringList.toArray(a);


        String[] b = new String[3];
        String[] strings2 = stringList.toArray(b);



    }

    @Test
    void parseObjectTest() throws ClassNotFoundException {
        Object t1 = JSON.parseObject("16", Class.forName("java.lang.Integer"));
    }

}
