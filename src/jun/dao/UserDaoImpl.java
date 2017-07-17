package jun.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import jun.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
//	private HibernateTemplate hibernateTemplate;
//
//	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
//		this.hibernateTemplate = hibernateTemplate;
//	}
	
	@SuppressWarnings("all")
	//登录的方法
	public User loginUser(User user) {
		// 调用方法得到hibernateTemplate对象
		HibernateTemplate  hibernateTemplate = this.getHibernateTemplate();
		//登录的查询操作
		//根据用户名和密码查询
		List<User> list = (List<User>) this.getHibernateTemplate().
				find("from User where username=? and password=?", user.getUsername(),user.getPassword());
		//返回user对象,如果没有结果list里面没有值，根据get获取不到值，出现下标越界异常
		if(list.size()!=0 && list!=null){
		User use = list.get(0);
		return use;
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) this.getHibernateTemplate().find("from User");
	}


}
