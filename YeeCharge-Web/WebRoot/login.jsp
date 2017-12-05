<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="resources/styles/clicki.web.css?V=20120501" media="screen" />
<link rel="stylesheet" type="text/css" href="resources/styles/clicki.loginandreg.css?V=20120501" media="screen" />
<link rel="stylesheet" type="text/css" href="resources/styles/clicki.webkitanimation.css?V=20120501" media="screen" />
  <script type="text/javascript">
		window.onload=function(){
	  		var str = decodeURI('${cookie.remname.value}');
	  		document.getElementsByName("username")[0].value = str;
  		};
  </script>
  </head>
  
  <body>
  	<div align="center"  class="theCenterBox" style="">
	<h1>Estore_登录</h1><hr>
	<font color="red">${msg }</font>
	<form action="/LoginServlet" method="POST">
		<table>
			<tr>
				<td>用户名：</td><!--11个内置对象cookie是一个map拿到对象后要.value一下才能拿到值 -->
				<td><input type="text" name="username" value="" autofocus="autofocus"> </td>
				<td id="username_msg"></td>
			</tr>		
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"> </td>
				<td id="password_msg"></td>
			</tr>		
			<tr>
				<td><input type="checkbox" name="remname" value="true" 
					<c:if test="${cookie.remname != null }">
						checked="checked"
					</c:if>
				/> 记住用户名</td>
				<td><input type="checkbox" name="autologin" value="true" /> 30天内自动登录</td>
			</tr>		
			<tr>
  				<td colspan="2" align="left"><input type="submit" value="登录"/></td>
  			</tr>	
		</table>
	</form>
	</div>
  </body>
</html>


