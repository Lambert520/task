package com.ahobby.task.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CountWord {
		public static String[] strTostrArray(String s) {
			/*
			 * 将非字母字符全部替换为空格字符" " 得到一个全小写的纯字母字符串包含有空格字符
			*/
			s = s.toLowerCase();// 将字符串中的英文部分的字符全部变为小写
			String regex = "[\\W]+";// 非字母的正则表达式 --\W：表示任意一个非单词字符
			s = s.replaceAll(regex, " ");
			String[] strs = s.split(" "); // 以空格作为分隔符获得字符串数组
			return strs;
		 }
		
		
		private static void demo(){
			Map<String, Integer> cache = new HashMap<String, Integer>();
			String key="";
			Integer counter = cache.get(key);
			int value =1; // first default
			if(counter!=null){ //not first
				value = counter +1;
			}
			
			cache.put(key, value);
		}
		
		
		public static void countword(String[] strs) {
			/*
			* 建立字符串(String)出现次数(Integer)的映射
			*/
			Map<String, Integer> cache = new HashMap<String, Integer>();
			/*
			 * 如果用put方法放入两个相同的单词,那么就判断两个冲突的key是否相等
			 * 如果相等,put方法就返回之前记录的单词的个数给变量in。
			*/
			Integer in = null;
			// 遍历数组 strs
			for (String each : strs) {
				in = cache.put(each, 1);
				
				//将单词的次数更新,即 "in+1"
				if (in != null) {
					cache.put(each, in + 1);
				}
			}
			//利用Set的entrySet(): 返回Map.Entry对象的视图集，即映像中的关键字/值对
			Set<Map.Entry<String, Integer>> set = cache.entrySet();
			
//			System.out.println("键和值排序前:");
//			for (Map.Entry<String, Integer> e : set) {
//				System.out.println(e.getKey()+" : "+e.getValue());
			
			//将Map.Entry<String,Integer>类型的内容放入链表中，准备排序
			List<Map.Entry<String,Integer>> aList = new LinkedList<Map.Entry<String,Integer>>(set);
			//进行排序
			//对于Comparator接口的重写--比较器
			//这个接口就一个抽象函数，给出的参数与返回值都是定死的。
			Collections.sort(aList, new Comparator<Map.Entry<String,Integer>>(){
				
				public int compare(Map.Entry<String, Integer> ele1, Map.Entry<String, Integer> ele2){
				    return ele1.getValue().compareTo(ele2.getValue()); 
				}
			});
			//将内容放入LinkedHashMap中按顺序排列，LinkedHashMap中就是按顺序排列的
			Map<String,Integer> map1 = new LinkedHashMap<String, Integer>();
		    for(Map.Entry<String,Integer> entry: aList){
		    	map1.put(entry.getKey(), entry.getValue()); 
		    } 
		    System.out.println("map size:"+map1.size());
		    int printNum = map1.size()-10;
		    System.out.println("出现次数最高的"+printNum+"个单词的键和值为: "); 
		    int p = 0;
		    for(Map.Entry<String,Integer> entry : map1.entrySet()){
		    	if(p>=(printNum)){
		    		System.out.println(entry.getKey() + " : " + entry.getValue());
		    	}
		    	p++;
		    } 
			/*String maxStr = null;// 用于存放出现最多的单词
			int maxValue = 0;// 用于存放出现最多的次数
			String key = null;
			Integer value;
			for (Map.Entry<String, Integer> e : set) {
				 key = e.getKey();
				 value = e.getValue();
				 p++;
				if (value > maxValue) {
					maxValue = value;// 这里有自动拆装箱
				    maxStr = key;
				}
			}
			System.out.println("出现最多的单词是:\n" + maxStr + " 出现了  " + maxValue + " 次");*/
		}
		//@SuppressWarnings("resource")
		public static void main(String[] args) throws FileNotFoundException {
			FileReader f = new FileReader("E:/JAVA/word.txt");
			// ## hyunji scanner not need
			Scanner sc = new Scanner(f);
			String s=null;
			//System.out.println("从文件中读取的内容为:");
			s = sc.nextLine();
			//System.out.println(s);
			String[] strs = strTostrArray(s);
			countword(strs);
		}
}
