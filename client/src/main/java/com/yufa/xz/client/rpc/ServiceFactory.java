package com.yufa.xz.client.rpc;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author admin
 * @data 2020/8/4
 */
public class ServiceFactory<T> implements FactoryBean<T> {

    private Class<T> interfaceType;

    public ServiceFactory(Class<T> interfaceType) {
        this.interfaceType = interfaceType;
    }

    @Override
    public T getObject() {
        InvocationHandler handler = new ServiceProxy();
        return (T) Proxy.newProxyInstance(interfaceType.getClassLoader(),
                new Class[]{interfaceType}, handler);
    }

    @Override
    public Class<T> getObjectType() {
        return interfaceType;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}