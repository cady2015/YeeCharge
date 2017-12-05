<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>YeeCharge系统首页</title>
		<!--根据设备的宽度来调整页面的缩放比-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!--引入bootstrap的css文件-->
		<link  href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link  href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
		<!-- 引入js-->
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script  type="text/javascript" src="js/bootstrap.min.js"></script>
		
		
		<style type="text/css">
			#header{
				width:100%;
				height:140px;
				margin:0 auto;
				position:relative;
				background:#0099CC;
				
				
			}
			#navbar-right{
				width: 500px;
				height: 400px;
				border-style: solid;
				border-color:#FF6600;
				border-width: 5px;
				border-radius: 60px;
				padding-left: 50px;
				padding-top:0px ;
				margin-left: 800px;
				margin-top: 10px;
				
			}
			#footer2{
				width:100%;
				height:60px;
				margin-top:100px;
				margin:0 auto;
				position:relative;
				background:#0099CC;
				margin-top:20px ;
				
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
		</style>
		
		
		
	</head>
	<body>
		<!--创建整体布局的DIV-->
		<div class="container" >
		   
			<div id="header">
			<div class="col-md-4" style="width: 200px; height: 25px;">
		   	    <img src="img/012.png"   style="width: 350px;height: 110px; margin-left: 0px;" >
		   	</div>
		   	<div class="col-md-8" style="padding-left:200px;width: 900px; height:25px ;">
		    <h1><font face="微软雅黑", size="6", color="#FFFFFF">YeeCharge&nbsp太&nbsp阳&nbsp能&nbsp充&nbsp电&nbsp站&nbsp管&nbsp理&nbsp平&nbsp台</font> </h1> 
		    <font face="微软雅黑", size="5",color="#FFFFFF">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspYeeCharge Solar &nbspCharging &nbspPile &nbspPlatform</font>
		    </div>
			</div>
			
		
			<div>
			 <!--内容的DIV左半部分-->
			 <div class="row">
			 <div id="navbar-left" >
				
			 		<div class="col-md-6" style=" height:140px; width:55%;padding-top: 10px;">
			 			<div id="carousel-example-generic" class="carousel slide" data-slide="carousel" >
			       <!-- Indicators -->
			  	   <ol class="carousel-indicators">
			    	<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
			    	<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			    	<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			    	
			  	   </ol>
			
			       <!-- 放置循环滚动的图片 ，只有一个图片是正在活动的-->
			       <div class="carousel-inner" role="listbox" style="width: 100%;height: 380px;">
			       
				      <div class="item active">
				      <img src="img/014.jpg" alt=" " width="1000px" height="677px">
				      <div class="carousel-caption">
				      </div>
				      </div>
				      
				      <div class="item">
				      <img src="img/007.jpg" alt=" " width="100%" height="100%">
				      <div class="carousel-caption">
				      </div>
				      </div>
				      
				      <div class="item">
				      <img src="img/008.jpg" alt="" width="100%" height="100%" >
				      <div class="carousel-caption">
				      </div>
				      </div>
				      
				     
			 
			
			  	<!-- 手动点击切换按钮-->
				<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
				    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				    <span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
				    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				    <span class="sr-only">Next</span>
				</a>
				</div>
				</div>
			
				
				</div> 
				<!--内容的DIV右半部分-->
				
				

			      </div>
			      <div id="navbar-right">
			 		<div class="col-md-6" style="height:330px; width:440px;padding-top: 100px;margin-left: 0px;">
			 		 <form class="form-horizontal" action="/LoginServlet" method="POST">
						  <div class="form-group">
						    <label for="inputname" class="col-sm-3 control-label" ><font size="3">用&nbsp户&nbsp名：</font></label>
						    <div class="col-sm-6">
						      <input type=" text" class="form-control" id="inputname" name="username" placeholder="">
						    </div>
						  </div>
						  
						  <br />
						  <div class="form-group">
						    <label for="inputPassword" class="col-sm-3 control-label" ><font size="3">密&nbsp码：</font></label>
						    <div class="col-sm-6">
						      <input type="password" class="form-control" id="inputPassword" name="password" placeholder="">
						    </div>
						  </div>
						  <br />
						 <br />
						  <div class="form-group">
						    <div class="col-sm-offset-3 col-sm-10">
						       <button type="submit" class="btn btn-default"  >登录</button>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						       <a href="/regist.jsp"><button type="button" class="btn btn-default" >注册</button></a>
						    </div><br/>
						    <div class="col-sm-offset-3 col-sm-10">
						    	<input type="checkbox" name="autologin" value="true" />30天内自动登录
						    </div>
						  </div>
						  
						</form>

			 		</div>
			 		</div>
			     </div>
			    </div>
			 
			
			<div id="footer2">
			
			</div>

			</div>
			 <!--页脚的DIV-->
			 <div id="footer">
			 <center><a href="#" style="color:white">关于我们</a>  &nbsp&nbsp&nbsp&nbsp&nbsp <a href="#" style="color:white">联系方式</a>     </center>
			 </div>
			</body>
		</html>
