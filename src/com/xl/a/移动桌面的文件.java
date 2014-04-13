package com.xl.a;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.xl.util.FileUtil;

/**
 * @Decription ˼·:1.��ȡԴ�ļ�:����ԴĿ¼�����е��ļ����뼯����,�����ļ�����.dbk<br/>
 *             2.����Դ����<br/>
 *             3.�ƶ��ļ�:�õ�Դ�ļ������ԴĿ¼��Ŀ¼<br/>
 *             4.�ж�Ŀ���Ƿ���ڸ�Ŀ¼,û���򴴽�<br/>
 *             5.�ƶ��ļ�,���ƶ�������:����.dbk<br/>
 *             6.�ƶ�
 * 
 * 
 * 
 * @date 2013-12-24
 * 
 * @author ����
 * 
 */
public class �ƶ�������ļ� {
	private String srcDir = "C:/Users/Administrator/Desktop/���繤��ʦ��ѧ��Ƶ";

	private String targetDir = "G:/���繤��ʦ��ѧ��Ƶ";

	@Test
	public void test() {
		srcDir = "C:/Users/Administrator/Desktop/linux��Ƶ�̳�1";
		targetDir = "G:/linux��Ƶ�̳�1";
		File srcFile = new File(srcDir);
		List<File> list = getSrcFiles(srcFile);
		for (int i = 0; i < list.size(); i++) {
			String relativePath = getRelativePath(list.get(i));
			// ����Ŀ���ļ�
			File targetFile = new File(targetDir, relativePath);
			if (targetFile.exists()) {
				System.out.println(targetFile.getAbsolutePath() + "�Ѿ�����");
				continue;
			} else if (targetFile.getAbsolutePath().endsWith(".dbk")) {
				continue;
			}

			else if (!targetFile.getParentFile().exists()) {
				targetFile.getParentFile().mkdirs();
			}
			list.get(i).renameTo(targetFile);
			System.out.println(list.get(i).getAbsolutePath() + "�ƶ���"
					+ targetFile.getAbsolutePath());
		}
	}

	/**
	 * �õ����·��
	 * 
	 * @param srcFile
	 * @return String
	 */
	public String getRelativePath(File srcFile) {
		if (srcFile.isFile()) {
			String src1 = srcFile.getAbsolutePath();
			// 1.�õ�Դ�ļ������·��
			String src2 = src1.substring(src1.lastIndexOf(srcDir)
					+ srcDir.length() + 2);
			return src2;
		} else {
			throw new RuntimeException("�ⲻ���ļ�");
		}
	}

	/**
	 * �õ�Դ�ļ��ļ���
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
		// �õ�Դ·��
		String _file = file.getAbsolutePath();
		_file = _file.substring(_file.lastIndexOf(src) + src.length() + 1);
		if (_file.equals(targetFile.getName())) {
			return true;
		} else {
			return false;
		}
	}
}
