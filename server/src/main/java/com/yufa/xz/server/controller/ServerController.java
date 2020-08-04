package com.yufa.xz.server.controller;

import com.alibaba.fastjson.JSON;
import com.yufa.xz.server.rpc.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @data 2020/7/31
 */

@RestController
public class ServerController {

    @RequestMapping("/")
    public Result rpcMethod(String identifier, String methodName,
                            String argTypes, String argValues){

        try {
            Class<?> clazz = Class.forName(identifier);

            List<String> argTypeStringList = JSON.parseArray(argTypes, String.class);
            List<String> argValueStringList = JSON.parseArray(argValues, String.class);
            Class[] argTypeArray = new Class[argTypeStringList.size()];
            Object[] argValueArray = new Object[argTypeStringList.size()];

            // 将参数类型列表和参数值列表 转换为 参数类型数组 和 参数值数组
            // 以便下面用于反射
            argListToArray(argTypeStringList, argValueStringList, argTypeArray, argValueArray);

            Method method = clazz.getMethod(methodName, argTypeArray);
            Object result = method.invoke(clazz.newInstance(), argValueArray);

            Result re = Result.getSuccessResult(method.getReturnType().getName(), JSON.toJSONString(result));
            return re;

        } catch (Exception e) {
            e.printStackTrace();
            return Result.getFailResult("服务端解析异常");
        }
    }

    private void argListToArray(List<String> argTypeStringList,
                                List<String> argValueStringList,
                                Class[] argTypeArray,
                                Object[] argValueArray) throws ClassNotFoundException {
        List<Class> argTypeList = new ArrayList<>();
        for (String type : argTypeStringList) {
            argTypeList.add(Class.forName(type));
        }
        argTypeList.toArray(argTypeArray);

        List<Object> argValueList = new ArrayList<>();
        for (int i = 0; i < argTypeList.size(); i++) {
            if (argTypeList.get(i).equals(String.class)){
                argValueList.add(argValueStringList.get(i));
            }else {
                argValueList.add(JSON.parseObject(argValueStringList.get(i), argTypeList.get(i)));
            }
        }
        argValueList.toArray(argValueArray);
    }
}
