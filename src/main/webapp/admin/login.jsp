<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>登录</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="${pageContext.request.contextPath }/admin/media/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath }/admin/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath }/admin/media/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath }/admin/media/css/style-metro.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath }/admin/media/css/style.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath }/admin/media/css/style-responsive.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath }/admin/media/css/default.css" rel="stylesheet" type="text/css" id="style_color" />
	<link href="${pageContext.request.contextPath }/admin/media/css/uniform.default.css" rel="stylesheet" type="text/css" />
	<!-- END GLOBAL MANDATORY STYLES -->
	<!-- BEGIN PAGE LEVEL STYLES -->
	<link href="${pageContext.request.contextPath }/admin/media/css/login.css" rel="stylesheet" type="text/css" />
	<!-- END PAGE LEVEL STYLES -->
	
	<script src="${pageContext.request.contextPath }/admin/media/js/jquery-1.10.1.min.js"></script> 
	<script type="text/javascript">
    	$(function(){
        	//刷新验证码：重新给图片的src赋值，后边加时间，防止缓存 
    		$("#randomcode_img").click(function(){
    			$(this).attr('src',
                	'${pageContext.request.contextPath }/code?time=' + new Date().getTime());
    		});
    	});
	</script>

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="login">

	<!-- BEGIN LOGO -->

	<div class="logo">
		<h3 style="color: white;">蜀南气矿团委</h3>
	</div>

	<!-- END LOGO -->

	<!-- BEGIN LOGIN -->

	<div class="content">

		<!-- BEGIN LOGIN FORM -->

		<form class="form-vertical login-form" action="${pageContext.request.contextPath }/login" method="post">
			<h3 class="form-title">登录账户</h3>
			<c:if test="${msg != null }">
				<div class="alert alert-error">
					<button class="close" data-dismiss="alert"></button>
					<strong>警告：</strong><font style="color:red">${msg }</font>
				</div>
			</c:if>
			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">用户名</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="用户名" name="account"/>
					</div>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input class="m-wrap placeholder-no-fix" type="password" placeholder="密码" name="password"/>
					</div>
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">验证码</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-file-text"></i>
						<input style="width: 185px;" class="m-wrap placeholder-no-fix" type="text" placeholder="验证码" name="randomCode" id="randomCode"/>
<!-- 						<img style="width: 60px; height: 34px;" src="media/image/7.jpg" /> -->
				    	<img id="randomcode_img" src="${pageContext.request.contextPath }/code" alt=""
						style="width: 60px; height: 34px;" align='absMiddle' /> 
					</div>
				</div>
				
			</div>

			<div class="form-actions">
				<!--<label class="checkbox">
				<input type="checkbox" name="remember" value="1"/> 记住我
				</label>-->
				<button type="submit" class="btn green pull-right">
				登录 <i class="m-icon-swapright m-icon-white"></i>
				</button>            
			</div>
		</form>

		<!-- END LOGIN FORM -->     
		
	</div>   

	<!-- BEGIN COPYRIGHT -->

	<div class="copyright">

		Powered by 北京信雅致达信息科技有限公司

	</div>

	<!-- END COPYRIGHT -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<script src="${pageContext.request.contextPath }/admin/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/admin/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="${pageContext.request.contextPath }/admin/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      

	<script src="${pageContext.request.contextPath }/admin/media/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="media/js/excanvas.min.js"></script>

	<script src="media/js/respond.min.js"></script>  

	<![endif]-->   

	<script src="${pageContext.request.contextPath }/admin/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/admin/media/js/jquery.blockui.min.js" type="text/javascript"></script>  

	<script src="${pageContext.request.contextPath }/admin/media/js/jquery.cookie.min.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/admin/media/js/jquery.uniform.min.js" type="text/javascript" ></script>

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="${pageContext.request.contextPath }/admin/media/js/jquery.validate.min.js" type="text/javascript"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${pageContext.request.contextPath }/admin/media/src/app.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath }/admin/media/src/login.js" type="text/javascript"></script>      

	<!-- END PAGE LEVEL SCRIPTS --> 

	<script>

		jQuery(document).ready(function() {     

		  App.init();

		  Login.init();

		});

	</script>

	<!-- END JAVASCRIPTS -->
<!-- END BODY -->

</html>