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
	//��¼�ķ���
	public User loginUser(User user) {
		// ���÷����õ�hibernateTemplate����
		HibernateTemplate  hibernateTemplate = this.getHibernateTemplate();
		//��¼�Ĳ�ѯ����
		//�����û����������ѯ
		List<User> list = (List<User>) this.getHibernateTemplate().
				find("from User where username=? and password=?", user.getUsername(),user.getPassword());
		//����user����,���û�н��list����û��ֵ������get��ȡ����ֵ�������±�Խ���쳣
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
