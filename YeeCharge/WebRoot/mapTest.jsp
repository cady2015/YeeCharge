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
		<link  href="css/showmapstyle.css" rel="stylesheet" type="text/css"/>
		<!-- 引入js-->
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script  type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=L8bP6CEiduuwvirG7plamYaFK8yYBGXi"></script>
		 	

	</head>
	<body>
		<div class="container" >
		   <div id="header">
			<div class="col-md-4" style="width: 18%; height: 20%;">
		   	    <img src="img/012.png"   style="width: 200%;height: 500%; margin-left: 0;" >
		   	</div>
		   	<div class="col-md-8" style="padding-left:15%;width: 82%; height:20% ;">
		    <h1><font face="微软雅黑", size="6", color="#B92C28">YeeCharge&nbsp太&nbsp阳&nbsp能&nbsp充&nbsp电&nbsp站&nbsp管&nbsp理&nbsp平&nbsp台</font> </h1> 
		    <h2><font face="微软雅黑", size="5 ",color="#FFFF00">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspYeeCharge&nbsp Solar &nbspCharging &nbspPile &nbspPlatform</font></h2>
		    </div>
		</div>
		
			<div id="main">
				<div id="mainleft">

			 		<center>
					<a class="daohang" href="/ListCPServlet">管理充电桩部署</a><br>
					<a class="daohang" href="/showmap.jsp">查看充电桩地理分布</a><br>
					<a class="daohang" href="/userlist.jsp">列出用户</a><br>
			 		</center> 
				</div>
				<div id="mainright">
					<div id="allmap" style="height: 100%;"></div>
					
	            </div>
				<div id="allmapright" >
				<p style="color:black">在线充电桩个数：</p></br>
				<p style="color:gray">故障充电桩个数：</p></br>
				<p style="color:red">正在使用的充电桩个数：</p></br>
				<p style="color:blue">空闲充电桩个数：</p></br>
				
					
					</div>
			</div>
			
			<div id="footer">
			     <center>
			     <a href="#" style="color:black">关于我们</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a href="#" style="color:black">联系方式</a>
			     </center>
				
			</div>
			
	</body>
</html>
<script type="text/javascript">
// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(108.997638,34.257671);
	map.centerAndZoom(point, 15);
	map.addControl(new BMap.NavigationControl());    
	map.addControl(new BMap.ScaleControl());    
	map.addControl(new BMap.GeolocationControl());  
	map.enableScrollWheelZoom();//启用地图滚轮放大缩小
		
	// 编写自定义函数,创建标注
	function addMarker(point,label){
		var icon = new BMap.Icon('img/1.png', new BMap.Size(20, 32), {  
					anchor: new BMap.Size(10, 30)});
		var marker = new BMap.Marker(point,{icon:icon});
		map.addOverlay(marker);
		marker.setLabel(label);
	}
	// 随机向地图添加25个标注
	var bounds = map.getBounds();
	var sw = bounds.getSouthWest();
	var ne = bounds.getNorthEast();
	var lngSpan = Math.abs(sw.lng - ne.lng);
	var latSpan = Math.abs(ne.lat - sw.lat);
	for (var i = 0; i < 10; i++) {
		var point = new BMap.Point(sw.lng + lngSpan * (Math.random() * 0.7), ne.lat - latSpan * (Math.random() * 0.7));
		var label = new BMap.Label("我是id="+i,{offset:new BMap.Size(20,-10)});
		label.setStyle({ 
		color : "#f0f", 
		fontSize : "16px", 
		backgroundColor :"0.01",
		border :"0", 
		fontWeight :"bold" 
		});
		addMarker(point,label);
		label.setTitle("我是文本标注label"); 
	}
	function deletePoint(){
		var allOverlay = map.getOverlays();
		for (var i = 0; i < allOverlay.length -1; i++){
			if(allOverlay[i].getLabel().content == "我是id=1"){
				map.removeOverlay(allOverlay[i]);
				return false;
			}
		}
	}
</script>


