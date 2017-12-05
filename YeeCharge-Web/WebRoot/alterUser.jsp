<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改用户信息</title>
		<!--根据设备的宽度来调整页面的缩放比-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!--引入bootstrap的css文件-->
		<link  href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link  href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
		<!-- 引入js-->
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script  type="text/javascript" src="js/bootstrap.min.js"></script>
		<script  type="text/javascript" src="js/funcScript1.js"></script>
	</head>
	<body>
		<div class="row" style="background: #3399CC;width:100%;height:100%;padding-top:80px">
			<div class="col-md-2"></div>
			
			<div class="col-md-8" style=" background-image:url(img/regist_bg.jpg);aliment:center; margin: 30px;border: 7px solid #CCCCCC;">
				<div style="padding-left:120px">
					<h1>修改用户信息  </h1>
				</div>
				<br/>
				<form action="/AlterUserServlet" method="post" class="form-horizontal" onsubmit="return checkForm()" style="margin-top: 5px;">
					<input type="hidden" name="method" value="regist"/>
					<div class="form-group">
					   <label for="username" class="col-sm-2 control-label">用户名</label>
					   <div class="col-sm-6">
					   		<input type="text" class="form-control" id="username"  name="username" value="${requestScope.username }" placeholder="请输入用户名" onblur="checkUsrname(this)"/>
						</div> 
							<a id="username_msg"></a>
					</div>
					
					<div class="form-group">
					   <label for="phonenum" class="col-sm-2 control-label">手机号码</label>
					   <div class="col-sm-6">
					   		<input type="text" class="form-control" id="phonenum" maxlength="11" name="phonenum" value="${requestScope.phonenum }" placeholder="请输入手机号码" onblur="checkPhonenum(this)"/>
					</div>
							<a id="phonenum_msg"></a> 
					</div>
					
					<div class="form-group">
					   <label for="inputPassword" class="col-sm-2 control-label">密码</label>
					   <div class="col-sm-6">
					   		<input type="password" class="form-control" id="inputPassword" name="password" placeholder="请输入密码" onblur="checkPsw(this)"/>
					</div>
					   		<a id="password_msg"></a>
					</div>
					
					<div class="form-group">
					   <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
					   <div class="col-sm-6">
					   		<input type="password" class="form-control" id="confirmpwd"  name="password2" placeholder="请输入确认密码" onblur="checkPsw2(this)"/>
						</div>
					   		<a id="password2_msg"></a>
					</div>
					<div class="form-group">
					   <label for="email" class="col-sm-2 control-label">邮箱</label>
					   <div class="col-sm-6">
					   		<input type="text" class="form-control" id="email"  name="email" placeholder="请输入邮箱" value="${requestScope.email }" onblur="checkEmail(this)"/>
						</div>
					   		<a id="email_msg"></a>
					</div>
					
					<div class="form-group">
					   <label for="valiStr" class="col-sm-2 control-label">验证码</label>
					   	<div class="col-sm-3">
					   		<input type="text" class="form-control" id="valiStr"  name="valistr" onblur="checkValiImg(this)"/>
							<a id="valistr_msg"></a>
							<c:if test="${msg!=null }">
								<font color="red">${msg }</font>
							</c:if>
						</div>
						<div class="col-sm-1">
							<img src="/ValiImg" onclick="changeImg(this)" style="cursor: pointer;height: 35px;"/>
						</div>
					</div>
				
					<div class="form-group">
					 <div class="col-sm-offset-2 col-sm-10">
					   		<input type="submit"  width="100" value="立即注册" name="submit" border="0"  
					   		style="background:#C9302C no-repeat scroll 0 0 rgba(0,0,0,0) ; 
					   		height: 35px;width: 100px; color:#000000;"/>
					</div>
					</div>
				</form>
			</div>
		</div>
	
	</body>
</html>
