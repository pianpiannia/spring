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
	//������ѯ����
	public String listcondition(){		
		//�������Ͳ�ѯ
		if(customer.getCustName()!=null && !"".equals(customer.getCustName())){
			List<Customer> list = customerService.finCondition(customer);
			ServletActionContext.getRequest().setAttribute("list", list);
		}else{
			//������������ݣ��Ͳ�ѯ����
			//list();
			list = customerService.findAll();
		}
		
		return "listcondition";
	}
	
	//ʹ�����Է�װ��ȡ��ǰҳ
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	//��ҳ����
	public String listPage(){
		//����service���淽��ʵ�ַ�װ
		PageBean pageBean = customerService.listPage(currentPage);
		//�ŵ������
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listPage";
	}
	
	//1.�����ҳ��
		public String toAddPage(){
			List<Dict> listDict = customerService.findAllDictLevel();
			ServletActionContext.getRequest().setAttribute("listDict", listDict);
			return "toAddPage";
		}
		
		//2.��ӵķ���
		public String add(){
			//����߼�
			customerService.add(customer);
			return "add";
		}
		
		//����list����
		private List<Customer> list;
		//���ɱ�����get����
		public List<Customer> getList() {
			return list;
		}
		//3.�ͻ��б�ķ���
		public String list(){
			//��һ�ַ�ʽ���ŵ������
//			List<Customer> list = customerService.findAll();
			
//			ServletActionContext.getRequest().setAttribute("list", list);
			
			//�ڶ��ַ�ʽ������list�ŵ�ֵջ
			list = customerService.findAll();
			return "list";
		}
		//4.ɾ���ķ���
		public String delete(){
			//ʹ��ģ��������ñ����ύ��cidֵ
			int cid = customer.getCid();
			//ɾ���淶���������ȸ���cid��ѯ����ɾ��
			Customer c = customerService.findOne(cid);
			if(c != null){
				customerService.delete(c);
			}
			return "delete";
		}
		//5.�޸�-����id��ѯ
		public String showCustomer(){
			
			int cid  = customer.getCid();
			Customer c = customerService.findOne(cid);
			//�ŵ����������
			ServletActionContext.getRequest().setAttribute("customer", c);
			
			return "showCustomer";
		}
		//6.�޸ķ���
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
		//������Դͳ��
		public String countSource(){
			List list = customerService.findCountSource();
			ServletActionContext.getRequest().setAttribute("list", list);
			return "countSource";
		} 
		//���ݼ���ͳ��
		public String countLevel(){
			List list = customerService.findCountLevel();
			ServletActionContext.getRequest().setAttribute("list", list);
			return "countLevel";
		}
}
