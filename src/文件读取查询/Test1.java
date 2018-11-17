package 文件读取查询;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Test1 {
		public static void main(String[] args) throws IOException {
			FileReader f = new FileReader("E:/JAVA/word.txt");
			Scanner sc = new Scanner(f);
			//HashMap hm = new HashMap();
			TreeMap tm = new TreeMap();
			//char [] c = null;
			int p=0;
			String s1 = null;
			String s2 [] = null; 
			while(sc.hasNextLine()){
				
				s2[p++] = sc.nextLine();
				
//				for(int j=0;j<s1.length();j++){
//						c = s1.toCharArray();
//					}
//				hm.put(s1,s1);   //把元素加入映射
			}
			for(int i=0;i<s2.length;i++)
					System.out.println(s2[i]);
			//得到映射项的集合
//			Set set = hm.entrySet();
//			Iterator i = set.iterator();
//			while(i.hasNext()){
//				//for(int m=0;m<s1.length();m++)
//					Map.Entry word = (Map.Entry) i.next();
//				System.out.print(word.getKey()+" : ");
//				System.out.println(word.getValue());
//			}
		}
}
