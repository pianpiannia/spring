<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<td>客户名称</td>
			<td>用户名称</td>
			<td>拜访地址</td>
			<td>拜访内容</td>
		</tr>
		
		<!-- 第一种方式取数据 -->
		<c:forEach items="${list }" var="visit">
			<tr>
				<td>${visit.customer.custName }</td>
				<td>${visit.user.username }</td>
				<td>${visit.vaddress }</td>
				<td>${visit.vcontent }</td>
				</tr>
		</c:forEach>
		
		<!-- 第二种方式取值 -->
	<%-- 	<s:iterator value="list" var="visit">
			<tr>
				<td><s:property value="#visit.customer.custName"/></td>
				<td><s:property value="#visit.user.username"/></td>
				<td><s:property value="#visit.vaddress"/></td>
				<td><s:property value="#visit.vcontent"/></td></tr>
		</s:iterator> --%>
	</table>
</body>
</html>