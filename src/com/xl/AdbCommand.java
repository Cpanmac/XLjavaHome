package com.xl;
import com.xl.util.SystemUtil;

/**
 * @Decription ���뵽�ֻ� 1.Դ: 2.Ŀ��:
 * 
 * @date 2013-12-20
 * 
 * @author ����
 * 
 */
public class AdbCommand {
	/** ԴĿ�����·�� */
	private String srcPath;
	/** Ŀ��ľ���·�� */
	private String targetPath = "/mnt/sdcard/1/";

	public AdbCommand(String srcPath) {
		this.srcPath = srcPath;
	}

	public AdbCommand(String srcPath, String targetPath) {
		this.srcPath = srcPath;
		this.targetPath = targetPath;
	}

	public static void main(String[] args) {
		System.out.println(SystemUtil.getShellInfo("adb devices"));
		String src = "d:/1";
		AdbCommand a = new AdbCommand(src);
	}

	public void moveToPhone() {
		SystemUtil.getShellInfo("adb push " + srcPath + " " + targetPath);
	}

}
