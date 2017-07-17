<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><form action="${pageContext.request.contextPath }/customer_listcondition.action" method="post">
<table>
	<tr>
	<td>客户名称：<input type="text" name="custName"></td>
	<td><input type="submit" value="查询"></td></tr>
		<tr>
			<td>客户名称</td>
			<td>客户级别</td>
			<td>信息来源</td>
			<td>固定电话</td>
			<td>客户手机</td>
		</tr>
		
		<!-- 第一种方式取数据 -->
		<c:forEach items="${list }" var="customer">
			<tr>
				<td>${customer.custName }</td>
				<td>${customer.dictCustLevel.dname }</td>
				<td>${customer.custSource }</td>
				<td>${customer.custPhone }</td>
				<td>${customer.custMobile }</td>
				<td><a href="${pageContext.request.contextPath }/customer_delete.action?cid=${customer.cid}">删除</a></td>
				<td><a href="${pageContext.request.contextPath }/customer_showCustomer.action?cid=${customer.cid}">修改</a></td>
			</tr>
		</c:forEach>
		
		<!-- 第二种方式取值 -->
		<%-- <s:iterator value="list" var="cus">
			<tr>
				<td><s:property value="#cus.custName"/></td>
				<td><s:property value="#cus.custLevle"/></td>
				<td><s:property value="#cus.custSource"/></td>
				<td><s:property value="#cus.custPhone"/></td>
				<td><s:property value="#cus.custMobile"/></td>
				<td><a href="${pageContext.request.contextPath }/customer_delete.action?cid=<s:property value="#cus.cid"/>">删除</a></td>
			</tr>
		</s:iterator> --%>
	</table>
	</form>
</body>
</html>