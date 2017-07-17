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

	//封装分页数据到pageBean对象里面
	public PageBean listPage(Integer currentPage) {
		//创建PageBean对象
		PageBean pageBean = new PageBean();
		//当前页
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount = customerDao.findCount();
		pageBean.setTotalCount(totalCount);
		//每页显示纪录输
		int pageSize = 3;
		//总页数
		//是否能够整除
		int totalPage = 0;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		
		//开始的位置
		int begin = (currentPage-1)*pageSize;
		
		//每页纪录的list集合
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
