package com.shunan.committeewb.po;

import java.util.List;

public class Result<T>{
	private int code;     //状态码     200
	private String msg;   //描述信息   success
	private List<T> data; //数据       返回的数据 or 空数组
	
	public Result() {
		super();
	}
	public Result(int code, String msg, List<T> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
}
