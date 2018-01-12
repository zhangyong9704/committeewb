package com.shunan.committeewb.po;
/**
 * 专题标签
 * @author 李琳茹
 *
 */
public class Activity {
	private int id;
	private String name;
	private String url;
	private String sort;
	private Activity(){}
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
}
