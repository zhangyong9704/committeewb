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
	private int status;//发布状态:0已发布,1草稿
	private Date showTime;//显示时间
	private long count;//浏览量
	private int isHavePic;//是否是图文新闻:0纯文字,1图文
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
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", newsTypeID=" + newsTypeID + ", picUrl=" + picUrl
				+ ", content=" + content + ", publishTime=" + publishTime + ", author=" + author + ", status=" + status
				+ ", showTime=" + showTime + ", count=" + count + "]";
	}
}
