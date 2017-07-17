package jun.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import jun.entity.User;
import jun.service.UserService;

public class UserAction extends ActionSupport {

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//���Է�װ��ȡ
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//��¼�ķ���
	public String login(){
		//��װ��ʵ�������
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//����service�ķ���ʵ��
		User userExist = userService.login(user);
		//�ж�
		if(userExist != null){//�ɹ�
			//ʹ��session�����¼״̬
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user", userExist);
			return "loginsuccess";
		}else{//ʧ��
		return "login";
		}
	}
}
