package com.shunan.committeewb.po;

import java.io.Serializable;

/**
 * 用户表
 * @author 李琳茹
 *
 */
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String account;//账号
	private String password;//密码
	private String realName;//账号使用者真实姓名
	private String salt;//盐
	private String sex;//性别
	private String tel;//联系方式
	private String email;//邮箱
	public User() {
		super();
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [account=" + account + ", password=" + password + ", realName=" + realName + ", salt=" + salt
				+ ", sex=" + sex + ", tel=" + tel + ", email=" + email + "]";
	}
}
