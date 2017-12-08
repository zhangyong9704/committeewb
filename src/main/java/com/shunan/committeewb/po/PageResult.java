package com.shunan.committeewb.po;

import java.util.List;

/**
 * 分页查询返回的json数据的数据结构
 * @author 李琳茹
 *
 * @param <T>
 */
public class PageResult<T> extends Result<T> {
	private long total;
	
	public PageResult() {
		super();
	}
	public PageResult(int code, String msg, List<T> data,long total) {
		super(code,msg,data);
		this.total = total;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
