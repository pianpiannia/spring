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
	<form action="${pageContext.request.contextPath }/linkMan_moreCondition.action" method="post">
		<table>
		<tr>
			<td>联系人名称：</td>
			<td><input type="text" name="lkmName">
			</td>
		</tr>
		<tr>
			<td>所属客户：</td>
			<td><select name="customer.cid">
				<option value="0">--请选择--</option>
				<c:forEach items="${list }" var="cus">
					<option value="${cus.cid }">${cus.custName }
				</c:forEach>
			</select>
			</td>
		</tr>
		<!-- <tr>
			<td>信息来源：</td>
			<td><input type="text" name="custSource">
			</td>
		</tr> -->	
	</table>
	<span><input type="submit" name="submit" value="查询"></span>
	</form>
</body>
</html>