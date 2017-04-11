package cn.service.impl;

import cn.dao.UserDao;
import cn.dao.impl.UserDaoJdbcImpl;
import cn.domain.User;
import cn.exception.ServiceUserExist;
import cn.utils.ServiceUtils;

public class BusinessServiceImpl {
	
	private UserDao dao = new  UserDaoJdbcImpl();
	public void register(User user) throws ServiceUserExist {
		boolean b = dao.find(user.getUsername());
		if(b) {
			throw new ServiceUserExist("用户名已存在！");
		} else {
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			dao.add(user);
		}
	}
	
	public User login(String username, String password) {
		return dao.find(username, ServiceUtils.md5(password));
	}
}
