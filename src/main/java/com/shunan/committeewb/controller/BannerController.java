package com.shunan.committeewb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shunan.committeewb.po.Banner;
import com.shunan.committeewb.po.Result;
import com.shunan.committeewb.service.BannerService;

/**
 * Banner
 * @author 李琳茹
 *
 */
@Controller
@RequestMapping("/banner")
public class BannerController {
	@Autowired
	private BannerService bannerService;
	
	/**
	 * 查询头部大Banner or 友情链接
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryAllBanners")
	@ResponseBody
	public Result<Banner> queryAllBanners(int type) throws Exception{
		Result<Banner> result = null;
		List<Banner> list = new ArrayList<Banner>();
		try {
			list = bannerService.queryAllBanners(type);
			result = new Result<Banner>(200, "查询成功！", list);
		} catch (Exception e) {
			result = new Result<Banner>(100, "查询失败！", list);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 添加banner图 or 友情链接
	 * @param picFile
	 * @param banner
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertBanner")
	@ResponseBody
	public Result<String> insertBanner(MultipartFile picFile,Banner banner) throws Exception{
		//校验上传的文件是否符合要求
/*		if(banner.getType() == 0){
			//上传banner图
			if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
				Result<String> picResult = FileUtil.checkFile(picFile, 
						CommonUtils.HOME_BANNER_WIDTH, CommonUtils.HOME_BANNER_HEIGHT, CommonUtils.FILE_MAXSIZE);
				if(picResult.getCode()!=200){
					return picResult;
				}
			}
		}else{
			//上传友情链接
			if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
				Result<String> picResult = FileUtil.checkFile(picFile, 
						CommonUtils.LINK_WIDTH, CommonUtils.LINK_HEIGHT, CommonUtils.FILE_MAXSIZE);
				if(picResult.getCode()!=200){
					return picResult;
				}
			}
		}*/
		
		//添加
		Result<String> result = null;
		List<String> list = new ArrayList<String>();
		try {
			bannerService.insertBanner(picFile,banner);
			result = new Result<String>(200, "添加成功！", list);
		} catch (Exception e) {
			result = new Result<String>(100, "添加失败！", list);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 修改banner图 or 友情链接
	 * @param picFile
	 * @param banner
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateBanner")
	@ResponseBody
	public Result<String> updateBanner(MultipartFile picFile,Banner banner) throws Exception{
		//校验上传的文件是否符合要求
/*		if(banner.getType() == 0){
			//上传banner图
			if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
				Result<String> picResult = FileUtil.checkFile(picFile, 
						CommonUtils.HOME_BANNER_WIDTH, CommonUtils.HOME_BANNER_HEIGHT, CommonUtils.FILE_MAXSIZE);
				if(picResult.getCode()!=200){
					return picResult;
				}
			}
		}else{
			//上传友情链接
			if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
				Result<String> picResult = FileUtil.checkFile(picFile, 
						CommonUtils.LINK_WIDTH, CommonUtils.LINK_HEIGHT, CommonUtils.FILE_MAXSIZE);
				if(picResult.getCode()!=200){
					return picResult;
				}
			}
		}*/
		
		//修改
		Result<String> result = null;
		List<String> list = new ArrayList<String>();
		try {
			bannerService.updateBanner(picFile,banner);
			result = new Result<String>(200, "修改成功！", list);
		} catch (Exception e) {
			result = new Result<String>(100, "修改失败！", list);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 删除banner
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteBanner")
	@ResponseBody
	public Result<String> deleteBanner(int id) throws Exception{
		Result<String> result = null;
		List<String> list = new ArrayList<String>();
		
		Banner banner2 = bannerService.queryBannerByID(id);
		if(banner2 == null){
			return new Result<String>(100, "数据不存在,删除失败！", list);
		}
		
		try {
			bannerService.deleteBanner(id);
			result = new Result<String>(200, "删除成功！", list);
		} catch (Exception e) {
			result = new Result<String>(100, "删除失败！", list);
			e.printStackTrace();
		}
		return result;
	}

}
