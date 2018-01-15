package com.shunan.committeewb.po;

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
}
