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
		<link  href="css/tableStyle.css" rel="stylesheet" type="text/css"/>
		
		<!-- 引入js-->
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>

	</head>
	<body>
		<div class="container" >
		   <div id="header">
			<div class="col-md-4" style="width: 18%; height: 20%;">
		   	    <img src="img/012.png"   style="width: 200%;height: 400%; margin-left: 0;" >
		   	</div>
		   	<div class="col-md-8" style="padding-left:15%;width: 82%; height:20% ;">
		    <h1><font face="微软雅黑", size="6", color="#FFFFFF">YeeCharge&nbsp太&nbsp阳&nbsp能&nbsp充&nbsp电&nbsp站&nbsp管&nbsp理&nbsp平&nbsp台</font> </h1> 
		    <h2><font face="微软雅黑", size="5 ",color="#FFFF00">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspYeeCharge&nbsp Solar &nbspCharging &nbspStation &nbspPlatform</font></h2>
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
			<!-- 主窗体开始 -->
	<div id="mainright1" >
    <table class=altrowstable id="alternatecolor">
    	<tr class=stable >
    		<th style="text-align: center;">充电桩编号</th>
    		<th>状态</th>
    		<th>电压</th>
    		<th>电流</th>
    		<th>温度</th>
    		<th>剩余电量</th>
    		<th>更新时间</th>
    	</tr>
    	<tr class=oddrowcolor>
    		<td style="text-align: center;">id</td>
    		<td>状态</td>
    		<td>电压</td>
    		<td>电流</td>
    		<td>温度</td>
    		<td>剩余电量</td>
    		<td>更新时间</td>
	    </tr>
    	<tr class=evenrowcolor>
    		<td style="text-align: center;">id</td>
    		<td>状态</td>
    		<td>电压</td>
    		<td>电流</td>
    		<td>温度</td>
    		<td>剩余电量</td>
    		<td>更新时间</td>
	    </tr>
    	<tr class=oddrowcolor>
    		<td style="text-align: center;">id</td>
    		<td>状态</td>
    		<td>电压</td>
    		<td>电流</td>
    		<td>温度</td>
    		<td>剩余电量</td>
    		<td>更新时间</td>
	    </tr>
    	<tr class=evenrowcolor>
    		<td style="text-align: center;">id</td>
    		<td>状态</td>
    		<td>电压</td>
    		<td>电流</td>
    		<td>温度</td>
    		<td>剩余电量</td>
    		<td>更新时间</td>
	    </tr>
    	<tr class=oddrowcolor>
    		<td style="text-align: center;">id</td>
    		<td>状态</td>
    		<td>电压</td>
    		<td>电流</td>
    		<td>温度</td>
    		<td>剩余电量</td>
    		<td>更新时间</td>
	    </tr>
    	<tr class=evenrowcolor>
    		<td style="text-align: center;">id</td>
    		<td>状态</td>
    		<td>电压</td>
    		<td>电流</td>
    		<td>温度</td>
    		<td>剩余电量</td>
    		<td>更新时间</td>
	    </tr>
    	<tr class=oddrowcolor>
    		<td style="text-align: center;">id</td>
    		<td>状态</td>
    		<td>电压</td>
    		<td>电流</td>
    		<td>温度</td>
    		<td>剩余电量</td>
    		<td>更新时间</td>
	    </tr>
    	<tr class=evenrowcolor>
    		<td style="text-align: center;">id</td>
    		<td>状态</td>
    		<td>电压</td>
    		<td>电流</td>
    		<td>温度</td>
    		<td>剩余电量</td>
    		<td>更新时间</td>
	    </tr>
    	<tr class=oddrowcolor>
    		<td style="text-align: center;">id</td>
    		<td>状态</td>
    		<td>电压</td>
    		<td>电流</td>
    		<td>温度</td>
    		<td>剩余电量</td>
    		<td>更新时间</td>
	    </tr>
    	<tr class=evenrowcolor>
    		<td style="text-align: center;">id</td>
    		<td>状态</td>
    		<td>电压</td>
    		<td>电流</td>
    		<td>温度</td>
    		<td>剩余电量</td>
    		<td>更新时间</td>
	    </tr>

    </table>
				
            </div>
            
</div>
<!-- 主窗体结束 -->	
</div>		
			<div id="footer">
			     <center>
			     <a href="#" style="color:white">关于我们</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a href="#" style="color:white">联系方式</a>
			     </center>
			</div>
		
	</body>
