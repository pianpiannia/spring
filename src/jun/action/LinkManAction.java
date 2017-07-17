package jun.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import jun.entity.Customer;
import jun.entity.LinkMan;
import jun.service.CustomerService;
import jun.service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{

	private LinkMan linkMan = new LinkMan();
	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}
	
	private LinkManService linkManService;

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	//1.到新增联系人界面的方法
	public String toAddPage(){
		//1.查询出所有客户，把所有客户List集合传到页面中显示（放到域对象）
		//调用客户service里面的方法得到所有客户
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "toAddPage";
	}
	/*
	 * 需要上传文件（流）
	 * 需要上传文件名称
	 * sturct2得到过程
	 * （1）小一条在action里面成员变量的位置定义位置（命名规范）
	 * - 一个表示上传文件
	 * - 一个表示文件名称
	 * （2）生产变量的get和set方法
	 * 还有一个变量，上传文件项的mime类型
	 */
	//1上传文件
	//变量名称是表单里面文件上传项的name值
	private File upload;
	//2上传文件的名称
	//变量名称是表单里面文件上传项的name值+FileName
	private String uploadFileName;
	//3生成get\set方法
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	//2.添加数据到数据库的方法
	public String addLinkMan() throws IOException{
		//判断是否需要上传文件
		if(upload!=null){
			//写上传代码
			//在服务器文件夹里面创建文件
			File serverFile = new File("t:\\f"+"/"+uploadFileName);
			//把上传文件复制到服务器文件里
			FileUtils.copyFile(upload, serverFile);
		}
		
		
		/*
		 * 可以封装联系人的基本信息，但是有cid是客户id值不能直接封装
		 * 把cid封装到LinkMan实体类里面的customer对象里面
		 * 
		 */
		
		//原始方式实现
		/*String scid = ServletActionContext.getRequest().getParameter("cid");
		int cid = Integer.parseInt(scid);
		//创建customer对象
		Customer c = new Customer();
		c.setCid(cid);
		linkMan.setCustomer(c);*/
		
		linkManService.addLinkMan(linkMan);
		
		return "addLinkMan";
	}
	
	public String showLinkMan(){
		
		int linkid = linkMan.getLinkId();
		LinkMan link = linkManService.findOne(linkid);
		List<Customer> listCustomer = customerService.findAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("link", link);
		request.setAttribute("listCustomer", listCustomer);
		return "showLinkMan";
	}
	
	public String list(){
		List<LinkMan> list = linkManService.list();
		ServletActionContext.getRequest().setAttribute("list", list);	
		return "list";
	}
	public String toSelectPage(){
		List<Customer> list = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toSelectPage";
	}
	
	public String moreCondition(){
		List<LinkMan> list = linkManService.findCondition(linkMan);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "moreCondition";
	}
}
