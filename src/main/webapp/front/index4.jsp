<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Cache-Control" content="max-age=7200" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>蜀南气矿团委</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/front/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="${pageContext.request.contextPath }/front/css/head1.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath }/front/css/index1.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/front/css/iconfont.css" rel="stylesheet">
       <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script> >
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<c:if test="${navList == null }">
		<%
			response.sendRedirect("/committeewb/index");
		 %>
	</c:if>
<div class="container-fluid">
    <!--head部分-->
    <div class="row head">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <img src="${pageContext.request.contextPath }/front/img/head.jpg"> <!--1920*345-->
        <div id="stars_box"></div>
        </div>
    </div><!--head部分-->
   <!--主体部分 -->
    <div class="row main" style="background:url(${pageContext.request.contextPath }/front/img/main1.jpg) no-repeat;background-size:100% ">  <!--1920*1245-->
        <!--导航部分-->
    <%--<div class='container-fluid'>--%>
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
    <iframe  align=center valign=middle id='ww'allowtransparency="true" frameborder="0" width="180"  scrolling="no" src="//tianqi.2345.com/plugin/widget/index.htm?s=3&z=2&t=0&v=0&d=3&bd=0&k=000000&f=ffffff&ltf=ffffff&htf=ffffff&q=1&e=1&a=0&c=57602&w=180&h=30&align=center"></iframe>
                         </li>
                    </ul>
                    </div>
                </div>
            </div>
        <%--</div>--%>
    </div><!--导航部分-->
        <!--　主体内容部分-->
        <div class="row mbody" style="position: relative;top:-5px;z-index: 0">
            <div class="col-md- col-sm-8 col-xs-8 col-md-offset-2 col-sm-offset-2 col-xs-offset-2">
            <!--<div class="col-md-12 col-sm-12 col-xs-12" style="margin-top: 5px">-->
                <!--banner-->
                <div class="row banner">
                <div class="col-md-12 col-sm-12 col-xs-12 ">
                	<c:forEach items="${bannerList }" var="banner">
	                	<c:if test="${banner.jumpLink!=null && banner.jumpLink!=''}">
	                		<a href="${banner.jumpLink}">
	                			<img src="${pageContext.request.contextPath }/upload/${banner.picUrl}"/>
	                		</a>
	                	</c:if>
	                	<c:if test="${banner.jumpLink==null || banner.jumpLink==''}">
	                		<img src="${pageContext.request.contextPath }/upload/${banner.picUrl}"/>
	                	</c:if>
				    </c:forEach>
                </div>  <!--　1201*289-->
                </div> <!--banner-->
                <!--第一行-->
                <div class="row items">
                   <div class="col-md-4 col-sm-4 col-xs-4 a1">
                    	<img src="${pageContext.request.contextPath }/front/img/listbg.png">
                    	<a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=0&currentPage=1&activityID=-1">图片新闻</a>
                    	<a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=0&currentPage=1&activityID=-1">更多>>></a>
                    </div>  <!--　306*31-->
                    <div class="col-md-4 col-sm-4 col-xs-4 a1">
                    	<img src="${pageContext.request.contextPath }/front/img/listbg.png">
                    	<a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=1&currentPage=1&activityID=-1">重点关注</a>
                    	<a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=1&currentPage=1&activityID=-1">更多>>></a>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-4 a1">
                    	<img src="${pageContext.request.contextPath }/front/img/listbg.png">
                    	<a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=2&currentPage=1&activityID=-1">公告栏</a>
                    	<a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=2&currentPage=1&activityID=-1">更多>>></a>
                    </div>
                </div>
                <div class="row itemsCon">
                   <!--轮播图 -->
                    <div class="col-md-4 col-sm-4 col-xs-4 b1">
                        <div class="warper"> <!--2017-12-15 -->
                            <ul id="slideName1" class="sildebar clearfix">
                            	<c:forEach items="${rollImgList }" var="news">
	                           		<li>
	                           			<%--<a href="${pageContext.request.contextPath }/news/${news.newsTypeID }/${news.id }/query">--%>
	                           				<%--<img src="${pageContext.request.contextPath }/upload/${news.picUrl}" alt="${news.title }">--%>
	                           			<%--</a>--%>
                                    <a href="${pageContext.request.contextPath }/news/-1/${news.newsTypeID }/${news.id }/query" style="background:url('${pageContext.request.contextPath }/upload/${news.picUrl}') no-repeat center center;background-size: cover;" title="${news.title }"> </a>
	                                   <a title="${news.title }" target="_blank" href="${pageContext.request.contextPath }/news/-1/${news.newsTypeID }/${news.id }/query">
		                                   ${news.title }
		                                   <%--<c:if test="${fn:length(news.title)>30 }">
		                         				${fn:substring(news.title, 0, 30) }...
		                         			</c:if>
		                         			<c:if test="${fn:length(news.title)<30 }">
		                         				${news.title }
		                         			</c:if>--%>
	                                   </a>
	                               	</li> <!--380*201 -->
                            	</c:forEach>
                            </ul>
                        </div>
                       </div> <!--轮播图 -->
                    <!--重点关注-->
                    <div class="col-md-4 col-sm-4 col-xs-4 b1">
                        <ul>
	                         <c:forEach items="${zdzzList }" var="news">
	                         	<li>
	                         		<a title="${news.title }" href="${pageContext.request.contextPath }/news/-1/${news.newsTypeID }/${news.id }/query" target="_blank">
	                         				${news.title }
	                         		</a>
	                         		<span><fmt:formatDate value="${news.showTime }" pattern="yyyy-MM-dd"/></span>
	                         	</li>
	                         </c:forEach>
                        </ul>
                    </div> <!--重点关注-->
                    <!--公告栏-->
                    <div class="col-md-4 col-sm-4 col-xs-4 b1">
                        <ul>
                            <c:forEach items="${ggList }" var="news">
	                         	<li>
	                         		<a title="${news.title }" href="${pageContext.request.contextPath }/news/-1/${news.newsTypeID }/${news.id }/query" target="_blank">
	                         				${news.title }
	                         		</a>
	                         		<span><fmt:formatDate value="${news.showTime }" pattern="yyyy-MM-dd"/></span>
	                         	</li>
	                         </c:forEach>
                        </ul>
                        <a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=8&currentPage=1&activityID=-1">
                        	<img src="${pageContext.request.contextPath }/upload/${lifeChat.picUrl}"> 
                        </a>   <!--　380*122-->
                    </div><!--公告栏-->
                </div><!--第一行-->
                <!--第二行-->
                <div class="row secondRow">
                    <!--文件通知-->
                    <div class="col-md-3  col-sm-3 col-xs-3 a1">
                            <img src="${pageContext.request.contextPath }/front/img/listbg.png"> <!--　306*31-->
                            <a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=3&currentPage=1&activityID=-1">文件通知</a>
                            <a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=3&currentPage=1&activityID=-1">更多>>></a>
    <div class="sol" style="overflow:hidden;width:95%">
                        <div class="list">
                            <ul>
	                           <c:forEach items="${wjtzList }" var="news">
		                         	<li>
		                         		<a title="${news.title }" href="${pageContext.request.contextPath }/news/-1/${news.newsTypeID }/${news.id }/query" target="_blank">
		                         				${news.title }
		                         		</a>
		                         		<span><fmt:formatDate value="${news.showTime }" pattern="yyyy-MM-dd"/></span>
		                         	</li>
		                        </c:forEach>
                            </ul>
                        </div>
    </div>
                    </div><!--文件通知-->
                    <!--团情快讯-->
                    <div class="col-md-3  col-sm-3 col-xs-3 a1">
                        <img src="${pageContext.request.contextPath }/front/img/listbg.png">  <!--　306*31-->
                        <a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=4&currentPage=1&activityID=-1">团情快讯</a>
                        <a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=4&currentPage=1&activityID=-1">更多>>></a>
       <div class="sol" style="overflow:hidden;width:95%">
    <div class="list">
                            <ul>
                            	<c:forEach items="${tqkxList }" var="news">
		                         	<li>
		                         		<a title="${news.title }" href="${pageContext.request.contextPath }/news/-1/${news.newsTypeID }/${news.id }/query" target="_blank">
		                         				${news.title }
		                         		</a>
		                         		<span><fmt:formatDate value="${news.showTime }" pattern="yyyy-MM-dd"/></span>
		                         	</li>
		                        </c:forEach>
                            </ul>
                        </div>
    </div>
                    </div><!--团情快讯-->
                    <!--蜀南青语-->
                    <div class="col-md-3  col-sm-3 col-xs-3 a1">
                        <img src="${pageContext.request.contextPath }/front/img/listbg.png">  <!--　306*31-->
                        <a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=5&currentPage=1&activityID=-1">蜀南青语</a>
                        <a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=5&currentPage=1&activityID=-1">更多>>></a>
    <div class="sol" style="overflow:hidden;width:95%">
                        <div class="list">
                            <ul>
                                <c:forEach items="${snqyList }" var="news">
		                         	<li>
		                         		<a title="${news.title }" href="${pageContext.request.contextPath }/news/-1/${news.newsTypeID }/${news.id }/query" target="_blank">
		                         				${news.title }
		                         		</a>
		                         		<span><fmt:formatDate value="${news.showTime }" pattern="yyyy-MM-dd"/></span>
		                         	</li>
		                        </c:forEach>
                            </ul>
                        </div>
    </div>
                    </div><!--蜀南青语-->
                    <!--专题活动-->
                    <div class="col-md-3  col-sm-3 col-xs-3 a1 lasta1">
                        <img src="${pageContext.request.contextPath }/front/img/listbg.png">   <!--　306*31-->
                        <a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=6&currentPage=1&activityID=-1&activityID=-1">专题活动</a>
                        <a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=6&currentPage=1&activityID=-1&activityID=-1">更多>>></a>
                        <div class="list lastlist">
                        <%--<div class="list lastlist" style="position: relative">--%>
                            <div class="img"> <!--287*69-->
                            	<c:forEach items="${zthdList }" var="activity">
                            		<a title="${activity.name }" href="${pageContext.request.contextPath }/news/newsList?newsTypeID=6&currentPage=1&activityID=${activity.id}" target="_blank">
                            			<img src="${pageContext.request.contextPath }/upload/${activity.url}">  
                            		</a>
                            	</c:forEach>
                            </div>
                            <!--向下箭头-->
                            <div class="cli" style="position: absolute;bottom: 0">
                               <%--下--%>
                               <span class="down iconfont icon-down-darrow"></span>
                                <%--上--%>
                               <span class="up iconfont icon-down-darrow"></span>
                            </div>


                        </div>
                    </div><!--专题活动-->

                </div> <!--第二行-->
                <!--青春剪影-->
                <div class="row listRow" >
                    <div class="col-md-3 col-sm-3 col-xs-3 a1">
                        <img src="${pageContext.request.contextPath }/front/img/listbg.png">   <!--　306*31-->
                        <a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=7&currentPage=1&activityID=-1">青春剪影</a>
                        <a href="${pageContext.request.contextPath }/news/newsList?newsTypeID=7&currentPage=1&activityID=-1">更多>>></a>
                    </div>
                </div>

    <div class="row thirdRow" >
    <div><img src="${pageContext.request.contextPath }/front/img/left.png" style="width: 100%"></div>
    <div class="col-md-11 col-sm-11 col-xs-11 a1" style="float: left">
    <div id="scroll_div" class="scroll_div">
    <div id="scroll_begin" style="width: 100%;">
    <ul>
    <c:forEach items="${qcjyList }" var="news">
        <li>
        <div class="thumbnail">
        <a href="${pageContext.request.contextPath }/news/-1/${news.newsTypeID }/${news.id }/query" target="_blank">
        <img src="${pageContext.request.contextPath }/upload/${news.picUrl}" alt="...">
        </a>
        <div class="caption">
        <p>
        <a title="${news.title }" href="${pageContext.request.contextPath }/news/-1/${news.newsTypeID }/${news.id }/query" target="_blank">
        <c:if test="${fn:length(news.title)>10 }">
            ${fn:substring(news.title, 0, 10) }...
        </c:if>
        <c:if test="${fn:length(news.title)<10 }">
            ${news.title }
        </c:if>
        </a>
        </p>
        </div>
        </div>
        </li>
    </c:forEach>
    </ul>
    </div>
    <div id="scroll_end" style="width: 100%;"></div>
    </div>
    </div>
    <div style="width:4.15%; float: left"><img src="${pageContext.request.contextPath }/front/img/right.png" style="width: 100%"></div>
    </div>
    <!--青春剪影-->
    <!--小banner-->
                <div class="row footer">
                <c:forEach items="${linksList }" var="banner">
                	<div class="col-md-2 col-md-2 col-md-2">
                		<a href="${banner.jumpLink }">
                			<c:if test="${banner.picUrl != null && banner.picUrl != ''}">
	                			<img title="${banner.name }" src="${pageContext.request.contextPath }/upload/${banner.picUrl}" alt="${banner.name }">
	                		</c:if>
	                		<c:if test="${banner.picUrl == null || banner.picUrl == ''}">
	                			<a href="${banner.jumpLink }">${banner.name }</a>
	                		</c:if>
                		</a>
                	</div>  <!--186*63-->
                </c:forEach>
                </div><!--小banner-->
            </div>
            </div><!--　主体内容部分-->
        </div><!--主体部分 -->
    </div><!--container-fluid结束-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath }/front/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath }/front/js/nav.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath }/front/js/index.js"></script>
<!--<script src="js/animate.js"></script>-->


</body>
</html>