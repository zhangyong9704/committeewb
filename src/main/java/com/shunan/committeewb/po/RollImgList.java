package com.shunan.committeewb.po;

/**
 * 轮播图列表
 * @author 李琳茹
 *
 */
public class RollImgList {
	private int newsID;//新闻ID
	private String title;//标题
	private String picUrl;//宣传图片地址
	private long count;//浏览量
	private int sort;//显示顺序
	private int isShow;//是否在首页展示:0不展示,1展示
	public RollImgList() {
		super();
	}
	public int getNewsID() {
		return newsID;
	}
	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
	@Override
	public String toString() {
		return "RollImgList [newsID=" + newsID + ", title=" + title + ", picUrl=" + picUrl + ", count=" + count
				+ ", sort=" + sort + ", isShow=" + isShow + "]";
	}
}
