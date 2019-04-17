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
    <script type="text/javascript"  src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
    	function checkpwd(){
    		var repwd = $("#repwd").val();
    		var pwd = $("#pwd").val();
    		if(repwd.length==0){
    			alert("确认密码不能为空!");
    			return false;
    		}
    		
    		if(repwd!=pwd){
    			alert("俩次密码不一致!");
    			return false;
    		}
    		return true;
    	}
    	
    	function sub(){
    		var flag = checkpwd();
    		return flag;
    	}
    
    
    </script>
  </head>
  <body>
    <nav class="nav">
      <div class="nav-inner">
        <div class="head">
          <div class="logo-img"></div>
          <h2>后台系统</h2>
        </div>
        <div class="user-info">
          <input class="search-input" type="text" />
          欢迎, <span class="username"><a href="list.do">${login_user.nickname }</a></span>
          <span class="line">|</span>
          <span class="logout-btn" id="logout-btn"> <a href="logout.do">退出</a></span>
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
            <a class="person-menu-item" href="publish.do">
              发布文章
            </a>
          </li>
          <li>
            <a class="person-menu-item" href="toUpdate.do?id=${login_user.id}">
              个人设置
            </a>
          </li>
          <li>
            <a class="person-menu-item active" href="updatePassword.jsp">
           			   密码设置
            </a>
          </li>
        </ul>
      </aside>

      <section class="person-main bg-white">
      	<form action="updatePwd.do" method="post" onsubmit="return sub();">
        <div class="my-form">
          <div class="form-item">
            <label class="label">用户名：</label>
            <input type="text"  value="${login_user.username }" name="username" readonly="readonly"   class="form-item_input" />
          </div>
          <div class="form-item">
            <label class="label">新密码：</label>
            <input type="password" id="pwd" name="new_password" class="form-item_input" />
          </div>
          <div class="form-item">
            <label class="label">确认新密码：</label>
            <input type="password"  id="repwd" onblur="checkpwd();" class="form-item_input" />
          </div>

          <div class="my-form_btns">
            <button class="is-button button-primary" type="submit">确定</button>
          </div>
        </div>
        </form>
      </section>
    </div>
  </body>
</html>
