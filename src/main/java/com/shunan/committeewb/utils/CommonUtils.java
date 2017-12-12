package com.shunan.committeewb.utils;

public class CommonUtils {
	//重点专注
	public static final int NEWS_ZDZZ = 1;
	public static final int NEWS_ZDZZ_LIMIT = 8;
	//公告
	public static final int NEWS_GG = 2;
	public static final int NEWS_GG_LIMIT = 3;
	//文件通知
	public static final int NEWS_WJTZ = 3;
	public static final int NEWS_WJTZ_LIMIT = 8;
	//团青快讯
	public static final int NEWS_TQKX = 4;
	public static final int NEWS_TQKX_LIMIT = 8;
	//蜀南青语
	public static final int NEWS_SNQY = 5;
	public static final int NEWS_SNQY_LIMIT = 8;
	//专题活动
	public static final int NEWS_ZTHD = 6;
	public static final int NEWS_ZTHD_LIMIT = 4;
	
	//上传文件类型  图片 or 附件
	public static final int IMG_FILE = 0;
	public static final int ATTACHMENT_FILE = 1;
	
	//图片上传类型，根据该类型判断是哪个模块上传的文件
	//网站信息设置
	public static final int WEBINFO_LOGO = 0;
	public static final int WEBINFO_TITLE = 1;
	public static final int WEBINFO_BACKGROUND = 2;
	//Banner图
	public static final int HOME_BANNER = 3;
	//新闻
	public static final int NEWS = 4;
	
	//图片文件大小
	//上传的图片的大小
	public static final long FILE_MAXSIZE = 20971520;  //20M 单位K
	
	//图片相关状态码
	public static final int CODE_IMG_TYPE = 101; //图片格式不正确时的状态码
	public static final int CODE_IMG_SIZE = 102; //图片太大时的状态码
	public static final int CODE_IMG_PX = 103; //图片分辨率不符合规范时的状态码
	
	//各个模块上传图片时要求的像素比 （宽/高）
	public static final int HOME_LOGO_WIDTH = 1200; //首页大banner
	public static final int HOME_LOGO_HEIGHT = 375;
	public static final int HOME_TITLE_WIDTH = 1920; //首页title
	public static final int HOME_TITLE_HEIGHT = 600;
	public static final int HOME_BACKGROUND_WIDTH = 1200; //首页背景图
	public static final int HOME_BACKGROUND_HEIGHT = 375;
	public static final int HOME_BANNER_WIDTH = 1190; //首页banner
	public static final int HOME_BANNER_HEIGHT = 370; 
	public static final int LINK_WIDTH = 110; //友情链接
	public static final int LINK_HEIGHT = 30; 
	public static final int NEWS_WIDTH = 1190; //新闻
	public static final int NEWS_HEIGHT = 370; 
}
