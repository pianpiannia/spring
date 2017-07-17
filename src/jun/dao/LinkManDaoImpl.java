package jun.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import jun.entity.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	@Override
	//1.�����ϵ�˵ķ���
	public void addLinkMan(LinkMan linkMan) {
		this.getHibernateTemplate().save(linkMan);
	}

	@Override
	public LinkMan findOne(int linkid) {
		
		
		return this.getHibernateTemplate().get(LinkMan.class, linkid);
	}

	//��������ѯ
	/*public List<LinkMan> findCondition(LinkMan linkMan) {
		String hql = "from LinkMan where 1=1";
		List<Object> p = new ArrayList<Object>();
		if(linkMan.getLkmName()!=null&&"".equals(linkMan.getLkmName())){
			hql += " and lkmName=?";
			p.add(linkMan.getLkmName());
		}
		//�ж��Ƿ�ѡ��ͻ�
		if(linkMan.getCustomer().getCid()!=null&&linkMan.getCustomer().getCid()>0){
			//�жϿͻ�����cid��ֵ
			hql += " and customer.cid=?";
			p.add(linkMan.getCustomer().getCid());
		}
		return (List<LinkMan>) this.getHibernateTemplate().find(hql, p.toArray());
	}*/
	public List<LinkMan> findCondition(LinkMan linkMan) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		if(linkMan.getLkmName()!=null&&"".equals(linkMan.getLkmName())){
			criteria.add(Restrictions.eq("lkmName", linkMan.getLkmName()));
		}
		//�ж��Ƿ�ѡ��ͻ�
		if(linkMan.getCustomer().getCid()!=null&&linkMan.getCustomer().getCid()>0){
			//�жϿͻ�����cid��ֵ
			criteria.add(Restrictions.eq("custoemr.cid", linkMan.getCustomer().getCid()));
		}
		return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<LinkMan> list() {
		// TODO Auto-generated method stub
		return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
	}

}
