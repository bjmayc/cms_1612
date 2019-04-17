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
       <script type="text/javascript"  src="js/My97DatePicker/WdatePicker.js"></script>
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
          欢迎, <span class="username"><a href="list.do">${login_user.username }</a></span>
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
      <span class="user-name">${login_user.username }</span>
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
            <a class="person-menu-item active" href="toUpdate.do?id=${login_user.id}">
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
      	
        <section class="person-main bg-white">
        	<form action="update.do" method="post">
        <div class="my-form">
          <div class="form-item">
            <label class="label">昵称：</label>
            <input type="text"  name="nickname" value="${u.nickname }" class="form-item_input" />
          </div>
          <div class="form-item">
          	性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label class="radio-inline">
				 <input type="radio" name="gender" id="man" <c:if test="${u.gender=='男'}">checked</c:if> value="男">男
				</label>
				&nbsp;&nbsp;&nbsp;
				<label class="radio-inline">
					  <input type="radio" name="gender" id="woman" <c:if test="${u.gender=='女'}">checked</c:if> value="女">女
				</label>
          </div>
          <div class="form-item">
            <label class="label">日期：</label>
            <input type="text" name="birthday"  value="<fmt:formatDate value='${u.birthday }' pattern='yyyy/MM/dd'/>" readonly="readonly"  onclick="WdatePicker({dateFmt:'yyyy/MM/dd'});" class="form-item_input" />
          </div>

          <div class="my-form_btns">
          	 <input type="hidden" name="id" value="${u.id }"/>
            <button type="reset"   class="is-button button-normal">取消</button>
            <button type="submit"  class="is-button button-primary">确定</button>
          </div>
        </div>
         </form>
      </section>
     
    </div>
  </body>
</html>
