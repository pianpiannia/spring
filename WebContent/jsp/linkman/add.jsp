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
	<form action="${pageContext.request.contextPath }/linkMan_addLinkMan.action" 
	method="post" enctype="multipart/form-data">
		<table>
		<tr>
			<td>所属客户：</td>
			<td><!-- <select name="cid"> -->
				<select name="customer.cid">
					<c:forEach var="customer" items="${listCustomer }">
						<option value="${customer.cid }">${customer.custName }</option>
					</c:forEach>
					
				</select>
			</td>
		</tr>
		<tr>
			<td>联系人名称：</td>
			<td><input type="text" name="lkmName">
			<span class="message"></span>
			</td>
		</tr>
		<tr>
			<td>联系人手机：</td>
			<td><input type="text" name="lkmPhone">
			<span class="message"></span>
			</td>
		</tr>	
		<tr>
			<td>联系人办公电话：</td>
			<td><input type="text" name="lkmMobile">
			<span class="message"></span>
			</td>
		</tr>
		<tr>
			<td>联系人性别：</td>
			<td><input type="radio" value="男" name="lkmGender">男
			<td><input type="radio" value="女" name="lkmGender">女
			</td>
		</tr>
		<tr>
			<td>选择文件：</td>
			<td><input type="file" name="upload">
			</td>
		</tr>
	</table>
	<span><input type="submit" name="submit" value="保存"></span>
	</form>
</body>
</html>