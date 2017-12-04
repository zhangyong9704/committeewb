package com.shunan.committeewb.po;
/**
 * 网站基本信息
 * @author 李琳茹
 *
 */
public class WebInfo {
	private int id;
	private String logoUrl;//logo地址
	private String titleUrl;//标题地址
	private String backgroundUrl;//网站背景图地址
	private String field1;//底部字段1
	private String field2;//底部字段2
	private String field3;//底部字段3
	private String field4;//底部字段4
	private String field5;//底部字段5
	public WebInfo() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getTitleUrl() {
		return titleUrl;
	}
	public void setTitleUrl(String titleUrl) {
		this.titleUrl = titleUrl;
	}
	public String getBackgroundUrl() {
		return backgroundUrl;
	}
	public void setBackgroundUrl(String backgroundUrl) {
		this.backgroundUrl = backgroundUrl;
	}
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	public String getField4() {
		return field4;
	}
	public void setField4(String field4) {
		this.field4 = field4;
	}
	public String getField5() {
		return field5;
	}
	public void setField5(String field5) {
		this.field5 = field5;
	}
	@Override
	public String toString() {
		return "WebInfo [id=" + id + ", logoUrl=" + logoUrl + ", titleUrl=" + titleUrl + ", backgroundUrl="
				+ backgroundUrl + ", field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + ", field4="
				+ field4 + ", field5=" + field5 + "]";
	}
}
