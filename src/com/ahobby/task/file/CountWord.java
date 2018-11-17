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
			 * ������ĸ�ַ�ȫ���滻Ϊ�ո��ַ�" " �õ�һ��ȫСд�Ĵ���ĸ�ַ��������пո��ַ�
			*/
			s = s.toLowerCase();// ���ַ����е�Ӣ�Ĳ��ֵ��ַ�ȫ����ΪСд
			String regex = "[\\W]+";// ����ĸ��������ʽ --\W����ʾ����һ���ǵ����ַ�
			s = s.replaceAll(regex, " ");
			String[] strs = s.split(" "); // �Կո���Ϊ�ָ�������ַ�������
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
			* �����ַ���(String)���ִ���(Integer)��ӳ��
			*/
			Map<String, Integer> cache = new HashMap<String, Integer>();
			/*
			 * �����put��������������ͬ�ĵ���,��ô���ж�������ͻ��key�Ƿ����
			 * ������,put�����ͷ���֮ǰ��¼�ĵ��ʵĸ���������in��
			*/
			Integer in = null;
			// �������� strs
			for (String each : strs) {
				in = cache.put(each, 1);
				
				//�����ʵĴ�������,�� "in+1"
				if (in != null) {
					cache.put(each, in + 1);
				}
			}
			//����Set��entrySet(): ����Map.Entry�������ͼ������ӳ���еĹؼ���/ֵ��
			Set<Map.Entry<String, Integer>> set = cache.entrySet();
			
//			System.out.println("����ֵ����ǰ:");
//			for (Map.Entry<String, Integer> e : set) {
//				System.out.println(e.getKey()+" : "+e.getValue());
			
			//��Map.Entry<String,Integer>���͵����ݷ��������У�׼������
			List<Map.Entry<String,Integer>> aList = new LinkedList<Map.Entry<String,Integer>>(set);
			//��������
			//����Comparator�ӿڵ���д--�Ƚ���
			//����ӿھ�һ���������������Ĳ����뷵��ֵ���Ƕ����ġ�
			Collections.sort(aList, new Comparator<Map.Entry<String,Integer>>(){
				
				public int compare(Map.Entry<String, Integer> ele1, Map.Entry<String, Integer> ele2){
				    return ele1.getValue().compareTo(ele2.getValue()); 
				}
			});
			//�����ݷ���LinkedHashMap�а�˳�����У�LinkedHashMap�о��ǰ�˳�����е�
			Map<String,Integer> map1 = new LinkedHashMap<String, Integer>();
		    for(Map.Entry<String,Integer> entry: aList){
		    	map1.put(entry.getKey(), entry.getValue()); 
		    } 
		    System.out.println("map size:"+map1.size());
		    int printNum = map1.size()-10;
		    System.out.println("���ִ�����ߵ�"+printNum+"�����ʵļ���ֵΪ: "); 
		    int p = 0;
		    for(Map.Entry<String,Integer> entry : map1.entrySet()){
		    	if(p>=(printNum)){
		    		System.out.println(entry.getKey() + " : " + entry.getValue());
		    	}
		    	p++;
		    } 
			/*String maxStr = null;// ���ڴ�ų������ĵ���
			int maxValue = 0;// ���ڴ�ų������Ĵ���
			String key = null;
			Integer value;
			for (Map.Entry<String, Integer> e : set) {
				 key = e.getKey();
				 value = e.getValue();
				 p++;
				if (value > maxValue) {
					maxValue = value;// �������Զ���װ��
				    maxStr = key;
				}
			}
			System.out.println("�������ĵ�����:\n" + maxStr + " ������  " + maxValue + " ��");*/
		}
		//@SuppressWarnings("resource")
		public static void main(String[] args) throws FileNotFoundException {
			FileReader f = new FileReader("E:/JAVA/word.txt");
			// ## hyunji scanner not need
			Scanner sc = new Scanner(f);
			String s=null;
			//System.out.println("���ļ��ж�ȡ������Ϊ:");
			s = sc.nextLine();
			//System.out.println(s);
			String[] strs = strTostrArray(s);
			countword(strs);
		}
}
