package com.yufa.xz.client.rpc;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @data 2020/7/30
 */
public class ServiceProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RemoteClass remoteClass = method.getDeclaringClass().getAnnotation(RemoteClass.class);

        List<Object> argsTypeList = new ArrayList<>();
        if (args != null) {
            for (Object arg : args) {
                argsTypeList.add(arg.getClass().getName());
            }
        }

        String argsTypes = JSON.toJSONString(argsTypeList);
        String argValues = JSON.toJSONString(args);

        Result result = HttpUtils.callRemoteService(remoteClass.value(), method.getName(), argsTypes, argValues);
        if (result.isSuccess()) {
            return JSON.parseObject(result.getResultValue(), Class.forName(result.getResultType()));
        } else {
            throw new Exception("远程调用异常："+ result.getMessage());
        }
    }
}
