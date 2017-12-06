package com.shunan.committeewb.utils;

import java.io.File;
import java.io.IOException;

/**
 * 创建文件 工具类
 * @author 李琳茹
 *
 */
public class CreateFileUtil {
	public static boolean createFile(String destFileName){
		File file = new File(destFileName);
		if(file.exists()){
			file.delete();
		}
		if(destFileName.endsWith(File.separator)){
			System.out.println("创建文件失败！目标文件不能为目录");
			return false;
		}
		//判断其父目录是否存在
		if(!file.getParentFile().exists()){
			//父目录不存在
			if(!file.getParentFile().mkdirs()){
				System.out.println("创建目标文件所在的父目录失败!");
				return false;
			}
		}
		//创建目标文件
		System.out.println("文件路径："+file.getPath());
		try {
			if(file.createNewFile()){
				System.out.println("创建文件成功");
				file.setExecutable(true); //设置可执行权限
				file.setReadable(true); //设置可读权限
				file.setWritable(true); //设置可写权限
				return true;
			}else{
				System.out.println("创建文件失败");
				return false;
			}
		} catch (IOException e) {
			System.out.println("创建文件失败！"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}
