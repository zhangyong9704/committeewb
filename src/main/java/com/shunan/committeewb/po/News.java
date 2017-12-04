package com.shunan.committeewb.po;

import java.util.Date;

/**
 * 新闻信息
 * @author 李琳茹
 *
 */
public class News {
	private int id;
	private String title;//标题
	private int newsTypeID;//新闻类型ID
	private String picUrl;//宣传图片地址
	private String content;//新闻内容
	private Date publishTime;//发布时间
	private String author;//作者
	public News() {
		super();
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
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", newsTypeID=" + newsTypeID + ", picUrl=" + picUrl
				+ ", content=" + content + ", publishTime=" + publishTime + ", author=" + author + "]";
	}
}
