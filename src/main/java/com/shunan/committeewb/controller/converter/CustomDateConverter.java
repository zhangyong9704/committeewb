package com.shunan.committeewb.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日期转换器
 * @author 李琳茹
 *
 */
public class CustomDateConverter implements org.springframework.core.convert.converter.Converter<String, Date>{

	/**
	 * String转Date
	 */
	public Date convert(String source) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
