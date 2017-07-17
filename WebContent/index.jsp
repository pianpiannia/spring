<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	欢迎：${user.username }
	<table>
		<tr><td><a href="${pageContext.request.contextPath }/customer_toAddPage.action" target="_blank">
				新增客户</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/customer_list.action" target="_blank">
				客户列表</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/customer_listPage.action?currentPage=1" target="_blank">
				分页客户列表</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/customer_toSelectCustomerPage.action" target="_blank">
				客户查询</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/linkMan_toAddPage.action" target="_blank">
				新增联系人</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/linkMan_list.action" target="_blank">
				联系人列表</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/linkMan_toSelectPage.action" target="_blank">
				联系人查询</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/visit_toAddPage.action" target="_blank">
				新增客户拜访</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/visit_list.action" target="_blank">
				客户拜访列表</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/customer_countSource.action" target="_blank">
				客户来源统计</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath }/customer_countLevel.action" target="_blank">
				客户级别统计</a></td></tr>
		
	</table>
</body>
</html>