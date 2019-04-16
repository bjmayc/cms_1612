<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${current_user == null }">
	<li><a href="${pageContext.request.contextPath}/toLogin.do">登录</a></li>
	<li><a href="${pageContext.request.contextPath}/toRegister.do">注册</a></li>
	<li><a href="${pageContext.request.contextPath}/showCart.do">购物车</a></li>
</c:if>
<c:if test="${current_user != null }">
	<li>${current_user.username }</li>
	<li><a href="${pageContext.request.contextPath}/order/showOrders.do">我的订单</a></li>
	<li><a href="${pageContext.request.contextPath}/showCart.do">购物车</a></li>
</c:if>