<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html><html><head>    <meta charset="utf-8"/>    <title>新闻站后台管理</title>    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>    <meta content="" name="description"/>    <meta content="" name="author"/>    <link href="${pageContext.request.contextPath }/admin/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>    <link href="${pageContext.request.contextPath }/admin/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>    <link href="${pageContext.request.contextPath }/admin/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>    <link href="${pageContext.request.contextPath }/admin/media/css/style.css" rel="stylesheet" type="text/css"/>    <link href="${pageContext.request.contextPath }/admin/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>    <link href="${pageContext.request.contextPath }/admin/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/media/css/websetting.css"/>    <!-- bootstrap-table -->    <link href="${pageContext.request.contextPath }/admin/media/css/bootstrap-table.min.css" rel="stylesheet" type="text/css" />    <link href="${pageContext.request.contextPath }/admin/media/css/bootstrap-editable.css" rel="stylesheet" type="text/css" />
</head><body class="page-header-fixed page-sidebar-fixed"><div class="header navbar navbar-inverse navbar-fixed-top">	    <!-- BEGIN TOP NAVIGATION BAR -->    <div class="navbar-inner">        <div class="container-fluid">            <a class="brand" href="${pageContext.request.contextPath }/admin/index.jsp">                 <div style="margin-left: 20px;">蜀南</div>            </a>            <!-- BEGIN RESPONSIVE MENU TOGGLER -->            <a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">                <img src="${pageContext.request.contextPath }/admin/media/image/menu-toggler.png" alt=""/>            </a>            <!-- END RESPONSIVE MENU TOGGLER -->            <!-- BEGIN TOP NAVIGATION MENU -->            <ul class="nav pull-right">                <!-- BEGIN USER LOGIN DROPDOWN -->                <li class="dropdown user">                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">                        <img alt="" src="${pageContext.request.contextPath }/admin/media/image/avatar.png" style="width: 29px;"/>                        <span class="username">管理员</span>                        <i class="icon-angle-down"></i>                    </a>                    <ul class="dropdown-menu">                        <li><a href="${pageContext.request.contextPath }/logout"><i class="icon-key"></i> 登出</a></li>                    </ul>                </li>                <!-- END USER LOGIN DROPDOWN -->            </ul>            <!-- END TOP NAVIGATION MENU -->        </div>    </div>    <!-- END TOP NAVIGATION BAR --></div><!-- BEGIN CONTAINER --><div class="page-container">    <!-- BEGIN SIDEBAR -->    <div class="page-sidebar nav-collapse collapse">        <!-- BEGIN SIDEBAR MENU -->        <ul class="page-sidebar-menu">            <li>                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->                <div class="sidebar-toggler hidden-phone"></div>                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->            </li>            <br/>            <li class="start">                <a href="${pageContext.request.contextPath }/admin/index.jsp">                    <i class="icon-home"></i>                    <span class="title">首页</span>                    <span class="selected"></span>                </a>            </li>            <li class="active">                <a href="${pageContext.request.contextPath }/admin/websetting.jsp">                    <i class="icon-cogs"></i>                    <span class="title">网站基础信息</span>                    <span class="selected"></span>                </a>            </li>            <li class="">                <a href="javascript:;">                    <i class="icon-bookmark-empty"></i>                    <span class="title">新闻管理</span>                    <span class="arrow"></span>                </a>                <ul class="sub-menu">                	<li>                        <a href="${pageContext.request.contextPath }/news/write" target="_blank">                            	写文章</a>                    </li>                    <li>                        <a href="${pageContext.request.contextPath }/admin/newslist.jsp">                            	文章管理</a>                    </li>                    <li>                        <a href="${pageContext.request.contextPath }/admin/picturenews.jsp">                            	图片新闻</a>                    </li>                    <li>                        <a href="${pageContext.request.contextPath }/admin/lifechat.jsp">                            	生活大家谈</a>                    </li>                </ul>            </li>            <li class="">                <a href="${pageContext.request.contextPath }/home/edit/1" target="_blank">                    <i class="icon-flag"></i>                    <span class="title">规章制度</span>                    <span class="selected"></span>                </a>            </li>            <li class="">                <a href="${pageContext.request.contextPath }/home/edit/2" target="_blank">                    <i class="icon-certificate"></i>                    <span class="title">工作标准</span>                    <span class="selected"></span>                </a>            </li>            <li class="">                <a href="${pageContext.request.contextPath }/home/edit/3" target="_blank">                    <i class="icon-user"></i>                    <span class="title">通讯录</span>                    <span class="selected"></span>                </a>            </li>            <li class="">                <a href="${pageContext.request.contextPath }/home/edit/4" target="_blank">                    <i class="icon-th-large"></i>                    <span class="title">风采录</span>                    <span class="selected"></span>                </a>            </li>        </ul>        <!-- END SIDEBAR MENU -->    </div>    <!-- END SIDEBAR -->    <!-- BEGIN PAGE -->    <div class="page-content">        <!-- BEGIN PAGE CONTAINER-->        <div class="container-fluid">            <!-- BEGIN PAGE HEADER-->            <div class="row-fluid">                <div class="span12">                    <!-- BEGIN STYLE CUSTOMIZER -->                    <div class="color-panel hidden-phone hide">                        <div class="color-mode-icons icon-color"></div>                        <div class="color-mode-icons icon-color-close"></div>                        <div class="color-mode">                            <p>主题颜色</p>                            <ul class="inline">                                <li class="color-black current color-default" data-style="default"></li>                                <li class="color-blue" data-style="blue"></li>                                <li class="color-brown" data-style="brown"></li>                                <li class="color-purple" data-style="purple"></li>                                <li class="color-grey" data-style="grey"></li>                                <li class="color-white color-light" data-style="light"></li>                            </ul>                            <label>                                <span>Layout</span>                                <select class="layout-option m-wrap small">                                    <option value="fluid" selected>Fluid</option>                                    <option value="boxed">Boxed</option>                                </select>                            </label>                            <label>                                <span>Header</span>                                <select class="header-option m-wrap small">                                    <option value="fixed" selected>Fixed</option>                                    <option value="default">Default</option>                                </select>                            </label>                            <label>                                <span>Sidebar</span>                                <select class="sidebar-option m-wrap small">                                    <option value="fixed">Fixed</option>                                    <option value="default" selected>Default</option>                                </select>                            </label>                            <label>                                <span>Footer</span>                                <select class="footer-option m-wrap small">                                    <option value="fixed">Fixed</option>                                    <option value="default" selected>Default</option>                                </select>                            </label>                        </div>                    </div>                    <!-- END BEGIN STYLE CUSTOMIZER -->					<div class="alert alert-block myalert hide">					 <!-- <button type="button" class="close" data-dismiss="alert"></button>-->					  <span class="alertMsg"></span>					</div>                    <!-- BEGIN PAGE TITLE & BREADCRUMB-->                    <h3 class="page-title">                                 	网站基础信息                        <small>分类</small>                    </h3>                    <ul class="breadcrumb">                        <li>                            <i class="icon-home"></i>                            <a href="${pageContext.request.contextPath }/admin/index.jsp">首页</a>                            <i class="icon-angle-right"></i>                        </li>                        <li><a href="${pageContext.request.contextPath }/admin/websetting.jsp">网站基础信息</a></li>                    </ul>                    <!-- END PAGE TITLE & BREADCRUMB-->                </div>            </div>            <!-- END PAGE HEADER-->            <!-- BEGIN PAGE CONTENT-->			<div class="row-fluid profile">				<div class="span12">					<!--BEGIN TABS-->					<div class="tabbable tabbable-custom tabbable-full-width">						<ul class="nav nav-tabs">							<li class="active"><a href="#tab_1_1" data-toggle="tab">网站设置</a></li>							<li><a href="#tab_1_2" data-toggle="tab">导航栏</a></li>							<li><a href="#tab_1_3" data-toggle="tab">banner图</a></li>							<li><a href="#tab_1_4" data-toggle="tab">友情链接</a></li>							<li style="display: none;"><a href="#tab_1_5" data-toggle="tab">Help</a></li>						</ul>						<div class="tab-content">							<!--tab_1_1-->							<div class="active tab-pane row-fluid" id="tab_1_1">								<!--<span class="label label-important">网站logo等信息</span>-->								<table id="baseinfotable"></table><br />								<div id="dashboard">									<form class="horizontal-form" id="mybaseForm" enctype='multipart/form-data'>										<input name="id" type="hidden" />										<div class="row-fluid">						                    <div class="span4 responsive" data-tablet="span6" data-desktop="span4">						                        <div class="dashboard-stat blue">						                            <h4 style="color: white;">&nbsp;&nbsp; logo图标<small style="color: black;">&nbsp;&nbsp;  像素要求123*123; 大小要求&lt;5M</small></h4>						                            <div class="more">						                                <input name="logoFile" style="width: 100%;" type="file" accept="image/jpeg,image/png,image/gif" />						                            </div>						                        </div>						                    </div>						                    <div class="span4 responsive" data-tablet="span6" data-desktop="span4">						                        <div class="dashboard-stat green">						                            <h4 style="color: white;">&nbsp;&nbsp; 标题图标<small style="color: black;">&nbsp;&nbsp;  像素要求123*123; 大小要求&lt;5M</small></h4>						                            <div class="more">						                                <input name="titleFile" style="width: 100%;" type="file" accept="image/jpeg,image/png,image/gif" />						                            </div>						                        </div>						                    </div>						                    <div class="span4 responsive" data-tablet="span6  fix-offset" data-desktop="span4">						                        <div class="dashboard-stat purple">						                            <h4 style="color: white;">&nbsp;&nbsp; 背景图片<small style="color: black;">&nbsp;&nbsp;  像素要求123*123; 大小要求&lt;5M</small></h4>						                            <div class="more">						                                <input name="backgroundFile" style="width: 100%;" type="file" accept="image/jpeg,image/png,image/gif" />						                            </div>						                        </div>						                    </div>						                </div>						                						                <div class="row-fluid">											<div class="span6">												<div class="control-group">													<label class="control-label" for="firstName">字段1</label>													<div class="controls">														<input name="field1" type="text" id="firstName" class="m-wrap span12" placeholder="字段1">													</div>												</div>											</div>											<div class="span6">												<div class="control-group">													<label class="control-label" for="lastName">字段2</label>													<div class="controls">														<input name="field2" type="text" id="lastName" class="m-wrap span12" placeholder="字段2">													</div>												</div>											</div>										</div>										<div class="row-fluid">											<div class="span6">												<div class="control-group">													<label class="control-label" for="firstName">字段3</label>													<div class="controls">														<input name="field3" type="text" id="firstName" class="m-wrap span12" placeholder="字段3">													</div>												</div>											</div>											<div class="span6">												<div class="control-group">													<label class="control-label" for="lastName">字段4</label>													<div class="controls">														<input name="field4" type="text" id="lastName" class="m-wrap span12" placeholder="字段4">													</div>												</div>											</div>										</div>										<div class="row-fluid">											<div class="span6">												<div class="control-group">													<label class="control-label" for="firstName">字段5</label>													<div class="controls">														<input name="field5" type="text" id="firstName" class="m-wrap span12" placeholder="字段5">													</div>												</div>											</div>											<div class="span6">												<div class="control-group">													<label class="control-label" for="firstName">&nbsp;</label>													<div class="controls">														<button id="modifybaseInfo" class="btn btn-danger" type="button">修改</button>													</div>												</div>											</div>										</div>									</form>								</div>							</div>							<!--end tab_1_1-->														<!--tab_1_2-->							<div class="tab-pane profile-classic row-fluid" id="tab_1_2">								<!--<span class="label label-important">网站导航栏信息</span>-->								<table id="navinfotable"></table><br />								<div id="toolbar">									<form class="form-inline">									  <button id="addNav" type="button" class="btn btn-success">添加</button>									  <span class="addNavInput hide" style="margin-left: 10px; border-left: 1px solid gray;">									  	名称:<input type="text" class="navName input-small" placeholder="名称">									  	链接:<input type="text" class="navLink input-small" placeholder="链接">									  	位置:<input type="number" class="navPos input-small" placeholder="位置">									  	<button id="resetAddNav" type="button" class="btn btn-primary btn-mini hide">取消</button>									  	<button id="saveAddNav" type="button" class="btn btn-success btn-mini">保存</button>									  </span>									  									</form>								</div>																			</div>							<!--end tab_1_2-->														<!--tab_1_3-->							<div class="tab-pane row-fluid profile-account" id="tab_1_3">								<table id="bannertable"></table><br />								<div id="dashboard">									<form class="horizontal-form" id="mybannerForm" enctype='multipart/form-data'>										<input id="bannerid" name="id" type="hidden" />										<input id="bannername" name="name" type="hidden" />										<input id="bannerlink" name="jumpLink" type="hidden" />										<input name="type" value="0" type="hidden" />										<div class="row-fluid">						                    <div class="span4 responsive" data-tablet="span6" data-desktop="span4">						                        <div class="dashboard-stat blue">						                            <h4 style="color: white;">&nbsp;&nbsp; banner图<small style="color: black;">&nbsp;&nbsp;  像素要求123*123; 大小要求&lt;5M</small></h4>						                            <div class="more">						                                <input name="picFile" style="width: 100%;" type="file" accept="image/jpeg,image/png,image/gif" />						                            </div>						                        </div>						                    </div>						           			
						               </div>						               <button id="bannerModify" class="btn btn-danger" type="button">修改banner图</button>						           </form>						       </div>							</div>							<!--end tab_1_3-->							<!--tab_1_4-->							<div class="tab-pane" id="tab_1_4">								<table id="friendLinktable"></table><br />								<div id="toolbar_friendLink">									<form id="friendLinkForm" class="form-inline">									  <button id="addFriendLink" type="button" class="btn btn-success">添加</button>									  <span class="addFriendLinkInput hide" style="margin-left: 10px; border-left: 1px solid gray;">									  	名称:<input name="name" type="text" class="friendLinkName input-small" placeholder="名称">									  	链接:<input name="jumpLink" type="text" class="friendLinkUrl input-small" placeholder="链接">									  	图片:<input name="picFile" type="file" style="width: 180px;" class="friendLinkPic input-small" placeholder="图片">									  	<button id="resetAddFriendLink" type="button" class="btn btn-primary btn-mini hide">取消</button>									  	<button id="saveAddFriendLink" type="button" class="btn btn-success btn-mini">保存</button>									  </span>									</form>								</div>							</div>							<!--end tab_1_4-->							<!--tab_1_5-->							<div class="tab-pane row-fluid" id="tab_1_5">								<h1>标签5</h1>							</div>							<!--end tab_1_5-->						</div>					</div>					<!--END TABS-->				</div>			</div>			<!-- END PAGE CONTENT-->    </div>    <!-- END PAGE --></div><!-- END CONTAINER --><!-- BEGIN FOOTER --><div class="footer">    <div class="footer-inner">        2017 &copy; 翡翠集团.    </div>    <div class="footer-tools">			<span class="go-top">			<i class="icon-angle-up"></i>			</span>    </div></div><!-- END FOOTER --><!-- BEGIN CORE PLUGINS --><script src="${pageContext.request.contextPath }/admin/media/js/jquery-1.10.1.min.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/js/jquery.form.min.js"></script><script src="${pageContext.request.contextPath }/admin/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script><!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip --><script src="${pageContext.request.contextPath }/admin/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/js/bootstrap.min.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/js/bootstrap-table.min.js"></script><script src="${pageContext.request.contextPath }/admin/media/js/bootstrap-table-zh-CN.min.js"></script><!--[if lt IE 9]><script src="media/js/excanvas.min.js"></script><script src="media/js/respond.min.js"></script><![endif]--><script src="${pageContext.request.contextPath }/admin/media/js/jquery.slimscroll.min.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/js/jquery.blockui.min.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/js/jquery.cookie.min.js" type="text/javascript"></script><!--<script src="media/js/jquery.uniform.min.js" type="text/javascript"></script>--><!-- END CORE PLUGINS --><!-- BEGIN PAGE LEVEL SCRIPTS --><script src="${pageContext.request.contextPath }/admin/media/src/app.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/admin/media/src/commonUtils.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/src/websetting.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/js/bootstrap-editable.min.js" type="text/javascript"></script><script src="${pageContext.request.contextPath }/admin/media/js/bootstrap-table-editable.js" type="text/javascript"></script><!-- END PAGE LEVEL SCRIPTS --><script>  jQuery(document).ready(function () {    App.init();    WebSetting.init();    WebSetting.initTable(); // 初始化table    WebSetting.initPostAjax();  });</script><!-- END JAVASCRIPTS --></body><!-- END BODY --></html>