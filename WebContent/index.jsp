<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	��ӭ��${user.username }
	<table>
		<tr><td><a href="${pageContext.request.contextPath }/customer_toAddPage.action" target="_blank">
				�����ͻ�</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/customer_list.action" target="_blank">
				�ͻ��б�</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/customer_listPage.action?currentPage=1" target="_blank">
				��ҳ�ͻ��б�</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/customer_toSelectCustomerPage.action" target="_blank">
				�ͻ���ѯ</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/linkMan_toAddPage.action" target="_blank">
				������ϵ��</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/linkMan_list.action" target="_blank">
				��ϵ���б�</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/linkMan_toSelectPage.action" target="_blank">
				��ϵ�˲�ѯ</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/visit_toAddPage.action" target="_blank">
				�����ͻ��ݷ�</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/visit_list.action" target="_blank">
				�ͻ��ݷ��б�</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/customer_countSource.action" target="_blank">
				�ͻ���Դͳ��</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/customer_countLevel.action" target="_blank">
				�ͻ�����ͳ��</a></td></tr>
		
	</table>
</body>
</html>