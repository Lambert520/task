package com.ahobby.task.file;

import java.io.File;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		File dir = new File("E:/JAVA");
		File f = new File(dir,"word.txt");
		if(f.exists())
			System.out.println("�ļ�����!");
		else{
			if(f.createNewFile())
				System.out.println("�ɹ�");
			else
				System.out.println("ʧ��!");
		}
			
		
	}
}
