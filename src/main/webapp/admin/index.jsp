<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html> 

<head>
    <meta charset="utf-8"/>
    <title>新闻站后台管理</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <link href="${pageContext.request.contextPath }/admin/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath }/admin/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath }/admin/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath }/admin/media/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath }/admin/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath }/admin/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
    <!-- bootstrap-table -->
    <link href="${pageContext.request.contextPath }/admin/media/css/bootstrap-table.min.css" rel="stylesheet" type="text/css" />
</head>
<body class="page-header-fixed page-sidebar-fixed">
	<%
		Object user = request.getSession().getAttribute("user");
		if(user == null){
			response.sendRedirect("/committeewb/admin/login.jsp");
		}
	 %>
<div class="header navbar navbar-inverse navbar-fixed-top">
    <!-- BEGIN TOP NAVIGATION BAR -->
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="brand" href="${pageContext.request.contextPath }/admin/index.jsp">
                <!-- <img src="" alt="蜀南"/> -->
                <div style="margin-left: 20px;">蜀南气矿</div>
            </a>
            <!-- BEGIN RESPONSIVE MENU TOGGLER -->
            <a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
                <img src="${pageContext.request.contextPath }/admin/media/image/menu-toggler.png" alt=""/>
            </a>
            <!-- END RESPONSIVE MENU TOGGLER -->
            <!-- BEGIN TOP NAVIGATION MENU -->
            <ul class="nav pull-right">
                <!-- BEGIN USER LOGIN DROPDOWN -->
                <li class="dropdown user">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img alt="" src="${pageContext.request.contextPath }/admin/media/image/avatar.png" style="width: 29px;"/>
                        <span class="username">管理员</span>
                        <i class="icon-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath }/logout"><i class="icon-key"></i> 登出</a></li>
                    </ul>
                </li>
                <!-- END USER LOGIN DROPDOWN -->
            </ul>
            <!-- END TOP NAVIGATION MENU -->
        </div>
    </div>
    <!-- END TOP NAVIGATION BAR -->
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">

    <!-- BEGIN SIDEBAR -->

    <div class="page-sidebar nav-collapse collapse">
        <!-- BEGIN SIDEBAR MENU -->
        <ul class="page-sidebar-menu">
            <li>
                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                <div class="sidebar-toggler hidden-phone"></div>
                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
            </li>
            <br/>
            <li class="start active">
                <a href="${pageContext.request.contextPath }/admin/index.jsp">
                    <i class="icon-home"></i>
                    <span class="title">首页</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li class="">
                <a href="${pageContext.request.contextPath }/admin/websetting.jsp">
                    <i class="icon-cogs"></i>
                    <span class="title">网站基础信息</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li class="">
                <a href="javascript:;">
                    <i class="icon-bookmark-empty"></i>
                    <span class="title">新闻管理</span>
                    <span class="arrow"></span>
                </a>
                <ul class="sub-menu">
                	<li>
                        <a href="${pageContext.request.contextPath }/news/write" target="_blank">
                            	写文章</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/admin/newslist.jsp">
                            	文章管理</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/admin/picturenews.jsp">
                            	图片新闻</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/admin/lifechat.jsp">
                            	生活大家谈</a>
                    </li>
                </ul>
            </li>
            <li class="">
                <a href="${pageContext.request.contextPath }/home/edit/1" target="_blank">
                    <i class="icon-flag"></i>
                    <span class="title">规章制度</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li class="">
                <a href="${pageContext.request.contextPath }/home/edit/2" target="_blank">
                    <i class="icon-certificate"></i>
                    <span class="title">工作标准</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li class="">
                <a href="${pageContext.request.contextPath }/home/edit/3" target="_blank">
                    <i class="icon-user"></i>
                    <span class="title">通讯录</span>
                    <span class="selected"></span>
                </a>
            </li>
            <li class="">
                <a href="${pageContext.request.contextPath }/home/edit/4" target="_blank">
                    <i class="icon-th-large"></i>
                    <span class="title">风采录</span>
                    <span class="selected"></span>
                </a>
            </li>
        </ul>
        <!-- END SIDEBAR MENU -->
    </div>
    <!-- END SIDEBAR -->

    <!-- BEGIN PAGE -->
    <div class="page-content">
        <!-- BEGIN PAGE CONTAINER-->
        <div class="container-fluid">
            <!-- BEGIN PAGE HEADER-->
            <div class="row-fluid">
                <div class="span12">
                    <!-- BEGIN STYLE CUSTOMIZER -->
                    <div class="color-panel hidden-phone hide">
                        <div class="color-mode-icons icon-color"></div>
                        <div class="color-mode-icons icon-color-close"></div>
                        <div class="color-mode">
                            <p>主题颜色</p>
                            <ul class="inline">
                                <li class="color-black current color-default" data-style="default"></li>
                                <li class="color-blue" data-style="blue"></li>
                                <li class="color-brown" data-style="brown"></li>
                                <li class="color-purple" data-style="purple"></li>
                                <li class="color-grey" data-style="grey"></li>
                                <li class="color-white color-light" data-style="light"></li>
                            </ul>
                            <label>
                                <span>Layout</span>
                                <select class="layout-option m-wrap small">
                                    <option value="fluid" selected>Fluid</option>
                                    <option value="boxed">Boxed</option>
                                </select>
                            </label>
                            <label>
                                <span>Header</span>
                                <select class="header-option m-wrap small">
                                    <option value="fixed" selected>Fixed</option>
                                    <option value="default">Default</option>
                                </select>
                            </label>
                            <label>
                                <span>Sidebar</span>
                                <select class="sidebar-option m-wrap small">
                                    <option value="fixed">Fixed</option>
                                    <option value="default" selected>Default</option>
                                </select>
                            </label>
                            <label>
                                <span>Footer</span>
                                <select class="footer-option m-wrap small">
                                    <option value="fixed">Fixed</option>
                                    <option value="default" selected>Default</option>
                                </select>
                            </label>
                        </div>
                    </div>
                    <!-- END BEGIN STYLE CUSTOMIZER -->
                    <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                    <h3 class="page-title">
                                 	首页示意图
                        <small></small>
                    </h3>
                    <ul class="breadcrumb">
                        <li>
                            <i class="icon-home"></i>
                            <a href="${pageContext.request.contextPath }/admin/index.jsp">首页</a>
                            <i class="icon-angle-right"></i>
                        </li>
                        <li><a href="${pageContext.request.contextPath }/admin/index.jsp">示意图</a></li>
                    </ul>
                    <!-- END PAGE TITLE & BREADCRUMB-->
                </div>
            </div>
            <!-- END PAGE HEADER-->

            <div id="dashboard">
            	<img src="${pageContext.request.contextPath }/admin/media/image/example.jpg"/>
            </div>
        </div>
        <!-- END PAGE CONTAINER-->
    </div>
    <!-- END PAGE -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="footer">
    <div class="footer-inner">
        Powered by 北京信雅致达信息科技有限公司
    </div>
    <div class="footer-tools">
			<span class="go-top">
			<i class="icon-angle-up"></i>
			</span>
    </div>
</div>

<!-- END FOOTER -->

<!-- BEGIN CORE PLUGINS -->

<script src="${pageContext.request.contextPath }/admin/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath }/admin/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

<script src="${pageContext.request.contextPath }/admin/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath }/admin/media/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/admin/media/js/bootstrap-table.min.js"></script>
<!--[if lt IE 9]>

<script src="media/js/excanvas.min.js"></script>

<script src="media/js/respond.min.js"></script>

<![endif]-->

<script src="${pageContext.request.contextPath }/admin/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath }/admin/media/js/jquery.blockui.min.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath }/admin/media/js/jquery.cookie.min.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath }/admin/media/js/jquery.uniform.min.js" type="text/javascript"></script>

<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->

<script src="${pageContext.request.contextPath }/admin/media/src/app.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath }/admin/media/src/index.js" type="text/javascript"></script>

<!-- END PAGE LEVEL SCRIPTS -->

<script>

  jQuery(document).ready(function () {

    App.init();

    Index.init();

    Index.initTable(); // 初始化table
  });

</script>

<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>