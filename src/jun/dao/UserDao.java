package jun.dao;

import java.util.List;

import jun.entity.User;

public interface UserDao {

	User loginUser(User user);

	List<User> findAll();
}
