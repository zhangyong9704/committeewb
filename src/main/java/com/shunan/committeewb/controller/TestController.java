package com.shunan.committeewb.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shunan.committeewb.dao.FilesMapper;
import com.shunan.committeewb.po.Files;
import com.shunan.committeewb.po.Result;
import com.shunan.committeewb.utils.CreateFileUtil;
import com.shunan.committeewb.utils.FileUtil;

@Controller
public class TestController {
	
	@Autowired
	private FilesMapper filesMapper;
	
	@RequestMapping("/uploadMultiFile")
	public String uploadMultiFile(MultipartFile[] files) throws Exception{
		for(MultipartFile file:files){
			if(file!=null && file.getOriginalFilename()!=null && (!file.getOriginalFilename().equals(""))){
				//图片上传成功后，存放图片的位置
				String filePath = FileUtil.getUploadFilePath();
				//上传原文件名称
				String originalFilename = file.getOriginalFilename();
				
				if(originalFilename.contains(".")){
					//新文件
					File file2=new File(filePath+originalFilename);
					if(CreateFileUtil.createFile(filePath+originalFilename)){
						//将内存中的文件写入硬盘
						file.transferTo(file2);
					}
				}
			}
		}
		return "home";
	}
	
	@RequestMapping("/insertFiles")
	public String insertFiles() throws Exception{
		Files files = new Files();
		files.setName("新建文档.txt");
		files.setUrl("http://www.baidu.com");
		filesMapper.insertFiles(files);
		System.out.println("-->"+files.getId());
		return "home";
	}
	
	@RequestMapping("dealJsonFile")
	@ResponseBody
	public Result<String> dealJsonFile() throws Exception{
		Result<String> result = null;
		
		File baseFile = new File(Test.class.getClassLoader().getResource("/").getPath());
		File parentFile  = baseFile.getParentFile().getParentFile();
		String filePath = parentFile.getAbsolutePath()+File.separator;
		String oldFilePath = filePath+"admin/jsp/config.json";
		
		BufferedReader br = new BufferedReader(new FileReader(oldFilePath));
		String str = null,jsonStr = "";
		
		while((str=br.readLine())!=null){
			System.out.println("str===>"+str);
			jsonStr += str;
		}
		br.close();
		
		JSONObject jsonObject = new JSONObject(jsonStr);
		Boolean isWatermark = jsonObject.getBoolean("isWatermark");
		String watermarkText = jsonObject.getString("watermarkText");
		String watermarkImgPath = jsonObject.getString("watermarkImgPath");
		String watermarkType = jsonObject.getString("watermarkType");
		
		System.out.println(isWatermark+","+watermarkText+","+watermarkImgPath+","+watermarkType);
		
		jsonObject.put("isWatermark", false);
		jsonObject.put("watermarkText", "蜀南气矿团委");
		jsonObject.put("watermarkImgPath", "upload");
		jsonObject.put("watermarkType", "icon");
		
		jsonStr = jsonObject.toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(oldFilePath));
		bw.write(jsonStr);
		bw.flush();
		bw.close();
		
		return result;
	}
}
