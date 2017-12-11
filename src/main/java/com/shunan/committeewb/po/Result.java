package com.shunan.committeewb.po;

import java.util.List;

/**
 * 返回前端页面的json数据的数据结构
 * @author 李琳茹
 *
 * @param <T>
 */
public class Result<T>{
	private int code;     //状态码     200
	private String msg;   //描述信息   success
	private List<T> rows; //数据       返回的数据 or 空数组
	
	public Result() {
		super();
	}
	public Result(int code, String msg, List<T> rows) {
		super();
		this.code = code;
		this.msg = msg;
		this.rows = rows;
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
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
