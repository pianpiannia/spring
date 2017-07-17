<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<form id="form1" name="form1" action="${pageContext.request.contextPath }/user_login.action" method="post">
		<table>
		<tr>
			<td>登录账号：</td>
			<td><input class="userinput" type="text" name="username">
				<span class="message"></span>
			</td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="password">
			<span class="message"></span>
			</td>
		</tr>
	</table>
	<span><input type="submit" name="submit" value="登录"></span>
	</form>

</body>
</html>