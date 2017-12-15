<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="com.shop.entity.CartProduct"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>cart</title>
<link href="/test5/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/test5/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="/test5/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='https://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<!--//fonts-->
<script type="text/javascript" src="/test5/js/move-top.js"></script>
<script type="text/javascript" src="/test5/js/easing.js"></script>
				<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
<script>$(document).ready(function(c) {
	$('.alert-close1').on('click', function(c){
		$('.message1').fadeOut('slow', function(c){
	  		$('.message1').remove();
		});
	});	  
});
</script>				
</head>
<body>
  <!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">	
			<div class="header-top-in">			
				<div class="logo">
					<a href="/test5/index.jsp"><img src="/test5/images/logo.png" alt=" " ></a>
				</div>
				<div class="header-in">
					<ul class="icon1 sub-icon1">
							<li  ><a href="/test5/cart/cartDisplay">购物车 (0)</a> </li>
							<li  ><a href="/test5/user.jsp">我的账户</a></li>
							<li > <a href="/test5/loginadm.jsp" >管理员登录</a> </li>	
							<li><div class="cart">
									<a href="#" class="cart-in"> </a>
									<span> 0</span>
								</div>
								<ul class="sub-icon1 list">
						  <h3>最近添加的项目(2)</h3>
						  <div class="shopping_cart">
							  <div class="cart_box">
							   	 <div class="message">
							   	     <div class="alert-close"> </div> 
					                <div class="list_img"><img src="/test5/images/14.jpg" class="img-responsive" alt=""></div>
								    <div class="list_desc"><h4><a href="#">velit esse molestie</a></h4>1 x<span class="actual">
		                             $12.00</span></div>
		                              <div class="clearfix"></div>
	                              </div>
	                            </div>
	                            <div class="cart_box1">
								  <div class="message1">
							   	     <div class="alert-close1"> </div> 
					                <div class="list_img"><img src="/test5/images/15.jpg" class="img-responsive" alt=""></div>
								    <div class="list_desc"><h4><a href="#">velit esse molestie</a></h4>1 x<span class="actual">
		                             $12.00</span></div>
		                              <div class="clearfix"></div>
	                              </div>
	                            </div>
	                        </div>
	                        <div class="total">
	                        	<div class="total_left">购物车小计 : </div>
	                        	<div class="total_right">$250.00</div>
	                        	<div class="clearfix"> </div>
	                        </div>
                            <div class="login_buttons">
							  <div class="check_button"><a href="/test5/order.jsp">去结算</a></div>
							  <div class="clearfix"></div>
						    </div>
					      <div class="clearfix"></div>
						</ul>
							</li>
						</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			</div>
		</div>
		<div class="header-bottom">
		<div class="container">
			<div class="h_menu4">
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
					<li class="active"><a href="/test5/index.jsp"><i> </i>首页</a></li>
					<li ><a href="/test5/product/productDisplay" >产品</a>
						<ul class="drop">
							<li><a href="products.jsp">最新产品</a></li>
							<li><a href="/test5/product/displayByType?type=电脑">电脑</a></li>
							<li><a href="/test5/product/displayByType?type=手机">手机</a></li>
							<li><a href="/test5/product/displayByType?type=paid">paid</a></li>
							<li><a href="/test5/product/displayByType?type=相机">相机</a></li>
						</ul>
						</li> 							  				 
						<li><a href="/test5/login.jsp" >用户登录</a></li>
					
				</ul>
				<script type="text/javascript" src="/test5/js/nav.js"></script>
			</div>
		</div>
		</div>
		<div class="header-bottom-in">
			<div class="container">
			<div class="header-bottom-on">
			<p class="wel"><a href="#">欢迎光临，您可以登录或注册一个账户.</a></p>
			<div class="header-can">
				<ul class="social-in">
						<li><a href="#"><i> </i></a></li>
						<li><a href="#"><i class="facebook"> </i></a></li>
						<li><a href="#"><i class="twitter"> </i></a></li>					
						<li><a href="#"><i class="skype"> </i></a></li>
					</ul>	
					<div class="down-top">		
							<select class="in-drop">
							  <option value="Dollars" class="in-of">美元</option>
							  <option value="Euro" class="in-of">欧元</option>
							  <option value="Yen" class="in-of">日元</option>
							</select>
					 </div>
					<div class="search">
						<form>
							<input type="text" value="Search" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '';}" >
							<input type="submit" value="">
						</form>
					</div>

					<div class="clearfix"> </div>
			</div>
			<div class="clearfix"></div>
		</div>
		</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${empty cartProductList}">
		<div class="container">
			<div class="check-out">
    	   	 <h4 class="title">购物车</h4>
    	    	<p class="cart">您的购物车中没有商品.<br>点击<a href="/test5/index.jsp"> 这里</a> 开始购物</p>
    		</div>
		</div>
		</c:when>
		<c:when test="${not empty cartProductList}">
			<div class="container">
				<div class="check-out">
    	   	 	<h4 class="title">购物车</h4>
    	   	 		<table border="1" cellpadding="10">
    	   	 			<tr>
    	   	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;产品编号 &nbsp;&nbsp;&nbsp;      </td>
    	   	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;用户编号 &nbsp;&nbsp;&nbsp;      </td>
    	   	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;产品名称&nbsp; &nbsp;&nbsp;      </td>
    	   	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;产品单价 &nbsp;&nbsp;&nbsp;      </td>
    	   	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;产品数量&nbsp;  &nbsp;&nbsp;		</td>
    	   	 			</tr>
    	   	 			<c:forEach items="${cartProductList }" var="cpt">
    	   	 				<tr>
    	   	 					<td>&nbsp;&nbsp;&nbsp;&nbsp;${cpt.productId } &nbsp;&nbsp;&nbsp;      </td>
    	   	 					<td>&nbsp;&nbsp;&nbsp;&nbsp;${cpt.userId } &nbsp;&nbsp;&nbsp;      </td>
    	   	 					<td>&nbsp;&nbsp;&nbsp;&nbsp;${cpt.productName }&nbsp; &nbsp;&nbsp;      </td>
    	   	 					<td>&nbsp;&nbsp;&nbsp;&nbsp;${cpt.price } &nbsp;&nbsp;&nbsp;      </td>
    	   	 					<td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/test5/cart/cartReduceDisplay?productId=${cpt.productId }">-</a>&nbsp;&nbsp;&nbsp;&nbsp;${cpt.count }&nbsp;  &nbsp;<a href="/test5/cart/cartAddDisplay?productId=${cpt.productId }">+</a>&nbsp;		</td>
    	   	 				</tr>
    	   	 			</c:forEach>
    	   	 			<tr>
    	   	 				<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;总计：${money }
    	   	 				</td>
    	   	 				<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;<a href="/test5/order/generateOrder">生成订单</a></td>
    	   	 			</tr>
    	   	 		</table>
			</div>
			</div>
		</c:when>
	</c:choose>
	
	
	
	
		<!---->
		<div class="footer">
			<div class="footer-top">
				<div class="container">
					<div class="col-md-4 footer-in">
						<h4><i> </i>Suspendisse sed</h4>
						<p>Aliquam dignissim porttitor tortor non fermentum. Curabitur in magna lectus. Duis sed eros diam. Lorem ipsum dolor sit amet, consectetur.</p>
					</div>
					<div class="col-md-4 footer-in">
						<h4><i class="cross"> </i>Suspendisse sed</h4>
						<p>Aliquam dignissim porttitor tortor non fermentum. Curabitur in magna lectus. Duis sed eros diam. Lorem ipsum dolor sit amet, consectetur.</p>
					</div>
					<div class="col-md-4 footer-in">
						<h4><i class="down"> </i>Suspendisse sed</h4>
						<p>Aliquam dignissim porttitor tortor non fermentum. Curabitur in magna lectus. Duis sed eros diam. Lorem ipsum dolor sit amet, consectetur.</p>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!---->
			<div class="footer-middle">
				<div class="container">
					<div class="footer-middle-in">
						<h6>关于我们</h6>
						<p>Suspendisse sed accumsan risus. Curabitur rhoncus, elit vel tincidunt elementum, nunc urna tristique nisi, in interdum libero magna tristique ante. adipiscing varius. Vestibulum dolor lorem.</p>
					</div>
					<div class="footer-middle-in">
						<h6>信息</h6>
						<ul>
							<li><a href="#">关于我们</a></li>
							<li><a href="#">配送信息</a></li>
							<li><a href="#">隐私政策</a></li>
							<li><a href="#">条款条件</a></li>
						</ul>
					</div>
					<div class="footer-middle-in">
						<h6>客户服务</h6>
						<ul>
							<li><a href="contact.html">联系我们</li>
							<li><a href="#">返回</a></li>
							<li><a href="#">网站地图</a></li>
						</ul>
					</div>
					<div class="footer-middle-in">
						<h6>我的账户</h6>
						<ul>
							<li><a href="account.html">我的账户</a></li>
							<li><a href="#">订单历史</a></li>
							<li><a href="wishlist.html">愿望清单</a></li>
							<li><a href="#">通讯</a></li>
						</ul>
					</div>
					<div class="footer-middle-in">
						<h6>附加功能</h6>
						<ul>
							<li><a href="#">品牌</a></li>
							<li><a href="#">购物券</a></li>
							<li><a href="#">关联公司</a></li>
							<li><a href="#">特价</a></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<p class="footer-class">Copyright &copy; 2015.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
			<script type="text/javascript">
						$(document).ready(function() {
							/*
							var defaults = {
					  			containerID: 'toTop', // fading element id
								containerHoverID: 'toTopHover', // fading element hover id
								scrollSpeed: 1200,
								easingType: 'linear' 
					 		};
							*/
							
							$().UItoTop({ easingType: 'easeOutQuart' });
							
						});
					</script>
				<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>

		</div>
</body>
</html>