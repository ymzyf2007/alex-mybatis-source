package org.apache.ibatis.binding;

public class UserDao implements IUserDao {

	@Override
	public void save() {
		System.out.println("user save...");
	}

}
