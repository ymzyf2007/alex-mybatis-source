package org.apache.ibatis.binding;

public class StaticProxyTest {
	
	public static void main(String[] args) {
		IUserDao target = new UserDao();
		IUserDao proxy = new UserDaoProxy(target);
		proxy.save();
	}

}
