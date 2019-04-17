<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>个人中心</title>
    <!-- <link rel="stylesheet" href="../style/bulma.min.css" /> -->
       <script type="text/javascript"  src="js/My97DatePicker/WdatePicker.js"></script>
  </head>
  <body>
  	<form  action="add.do"  method="post"  enctype="multipart/form-data">
  		标题:  <input  name="title"/><br/>
  		图片:  <input  name="mf"  type="file"/><br/>
  		地址:  <input  name="url"/><br/>
  		<input   type="submit"  value="提交"/>
  	</form>
  </body>
</html>
