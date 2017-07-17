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
	<form action="${pageContext.request.contextPath }/customer_add.action" method="post">
		<table>
		<tr>
			<td>客户名称：</td>
			<td><input type="text" name="custName">
				<span class="message"></span>
			</td>
		</tr>
		<tr>
			<td>客户级别：</td>
			<td><select name="dictCustLevel.did">
				<c:forEach items="${listDict }" var="dict">
					<option value="${dict.did }">${dict.dname }
				</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td>信息来源：</td>
			<td><input type="text" name="custSource">
			<span class="message"></span>
			</td>
		</tr>	
		<tr>
			<td>固定电话：</td>
			<td><input type="text" name="custPhone">
			<span class="message"></span>
			</td>
		</tr>
		<tr>
			<td>客户手机：</td>
			<td><input type="text" name="custMobile">
			<span class="message"></span>
			</td>
		</tr>
	</table>
	<span><input type="submit" name="submit" value="保存"></span>
	</form>
</body>
</html>