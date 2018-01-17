package com.shunan.committeewb.po;

import java.util.Date;
import java.util.List;

/**
 * 写文章/修改文章 封装的NewsVO
 * @author 李琳茹
 *
 */
public class WriteNewsVO extends News {
	private int id;
	private String title;//标题
	private int newsTypeID;//新闻类型ID
	private String picUrl;//宣传图片地址
	private String content;//新闻内容
	private Date createTime;//创建时间
	private String author;//作者
	private int status;//发布状态:0已发布,1草稿
	private Date showTime;//显示时间
	private long count;//浏览量
	private int isHavePic;//是否是图文新闻:0纯文字,1图文
	private List<Integer> activityIDs;
	public WriteNewsVO(){}
	public WriteNewsVO(News news,List<Integer> activityIDs){
		super();
		this.id = news.getId();
		this.title = news.getTitle();
		this.newsTypeID = news.getNewsTypeID();
		this.picUrl = news.getPicUrl();
		this.content = news.getContent();
		this.createTime = news.getCreateTime();
		this.author = news.getAuthor();
		this.status = news.getStatus();
		this.showTime = news.getShowTime();
		this.count = news.getCount();
		this.isHavePic = news.getIsHavePic();
		this.activityIDs = activityIDs;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNewsTypeID() {
		return newsTypeID;
	}
	public void setNewsTypeID(int newsTypeID) {
		this.newsTypeID = newsTypeID;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getShowTime() {
		return showTime;
	}
	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public int getIsHavePic() {
		return isHavePic;
	}
	public void setIsHavePic(int isHavePic) {
		this.isHavePic = isHavePic;
	}
	public List<Integer> getActivityIDs() {
		return activityIDs;
	}
	public void setActivityIDs(List<Integer> activityIDs) {
		this.activityIDs = activityIDs;
	}
}
