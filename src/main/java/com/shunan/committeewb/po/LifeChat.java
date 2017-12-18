package com.shunan.committeewb.po;
/**
 * 生活大家谈图片
 * @author 李琳茹
 *
 */
public class LifeChat {
	private int id;
	private String name;
	private String picUrl;//图片地址
	public LifeChat() {
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
}
