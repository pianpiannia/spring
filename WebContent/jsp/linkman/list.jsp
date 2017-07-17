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
			<td>联系人名称</td>
			<td>联系人性别</td>
			<td>联系人电话</td>
			<td>联系人手机</td>
		</tr>
		
		<!-- 第一种方式取数据 -->
		<c:forEach items="${list }" var="linkman">
			<tr>
				<td>${linkman.lkmName }</td>
				<td>${linkman.lkmGender }</td>
				<td>${linkman.lkmPhone }</td>
				<td>${linkman.lkmMobile }</td>
				</tr>
		</c:forEach>
		
		<!-- 第二种方式取值 -->
		<%-- <s:iterator value="list" var="linkman">
			<tr>
				<td><s:property value="#linkman.lkmName"/></td>
				<td><s:property value="#linkman.lkmGender"/></td>
				<td><s:property value="#linkman.lkmPhone"/></td>
				<td><s:property value="#linkman.lkmMobile"/></td>
				</tr>
		</s:iterator> --%>
	</table>
</body>
</html>