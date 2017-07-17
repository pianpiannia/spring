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
<body>
<table>
		<tr>
			<td>客户名称</td>
			<td>客户级别</td>
			<td>信息来源</td>
			<td>固定电话</td>
			<td>客户手机</td>
		</tr>
		
		<!-- 第一种方式取数据 -->
		<c:forEach items="${pageBean.list }" var="customer">
			<tr>
				<td>${customer.custName }</td>
				<td>${customer.custLevel }</td>
				<td>${customer.custSource }</td>
				<td>${customer.custPhone }</td>
				<td>${customer.custMobile }</td>
			</tr>
		</c:forEach>	
	</table>
	<div style="line-height: 20px;height:20px;text-align:right">
		共[<b>${pageBean.totalCount }</b>]条记录，共[<b>${pageBean.totalPage }</b>]页，
		当前第[<b>${pageBean.currentPage }</b>]页
		<!-- 前一页表示当前页减一
			判断如果是第一页，就没有前一页
		 -->
		 <c:if test="${pageBean.currentPage!=1 }">
			[<a href="${pageContext.request.contextPath }/customer_listPage.action?currentPage=${pageBean.currentPage-1}">前一页</a>]
		 </c:if>
		<!-- 当前页+1 
			如果最后一页就没有后一页
		-->
		<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
			[<a href="${pageContext.request.contextPath }/customer_listPage.action?currentPage=${pageBean.currentPage+1}">后一页</a>
		</c:if>
		</div>
</body>
</html>