<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/customer_update.action">
	<input type="hidden" name="cid" value="${customer.cid }">
	<table>
		<tr>
			<td>客户名称</td>
			<td>客户级别</td>
			<td>信息来源</td>
			<td>固定电话</td>
			<td>客户手机</td>
		</tr>
		<tr>
			<td><input type="text" name="custName" value="${customer.custName }"></td>
			<td><input type="text" name="custLevel" value="${customer.custLevel }"></td>
			<td><input type="text" name="custSource" value="${customer.custSource }"></td>
			<td><input type="text" name="custPhone" value="${customer.custPhone }"></td>
			<td><input type="text" name="custMobile" value="${customer.custMobile }"></td>
		</tr>
	</table>
	<input type="submit" value="保存">
</form>
</body>
</html>