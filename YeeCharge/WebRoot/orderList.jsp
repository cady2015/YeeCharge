<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
	<h1>订单查询</h1><hr>
	<c:forEach items="${requestScope.list }" var="olf">
		<h3>
		订单号:${olf.id }
		</h3>
		用户名称 :${olf.username }<br>
		订单金额 :${olf.money }<br>
		支付状态 :<c:if test="${olf.paystate==0 }">
					<font color="red">未支付</font>
					<a href="/DelOrderServlet?id=${olf.id}">订单删除</a>
					<a href="/pay.jsp?id=${olf.id}&money=${olf.money}">在线支付</a><br>
				</c:if>
				<c:if test="${olf.paystate!=0 }">
					<font color="blue">已支付</font><br>
				</c:if>
		收货地址 :${olf.receiverinfo}<br>
		下单时间 :${olf.ordertime }<br>
		
		<table bordercolor="gray" border="1" width="100%" cellpadding="10px" style="margin: 0px;text-align: center;">
			<tr >
				<th>商品名称</th>
				<th>购买数量</th>
				<th>单价</th>
				<th>总金额</th>
			</tr>
			<c:forEach items="${olf.prodMap }" var="map">
				<tr >
					<td>${map.key.name }</td>
					<td>${map.value }</td>
					<td>${map.key.price }</td>
					<td>${map.key.price*map.value }</td>
				</tr>			
			</c:forEach>
		</table>
		<hr><br>
	</c:forEach>
  </body>
</html>

