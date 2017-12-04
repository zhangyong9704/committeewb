package com.shunan.committeewb.po;
/**
 * 上传文件
 * @author 李琳茹
 *
 */
public class Files {
	private int id;
	private String name;//文件名
	private String url;//文件地址链接
	public Files() {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Files [id=" + id + ", name=" + name + ", url=" + url + "]";
	}
	
}
