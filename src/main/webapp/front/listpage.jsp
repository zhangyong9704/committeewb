<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
    <link href="${pageContext.request.contextPath }/front/css/listpage1.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/front/css/iconfont.css" rel="stylesheet">
      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<c:if test="${newsList == null }">
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
					    	<li>
					    		<c:if test="${nav.id!=6 }">
					    			<a href="${pageContext.request.contextPath }/${nav.jumpLink }">${nav.name }</a>
					    		</c:if>
					    		<c:if test="${nav.id==6 }">
					    			<c:if test="${nav.jumpLink==null ||  nav.jumpLink==''}">
					    				${nav.name }
					    			</c:if>
					    			<c:if test="${nav.jumpLink!=null &&  nav.jumpLink!=''}">
					    				<a href="${nav.jumpLink }">${nav.name }</a>
					    			</c:if>
					    		</c:if>
					    	</li>
					   	</c:forEach>
    <li class='date1'>${date }&nbsp;&nbsp;${day}</li><li class='weather' id="weather">
    <iframe id='ww'allowtransparency="true" frameborder="0" width="180" height="36" scrolling="no" src="//tianqi.2345.com/plugin/widget/index.htm?s=3&z=2&t=0&v=0&d=3&bd=0&k=000000&f=ffffff&ltf=ffffff&htf=ffffff&q=1&e=1&a=0&c=57602&w=180&h=36&align=center"></iframe>
    </li>
                    </ul>
                    </div>
                </div>
            </div>
        </div>  <!--导航部分-->
        <!--　主体内容部分-->
        <div class="row mbody" style="position: relative;top:-5px;z-index: 0">
            <div class="col-md-8 col-md-offset-2">
                <!--banner-->
                <div class="row banner">
                    <div class="col-md-12 ">
                        <c:forEach items="${bannerList }" var="banner">
                        	<img src="${pageContext.request.contextPath }/upload/${banner.picUrl}"/>
				    	</c:forEach>
                    </div>  <!--　1201*289-->
                </div> <!--banner-->
                <div class="breadnav">
                    <span>您的位置：<a href="#">首页</a><span class="iconfont icon-icon-copy"></span><span>${newsTypeName }</span></span>
                </div>
               <!--主要内容 -->
                <div class="col-md-12 concent">
                    <!--左侧列表-->
                  <div class="left">
                      <img src="${pageContext.request.contextPath }/front/img/leftbg.png">   <!--285*404-->
                      <ul>
                          <c:forEach items="${newsTypeList }" var="newsType">
	                          <c:if test="${newsType.id == newsTypeID }">
	                      	  	<li style="background: url(${pageContext.request.contextPath }/front/img/itemsd.png) no-repeat;">
	                      	  		<a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=${newsType.id }&currentPage=1">${newsType.name }</a>
	                      	  	</li>
	                      	  </c:if>
	                      	  <c:if test="${newsType.id != newsTypeID }">
	                      	  	<li>
	                      	  		<a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=${newsType.id }&currentPage=1">${newsType.name }</a>
	                      	  	</li>
	                      	  </c:if>
                          </c:forEach>
                      </ul>
                  </div> <!--左侧列表-->
                    <!--右侧内容-->
                  <div class="right">
                      <ul>
                      <c:forEach items="${newsList }" var="news">
                      	<li>
                      		<a href="${pageContext.request.contextPath }/news/${newsTypeID }/${news.id }/query">
                    			<c:if test="${fn:length(news.title)>35 }">
                       				${fn:substring(news.title, 0, 35) }...
                       			</c:if>
                       			<c:if test="${fn:length(news.title)<35 }">
                       				${news.title }
                       			</c:if>
                      		</a>
                      	</li>
                      </c:forEach>
                      </ul>
                  </div> <!--右侧内容-->
                    <!--分页-->
                    <div class="fenye">
                        <a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=${newsTypeID }&currentPage=1">首页&nbsp;&nbsp;</a>
                        <c:if test="${currentPage != 1 }">
                        	<a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=${newsTypeID}&currentPage=${currentPage-1 }">上一页&nbsp;&nbsp;</a>
                        </c:if>
                        <c:if test="${currentPage != pageCount }">
                        	<a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=${newsTypeID}&currentPage=${currentPage+1 }">下一页&nbsp;&nbsp;</a>
                        </c:if>
                        <a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=${newsTypeID}&currentPage=${pageCount }">尾页&nbsp;&nbsp;</a>
                        <span>当前第${currentPage }页&nbsp;&nbsp;</span>
                        <span>共${pageCount }页&nbsp;&nbsp;</span>
                        <span>共${rowCount }条数据</span>
                    </div><!--分页-->
                </div> <!--主要内容 -->
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
</html>