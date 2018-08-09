package org.apache.ibatis.binding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态创建代理对象
 * @author Administrator
 *
 */
public class ProxyFactory {
	
	private Object target;
	
	public ProxyFactory(Object target) {
		this.target = target;
	}
	
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("前置通知...");
				Object returnValue = method.invoke(target, args);
				System.out.println("后置通知...");
				return returnValue;
			}
		});
	}

}