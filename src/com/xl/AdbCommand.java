package com.xl;
import com.xl.util.SystemUtil;

/**
 * @Decription 导入到手机 1.源: 2.目的:
 * 
 * @date 2013-12-20
 * 
 * @author 徐立
 * 
 */
public class AdbCommand {
	/** 源目标绝对路径 */
	private String srcPath;
	/** 目标的绝对路径 */
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
