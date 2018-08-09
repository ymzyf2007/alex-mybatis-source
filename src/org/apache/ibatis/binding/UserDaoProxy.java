package org.apache.ibatis.binding;

public class UserDaoProxy implements IUserDao {
	
	private IUserDao userDao;
	
	public UserDaoProxy(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save() {
		System.out.println("user save...前置通知");
		userDao.save();
		System.out.println("user save...后置通知");
	}

}