package com.xl.a;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.xl.util.FileUtil;

/**
 * @Decription 思路:1.获取源文件:遍历源目录下所有的文件加入集合中,缓存文件不加.dbk<br/>
 *             2.遍历源集合<br/>
 *             3.移动文件:得到源文件的相对源目录的目录<br/>
 *             4.判断目标是否存在该目录,没有则创建<br/>
 *             5.移动文件,不移动的条件:缓存.dbk<br/>
 *             6.移动
 * 
 * 
 * 
 * @date 2013-12-24
 * 
 * @author 徐立
 * 
 */
public class 移动桌面的文件 {
	private String srcDir = "C:/Users/Administrator/Desktop/网络工程师教学视频";

	private String targetDir = "G:/网络工程师教学视频";

	@Test
	public void test() {
		srcDir = "C:/Users/Administrator/Desktop/linux视频教程1";
		targetDir = "G:/linux视频教程1";
		File srcFile = new File(srcDir);
		List<File> list = getSrcFiles(srcFile);
		for (int i = 0; i < list.size(); i++) {
			String relativePath = getRelativePath(list.get(i));
			// 创建目标文件
			File targetFile = new File(targetDir, relativePath);
			if (targetFile.exists()) {
				System.out.println(targetFile.getAbsolutePath() + "已经存在");
				continue;
			} else if (targetFile.getAbsolutePath().endsWith(".dbk")) {
				continue;
			}

			else if (!targetFile.getParentFile().exists()) {
				targetFile.getParentFile().mkdirs();
			}
			list.get(i).renameTo(targetFile);
			System.out.println(list.get(i).getAbsolutePath() + "移动到"
					+ targetFile.getAbsolutePath());
		}
	}

	/**
	 * 得到相对路径
	 * 
	 * @param srcFile
	 * @return String
	 */
	public String getRelativePath(File srcFile) {
		if (srcFile.isFile()) {
			String src1 = srcFile.getAbsolutePath();
			// 1.得到源文件的相对路径
			String src2 = src1.substring(src1.lastIndexOf(srcDir)
					+ srcDir.length() + 2);
			return src2;
		} else {
			throw new RuntimeException("这不是文件");
		}
	}

	/**
	 * 得到源文件的集合
	 * 
	 * @param srcFile
	 * @return List<File>
	 */
	public List<File> getSrcFiles(File srcFile) {
		ArrayList<File> list = new ArrayList<File>();
		FileUtil.queryAll(list, srcFile);
		return list;
	}

	public boolean isMove(String src, File file, File targetFile) {
		// 得到源路径
		String _file = file.getAbsolutePath();
		_file = _file.substring(_file.lastIndexOf(src) + src.length() + 1);
		if (_file.equals(targetFile.getName())) {
			return true;
		} else {
			return false;
		}
	}
}
