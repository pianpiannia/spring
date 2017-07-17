package jun.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import jun.entity.Customer;
import jun.entity.User;
import jun.entity.Visit;
import jun.service.CustomerService;
import jun.service.UserService;
import jun.service.VisitService;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{
	
	Visit visit = new Visit();
	public Visit getModel() {
		// TODO Auto-generated method stub
		return visit;
	}
	
	private VisitService visitService;

	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	
	private CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private List<Visit> list;
	public List<Visit> getList() {
		return list;
	}

	public String toAddPage(){
		//查询所有客户
		List<Customer> listCustomer = customerService.findAll();
		//查询所有用户
		List<User> listUser = userService.findAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listCustomer", listCustomer);
		request.setAttribute("listUser", listUser);
		return "toAddPage";
	}
	
	public String addVisit(){
		visitService.addVisit(visit);
		return "addVisit";
	}
	public String list(){
		list = visitService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	
}
