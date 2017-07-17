package jun.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import jun.dao.CustomerDao;
import jun.entity.Customer;
import jun.entity.Dict;
import jun.entity.PageBean;

@Transactional
public class CustomerService {

	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void add(Customer customer) {
		customerDao.add(customer);
	}

	public List<Customer> findAll() {
		
		return customerDao.findAll();
	}

	public Customer findOne(int cid) {
		// TODO Auto-generated method stub
		return customerDao.finOne(cid);
	}

	public void delete(Customer c) {
		customerDao.delete(c);
	}

	public void update(Customer customer) {
		customerDao.update(customer);
	}

	//��װ��ҳ���ݵ�pageBean��������
	public PageBean listPage(Integer currentPage) {
		//����PageBean����
		PageBean pageBean = new PageBean();
		//��ǰҳ
		pageBean.setCurrentPage(currentPage);
		//�ܼ�¼��
		int totalCount = customerDao.findCount();
		pageBean.setTotalCount(totalCount);
		//ÿҳ��ʾ��¼��
		int pageSize = 3;
		//��ҳ��
		//�Ƿ��ܹ�����
		int totalPage = 0;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		
		//��ʼ��λ��
		int begin = (currentPage-1)*pageSize;
		
		//ÿҳ��¼��list����
		List<Customer> list = customerDao.findPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	public List<Customer> finCondition(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.finCondition(customer);
	}

	public List<Customer> findMoreCondition(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.findMoreCondition(customer);
	}

	public List<Dict> findAllDictLevel() {
		// TODO Auto-generated method stub
		return customerDao.findAllDictLevel();
	}

	public List findCountSource() {
		// TODO Auto-generated method stub
		return customerDao.findCountSource();
	}

	public List findCountLevel() {
		// TODO Auto-generated method stub
		return customerDao.findCountLevel();
	}
	
	
}
