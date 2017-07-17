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
	//1.��������ϵ�˽���ķ���
	public String toAddPage(){
		//1.��ѯ�����пͻ��������пͻ�List���ϴ���ҳ������ʾ���ŵ������
		//���ÿͻ�service����ķ����õ����пͻ�
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "toAddPage";
	}
	/*
	 * ��Ҫ�ϴ��ļ�������
	 * ��Ҫ�ϴ��ļ�����
	 * sturct2�õ�����
	 * ��1��Сһ����action�����Ա������λ�ö���λ�ã������淶��
	 * - һ����ʾ�ϴ��ļ�
	 * - һ����ʾ�ļ�����
	 * ��2������������get��set����
	 * ����һ���������ϴ��ļ����mime����
	 */
	//1�ϴ��ļ�
	//���������Ǳ������ļ��ϴ����nameֵ
	private File upload;
	//2�ϴ��ļ�������
	//���������Ǳ������ļ��ϴ����nameֵ+FileName
	private String uploadFileName;
	//3����get\set����
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
	
	//2.������ݵ����ݿ�ķ���
	public String addLinkMan() throws IOException{
		//�ж��Ƿ���Ҫ�ϴ��ļ�
		if(upload!=null){
			//д�ϴ�����
			//�ڷ������ļ������洴���ļ�
			File serverFile = new File("t:\\f"+"/"+uploadFileName);
			//���ϴ��ļ����Ƶ��������ļ���
			FileUtils.copyFile(upload, serverFile);
		}
		
		
		/*
		 * ���Է�װ��ϵ�˵Ļ�����Ϣ��������cid�ǿͻ�idֵ����ֱ�ӷ�װ
		 * ��cid��װ��LinkManʵ���������customer��������
		 * 
		 */
		
		//ԭʼ��ʽʵ��
		/*String scid = ServletActionContext.getRequest().getParameter("cid");
		int cid = Integer.parseInt(scid);
		//����customer����
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
