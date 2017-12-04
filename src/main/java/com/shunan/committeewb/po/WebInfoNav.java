package com.shunan.committeewb.po;
/**
 * 网站信息导航栏
 * @author 李琳茹
 *
 */
public class WebInfoNav {
	private int id;
	private int webInfoID;//网站基本信息ID
	private int navID;//导航栏ID
	public WebInfoNav() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWebInfoID() {
		return webInfoID;
	}
	public void setWebInfoID(int webInfoID) {
		this.webInfoID = webInfoID;
	}
	public int getNavID() {
		return navID;
	}
	public void setNavID(int navID) {
		this.navID = navID;
	}
	@Override
	public String toString() {
		return "WebInfoNav [id=" + id + ", webInfoID=" + webInfoID + ", navID=" + navID + "]";
	}
}
