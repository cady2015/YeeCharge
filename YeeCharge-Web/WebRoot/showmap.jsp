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
		   	    <img src="img/012.png"   style="width: 200%;height: 110px; margin-left: 0;" >
		   	</div>
		   	<div class="col-md-8" style="padding-left:15%;width: 82%; height:20% ;">
		    <h1><font face="微软雅黑", size="6", color="#FFFFFF">&nbsp&nbsp&nbsp&nbspYeeCharge&nbsp太&nbsp阳&nbsp能&nbsp充&nbsp电&nbsp站&nbsp管&nbsp理&nbsp平&nbsp台</font> </h1> 
		    <h2><font face="微软雅黑", size="5",color="#FFFFFF">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspYeeCharge&nbsp Solar &nbspCharging &nbspStation &nbspPlatform</font></h2>
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
					<div id="allmap" style="height: 100%;"></div>
					
	            </div>
				<div id="allmapright" >
					<p style="color:black">总在线充电桩个数：<span id="count0">10</span></p></br>
					<p style="color:gray">故障充电桩个数：<span id="count1">1</p></br>
					<p style="color:#00CC00">正在使用的充电桩个数：<span id="count2">6</p></br>
					<p style="color:blue">空闲充电桩个数：<span id="count3">3</p></br>
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
<script type="text/javascript">
// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(108.998252,34.260536);
	map.centerAndZoom(point, 20);
	map.addControl(new BMap.NavigationControl());    
	map.addControl(new BMap.ScaleControl());    
	map.addControl(new BMap.GeolocationControl());  
	map.enableScrollWheelZoom();//启用地图滚轮放大缩小
		
		
	var jsonPoints ={'dev1':{lon:108.999559,lat:34.260793}
			,'dev2':{lon:108.997071,lat:34.259551}
			,'dev3':{lon:108.998369,lat:34.259667}
			,'dev4':{lon:108.997812,lat:34.259737}
			,'dev5':{lon:108.999923,lat:34.259394}
			,'dev6':{lon:108.997228,lat:34.260886}
			,'dev7':{lon:108.997479,lat:34.259913}
			,'dev8':{lon:108.9973,lat:34.259931}
			,'dev9':{lon:108.999033,lat:34.259491}
			,'dev10':{lon:108.997102,lat:34.259924}
		}
		
		
	addPoint(jsonPoints.dev1.lon,jsonPoints.dev1.lat,"正在充电",1,10,-20);
	addPoint(jsonPoints.dev2.lon,jsonPoints.dev2.lat,"正在充电",1,10,-20);
	addPoint(jsonPoints.dev3.lon,jsonPoints.dev3.lat,"正在充电",1,10,-20);
	addPoint(jsonPoints.dev4.lon,jsonPoints.dev4.lat,"正在充电",1,10,-20);
	addPoint(jsonPoints.dev5.lon,jsonPoints.dev5.lat,"正在充电",1,10,-20);
	addPoint(jsonPoints.dev6.lon,jsonPoints.dev6.lat,"正在充电",1,10,-20);
	addPoint(jsonPoints.dev7.lon,jsonPoints.dev7.lat,"空闲",2,10,-20);
	addPoint(jsonPoints.dev8.lon,jsonPoints.dev8.lat,"空闲",2,10,-20);
	addPoint(jsonPoints.dev9.lon,jsonPoints.dev9.lat,"空闲",2,10,-20);
	addPoint(jsonPoints.dev10.lon,jsonPoints.dev10.lat,"故障",3,10,-20);
	
	// 编写自定义函数,创建标注
	function addMarkerGray(point,label){
		var icon = new BMap.Icon('img/marker_gray1.png', new BMap.Size(20, 32), {  
					anchor: new BMap.Size(10, 30)});
		var marker = new BMap.Marker(point,{icon:icon});
		map.addOverlay(marker);
		marker.setLabel(label);
	}
	function addMarkerGreen(point,label){
		var icon = new BMap.Icon('img/marker_green.png', new BMap.Size(20, 32), {  
					anchor: new BMap.Size(10, 30)});
		var marker = new BMap.Marker(point,{icon:icon});
		map.addOverlay(marker);
		marker.setLabel(label);
	}
	function addMarkerRed(point,label){
		var marker = new BMap.Marker(point);
		map.addOverlay(marker);
		marker.setLabel(label);
	}
	
	// 随机向地图添加25个标注
	// 参数含义：lon：经度 lat:纬度  lablestring：描述信息  type:1--red 2--green 3--gray 
	function addPoint(lon,lat,lableString,type,os_r,os_d){
		var point = new BMap.Point(lon,lat);
		var label = new BMap.Label(lableString,{offset:new BMap.Size(os_r,os_d)});
		label.setStyle({ 
		color : "#FF33CC", 
		fontSize : "14px", 
		backgroundColor :"0.01",
		"border" :"1", 
		"borderColor": "#808080",
		fontWeight :"bold",
		"cursor": "pointer"
		});
		if(type==1){
			addMarkerRed(point,label);
		}else if(type==2){
			addMarkerGreen(point,label);
		}else if(type==3){
			addMarkerGray(point,label);
		}
		
	}
	
	function startRequest(){
		$.get("/ListStatusCountServlet",function(data){
		//返回数据的格式："json = {ret1:10,rst2:1,rst3:4,rst4:5}"
			var json = eval("("+data+")");
			
			$("#count0").html(json.rst0);
			$("#count1").html(json.rst1);
			$("#count2").html(json.rst2);
			$("#count3").html(json.rst3);
		});
	}
	
	//当页面加载完成后调用定时任务startRequest函数，每1秒调用1次
	$(document).ready(function () {
		setInterval("startRequest()",1000);
	});
	
</script>


