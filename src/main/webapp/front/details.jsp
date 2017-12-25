<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>蜀南气矿团委</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/front/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/front/css/head1.css" rel="stylesheet">
    <!--<link href="css/index1.css" rel="stylesheet">-->
    <link href="${pageContext.request.contextPath }/front/css/details1.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<c:if test="${news == null}">
		<%
			response.sendRedirect("/committeewb/news/newsList?newsTypeID=0");
		 %>
	</c:if>
<div class="container-fluid">
    <!--head部分-->
    <div class="row head">
        <!--<div class="col-md-12 col-sm-12 col-xs-12 " style="background:url(img/head11.jpg) no-repeat center 60%;background-size: cover;height: 300px;">-->
        <div class="col-md-12 col-sm-12 col-xs-12">
            <img src="${pageContext.request.contextPath }/front/img/head.jpg"><!--1920*345-->
        <div id="stars_box"></div>
        </div>
    </div><!--head部分-->
    <!--主体部分 -->
    <div class="row main" style="background:url(${pageContext.request.contextPath }/front/img/main1.jpg) no-repeat;background-size:100%">    <!--1920*1245-->
        <!--导航部分-->
         <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="row" style="position: relative;top:-5px;z-index: 100">
                <div class="col-md-12 col-sm-12 col-xs-12 nav"><!--1920*73-->
                    <img src="${pageContext.request.contextPath }/front/img/navbg.png" style="width: 100%">
                    <div>
                    <ul>
                        <c:forEach items="${navList }" var="nav">
					    	<li><a href="${pageContext.request.contextPath }/${nav.jumpLink }">${nav.name }</a></li>
					   	</c:forEach>
					   	<li><a href="#">${date }</a></li>
                        <li><a href="#">${day }</a></li>
                        <li><a href="#">天气晴</a></li>
                    </ul>
                    </div>
                </div>
            </div>
        </div> <!--导航部分-->
        <!--　主体内容部分-->
        <div class="row mbody" style="position: relative;top:-5px;z-index: 0">
            <div class="col-md-8 col-md-offset-2">
                <!--主要内容 -->
                <div class="col-md-12 concent">
                    <div class="actirl">
                        <div class="title">
                            <h2>${news.title }</h2>
                            <p>
                            	发稿时间：<fmt:formatDate value="${news.showTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </p>
                        </div>
                    <!--左侧列表-->
                    <div class="left">
                        ${news.content }
                    </div> <!--左侧列表-->
                    <!--右侧内容-->
                    <div class="right">
                        <div class="r1">
                            <ul>
                                <li><a href="#"><h3>蜀南石油近期热门</h3></a></li>
                                <li><a href="#"><p>蜀南石油近期热门</p></a></li>
                                <li><a href="#"><span>蜀南石油近期热门</span></a></li>
                                <li><a href="#"><h3>蜀南石油近期热门</h3></a></li>
                                <li><a href="#"><p>蜀南石油近期热门</p></a></li>
                                <li><a href="#"><span>蜀南石油近期热门</span></a></li>
                            </ul>
                        </div>
                        <div class="r2">
                            <span><a href="#"> 更多>>></a></span>
                        </div>
                    </div> <!--右侧内容-->
                    </div>
                </div> <!--主要内容 -->
                    <!--分页-->
                    <div class="fenye">
                    	<c:if test="${firstNews.id != news.id }">
                    		<a href="${pageContext.request.contextPath }/news/${newsTypeID }/${firstNews.id }/query">首篇&nbsp;|&nbsp;</a>
                    	</c:if>
                        <c:if test="${previousNews != null}">
                        	<a href="${pageContext.request.contextPath }/news/${newsTypeID }/${previousNews.id }/query">上一篇&nbsp;</a>
                        </c:if>
                        <c:if test="${nextNews != null}">
                        	<a href="${pageContext.request.contextPath }/news/${newsTypeID }/${nextNews.id }/query">下一篇</a>
                        </c:if>
                        <c:if test="${lastNews.id != news.id }">
                        	<a href="${pageContext.request.contextPath }/news/${newsTypeID }/${lastNews.id }/query">&nbsp;|&nbsp;尾篇</a>
                        </c:if>
                    </div><!--分页-->
            </div>
        </div><!--　主体内容部分-->
    </div><!--主体部分 -->
</div><!--container-fluid结束-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath }/front/js/jquery-3.2.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath }/front/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/front/js/index.js"></script>
<script src="${pageContext.request.contextPath }/front/js/nav.js"></script>
</body>
</body>
</html>