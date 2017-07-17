package jun.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import jun.dao.UserDao;
import jun.entity.User;

@Transactional
public class UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	//登录的方法
	public User login(User user) {
		//调用dao里面方法
		
		return userDao.loginUser(user);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	
}
