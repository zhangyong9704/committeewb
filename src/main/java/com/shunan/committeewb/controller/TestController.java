package com.shunan.committeewb.controller;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.shunan.committeewb.dao.FilesMapper;
import com.shunan.committeewb.po.Files;
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
}
