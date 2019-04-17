<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
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
			location.href="shenhe.do?cpage="+pno+"&title="+$("#title").val()+"&content="+$("#content").val()+"&user="+$("#user").val()+"&ts="+$("#ts").val()+"&status="+$(":checked").val();
		}
		
		function   f1(){
			location.href="shenhe.do?title="+$("#title").val()+"&content="+$("#content").val()+"&user="+$("#user").val()+"&ts="+$("#ts").val()+"&status="+$(":checked").val();
		}
		
		function  tongguo(id){
			$.ajax({
				url:"tongguo.do",
				data:"id="+id,
				type:"post",
				dataType:"json",
				success:function(data){
					if(data==true){
						alert("审核成功");
						location.href="shenhe.do";
					}else{
						alert("审核失败!");
					}
				}
			});
		}
		
		
	</script>
	<div class="wrap">
		<header>
			<span class="heads"><img src="image/earth.png"/>八维CMS后台管理系统</span>
			<p class="denglu">
			<c:if test="${admin!=null}">
				<span><a href="publish.do">${admin.admin_username}</a></span>
			</c:if>
			<c:if test="${admin==null}">
				<span><a href="adminLogin.jsp">登录</a></span>
			</c:if>
			</p>
		</header>
		<main>
			 <div class="col-md-2">
				<ul>
					<li><a href="shenhe.do">文章审核</a></li>
					<li><a href="list.do">系统设置</a></li>
					<li><a href="list.do">分类管理</a></li>
					<li><a href="list.do">用户管理</a></li>
					<li><a href="guanggao.jsp">广告管理</a></li>
				</ul>				
			 </div>
			 <div class="col-md-10">
			 	<input  id="title"  value="${title }"/>
			 	<input  id="user"  value="${user }"/>
			 	
				<select name="status" id="status">
						<option value="-1" <c:if test="${status==-1 }">selected</c:if>>所有</option>
						<option value="1" <c:if test="${status==1 }">selected</c:if>>通过</option>
						<option value="0" <c:if test="${status==0 }">selected</c:if>>审核中</option>
						<option value="2" <c:if test="${status==2 }">selected</c:if>>未通过</option>
				</select><br/>
			 	<input  id="content"  value="${content }"/>
			 	<%-- <input  id="ts"  value="<fmt:formatDate value='${ts }' pattern='yyyy/MM/dd HH:mm:ss'/>"   onclick="WdatePicker({dateFmt:'yyyy/MM/dd HH:mm:ss'})"/> --%>
			 	<input  id="ts"  value="${ts }"   onclick="WdatePicker({dateFmt:'yyyy/MM/dd HH:mm:ss'})"/>
			 	<input type="button" value="查询"  onclick="f1()"/> 
			 	<br/>
			 	<table class="table table_hover">
			 		<tr>
			 			<th>文章id</th>
			 			<th>文章标题</th>
			 			<th>文章内容</th>
			 			<th>发布人</th>
			 			<th>发布时间</th>
			 			<th>发布状态</th>
			 			<th>操作</th>
			 		</tr>
			 	<c:forEach  items="${list1 }" var="a">
			 			<tr>
			 				<td>${a.id }</td>
			 				<td>${a.title }</td>
			 				<td>${a.content }</td>
			 				<td>${a.nickname }</td>
			 				<td><fmt:formatDate value='${a.created }'  pattern='yyyy/MM/dd HH:mm:ss'/></td>
			 				<td>
			 					<c:if test="${a.status==0}">
			 						<span style="color:red;">待审核</span>
			 					</c:if>
			 					<c:if test="${a.status==1}">
			 						<span style="color:green;">已通过</span>
			 					</c:if>
			 					<c:if test="${a.status==2}">
			 						<span style="color:yellow;">未通过</span>
			 					</c:if>
			 				</td>
			 				<td><a href="javascript:;" id="tongguo" onclick="tongguo(${a.id})">通过</a>&nbsp;|&nbsp;<a href="#">未通过</a></td>
			 			</tr>
			 	</c:forEach>
			 	</table>
			 	<span>${pm.page}</span>
			 </div>
		</main>
	</div>
</body>
</html>