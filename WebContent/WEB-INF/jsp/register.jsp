<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
	<title>用户注册</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/ShowCalendar.js"></script>
</head>

<body>	
	<div id="main">	
		<br/>
		
		<form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
		<table id="formtable">
			<tr>
				<td class="td1">登陆帐号：</td>
				<td>
					<input class="userinput" type="text" name="username" value="${form.username }">
					<span class="message">${form.errors.username }</span>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td></td>
			</tr>
			
			<tr>
				<td class="td1">重复密码：</td>
				<td>
					<input class="userinput" type="password" name="password" value="${form.password }">
					<span class="message">${form.errors.password }</span>
				</td>
			</tr>
			
			<tr>
				<td class="td1">确认密码：</td>
				<td>
					<input class="userinput" type="password" name="password2"  value="${form.password2 }">
					<span class="message">${form.errors.password2 }</span>	
				</td>
			</tr>
			
			<tr>
				<td class="td1">电子邮箱：</td>
				<td>
					<input class="userinput" type="text" name="email"  value="${form.email }">
					<span class="message">${form.errors.email }</span>
				</td>
			</tr>
			
			<tr>
				<td class="td1">生日：</td>
				<td>
					<input class="userinput" type="text" name="birthday" id="birthday" title="点击选择" onClick="showCalendar(this.id)" value="${form.birthday }">
					<span class="message">${form.errors.birthday }</span>
				</td>
			</tr>
			
			<tr>
				<td class="td1">您的呢称：</td>
				<td>
					<input class="userinput" type="text" name="nickname" value="${form.nickname }">
					<span class="message">${form.errors.nickname }</span>	
				</td>
			</tr>
			
			<tr>
				<td class="td1">图片认证：</td>
				<td>
					<input class="userinput" type="text" name="client_checkcode">
					<img src="${pageContext.request.contextPath }/ImageServlet"  onclick="this.src=this.src + '?' + new Date().getTime()" height="23px" width="120px" alt="看不清" style="cursor: hand;">
				</td>
			</tr>
			
			<tr>
				<td class="td1"></td>
				<td>
					<span class="message">${form.errors.client_checkcode }</span>	
				</td>
			</tr>
			
		</table>
		<div id="formsubmit">
			<span><input class="btn" type="reset" name="reset" value="重 置"></span>
			&nbsp;&nbsp;
			<span><input class="btn" type="submit" name="submit" value="注 册"></span>
		</div>	
		</form>
	</div>	
	<div id="footer">
		
	</div>
</body>
</html>