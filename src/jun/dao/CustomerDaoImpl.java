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

	//添加客户功能
	public void add(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	//客户列表功能
	@SuppressWarnings("all")
	public List<Customer> findAll() {
		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}

	@Override
	//根据cid查询
	public Customer finOne(int cid) {
		
		return this.getHibernateTemplate().get(Customer.class, cid);
	}

	@Override
	//删除功能
	public void delete(Customer c) {
		this.getHibernateTemplate().delete(c);
	}

	@Override
	//修改
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

	@Override
	//查询记录数
	public int findCount() {
		// 调用模板的find方法实现
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Customer");
		//从list中把值得到
		if(list != null && list.size() != 0){
			Object obj = list.get(0);
			//先变成long类型
			Long lobj = (Long) obj;
			int count = lobj.intValue();
			return count;
		}
		
		return 0;
	}

	@Override
	//分页查询操作
	public List<Customer> findPage(int begin, int pageSize) {
		//第一种：使用hibernate底层代码实现（了解）
		//先得到sessionFactory
		/*SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		//得到session对象
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Customer");
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		
		List<Customer> list = query.list();*/
		
		//第二种：使用离线对象和hibernateTemplate的方法实现
		//1.创建离线对象，设置对哪个实体类进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//2.调用模板方法来实现x
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}

	@SuppressWarnings("all")
	@Override
	public List<Customer> finCondition(Customer customer) {
		//第一种：使用hibernate底层代码实现（了解）
		/*		//先得到sessionFactory
			SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
				//得到session对象
			Session session = sessionFactory.getCurrentSession();
				
			Query query = session.createQuery("from Customer where custName like ?");
			query.setParameter(0, "%"+customer.getCustName()+"%");
			List<Customer> list = query.list();
			return list;*/
		
		//第二种方式
		/*List<Customer> list = (List<Customer>) this.getHibernateTemplate().
				find("from Customer where custName like ?", "%"+customer.getCustName()+"%");
		return list;*/
		
		//第三种：离线操作
		//1.创建离线对象，设置哪个实体类进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//2.设置对实体类哪个属性操作
		criteria.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
		//3.调用模板中的方法
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	//多条件组合查询
	/*public List<Customer> findMoreCondition(Customer customer) {
		//1-使用hibernate模板里面find方法实现
		//拼接hql语句
		String hql = "from Customer where 1=1";
		//创建list集合，如果值不为空，就把值设置到list里面
		List<Object> p = new ArrayList<Object>();
		//判断条件值是否为空，如果不为空就拼接
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
		//2.使用离线对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//判断条件值是否为空
		if(customer.getCustName()!=null&&!"".equals(customer.getCustName())){
			//对属性设置值
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

	//根据客户来源统计
	@SuppressWarnings("all")
	public List findCountSource() {
		// 复杂语句，直接调用底层sql实现
		//SQLQuery对象
		//1.得到sessionFactory对象
		//this.getHibernateTemplate().getSessionFactory();
		Session session = this.getSessionFactory().getCurrentSession();
		//2.创建SQLQuery对象
		SQLQuery sqlQuery = session.createSQLQuery("select count(*)as num,custSource from t_customer2 group by custSource");
		//sqlQuery原内容为数组结果
		//调用方法将内容转换为map结构
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		
		List list = sqlQuery.list();
		
		return list;
	}

	//根据客户级别统计
	@SuppressWarnings("all")
	public List findCountLevel() {
		Session session = this.getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("select c.num,d.dname from (select count(*)as num,custLevel from t_customer2 group by custLevel) c,t_dict d where c.custLevel=d.did");
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		List list = sqlQuery.list();
		return list;
	}

}
