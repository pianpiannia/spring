<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/customer_moreCondition.action" method="post">
		<table>
		<tr>
			<td>客户名称：</td>
			<td><input type="text" name="custName">
			</td>
		</tr>
		<tr>
			<td>客户级别：</td>
			<td><input type="text" name="custLevel">
			</td>
		</tr>
		<tr>
			<td>信息来源：</td>
			<td><input type="text" name="custSource">
			</td>
		</tr>	
	</table>
	<span><input type="submit" name="submit" value="查询"></span>
	</form>
</body>
</html>