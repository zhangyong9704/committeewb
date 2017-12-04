package com.shunan.committeewb.po;
/**
 * 新闻类型
 * @author 李琳茹
 *
 */
public class NewsType {
	private int id;
	private String name;//类型名称
	public NewsType() {
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
	@Override
	public String toString() {
		return "NewsType [id=" + id + ", name=" + name + "]";
	}
}
