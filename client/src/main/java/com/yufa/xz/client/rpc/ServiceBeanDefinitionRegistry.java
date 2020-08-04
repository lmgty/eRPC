package com.yufa.xz.client.rpc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @data 2020/8/4
 */
@Component
public class ServiceBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        try {
            Class<?> clazz = Class.forName("com.yufa.xz.client.remoteservice.UserService");
            registerBean(beanDefinitionRegistry, clazz);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void registerBean(BeanDefinitionRegistry registry, Class clazz) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
        definition.getConstructorArgumentValues().addGenericArgumentValue(clazz);
        definition.setBeanClass(ServiceFactory.class);
        definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        registry.registerBeanDefinition(clazz.getSimpleName(), definition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
