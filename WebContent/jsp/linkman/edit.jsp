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
<form action="">
<table>

	<tr>
		<td>客户名称</td>
		<td>客户级别</td>
		<td>信息来源</td>
		<td>固定电话</td>
		<td>客户手机</td>
	</tr>

	<c:forEach items="${list }" var="reader">
		<tr>
		<td>${reader.readName }</td>
		<td>${reader.address }</td>
		<td>${reader.readPhone }</td>
		<td><select name="">
			</select>
		</td>
	</tr>
	</c:forEach>
	<tr>
	<td><input type="submit" value="保存"></td></tr>
</table>
</form>
</body>
</html>