</html>
<script type="text/javascript">

	function refreshCPData(json){
	/*
		测试数据
		var json = 
		[{"cp_current":"25","cp_id":1,"cp_status":2,"cp_temperature":"32","cp_voltage":"3599","energy_left":99,"update_time":{"date":28,"day":4,"hours":17,"minutes":9,"month":6,"nanos":0,"seconds":16,"time":1469696956000,"timezoneOffset":-480,"year":116}},
		{"cp_current":"244","cp_id":2,"cp_status":2,"cp_temperature":"32","cp_voltage":"2700","energy_left":43,"update_time":{"date":28,"day":4,"hours":10,"minutes":52,"month":6,"nanos":0,"seconds":46,"time":1469674366000,"timezoneOffset":-480,"year":116}},
		{"cp_current":"244","cp_id":3,"cp_status":2,"cp_temperature":"33","cp_voltage":"2670","energy_left":43,"update_time":{"date":28,"day":4,"hours":10,"minutes":52,"month":6,"nanos":0,"seconds":48,"time":1469674368000,"timezoneOffset":-480,"year":116}},
		{"cp_current":"200","cp_id":4,"cp_status":2,"cp_temperature":"32","cp_voltage":"3000","energy_left":60,"update_time":{"date":28,"day":4,"hours":17,"minutes":9,"month":6,"nanos":0,"seconds":17,"time":1469696957000,"timezoneOffset":-480,"year":116}},
		{"cp_current":"0","cp_id":5,"cp_status":4,"cp_temperature":"32","cp_voltage":"3012","energy_left":75,"update_time":{"date":28,"day":4,"hours":10,"minutes":47,"month":6,"nanos":0,"seconds":37,"time":1469674057000,"timezoneOffset":-480,"year":116}},
		{"cp_current":"0","cp_id":6,"cp_status":0,"cp_temperature":"32","cp_voltage":"0","energy_left":0,"update_time":{"date":28,"day":4,"hours":10,"minutes":48,"month":6,"nanos":0,"seconds":43,"time":1469674123000,"timezoneOffset":-480,"year":116}},
		{"cp_current":"300","cp_id":7,"cp_status":2,"cp_temperature":"33","cp_voltage":"3607","energy_left":50,"update_time":{"date":28,"day":4,"hours":10,"minutes":52,"month":6,"nanos":0,"seconds":0,"time":1469674320000,"timezoneOffset":-480,"year":116}},
		{"cp_current":"20","cp_id":8,"cp_status":2,"cp_temperature":"32","cp_voltage":"4200","energy_left":99,"update_time":{"date":28,"day":4,"hours":17,"minutes":9,"month":6,"nanos":0,"seconds":18,"time":1469696958000,"timezoneOffset":-480,"year":116}},
		{"cp_current":"20","cp_id":9,"cp_status":2,"cp_temperature":"32","cp_voltage":"4100","energy_left":95,"update_time":{"date":28,"day":4,"hours":17,"minutes":9,"month":6,"nanos":0,"seconds":20,"time":1469696960000,"timezoneOffset":-480,"year":116}},
		{"cp_current":"0","cp_id":10,"cp_status":8,"cp_temperature":"32","cp_voltage":"0","energy_left":0,"update_time":{"date":28,"day":4,"hours":10,"minutes":54,"month":6,"nanos":0,"seconds":16,"time":1469674456000,"timezoneOffset":-480,"year":116}}]
	
	*/
	var len = $('table tr').length;
	
	for(var r=1,hang=0; hang<len; r++,hang++){//遍历tr
		for(var i=0; i<json.length; i++){//遍历td
			switch (i) {
			case 0:
				$('table tr:eq('+r+') td:eq('+i+')').text(json[hang].cp_id);
				break;
			case 1:
				$('table tr:eq('+r+') td:eq('+i+')').text(json[hang].cp_status);
				break;
			case 2:
				$('table tr:eq('+r+') td:eq('+i+')').text(json[hang].cp_voltage);
				break;
			case 3:
				$('table tr:eq('+r+') td:eq('+i+')').text(json[hang].cp_current);
				break;
			case 4:
				$('table tr:eq('+r+') td:eq('+i+')').text(json[hang].cp_temperature);
				break;
			case 5:
				$('table tr:eq('+r+') td:eq('+i+')').text(json[hang].energy_left);
				break;
			case 6:
				$('table tr:eq('+r+') td:eq('+i+')').text(FormatTime(json[hang].update_time.time));
				break;
			default:
				break;
			}
			
		}
	}
	}
	/**
	*	将返回的json的timestamp数据格式化
	*/
	function FormatTime(jsonTimeobj){
	
		var date= new Date(jsonTimeobj);
		var formattedDate = date.toLocaleDateString();
		var formattedTime = date.toLocaleTimeString();
		var xingqi = date.getDay();
		switch (xingqi) {
		case 0:
			xingqi = "一";
			break;
		case 1:
			xingqi = "二";
			break;
		case 2:
			xingqi = "三";
			break;
		case 3:
			xingqi = "四";
			break;
		case 4:
			xingqi = "五";
			break;
		case 5:
			xingqi = "六";
			break;
		case 6:
			xingqi = "日";
			break;

		default:
			break;
		}
		var DateTime = formattedDate+"  "+formattedTime;
		var FORMATTEDtime = DateTime +"  "+ "星期" +xingqi;
		//alert(FORMATTEDtime);
		return FORMATTEDtime;
	}
	
	function btnclic(){
		$.get("/GetAllCPstatusServlet",function(data){
		//返回数据的格式："json = {ret1:10,rst2:1,rst3:4,rst4:5}"
			var json = eval("("+data+")");
			
			//alert(json[0].cp_id);
	//刷新表格中的数据

	var len = $('table tr').length;
	
	for(var r=1,hang=0; hang<len; r++,hang++){//遍历tr
		for(var i=0; i<json.length; i++){//遍历td
			switch (i) {
			case 0:
				//var x =json[hang].cp_id;
				//alert(x);
				$('table tr:eq('+r+') td:eq('+i+')').text(json[hang].cp_id);
				break;
			case 1:
				$('table tr:eq('+r+') td:eq('+i+')').text(json[hang].cp_status);
				break;
			case 2:
				$('table tr:eq('+r+') td:eq('+i+')').text(json[hang].cp_voltage);
				break;
			case 3:
				$('table tr:eq('+r+') td:eq('+i+')').text(json[hang].cp_current);
				break;
			case 4:
				$('table tr:eq('+r+') td:eq('+i+')').text(json[hang].cp_temperature);
				break;
			case 5:
				$('table tr:eq('+r+') td:eq('+i+')').text(json[hang].energy_left);
				break;
			case 6:
				$('table tr:eq('+r+') td:eq('+i+')').text(FormatTime(json[hang].update_time.time));
				break;
			default:
				break;
			}
			}
		}
		});
	}
	
	//当页面加载完成后调用定时任务startRequest函数，每1秒调用1次
	$(document).ready(function () {
		setInterval("btnclic()",1000);
	});
	

</script>



