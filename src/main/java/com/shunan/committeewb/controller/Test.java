package com.shunan.committeewb.controller;

import java.util.Date;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Test {

	public static void main(String[] args) throws Exception{
		String source = "5253019";
		String salt = "1511167003013";
		Md5Hash md5Hash = new Md5Hash(source, salt, 10);
		System.out.println("pass="+md5Hash.toString());
		
		Date date1 = new Date(1009);
		Date date2 = new Date(80090);
		System.out.println(date1.getTime()-date2.getTime());
		System.out.println(System.currentTimeMillis()-date2.getTime());
		
		int a = Integer.parseInt("-1");
		System.out.println(a);
	}

}
