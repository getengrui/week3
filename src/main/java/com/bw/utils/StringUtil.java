package com.bw.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author wanghd
 *
 */
public class StringUtil {
	
	/**
	 * 判断字符串是否为空   空引号和空格也算没值
	 * 		如果为空 返回 true    不为空返回false
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return str == null || str.trim().length()<1;
	}
	
	/**
	 * 判断是否为手机号码
	 * 		如果是返回true  不是返回false
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str){
		String regex = "1[3|5|7|8|9]\\d{9}";
		return str.matches(regex);
	}
	
	/**
	 * 判断是否为电子邮箱
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str){
		String regex = "\\w+@\\w+(.com|.cn|.com.cn)";
		return str.matches(regex);
	}
	
	/**
	 * 判断是否全部为字母
	 * @param str
	 * @return
	 */
	public static boolean isString(String str){
		String regex = "[a-zA-Z]+";
		return str.matches(regex );
	}
	
	/**
	 * 获取n位随机英文字符串
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length){
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < length; i++) {
			//获取随机字符串
			//65-90 A-Z
			//97-122 a-z
			//1.生成随机数
			int num = (int) (Math.random()*123);
			
			//2.判断随机数是否在  65-90 或者 97-122
			if((num >=65 && num <=90 )|| (num >=97 && num <= 122)){
				char c = (char) num;
				sb.append(c);
			}else{
				i--;
			}
			
		}
		return sb.toString();
	}
	
	/**
	 * 获取n位随机英文和数字字符串
	 * @param length
	 * @return
	 */
	public static String getStringAndNumber(int length){
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		char[] words = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0'};
		for(int i = 0 ; i < length ; i++){
			int index = random.nextInt(36);
			String word = words[index] + "";
			if(!StringUtil.isNumber(word)){
				int bigorsmall = random.nextInt();
				if(bigorsmall % 2 == 0){
					word = word.toLowerCase();
				}
			}
			result.append(word);
		}
		
		return result.toString();
	}
	
	/**
	 * 是否是纯数字
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str){
		boolean blank = StringUtil.isEmpty(str);
		if(blank){
			Pattern pattern = Pattern.compile("^\\d*$");
			Matcher matcher = pattern.matcher(str);
			if(matcher.matches()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**
	 * 判断参数是否为数字，包含小数
	 * @param str
	 * @return
	 */
	public static boolean isFloat(String str){
		boolean blank = StringUtil.isEmpty(str);
		if(!blank){
			boolean matches = str.matches("(\\d+|\\d+\\.\\d+)");
			return matches;
		}
		return false;
	}
	
	
	/**
	 * 获取n个随机中文字符串
	 * @param length	获取指定长度的字符串
	 * @return
	 */
	public static String getAChinese(int length) {
        StringBuilder str = new StringBuilder();
        int hs = 0 ;
        int ls = 0; 
        Random random = new Random();
        for(int i = 0 ; i < length ; i++){
	        hs = (176 + Math.abs(random.nextInt(39))); 
	        ls = (161 + Math.abs(random.nextInt(93)));
	        byte[] b = new byte[2];
	        b[0] = (new Integer(hs).byteValue());
	        b[1] = (new Integer(ls).byteValue());
	        try {
	          str.append(new String(b, "GBk")); 
	        } catch (UnsupportedEncodingException e) {
	          e.printStackTrace();
	        }
        }
        return str.toString();
  }
	
	/*
	* 方法功能：根据正则在字符串提取一段值，用于后面在url地址里提取ID值。
	* 例如在“http://news.cnstock.com/news,yw-201908-4413224.htm”把“4413224”提取出来。
	*/
	public static String getPlaceholderValue(String src){
		
		String substring = src.substring(0, src.lastIndexOf("."));
		Pattern p = Pattern.compile("\\d+$");
		Matcher matcher = p.matcher(substring);
		while(matcher.find()){
			String group = matcher.group();
			return group;
		}
		return null;
		}
}
