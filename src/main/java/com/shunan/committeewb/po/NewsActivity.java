package com.shunan.committeewb.po;
/**
 * 新闻专题
 * @author 李琳茹
 *
 */
public class NewsActivity {
	private int id;
	private int newsID;
	private int activityID;
	
	public NewsActivity(){}
	public NewsActivity(int newsID, int activityID) {
		super();
		this.newsID = newsID;
		this.activityID = activityID;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNewsID() {
		return newsID;
	}
	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}
	public int getActivityID() {
		return activityID;
	}
	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}
}
