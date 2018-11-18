package com.ahobby.task.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RE {
	
	public static Boolean isTelphone(String mobile){
		boolean flag = false;    
		try{
			String check = "^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$";
		    Pattern regex = Pattern.compile(check);    
		    Matcher m = regex .matcher(mobile);    
		    flag = m.matches();    
		}catch(Exception e){    
		    flag = false;    
		}    
		return flag;
	}
	public static Boolean isEmail(String email){
		boolean flag = false;    
		try{    
		    String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";    
		    Pattern regex = Pattern.compile(check);    
		    Matcher matcher = regex.matcher(email);    
		    flag = matcher.matches();    
		}catch(Exception e){    
		    flag = false;    
		}    
		return flag;
	}
	public static Boolean isIpAddress(String ipAddress){
		boolean flag = false;
		try{
				String check = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."  
                +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."  
                +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."  
                +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$"; 
				// �ѹ�������ģʽ����
				Pattern pattern = Pattern.compile(check);  
				// ͨ��ģʽ����õ�ƥ��������
				Matcher matcher = pattern.matcher(ipAddress);
				flag = matcher.matches();
		}catch(Exception e){
			flag = false; 
		}
	
        return flag;  
	}
	public static void main(String[] args) {
		RE re = new RE();
		Scanner sc = new Scanner(System.in);
		System.out.println("����绰����:");
		String s1 = sc.nextLine();
		System.out.println("���������ַ:");
		String s2 = sc.nextLine();
		System.out.println("��������IP��ַ:");
		String s3 = sc.nextLine();
		System.out.println("�绰���������:\n"+re.isTelphone(s1));
		System.out.println("�����ַ������:\n"+re.isEmail(s2));
		System.out.println("����IP��ַ������:\n"+re.isIpAddress(s3));
	}
}
