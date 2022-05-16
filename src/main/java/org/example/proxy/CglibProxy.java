package org.example.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Object object;

    public CglibProxy(Object o) {
        this.object=o;

    }

    public Object getInstance(){
        Enhancer en =new Enhancer();
        en.setSuperclass(object.getClass());
        en.setCallback(this);
        return  en.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务.....");

        // 执行目标对象的方法
        //Object returnValue = method.invoke(o, objects);
        methodProxy.invokeSuper(o, objects);
        System.out.println("提交事务.....");

        return null;
    }
}
