package com.shunan.committeewb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shunan.committeewb.po.Result;
import com.shunan.committeewb.po.WebInfo;
import com.shunan.committeewb.service.WebInfoService;
import com.shunan.committeewb.utils.CommonUtils;
import com.shunan.committeewb.utils.FileUtil;

/**
 * 网站设置
 * @author 李琳茹
 *
 */
@Controller
@RequestMapping("/webInfo")
public class WebInfoController {
	@Autowired
	private WebInfoService webInfoService;
	
	/**
	 * 查询网站信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryWebInfo")
	@ResponseBody
	public Result<WebInfo> queryWebInfo() throws Exception{
		Result<WebInfo> result = null;
		List<WebInfo> list = new ArrayList<WebInfo>();
		
		try {
			WebInfo webInfo = webInfoService.queryWebInfo();
			list.add(webInfo);
			result = new Result<WebInfo>(200, "查询网站信息成功!", list);
		} catch (Exception e) {
			result = new Result<WebInfo>(100, "查询网站信息失败!", list);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 修改网站信息
	 * @param logoFile
	 * @param titleFile
	 * @param backgroundFile
	 * @param webInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateWebInfo")
	@ResponseBody
	public Result<String> updateWebInfo(MultipartFile logoFile,
			MultipartFile titleFile,MultipartFile backgroundFile,WebInfo webInfo) throws Exception{
		//校验上传的文件是否符合要求
		if(logoFile!=null && logoFile.getOriginalFilename()!=null && (!logoFile.getOriginalFilename().equals(""))){
			Result<String> picResult = FileUtil.checkFile(logoFile, 
					CommonUtils.HOME_LOGO_WIDTH, CommonUtils.HOME_LOGO_HEIGHT, CommonUtils.FILE_MAXSIZE);
			if(picResult.getCode()!=200){
				return picResult;
			}
		}
		if(titleFile!=null && titleFile.getOriginalFilename()!=null && (!titleFile.getOriginalFilename().equals(""))){
			Result<String> picResult = FileUtil.checkFile(titleFile, 
					CommonUtils.HOME_TITLE_WIDTH, CommonUtils.HOME_TITLE_HEIGHT, CommonUtils.FILE_MAXSIZE);
			if(picResult.getCode()!=200){
				return picResult;
			}
		}
		if(backgroundFile!=null && backgroundFile.getOriginalFilename()!=null && (!backgroundFile.getOriginalFilename().equals(""))){
			Result<String> picResult = FileUtil.checkFile(backgroundFile, 
					CommonUtils.HOME_BACKGROUND_WIDTH, CommonUtils.HOME_BACKGROUND_HEIGHT, CommonUtils.FILE_MAXSIZE);
			if(picResult.getCode()!=200){
				return picResult;
			}
		}
		
		//修改网站信息
		Result<String> result = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			webInfoService.updateWebInfo(logoFile,titleFile,backgroundFile,webInfo);
			result = new Result<String>(200, "修改网站信息成功!",list);
		} catch (Exception e) {
			result = new Result<String>(100, "修改网站信息失败!", list);
			e.printStackTrace();
		}
		return result;
	}

}
