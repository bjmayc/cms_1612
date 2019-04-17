<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
	<style>
		body,html,h4{
			padding:0;
			margin:0;
		}
		.wrap{
			width:100%;
			height:100%;
		}
		header{
			width:100%;
			height:40px;
		}
		.heads{
			margin-left:20px;
			line-height: 40px;
			font-size:20px;
		}
		input{
			margin-left: 100px;
			width:220px;
			height:30px;
			line-height: 40px;	
		}
		h4{
			line-height:30px;
			width:200px;
		}
		li{
			list-style-type:none;
		}
		.denglu{
			float:right;
			margin-right:80px;
			line-height: 40px;
		}
		.deng{
			margin-left: 30px;
		}
		.col-md-2{
			height:100%;
		}
		.col-md-2 ul li{
			width:100%;
			height:60px;
			line-height: 60px;
			font-size:22px;
		} 
		.col-md-10{
			height:100%;
		}
        .banner{
        	width:100%;
        }
        .banner img{
        	width:100%;
        	height:200px;
        }
        .col-md-10 ul{
			padding-left:40px;
			margin-top:30px;
         }
        .col-md-10 ul li{
        	width:100%;
        	height:90px;
        }
        .lis{
        	font-size: 18px;
        }
        .liss{
        	margin-top:25px;
        }
	</style>
	
</head>
<body bgcolor="yellow">
	<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
	
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function page(pno){
			location.href="page.do?cpage="+pno+"&channel_id="+$("#channel_id").val()+"&category_id="+$("#category_id").val();
		}
		
		function   f1(){
			location.href="page.do?channel_id="+$("#channel_id").val()+"&category_id="+$("#category_id").val()+"&like="+$("#like").val();
		}
		
		
	</script>
	<div class="wrap">
		<header>
			<span class="heads"><img src="image/earth.png"/>八维CMS管理系统</span>
			<input  name="like" id="like" value="${like }" /><button type="button"  class="btn btn-primary"  onclick="f1()">搜索</button>
			<p class="denglu">
			<c:if test="${login_user!=null}">
				<span><a href="publish.do">${login_user.nickname}</a></span>
			</c:if>
			<c:if test="${login_user==null}">
				<span><a href="login.jsp">登录</a></span>
			</c:if>
			
			<span class="deng"><a href="${pageContext.request.contextPath }/regist.jsp">注册</a></span></p>
		</header>
		<main>
			 <div class="col-md-2">
				<ul>
					<li><a href="list.do">推荐</a></li>
					<c:forEach  items="${list }"  var="c">
						<li><a href="page.do?channel_id=${c.id }">${c.name }</a></li>
					</c:forEach>
				</ul>				
			 </div>
			 <div class="col-md-6">
			 		<input  type="hidden" id="channel_id"  value="${channel_id}">
			 		<input  type="hidden" id="category_id"  value="${category_id}">
					<!-- <banner class="banner">
						<img src="image/a.jpg"  />
						<img src="image/b.jpg"  />
					</banner> -->
					<c:forEach  items="${cates }"  var="c">
							<a href="page.do?channel_id=${channel_id}&category_id=${c.id}">${c.name}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;				
					</c:forEach>
				<div id="myCarousel" class="carousel slide">
			   		 <!-- 轮播（Carousel）指标 -->
				    <ol class="carousel-indicators">
				        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				        <li data-target="#myCarousel" data-slide-to="1"></li>
				        <li data-target="#myCarousel" data-slide-to="2"></li>
				    </ol>   
				    <!-- 轮播（Carousel）项目
						作业：将下面的图片  从数据库 获取   
						-->
				    <div class="carousel-inner">
				        <div class="item active">
				            <img src="image/a.jpg" alt="First slide">
				        </div>
				        <div class="item">
				            <img src="image/b.jpg" alt="Second slide">
				        </div>
				         <div class="item">
				            <img src="image/c.jpg" alt="Three slide">
				        </div>
				    </div>
			   	  <!-- 轮播（Carousel）导航 -->
				   <a class="carousel-control left" href="#myCarousel" 
				       data-slide="prev">
				        <span _ngcontent-c3="" aria-hidden="true" class="glyphicon glyphicon-chevron-left"></span></a>
				   <a class="carousel-control right" href="#myCarousel" 
				       data-slide="next">
				        <span _ngcontent-c3="" aria-hidden="true" class="glyphicon glyphicon-chevron-right"></span>
				   </a>
			</div>
					<ul>
						<c:forEach  items="${articles }"  var="a">
						<li>
							<p class="lis"><img src="${pageContext.request.contextPath }/img/${a.picture }" />${a.title }</p>
							<p class="liss">作者 : ${a.nickname }&nbsp 浏览量 : ${a.hits } &nbsp 发布时间 ： ${a.created }</p>
						</li>
						</c:forEach>
					</ul>
					<span>${pm.page }</span>
			 </div>
		</main>
	</div>
</body>
</html>