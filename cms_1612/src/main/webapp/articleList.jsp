<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>个人中心</title>
    <!-- <link rel="stylesheet" href="../style/bulma.min.css" /> -->
    <link rel="stylesheet" href="style/common.css" />
  </head>
  <body>
    <nav class="nav">
      <div class="nav-inner">
        <div class="head">
          <div class="logo-img"></div>
          <h2>个人中心</h2>
        </div>
        <div class="user-info">
          <input class="search-input" type="text" />
          欢迎, <span class="username"><a href="list.do">${login_user.nickname}</a></span>
          <span class="line">|</span>
          <span class="logout-btn" id="logout-btn"><a href="logout.do">退出</a></span>
        </div>
      </div>
    </nav>
    <div class="banner"></div>
    <div class="user-avatar">
      <div class="avatar">
        <img src="../image/xyjy.png" alt="" />
      </div>
      <span class="user-name">${login_user.nickname }</span>
    </div>
    <div class="person-center">
      <aside class="person-menu">
        <ul>
          <li><a class="person-menu-item active" href="my.do">我的文章</a></li>
          <li>
            <a class="person-menu-item" href="publish.do">
              发布文章
            </a>
          </li>
          <li>
            <a class="person-menu-item" href="toUpdate.do?id=${login_user.id }">
              个人设置
            </a>
          </li>
          <li>
            <a class="person-menu-item" href="updatePassword.jsp">
              密码设置
            </a>
          </li>
        </ul>
      </aside>

      <section class="person-main">
        <div class="article-items">
        
        	<c:forEach items="${list }"  var="a">
          <div class="article-item">
            <div class="article-item_title">
           		${a.title },${a.title }
            </div>
            <div class="article-item_info">
              <div class="info-left">
                <span class="views">${a.hits}</span>
                <span class="publish-date"><fmt:formatDate value="${a.created }" pattern="yyyy-MM-dd HH:mm:ss" /></span>
              </div>
              <div class="info_more">
              	<c:if test="${a.status==0}">
              		<span class="article-status status-processing">审核中</span>
              	</c:if>
              	
              	<c:if test="${a.status==1}">
              		<span class="article-status status-passed">审核通过</span>
              	</c:if>
              	
              	<c:if test="${a.status==2}">
              		<span class="article-status status-deny">审核未通过</span>
              	</c:if>
                <span class="article-btn"><a href="delete.do?id=${a.id }">删除</a></span>
              </div>
            </div>
          </div>
		</c:forEach>
        </div>
      </section>
    </div>
  </body>
</html>
