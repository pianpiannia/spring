<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/visit_addVisit.action" 
	method="post">
		<table>
		<tr>
			<td>所属客户：</td>
			<td><select name="customer.cid">
				<c:forEach items="${listCustomer }" var="customer">
					<option value="${customer.cid }">${customer.custName }
				</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td>所属用户：</td>
			<td><select name="user.uid">
				<c:forEach items="${listUser }" var="user">
					<option value="${user.uid }">${user.username }
				</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td>拜访地址：</td>
			<td><input type="text" name="vaddress">
			<span class="message"></span>
			</td>
		</tr>	
		<tr>
			<td>拜访内容：</td>
			<td><input type="text" name="vcontent">
			<span class="message"></span>
			</td>
		</tr>
	</table>
	<span><input type="submit" name="submit" value="保存"></span>
	</form>
</body>
</html>