package com.xl.a;

import java.io.File;

public class 查到文件
{

}

class Demo1 implements Runnable{

	@Override
	public void run()
	{
		
	}
	public void find(String str){
		File file=new File("d:\\");
		File[] files=file.listFiles();
		for(File f:files){
			if(f.isFile()){
			}
		}
	}
	
}