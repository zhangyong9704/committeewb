package com.shunan.committeewb.po;
/**
 * 新闻附件
 * @author 李琳茹
 *
 */
public class NewsFile {
	private int id;
	private int newsID;//新闻ID
	private int fileID;//附件ID
	public NewsFile() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNewsID() {
		return newsID;
	}
	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}
	public int getFileID() {
		return fileID;
	}
	public void setFileID(int fileID) {
		this.fileID = fileID;
	}
	@Override
	public String toString() {
		return "NewsFile [id=" + id + ", newsID=" + newsID + ", fileID=" + fileID + "]";
	}
}
