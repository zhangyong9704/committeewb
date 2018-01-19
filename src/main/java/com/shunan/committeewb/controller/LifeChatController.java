package com.shunan.committeewb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shunan.committeewb.po.LifeChat;
import com.shunan.committeewb.po.Result;
import com.shunan.committeewb.service.LifeChatService;
import com.shunan.committeewb.utils.CommonUtils;
import com.shunan.committeewb.utils.FileUtil;

/**
 * 生活大家谈
 * @author 李琳茹
 *
 */
@Controller
@RequestMapping("/lifeChat")
public class LifeChatController {
	
	@Autowired
	private LifeChatService lifeChatService;

	/**
	 * 查询生活大家谈
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryLifeChat")
	@ResponseBody
	public Result<LifeChat> queryLifeChat() throws Exception{
		Result<LifeChat> result = null;
		List<LifeChat> list = new ArrayList<LifeChat>();
		
		try {
			LifeChat lifeChat = lifeChatService.queryLifeChat();
			if(lifeChat!=null){
				list.add(lifeChat);
			}
			result = new Result<LifeChat>(200, "查询成功！", list);
		} catch (Exception e) {
			result = new Result<LifeChat>(100, "查询失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 修改生活大家谈
	 * @param lifeChat
	 * @param picFile
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateLifeChat")
	@ResponseBody
	public Result<String> updateLifeChat(LifeChat lifeChat,MultipartFile picFile) throws Exception{
		Result<String> result = null;
		List<String> list = new ArrayList<String>();
		
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			Result<String> picResult = FileUtil.checkFile(picFile, 
					CommonUtils.SHDJT_WIDTH, CommonUtils.SHDJT_HEIGHT, CommonUtils.FILE_MAXSIZE,CommonUtils.PX_FIXED);
			if(picResult.getCode()!=200){
				return picResult;
			}
		}
		
		try {
			lifeChatService.updateLifeChat(lifeChat,picFile);
			result = new Result<String>(200, "修改成功！", list);
		} catch (Exception e) {
			result = new Result<String>(100, "修改失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}
}
