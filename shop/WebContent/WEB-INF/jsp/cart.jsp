<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
	<%@ include  file="include_bootstrap.jsp" %>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="css/style.css" type="text/css" />
		
		<script type="text/javascript">
		//当用户修改数量时，此函数负责修改小计的值，传入的参数，是被修改的文本输入框
		function chgSubtotal( ipt ){
			//得到输入框中的值
			var count = ipt.value;
			//通过ID，得到ID值中最后的数字（此数字代表是第几个购物项，通过此数字，得到此项的单价）
			var index = ipt.id.replace('ipt_count','');
			//在序号前面加上固定的单价的标签的ID的前缀，得到此标签的实际ID值
			var priceId = '#td_price'+index;
			//去掉内容中的￥，只得到数字部分
			var price = $(priceId).text().replace('￥','');
			//通过单价的数字*count,得到小计
			var subtotal = price * count;
			//通过序号，得到显示小计的span标签的ID
			var subtotalId = '#span_subtotal'+index;
			//使用JQuery的ID选择器，得到对应的SPAN标签
			$(subtotalId).text('￥'+subtotal);
		}
		
		
		</script>
		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
			
			.container .row div {
				/* position:relative;
	 float:left; */
			}
			
			font {
				color: #3164af;
				font-size: 18px;
				font-weight: normal;
				padding: 0 10px;
			}
		</style>
	</head>

	<body>

		
			<!--
            	时间：2015-12-30
            	描述：菜单栏
            -->
			<div class="container-fluid">
				<div class="col-md-4">
					<img src="${path }/resources/img/logo.gif" />
				</div>
				<div class="col-md-5">
					<img src="${path }/resources/img/header.png" />
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
							<%@ include  file="include_login.jsp" %>
					</ol>
				</div>
			</div>
			<!--
            	时间：2015-12-30
            	描述：导航条
            -->
			<div class="container-fluid">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<%@ include  file="include_nav.jsp" %>
							</ul>
							<form class="navbar-form navbar-right" role="search">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Search">
								</div>
								<button type="submit" class="btn btn-default">Submit</button>
							</form>

						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>


		<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong style="font-size:16px;margin:5px 0;">订单详情</strong>
					<form name="cartItems" action="${pageContext.request.contextPath}/order/generateOrder.do" method="post">
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${cart.map }" varStatus="s" var="e">
							<tr class="active">
								<td width="60" width="40%">
									<input type="hidden" name="id" value="${e.key }">
									<img src="${path }/resources${e.value.product.pimage }" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank"> ${e.value.product.pname }</a>
								</td>
								<td width="20%" id="td_price${s.count}">
									￥${e.value.product.shopPrice }
								</td>
								<td width="10%">
									<input onkeyup="chgSubtotal(this);" type="text" id="ipt_count${s.count}" name="count" value="${e.value.count }" maxlength="4" size="10">
								</td>
								<td width="15%">
									<span class="subtotal" id="span_subtotal${s.count}">￥${e.value.subtotal }</span>
								</td>
								<td>
									<a href="${pageContext.request.contextPath}/removeFromCart.do?pid=${e.key}" class="delete">删除</a>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					</form>
				</div>
			</div>

			<div style="margin-right:130px;">
				<div style="text-align:right;">
					<em style="color:#ff6600;">
				登录后确认是否享有优惠&nbsp;&nbsp;
			</em> 赠送积分: <em style="color:#ff6600;">596</em>&nbsp; 商品金额: <strong style="color:#ff6600;">￥${cart.total }元</strong>
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<a href="${pageContext.request.contextPath}/clearCart.do" id="clear" class="clear">清空购物车</a>
					<a href="order_info.htm">
						<input type="submit" width="100" onclick="document.cartItems.submit();" value="提交订单" name="submit" border="0" style="background: url('${path}/resources/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;">
					</a>
				</div>
			</div>

		</div>

		<div style="margin-top:50px;">
			<img src="${path }/resources/image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a>关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2005-2016 八维商城 版权所有
		</div>

	</body>

</html>