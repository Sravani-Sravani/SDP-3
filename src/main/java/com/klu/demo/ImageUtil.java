package com.klu.demo;

import java.io.UnsupportedEncodingException;


public class ImageUtil
{
	public String getImgData(byte[] byteData) throws UnsupportedEncodingException 
	{
		 byte[] encode = java.util.Base64.getEncoder().encode(byteData);
         return new String(encode, "UTF-8");
    }
}
