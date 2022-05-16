package org.example.circulardependencies;

import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.AopProxyFactory;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.framework.DefaultAopProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;


//@Component
public class JdkProxyBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

	@Override
	public Class<?> predictBeanType(Class<?> aClass, String s) throws BeansException {
		return null;
	}

	@Override
	public Constructor<?>[] determineCandidateConstructors(Class<?> aClass, String s) throws BeansException {
		return new Constructor[0];
	}

	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {

		// 假设:A 被切点命中 需要创建代理  @PointCut("execution(* *..InstanceA.*(..))")
		if(bean instanceof InstanceA) {
			JdkDynimcProxy jdkDynimcProxy = new JdkDynimcProxy(bean);
			return  jdkDynimcProxy.getProxy();
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInstantiation(Class<?> aClass, String s) throws BeansException {
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object o, String s) throws BeansException {
		return false;
	}

	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues propertyValues, PropertyDescriptor[] propertyDescriptors, Object o, String s) throws BeansException {
		return null;
	}

	@Override
	public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
		return null;
	}
}
