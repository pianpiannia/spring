package jun.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sun.org.apache.xalan.internal.xsltc.cmdline.Transform;

import jun.entity.Customer;
import jun.entity.Dict;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{

	//��ӿͻ�����
	public void add(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	//�ͻ��б���
	@SuppressWarnings("all")
	public List<Customer> findAll() {
		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}

	@Override
	//����cid��ѯ
	public Customer finOne(int cid) {
		
		return this.getHibernateTemplate().get(Customer.class, cid);
	}

	@Override
	//ɾ������
	public void delete(Customer c) {
		this.getHibernateTemplate().delete(c);
	}

	@Override
	//�޸�
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

	@Override
	//��ѯ��¼��
	public int findCount() {
		// ����ģ���find����ʵ��
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Customer");
		//��list�а�ֵ�õ�
		if(list != null && list.size() != 0){
			Object obj = list.get(0);
			//�ȱ��long����
			Long lobj = (Long) obj;
			int count = lobj.intValue();
			return count;
		}
		
		return 0;
	}

	@Override
	//��ҳ��ѯ����
	public List<Customer> findPage(int begin, int pageSize) {
		//��һ�֣�ʹ��hibernate�ײ����ʵ�֣��˽⣩
		//�ȵõ�sessionFactory
		/*SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		//�õ�session����
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Customer");
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		
		List<Customer> list = query.list();*/
		
		//�ڶ��֣�ʹ�����߶����hibernateTemplate�ķ���ʵ��
		//1.�������߶������ö��ĸ�ʵ������в���
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//2.����ģ�巽����ʵ��x
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}

	@SuppressWarnings("all")
	@Override
	public List<Customer> finCondition(Customer customer) {
		//��һ�֣�ʹ��hibernate�ײ����ʵ�֣��˽⣩
		/*		//�ȵõ�sessionFactory
			SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
				//�õ�session����
			Session session = sessionFactory.getCurrentSession();
				
			Query query = session.createQuery("from Customer where custName like ?");
			query.setParameter(0, "%"+customer.getCustName()+"%");
			List<Customer> list = query.list();
			return list;*/
		
		//�ڶ��ַ�ʽ
		/*List<Customer> list = (List<Customer>) this.getHibernateTemplate().
				find("from Customer where custName like ?", "%"+customer.getCustName()+"%");
		return list;*/
		
		//�����֣����߲���
		//1.�������߶��������ĸ�ʵ������в���
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//2.���ö�ʵ�����ĸ����Բ���
		criteria.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
		//3.����ģ���еķ���
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	//��������ϲ�ѯ
	/*public List<Customer> findMoreCondition(Customer customer) {
		//1-ʹ��hibernateģ������find����ʵ��
		//ƴ��hql���
		String hql = "from Customer where 1=1";
		//����list���ϣ����ֵ��Ϊ�գ��Ͱ�ֵ���õ�list����
		List<Object> p = new ArrayList<Object>();
		//�ж�����ֵ�Ƿ�Ϊ�գ������Ϊ�վ�ƴ��
		if(customer.getCustName()!=null && !"".equals(customer.getCustName())){
			hql += " and custName=?";
			p.add(customer.getCustName());
		}
		if(customer.getCustLevel()!=null && !"".equals(customer.getCustLevel())){
			hql += " and custLevel=?";
			p.add(customer.getCustLevel());
		}
		if(customer.getCustSource()!=null && !"".equals(customer.getCustSource())){
			hql += " and custSource=?";
			p.add(customer.getCustSource());
		}
		System.out.println("hql:"+hql);
		System.out.println("list:"+p);
		return (List<Customer>) this.getHibernateTemplate().find(hql, p.toArray());
	
	
	}*/
	public List<Customer> findMoreCondition(Customer customer) {
		//2.ʹ�����߶���
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//�ж�����ֵ�Ƿ�Ϊ��
		if(customer.getCustName()!=null&&!"".equals(customer.getCustName())){
			//����������ֵ
			criteria.add(Restrictions.eq("custName", customer.getCustName()));
		}
		/*if(customer.getCustLevel()!=null && !"".equals(customer.getCustLevel())){
			criteria.add(Restrictions.eq("custLevel", customer.getCustLevel()));
		}*/
		if(customer.getCustSource()!=null && !"".equals(customer.getCustSource())){
			criteria.add(Restrictions.eq("custSource", customer.getCustSource()));
		}
		
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
	
	
	}

	@Override
	public List<Dict> findAllDictLevel() {
		
		return (List<Dict>) this.getHibernateTemplate().find("from Dict");
	}

	//���ݿͻ���Դͳ��
	@SuppressWarnings("all")
	public List findCountSource() {
		// ������䣬ֱ�ӵ��õײ�sqlʵ��
		//SQLQuery����
		//1.�õ�sessionFactory����
		//this.getHibernateTemplate().getSessionFactory();
		Session session = this.getSessionFactory().getCurrentSession();
		//2.����SQLQuery����
		SQLQuery sqlQuery = session.createSQLQuery("select count(*)as num,custSource from t_customer2 group by custSource");
		//sqlQueryԭ����Ϊ������
		//���÷���������ת��Ϊmap�ṹ
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		
		List list = sqlQuery.list();
		
		return list;
	}

	//���ݿͻ�����ͳ��
	@SuppressWarnings("all")
	public List findCountLevel() {
		Session session = this.getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("select c.num,d.dname from (select count(*)as num,custLevel from t_customer2 group by custLevel) c,t_dict d where c.custLevel=d.did");
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		List list = sqlQuery.list();
		return list;
	}

}
