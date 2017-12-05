<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function changeNum(id,obj,oldnum){
  			if(!/^[1-9]\d*$/.test(obj.value)){
  				alert("购买数量必须为正整数!");
  				obj.value=oldnum;
  				return;
  			}
		  		window.location.href = "/ChangeCartServlet?id="+id+"&buynum="+obj.value;
  		}
  	</script>
  </head>
  
  <body>
	<h1>我的购物车</h1>
	<div align="right">
		<a href="/ProdListServlet">继续购物</a>
		<a href="/ClearCartServlet">清空购物车</a>
		<a href="/addOrder.jsp"><img src="/WebRoot/img/gotoorder.bmp"  style="border: 0"></a>
	</div><hr>
	<c:if test="${empty sessionScope.cartmap }" >
		<h2 align="center"><a href="ProdListServlet" >购物车空空如也，先去挑点东西吧！</a></h2>
	</c:if>
	
	<c:if test="${not empty sessionScope.cartmap }" >	
		<table width="100%" style="text-align: center">
			<tr>
				<th>缩略图</th>
				<th>商品名称</th>
				<th>商品种类</th>
				<th>商品单价</th>
				<th>购买数量</th>
				<th>库存状态</th>
				<th>总价</th>
			</tr>
			<!-- 变量注释：每一个entry代表一条购物信息 ，每一条信息都对应一行记录-->
			<c:set var="money" value="0"/>
			<c:forEach items="${sessionScope.cartmap }" var="entry">
				<tr>
					<td><img src="/ImgServlet?imgurl=${entry.key.imgurls }" ></img></td>
					<td>${entry.key.name}</td>
					<td>${entry.key.category}</td>
					<td>${entry.key.price}元</td>
					<td><input value="${entry.value}" id="buynum" style="width: 30px;" 
						onchange="changeNum('${entry.key.id }',this,${entry.value })"/>件</td>
					<td>
						<!-- 变量注释：entry.value(Integer类型)：用户需要该商品的数量 -->
								<!-- entry.(Product)key.pnum：根据商品bean查到的库存数量 -->
						<c:if test="${entry.value<=entry.key.pnum }">
							<font color="blue">有货</font>
						</c:if>
						<c:if test="${entry.value>entry.key.pnum }">
							<font color="red">缺货</font>
						</c:if>
					</td>
					<td>
						${entry.key.price*entry.value }元
						<c:set var="money" value="${money + entry.key.price*entry.value }"/>
					</td>
					<th><a href="/DelCartServlet?id=${entry.key.id }">删除</a></th>
				</tr>
			</c:forEach>
			
		</table>
	</c:if><hr>
	<div align="right">
		<font color="red" size=7>总价：${money>0?money:0 }元</font>
	</div>
	
  </body>
</html>
