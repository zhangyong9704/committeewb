package com.shunan.committeewb.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CommonUtils {
	//重点专注
	public static final int NEWS_ZDZZ = 1;
	public static final int NEWS_ZDZZ_LIMIT = 7;
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
	public static final int NEWS_ZTHD_LIMIT = 10;
	//青春剪影
	public static final int NEWS_QCJY = 7;
	public static final int NEWS_QCJY_LIMIT = 10;
	
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
	//生活大家谈
	public static final int SHDJT = 5;
	//专题标签
	public static final int ACTIVITY = 6;
	
	//图片文件大小
	//上传的图片的大小
	public static final long FILE_MAXSIZE = 20971520;  //20M 单位K
	
	//图片相关状态码
	public static final int CODE_IMG_TYPE = 101; //图片格式不正确时的状态码
	public static final int CODE_IMG_SIZE = 102; //图片太大时的状态码
	public static final int CODE_IMG_PX = 103; //图片分辨率不符合规范时的状态码
	
	//各个模块上传图片时要求的像素比 （宽/高）
	public static final int HOME_LOGO_WIDTH = 1200; //首页logo
	public static final int HOME_LOGO_HEIGHT = 375;
	public static final int HOME_TITLE_WIDTH = 1920; //首页title
	public static final int HOME_TITLE_HEIGHT = 600;
	public static final int HOME_BACKGROUND_WIDTH = 1200; //首页背景图
	public static final int HOME_BACKGROUND_HEIGHT = 375;
	public static final int HOME_BANNER_WIDTH = 1200; //首页banner
	public static final int HOME_BANNER_HEIGHT = 197; 
	public static final int LINK_WIDTH = 186; //友情链接
	public static final int LINK_HEIGHT = 63; 
	public static final int ROLLIMG_WIDTH = 334; //轮播图
	public static final int ROLLIMG_HEIGHT = 193; 
	public static final int SHDJT_WIDTH = 380; //生活大家谈
	public static final int SHDJT_HEIGHT = 122; 
	public static final int ZTHD_WIDTH = 287; //专题活动
	public static final int ZTHD_HEIGHT = 69; 
	public static final int QCJY_WIDTH = 222; //青春剪影
	public static final int QCJY_HEIGHT = 148; 
	public static final int WATERMARK_WIDTH = 100; //水印照片
	public static final int WATERMARK_HEIGHT = 30; 
	
	/**
	 * 将String转换为List
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static List<Integer> transferStringToIntList(String str) throws Exception{
		String[] strArr = str.trim().split(",");
		List<Integer> list = new ArrayList<Integer>();
		if(strArr.length>0){
			for(String s:strArr){
				if(!s.equals("")){
					list.add(Integer.parseInt(s));
				}
			}
		}
		return list;
	}
	
	/**
	 * 格式化日期
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String dateFormate(Date date) throws Exception{
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		String time = df.format(date);
		return time;
	}
	
	/**
	 * 获取日期是周几
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String getWeek(Calendar date) throws Exception{
		int weekday = date.get(Calendar.DAY_OF_WEEK);
		String day = "星期";
		switch (weekday) {
		case 1:
			day = day + "日";
			break;
		case 2:
			day =  day + "一";
			break;
		case 3:
			day = day + "二";
			break;
		case 4:
			day = day + "三";
			break;
		case 5:
			day = day + "四";
			break;
		case 6:
			day = day + "五";
			break;
		case 7:
			day = day + "六";
			break;

		default:
			break;
		}
		return day;
	}
	
}
