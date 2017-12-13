package com.shunan.committeewb.po;
/**
 * 轮播图
 * @author 李琳茹
 *
 */
public class RollImg {
	private int newsID;//新闻ID
	private int sort;//显示顺序
	private int isShow;//是否在首页展示:0不展示,1展示
	public RollImg() {
		super();
	}
	public RollImg(int newsID) {
		super();
		this.newsID = newsID;
	}
	public int getNewsID() {
		return newsID;
	}
	public void setNewsID(int newsID) {
		this.newsID = newsID;
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
		return "RollImg [newsID=" + newsID + ", sort=" + sort + ", isShow=" + isShow + "]";
	}
}
