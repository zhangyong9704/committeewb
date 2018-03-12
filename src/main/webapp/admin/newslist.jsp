<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html><html><head>    <meta charset="utf-8"/>    <title>新闻站后台管理</title>    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>    <meta content="" name="description"/>    <meta content="" name="author"/>    <link href="${pageContext.request.contextPath }/admin/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>    <link href="${pageContext.request.contextPath }/admin/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>    <link href="${pageContext.request.contextPath }/admin/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>    <link href="${pageContext.request.contextPath }/admin/media/css/style.css" rel="stylesheet" type="text/css"/>    <link href="${pageContext.request.contextPath }/admin/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>    <link href="${pageContext.request.contextPath }/admin/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/media/css/websetting.css?v=1.1"/>    <!-- bootstrap-table -->    <link href="${pageContext.request.contextPath }/admin/media/css/bootstrap-table.min.css" rel="stylesheet" type="text/css" />
</head><body class="page-header-fixed page-sidebar-fixed">	<%		Object user = request.getSession().getAttribute("user");		if(user == null){			response.sendRedirect("/committeewb/admin/login.jsp");		}	 %><div class="header navbar navbar-inverse navbar-fixed-top">    <!-- BEGIN TOP NAVIGATION BAR -->    <div class="navbar-inner">        <div class="container-fluid">            <a class="brand" href="${pageContext.request.contextPath }/admin/index.jsp">                <div style="margin-left: 20px;">蜀南气矿团委</div>            </a>            <!-- BEGIN RESPONSIVE MENU TOGGLER -->            <a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">                <img src="${pageContext.request.contextPath }/admin/media/image/menu-toggler.png" alt=""/>            </a>            <!-- END RESPONSIVE MENU TOGGLER -->            <!-- BEGIN TOP NAVIGATION MENU -->            <ul class="nav pull-right">                <!-- BEGIN USER LOGIN DROPDOWN -->                <li class="dropdown user">                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">                        <img alt="" src="${pageContext.request.contextPath }/admin/media/image/avatar.png" style="width: 29px;"/>                        <span class="username">管理员</span>                        <i class="icon-angle-down"></i>                    </a>                    <ul class="dropdown-menu">                        <li><a href="${pageContext.request.contextPath }/logout"><i class="icon-key"></i> 登出</a></li>                    </ul>                </li>                <!-- END USER LOGIN DROPDOWN -->            </ul>            <!-- END TOP NAVIGATION MENU -->        </div>    </div>    <!-- END TOP NAVIGATION BAR --></div><!-- BEGIN CONTAINER --><div class="page-container">    <!-- BEGIN SIDEBAR -->    <div class="page-sidebar nav-collapse collapse">        <!-- BEGIN SIDEBAR MENU -->       	<ul class="page-sidebar-menu">            <li>                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->                <div class="sidebar-toggler hidden-phone"></div>                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->            </li>            <br/>            <li class="start">                <a href="${pageContext.request.contextPath }/admin/index.jsp">                    <i class="icon-home"></i>                    <span class="title">首页</span>                    <span class="selected"></span>                </a>            </li>            <li class="">                <a href="${pageContext.request.contextPath }/admin/websetting.jsp">                    <i class="icon-cogs"></i>                    <span class="title">网站基础信息</span>                    <span class="selected"></span>                </a>            </li>            <li class="active">                <a href="javascript:;">                    <i class="icon-bookmark-empty"></i>                    <span class="title">新闻管理</span>                    <span class="arrow open"></span>                </a>                <ul class="sub-menu">                	<li>                        <a href="${pageContext.request.contextPath }/news/write" target="_blank">                            	写文章</a>                    </li>                    <li class="active">                        <a href="${pageContext.request.contextPath }/admin/newslist.jsp">                            	文章管理</a>                    </li>                    <li>                        <a href="${pageContext.request.contextPath }/admin/picturenews.jsp">                            	图片新闻</a>                    </li>                    <li>                        <a href="${pageContext.request.contextPath }/admin/tagnews.jsp">                            	标签新闻</a>                    </li>                    <li>                        <a href="${pageContext.request.contextPath }/admin/lifechat.jsp">                            	生活大家谈</a>                    </li>                </ul>            </li>            <li class="">                <a href="${pageContext.request.contextPath }/home/edit/1" target="_blank">                    <i class="icon-flag"></i>                    <span class="title">规章制度</span>                    <span class="selected"></span>                </a>            </li>            <li class="">                <a href="${pageContext.request.contextPath }/home/edit/2" target="_blank">                    <i class="icon-certificate"></i>                    <span class="title">工作标准</span>                    <span class="selected"></span>                </a>            </li>            <li class="">                <a href="${pageContext.request.contextPath }/home/edit/3" target="_blank">                    <i class="icon-user"></i>                    <span class="title">通讯录</span>                    <span class="selected"></span>                </a>            </li>            <li class="">                <a href="${pageContext.request.contextPath }/home/edit/4" target="_blank">                    <i class="icon-th-large"></i>                    <span class="title">风采录</span>                    <span class="selected"></span>                </a>            </li>        </ul>        <!-- END SIDEBAR MENU -->    </div>    <!-- END SIDEBAR -->    <!-- BEGIN PAGE -->    <div class="page-content">        <!-- BEGIN PAGE CONTAINER-->        <div class="container-fluid">            <!-- BEGIN PAGE HEADER-->            <div class="row-fluid">                <div class="span12">                    <!-- BEGIN STYLE CUSTOMIZER -->                    <div class="color-panel hidden-phone hide">                        <div class="color-mode-icons icon-color"></div>                        <div class="color-mode-icons icon-color-close"></div>                        <div class="color-mode">                            <p>主题颜色</p>                            <ul class="inline">                                <li class="color-black current color-default" data-style="default"></li>                                <li class="color-blue" data-style="blue"></li>                                <li class="color-brown" data-style="brown"></li>                                <li class="color-purple" data-style="purple"></li>                                <li class="color-grey" data-style="grey"></li>                                <li class="color-white color-light" data-style="light"></li>                            </ul>                            <label>                                <span>Layout</span>                                <select class="layout-option m-wrap small">                                    <option value="fluid" selected>Fluid</option>                                    <option value="boxed">Boxed</option>                                </select>                            </label>                            <label>                                <span>Header</span>                                <select class="header-option m-wrap small">                                    <option value="fixed" selected>Fixed</option>                                    <option value="default">Default</option>                                </select>                            </label>                            <label>                                <span>Sidebar</span>                                <select class="sidebar-option m-wrap small">                                    <option value="fixed">Fixed</option>                                    <option value="default" selected>Default</option>                                </select>                            </label>                            <label>                                <span>Footer</span>                                <select class="footer-option m-wrap small">                                    <option value="fixed">Fixed</option>                                    <option value="default" selected>Default</option>                                </select>                            </label>                        </div>                    </div>                    <!-- END BEGIN STYLE CUSTOMIZER -->                    <!-- BEGIN PAGE TITLE & BREADCRUMB-->                    <h3 class="page-title">                                 	新闻管理                        <small></small>                    </h3>                    <ul class="breadcrumb">                        <li>                            <i class="icon-home"></i>                            <a href="#">新闻管理</a>                            <i class="icon-angle-right"></i>                        </li>                        <li><a href="${pageContext.request.contextPath }/admin/newslist.jsp">文章管理</a></li>                    </ul>                    <!-- END PAGE TITLE & BREADCRUMB-->                </div>            </div>            <!-- END PAGE HEADER-->            <div id="dashboard">            		<div class="mydatachoice-wrapper">
            			<span class="title">数据选项:</span>        				<label class="radio inline">					  <input type="radio" name="optionsRadios" id="optionsRadios1" value="0" checked>					  所有数据					</label>					<label class="radio inline">					  <input type="radio" name="optionsRadios" id="optionsRadios2" value="1">					  已发布					</label>					<label class="radio inline">					  <input type="radio" name="optionsRadios" id="optionsRadios3" value="2">					  定时发布					</label>					<label class="radio inline">					  <input type="radio" name="optionsRadios" id="optionsRadios4" value="3">					  草稿					</label>
            		</div>            		            		<div class="mydatachoice-wrapper my_checkbox">            			<!--<span class="title">文章类型:</span>        				<label class="checkbox inline">						  <input type="checkbox" name="optionCheckboxs" id="inlineCheckbox1" value="1" checked>						    重点专注						</label>						<label class="checkbox inline">						  <input type="checkbox" name="optionCheckboxs" id="inlineCheckbox2" value="2">						  公告						</label>						<label class="checkbox inline">						  <input type="checkbox" name="optionCheckboxs" id="inlineCheckbox3" value="3">						  文件通知						</label>						<label class="checkbox inline">						  <input type="checkbox" name="optionCheckboxs" id="inlineCheckbox4" value="4">						  团青快讯						</label>						<label class="checkbox inline">						  <input type="checkbox" name="optionCheckboxs" id="inlineCheckbox5" value="5">						  蜀南青语						</label>						<label class="checkbox inline">						  <input type="checkbox" name="optionCheckboxs" id="inlineCheckbox6" value="6">						 专题活动						</label>-->            		</div>            </div>            <div id="toolbar">		        <button id="remove" class="btn btn-danger" disabled>		             	删除		        </button>		    </div>            <table id="newslisttable"></table>        </div>        <!-- END PAGE CONTAINER-->    </div>    <!-- END PAGE --></div><!-- END CONTAINER --><!-- BEGIN FOOTER --><div class="footer">    <div class="footer-inner">        Powered by 北京信雅致达信息科技有限公司    </div>    <div class="footer-tools">			<span class="go-top">			<i class="icon-angle-up"></i>			</span>    </div></div><!-- END FOOTER --><!-- BEGIN CORE PLUGINS --><script src="${pageContext.request.contextPath }/admin/media/js/jquery-1.10.1.min.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script><!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip --><script src="${pageContext.request.contextPath }/admin/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/js/bootstrap.min.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/js/bootstrap-table.min.js"></script><script src="${pageContext.request.contextPath }/admin/media/js/bootstrap-table-zh-CN.min.js"></script>
<!--[if lt IE 9]><script src="media/js/excanvas.min.js"></script><script src="media/js/respond.min.js"></script><![endif]--><script src="${pageContext.request.contextPath }/admin/media/js/jquery.slimscroll.min.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/js/jquery.blockui.min.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/js/jquery.cookie.min.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/js/lodash.min.js"></script><!--<script src="media/js/jquery.uniform.min.js" type="text/javascript"></script>--><!-- END CORE PLUGINS --><!-- BEGIN PAGE LEVEL SCRIPTS --><script src="${pageContext.request.contextPath }/admin/media/src/app.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/src/commonUtils.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/src/newslist.js?v=1.1" type="text/javascript"></script><!-- END PAGE LEVEL SCRIPTS --><script>  jQuery(document).ready(function () {    App.init();	NewsList.init();
  });</script><!-- END JAVASCRIPTS --></body><!-- END BODY --></html>