<c:forEach var="c" items="${allCategorys}">
	<li class="${param.cid==c.cid?'active':''}"><a href="${pageContext.request.contextPath}/showProductsByCidByPage.do?cid=${c.cid}">${c.cname }</a></li>
</c:forEach>