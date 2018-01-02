package com.shunan.committeewb.po;
/**
 * Banner图
 * 首页头部大banner以及底部小bannner
 * @author 李琳茹
 *
 */
public class Banner {
	private int id;
	private String name;//标题
	private String picUrl;//图片地址
	private String jumpLink;//跳转链接
	private int type;//banner类型:0头部大banner图,1底部小图
	private int sort;//显示顺序
	public Banner() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getJumpLink() {
		return jumpLink;
	}
	public void setJumpLink(String jumpLink) {
		this.jumpLink = jumpLink;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
}
