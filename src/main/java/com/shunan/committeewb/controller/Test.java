package com.shunan.committeewb.controller;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Test {

	public static void main(String[] args) {
		String source = "111111";
		String salt = "1511167003013";
		Md5Hash md5Hash = new Md5Hash(source, salt, 10);
		System.out.println(md5Hash.toString());
	}

}
