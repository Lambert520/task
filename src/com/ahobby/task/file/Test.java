package com.ahobby.task.file;

import java.io.File;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		File dir = new File("E:/JAVA");
		File f = new File(dir,"word.txt");
		if(f.exists())
			System.out.println("文件存在!");
		else{
			if(f.createNewFile())
				System.out.println("成功");
			else
				System.out.println("失败!");
		}
			
		
	}
}
