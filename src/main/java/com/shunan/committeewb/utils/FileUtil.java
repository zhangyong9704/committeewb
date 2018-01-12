package com.shunan.committeewb.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import javax.imageio.ImageIO;
import org.springframework.web.multipart.MultipartFile;

import com.shunan.committeewb.po.Activity;
import com.shunan.committeewb.po.Banner;
import com.shunan.committeewb.po.LifeChat;
import com.shunan.committeewb.po.News;
import com.shunan.committeewb.po.Result;
import com.shunan.committeewb.po.WebInfo;

/**
 * 文件处理 工具类
 * @author 李琳茹
 *
 */
public class FileUtil<T> {
	
	/**
	 * 获取上传的文件的路径：项目/upload/年月/文件名称  eg:committeewb/upload/201707/xxx.jpeg
	 * @return
	 * @throws Exception
	 */
	public static String getUploadFilePath() throws Exception{
		String subFileName = getYearMonth();
		
		//图片上传成功后，存放图片的位置
		File baseFile = new File(FileUtil.class.getClassLoader().getResource("/").getPath());
		File parentFile  = baseFile.getParentFile().getParentFile();
		String filePath = parentFile.getAbsolutePath()+File.separator+"upload"+File.separator;
		filePath = filePath + subFileName + File.separator;
		
		return filePath;
	}
	
	/**
	 * 获取服务器上upload文件夹的路径
	 * @return
	 * @throws Exception
	 */
	public static String getUploadPath() throws Exception{
		File baseFile = new File(FileUtil.class.getClassLoader().getResource("/").getPath());
		File parentFile  = baseFile.getParentFile().getParentFile();
		String filePath = parentFile.getAbsolutePath()+File.separator+"upload"+File.separator;
		
		return filePath;
	}
	
	/**
	 * 获取当前年月,例如 201707
	 * @return
	 * @throws Exception
	 */
	public static String getYearMonth() throws Exception{
		Calendar date = Calendar.getInstance();
		String year = date.get(Calendar.YEAR)+"";
		int mon = date.get(Calendar.MONTH)+1;
		String month = mon<10?("0"+mon):(mon+"");
		String subFileName = year + month;
		
		return subFileName;
	}
	
	/**
	 * 上传文件
	 * @param picFile 上传的文件
	 * @param t 实体类
	 * @param type 类型,标识要处理实体类中的哪个属性字段
	 * @return
	 * @throws Exception
	 */
	public static <T> T uploadFile(MultipartFile picFile,T t,int type) throws Exception{
		if(picFile!=null){
			//图片上传成功后，存放图片的位置
			String filePath = FileUtil.getUploadFilePath()+"image"+"/";
			//获取当前年月
			String yearMonth = FileUtil.getYearMonth();
			//上传原文件名称
			String originalFilename = picFile.getOriginalFilename();
			
			if(originalFilename.contains(".")){
				//新图片名称
				String newFileName=UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
				//新文件
				File file=new File(filePath+newFileName);
				//数据库中保存的上传的文件的名字
				String dbUploadFileName = yearMonth+"/image/"+newFileName;
				if(CreateFileUtil.createFile(filePath+newFileName)){
					//将内存中的文件写入硬盘
					picFile.transferTo(file);
					//网站信息设置 上传文件
					if(t instanceof WebInfo){
						WebInfo webInfo = (WebInfo) t;
						switch (type) {
						case CommonUtils.WEBINFO_LOGO:
							webInfo.setLogoUrl(dbUploadFileName);
							break;
						case CommonUtils.WEBINFO_TITLE:
							webInfo.setTitleUrl(dbUploadFileName);
							break;
						case CommonUtils.WEBINFO_BACKGROUND:
							webInfo.setBackgroundUrl(dbUploadFileName);
							break;

						default:
							break;
						}
					}
					//Banner图 or 友情链接 上传文件
					if(t instanceof Banner && type==CommonUtils.HOME_BANNER){
						Banner banner = (Banner) t;
						banner.setPicUrl(dbUploadFileName);
					}
					//新闻
					if(t instanceof News && type==CommonUtils.NEWS){
						News news = (News) t;
						news.setPicUrl(dbUploadFileName);
					}
					//生活大家谈
					if(t instanceof LifeChat && type==CommonUtils.SHDJT){
						LifeChat lifeChat = (LifeChat) t;
						lifeChat.setPicUrl(dbUploadFileName);
					}
					//专题标签
					if(t instanceof Activity && type==CommonUtils.ACTIVITY){
						Activity activity = (Activity) t;
						activity.setUrl(dbUploadFileName);
					}
				}
			}
		}
		return t;
	}
	
	/**
	 * 检测上传的文件是否满足要求
	 * @param picFile 上传的文件
	 * @param imgWidth 文件宽(px)
	 * @param imgHeight 文件高(px)
	 * @param fileSize 文件大小
	 * @return
	 * @throws Exception
	 */
	public static Result<String> checkFile(MultipartFile picFile,int imgWidth,int imgHeight,long fileSize) throws Exception{
		List<String> list = new ArrayList<String>();
		BufferedImage image = ImageIO.read(picFile.getInputStream());
		if(image == null){
			//上传文件无法转换成图片对象
			return new Result<String>(CommonUtils.CODE_IMG_TYPE, "图片格式不正确!",list);
		}else{
			int width = image.getWidth();
			int height = image.getHeight();
			if(imgHeight==0 && width!=imgWidth){
				return new Result<String>(CommonUtils.CODE_IMG_PX, "图片像素不符合要求！", list);
			}else if(width!=imgWidth || height!=imgHeight && imgHeight!=0){
				return new Result<String>(CommonUtils.CODE_IMG_PX,"图片像素不符合要求！",list);
			}
		}
		if(picFile.getSize()>fileSize){
			return new Result<String>(CommonUtils.CODE_IMG_SIZE, 
					"图片太大了！请上传小于"+(CommonUtils.FILE_MAXSIZE/1024/1024)+"M的图片！", list);
		}
		return new Result<String>(200, "上传文件符合要求！", list);
	}
}
