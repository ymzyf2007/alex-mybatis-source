package org.apache.ibatis.binding;

public class DynamicProxyTest {
	
	public static void main(String[] args) {
		IUserDao target = new UserDao();
		IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
		proxy.save();
	}

}