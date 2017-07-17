package jun.dao;

import java.util.List;

import jun.entity.Customer;
import jun.entity.Dict;

public interface CustomerDao {

	void add(Customer customer);

	List<Customer> findAll();

	Customer finOne(int cid);

	void delete(Customer c);

	void update(Customer customer);

	int findCount();

	List<Customer> findPage(int begin, int pageSize);

	List<Customer> finCondition(Customer customer);

	List<Customer> findMoreCondition(Customer customer);

	List<Dict> findAllDictLevel();

	List findCountSource();

	List findCountLevel();

}
