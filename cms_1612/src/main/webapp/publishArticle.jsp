<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>个人中心</title>
    <!-- <link rel="stylesheet" href="../style/bulma.min.css" /> -->
    <link rel="stylesheet" href="style/common.css" />
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <!-- 引入ckeditor富文本编辑工具 -->
    <script type="text/javascript"   src="${pageContext.request.contextPath }/js/ckeditor/ckeditor.js"></script>
    <script type="text/javascript">
	    window.onload = function()
	    {
	        CKEDITOR.replace('content');
	    };
    	
	    function f1(channel_id){
			$.ajax({
				url:"findCate.do",
				data:"channel_id="+channel_id,
				dataType:"json",
				type:"post",
				success:function(data){
					$("#s2").empty();
					for(var i=0;i<data.length;i++){
						$("#s2").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
					}
				}
			});    		
    	}
    </script>
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
          欢迎, <span class="username"><a href="list.do">${login_user.nickname }</a> </span>
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
          <li>
            <a class="person-menu-item " href="my.do">
              我的文章
            </a>
          </li>
          <li>
            <a class="person-menu-item active" href="publish.do">
              发布文章
            </a>
          </li>
          <li>
            <a class="person-menu-item" href="toUpdate.do?id=${login_user.id}">
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
      	<!-- 
      	  enctype=multipart/form-data   和上传文件解析相关的编码设置 key=value&key2=value2
      	 -->
		<form action="upload.do"   method="post"  enctype="multipart/form-data">
      <section class="person-main bg-white">
        <div class="my-form">
          <div class="form-item">
            <label class="label">文章标题：</label>
            <input type="text"  name="title" class="form-item_input" />
          </div>
          <div class="form-item">
            <label class="label">栏目：</label>
            <!-- <input type="text" class="form-item_input" /> -->
            <select name="channel_id" id="s1" onchange="f1(this.value)">
            	<option>--请选栏目--</option>
            	<c:forEach items="${list }" var="c">
            		<option value="${c.id }">${c.name }</option>
            	</c:forEach>
            </select>
          </div>
          <div class="form-item">
            <label class="label">分类：</label>
           <!--  <input type="text" class="form-item_input" /> -->
           	<select name="category_id" id="s2">
           	</select>
          </div>
          <div class="form-item">
            <label class="label">内容:</label>
            <textarea class="form-item_textarea" id="content" name="content"> </textarea>
          </div>
          <div class="form-item">
            <label class="label">上传图片:</label>
            <div class="form-con">
              <input type="file" name="pic" />
              <p class="tip">
               		 支持绝大多数的图片格式，单张图片大小不超过 10 M。
              </p>
            </div>
          </div>
          <div class="form-item">
            <label class="label">是否上头条:</label>
            <input type="checkbox" name="hot"  value="1"/>
          </div>
          <div class="my-form_btns">
            <button class="is-button button-primary"  type="submit">发布</button>
          </div>
        </div>
      </section>
     </form>
    </div>
  </body>
</html>
