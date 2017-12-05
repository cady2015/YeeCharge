<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>后台管理</title>
		<!--根据设备的宽度来调整页面的缩放比-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!--引入bootstrap的css文件-->
		<link  href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link  href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
		<!-- 引入js-->
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script  type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=L8bP6CEiduuwvirG7plamYaFK8yYBGXi"></script>
		 	<style>
		    #header{
				width:100%;
				height:20%;
				margin:0 auto;
				position:relative;
				background:#0099CC;
			}
			   /********内容样式*************/
			#mainleft{
				float: left;
				width:17%;
				height:75%;
				background: #99CCCC;
				padding-left:0.5%;
				margin-left: 0;
				margin-top: 0;
				padding-top:10%;
				
			}
			#mainright{
			    float: left;
				width:83%;
				height:75%;
				border-style: solid;
				border-color:#FF6600;
				border-width:3px;
				padding-left: 0;
				padding-top:0 ;
				margin-left:0%;
				margin-top: 0%;
				
				
				
			}
			
		 	
		 	
			#footer{
				clear: both;
				position: relative;
				width:100%;
				height:5%;
				font-family:"微软雅黑";
				margin:0 auto;
				font-size:16px;
			    padding-left: 0;
				padding-top:0.5% ;
				margin-left:0;
				margin-top: 0;
				background:#444;
				position:fixed;
                bottom:0;
			}
	 		
	 		
	 		.daohang{
	 			font-size:14px;
	 			text-align: center;
	 			margin:3px;
	 			line-height: 100%;
	 			height: 10%;
	 			width: 85%;
	 		    display:block;
	 			
	 		}
	 		.daohang:link,.daohang:visited{
	 			color: #333333;
	 			padding: 8px 12px 8px 12px;
	 			background-color: #99CCFF;
	 			text-decoration: none;
	 			border-top: 2px solid #FF6600;
	 			border-left: 2px solid #FF6600;
	 			border-bottom: 2px solid #FF6600;
	 			border-right: 2px solid #FF6600;
	 			border-radius: 10px;
	 		}
	 		.daohang:hover{
	 			color:#333333;
	 			padding: 5px 8px 3px 12px;
	 			background-color:#FFFFCC ;
	 			border-top: 1px solid #761C19;
	 			border-left: 1px solid #761C19;
	 			border-bottom: 1px solid  #761C19;
	 			border-right: 1px solid #761C19;
	 		}
	 		
	 		p{
	 		    font-size:18px;
	 		    font-family:"微软雅黑";
	 		}

		 	</style>
		

	</head>
	<body>
		<div class="container" >
		   <div id="header">
			<div class="col-md-4" style="width: 18%; height: 20%;">
		   	    <img src="img/012.png"   style="width: 200%;height: 110px; margin-left: 0;" >
		   	</div>
		   	<div class="col-md-8" style="padding-left:15%;width: 82%; height:20% ;">
		    <h1><font face="微软雅黑", size="6", color="#FFFFFF">YeeCharge&nbsp太&nbsp阳&nbsp能&nbsp充&nbsp电&nbsp站&nbsp管&nbsp理&nbsp平&nbsp台</font> </h1> 
		    <h2><font face="微软雅黑", size="5 ",color="#FFFF00">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspYeeCharge&nbsp Solar &nbspCharging &nbspStation &nbspPlatform</font></h2>
		    </div>
		</div>
		
			<div id="main">
				<div id="mainleft">

			 		<center>
					<a class="daohang" href="/ListCPServlet">管理充电桩部署</a><br>
					<a class="daohang" href="/showmap.jsp">查看充电桩地理分布</a><br>
					<a class="daohang" href="/cp_status.jsp">充电桩状态监测</a><br>
					<a class="daohang" href="/ListUserServlet">用户管理</a><br>
			 		</center> 
				</div>
	<div id="mainright">
	<div style="background-color: #a2b4ba;padding-top:1px;">
	<center><h3 ><font color="#dee0ea">用户列表</font></h3></center><hr>
	</div>
	<table id="table" border="1" width="100%" cellpadding="10px" style="margin: 0px;text-align: center;">
		<tr>
					<td>id</td>
					<td>用户名</td>
					<td>手机号码</td>
					<td>用户邮箱</td>
					<td>用户角色</td>
					<td></td>
					<td></td>
		</tr>	
		
				<c:forEach items="${requestScope.usersList }" var="user" >
					<tr>
							<td>${user.id }</td>
							<td>${user.username }</td>
							<td>${user.phonenum }</td>
							<td>${user.email }</td>
							<td>${user.role }</td>
							<td><a href="javascript:if(confirm('确实要删除吗?'))location='DelUserServlet?id=${user.id }'">删除用户</a></td>
							<td><a href="/alterUser.jsp?id=${user.id }">修改用户</a></td>
					</tr>	
				</c:forEach>
		
			</table>
	     </div>
	</div>
		</div>	
			<div id="footer">
			     <center>
			     <a href="#" style="color:white">关于我们</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a href="#" style="color:white">联系方式</a>
			     </center>
				
			</div>
			
	</body>
	
</html>
