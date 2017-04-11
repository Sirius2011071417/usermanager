<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<!-- 
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css"/>
 -->
</head>
<body>
	<div id="container">
			<div id="image">
				<div id="form">
					<div>${error }</div>
					<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
						<div class="input">
							用户：<input class="inputtext" type="text" name="username" />
						</div>
						<div class="input">
							密码：<input class="inputtext" type="password" name="password" />
						</div>
						<div id="btn">
							<input class="btn" type="button" value="注册" onclick="window.location.href='RegisterUIServlet'" />
							<input class="btn" type="submit" value="登陆" />
						</div>
					</form>
				</div>
			</div>
		</div>
</body>
</html>