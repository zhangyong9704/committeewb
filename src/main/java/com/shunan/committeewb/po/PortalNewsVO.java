package com.shunan.committeewb.po;

import java.util.Date;

/**
 * 门户网站新闻列表
 * @author 李琳茹
 *
 */
public class PortalNewsVO {
	private int newsID;
	private String newsTitle;
	private int activityID;
	private String activityName;
	private Date showTime;
	private int isLatestNews;//是否是最新的新闻:0是,1否
	public PortalNewsVO(){}
	public int getNewsID() {
		return newsID;
	}
	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public int getActivityID() {
		return activityID;
	}
	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}
	public Date getShowTime() {
		return showTime;
	}
	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}
	public int getIsLatestNews() {
		return isLatestNews;
	}
	public void setIsLatestNews(int isLatestNews) {
		this.isLatestNews = isLatestNews;
	}
	@Override
	public String toString() {
		return "PortalNewsVO [newsID=" + newsID + ", newsTitle=" + newsTitle + ", activityID=" + activityID
				+ ", activityName=" + activityName + ", showTime=" + showTime + "]";
	}
}
