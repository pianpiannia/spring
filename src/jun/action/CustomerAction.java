package jun.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import jun.entity.Customer;
import jun.entity.Dict;
import jun.entity.PageBean;
import jun.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	//条件查询方法
	public String listcondition(){		
		//如果输入就查询
		if(customer.getCustName()!=null && !"".equals(customer.getCustName())){
			List<Customer> list = customerService.finCondition(customer);
			ServletActionContext.getRequest().setAttribute("list", list);
		}else{
			//如果不输入内容，就查询所有
			//list();
			list = customerService.findAll();
		}
		
		return "listcondition";
	}
	
	//使用属性封装获取当前页
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	//分页方法
	public String listPage(){
		//调用service里面方法实现封装
		PageBean pageBean = customerService.listPage(currentPage);
		//放到域对象
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listPage";
	}
	
	//1.到添加页面
		public String toAddPage(){
			List<Dict> listDict = customerService.findAllDictLevel();
			ServletActionContext.getRequest().setAttribute("listDict", listDict);
			return "toAddPage";
		}
		
		//2.添加的方法
		public String add(){
			//添加逻辑
			customerService.add(customer);
			return "add";
		}
		
		//定义list变量
		private List<Customer> list;
		//生成变量的get方法
		public List<Customer> getList() {
			return list;
		}
		//3.客户列表的方法
		public String list(){
			//第一种方式：放到域对象
//			List<Customer> list = customerService.findAll();
			
//			ServletActionContext.getRequest().setAttribute("list", list);
			
			//第二种方式：返回list放到值栈
			list = customerService.findAll();
			return "list";
		}
		//4.删除的方法
		public String delete(){
			//使用模型驱动获得表单里提交的cid值
			int cid = customer.getCid();
			//删除规范方法：首先根据cid查询，再删除
			Customer c = customerService.findOne(cid);
			if(c != null){
				customerService.delete(c);
			}
			return "delete";
		}
		//5.修改-根据id查询
		public String showCustomer(){
			
			int cid  = customer.getCid();
			Customer c = customerService.findOne(cid);
			//放到域对象里面
			ServletActionContext.getRequest().setAttribute("customer", c);
			
			return "showCustomer";
		}
		//6.修改方法
		public String update(){
			customerService.update(customer);
			return "update";
		}
		
		public String toSelectCustomerPage(){
			return "toSelectCustomerPage";
		}
		public String moreCondition(){
			List<Customer> list = customerService.findMoreCondition(customer);
			ServletActionContext.getRequest().setAttribute("list", list);
			return "moreCondition";
		}
		//根据来源统计
		public String countSource(){
			List list = customerService.findCountSource();
			ServletActionContext.getRequest().setAttribute("list", list);
			return "countSource";
		} 
		//根据级别统计
		public String countLevel(){
			List list = customerService.findCountLevel();
			ServletActionContext.getRequest().setAttribute("list", list);
			return "countLevel";
		}
}
