package com.shunan.committeewb.po;

import java.util.Date;

/**
 * 规章制度、工作标准、通讯录、风采录
 * @author 李琳茹
 *
 */
public class Home {
	private int id;
	private String title;//标题
	private Date publishTime;//发布时间
	private String source;//来源
	private String content;//内容
	private String type;//类型
	public Home() {
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
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
