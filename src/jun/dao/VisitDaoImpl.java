package jun.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import jun.entity.Visit;

public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {

	//��ӿͻ��ݷ�
	public void add(Visit visit) {
		this.getHibernateTemplate().save(visit);
	}

	//�ݷ��б�
	public List<Visit> findAll() {
		
		return (List<Visit>) this.getHibernateTemplate().find("from Visit");
	}

}
