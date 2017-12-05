<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!--引入bootstrap的css文件-->
		<link  href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link  href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
		<!-- 引入js-->
		<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
		<script  type="text/javascript" src="js/bootstrap.min.js"></script>
		<script  type="text/javascript" src="js/checkForm.js"></script>
<title>部署新的充电桩</title>
</head>
<body>
	<h1>YeeCharge_部署新的充电桩</h1><hr>
	<div >
			<form action="/AddCPServlet" method="POST" >
			<table border="1px" align="center">
				<tr>
					<td>充电桩编号</td>
					<td><input type="text" name="cp_num" placeholder="请输入数字类型数值" onblur="checkCp_num(this)" /> </td>
				</tr>
					<a id="cp_num_msg"></a>
				<tr>
					<td>型号</td>
					<td><input type="text" name="cp_model" placeholder="请输入充电桩型号" onblur="checkCp_model(this)" /> </td>
				</tr>
					<a id="cp_model_msg"></a>
				<tr>
					<td>纬度</td>
					<td><input type="text" name="longitude" placeholder="请输入纬度值" onblur="checkLongitude(this)"/> </td>
				</tr>
					<a id="longitude_msg"></a>
				<tr>
					<td>经度</td>
					<td><input type="text" name="latitude" placeholder="请输入经度值" onblur="checkLatitude(this)"/> </td>
				</tr>
					<a id="latitude_msg"></a>
				<tr>
					<td>安装时间</td>
					<td><input type="datetime-local" name="install_time" onblur="checkNull(this)" /> </td>
				</tr>
					<a id="install_time_msg"></a>
				<tr>
					<td colspan="2"><input type="submit" value="部署这个充电桩" align="middle"/> </td>
				</tr>
			</table>
		</form>
		</div>
</body>
</html>