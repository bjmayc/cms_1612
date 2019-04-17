<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>注册页面</title>
    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript"  src="js/My97DatePicker/WdatePicker.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
          <script type="text/javascript">
			var flag1;
			var flag2;
          	$(function(){
				$("#a1").click(function(){
					$("#img").attr("src","${pageContext.request.contextPath }/code?dt="+Math.random());
				});
				
				$("#img").click(function(){
					$("#a1").click();
				});
				
				$("#code").blur(function(){
					if($(this).val().length==0){
						return;
					}
					$.ajax({
						url:"checkcode.do",
						data:"code="+$("#code").val(),
						dataType:"json",
						type:"post",
						async:false,
						success:function(data){
							if(data==true){
								$("#code_msg").html("正确");
								$("#code_msg").css("color","green");
								flag1=true;
							}else{
								$("#code_msg").html("错误");
								$("#a1").click();
								$("#code_msg").css("color","red");
								flag1=false;
							}
						}						
					});					
				});
				
				$("#username").blur(function(){
					if($(this).val().trim().length==0){
						//如果用户名的值没有填写 或者  空格   
						return;
					}
					$.ajax({
						url:"existUsername.do",
						data:"username="+$(this).val(),
						dataType:"json",
						async:false,
						type:"post",
						success:function(data){
							if(data==true){
								$("#username_msg").html("用户名可以使用");
								$("#username_msg").css("color","green");
								flag2=true;
							}else{
								$("#username_msg").html("用户名已经被占用");
								$("#username_msg").css("color","red");
								flag2=false;
							}
						}
					});
				});
			});
          	
          	//验证码错误 或者用户名被占用    不能提交
			function sub(){
          		$("#code").blur();
          		$("#username").blur();
				return flag1&&flag2;
			}
		</script>
  </head>

  <body class="bg-dark">
    <div class="container">
      <div class="card card-register mx-auto mt-5">
        <div class="card-header">注册新用户&nbsp;&nbsp;&nbsp;<span id="username_msg"></span></div>
        <div class="card-body">
          <form action="regist.do"  method="post" id="form1" onsubmit="return sub();">
           
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text" id="username"  name="username"   class="form-control" placeholder="请输入用户名" required="required">
                    <label for="username">username</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码" required="required">
                    <label for="password">password</label>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
               <div class="form-row">
               	  <div class="col-md-6">
            		 <div class="form-label-group">
                		 <input type="text" name="nickname" id="nickname" class="form-control" placeholder="请输入昵称" required="required">
               			 <label for="nickname">nickname</label>
              		 </div>
                 </div>		 
                 <div class="col-md-6">
            		 <div class="form-label-group">
                		 <input type="text"  onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})"    name="birthday" id="birthday" class="form-control">
               			 <label for="birthday">birthday</label>
              		 </div>
                 </div>
               </div>
             </div>
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-2">
                	 <label class="radio-inline">
					    <input type="radio" name="gender" id="man" value="男"> 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="gender" id="woman" value="女"> 女
					</label>
                </div>
                 <div class="col-md-10">
                	<img src="${pageContext.request.contextPath }/code" id="img"/><a href="javascript:;" id="a1">看不清换一个</a>
                	<input type="text" id="code" style="width:80px"/><span id="code_msg"></span>
                </div>
              </div>
            </div>
            
            <button type="submit" class="btn btn-primary btn-block">注册</button>
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="login.jsp">已经注册,直接登录</a>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
