package com.xl.���߳�;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import com.xl.util.FileTool;
import com.xl.util.StreamTool;

/**
 * @Decription
 * 
 * @date 2014-2-24
 * 
 * @author ����
 * 
 */
public class ���߳����� {
	/** ����·�� */
	public static final String path = "http://www.hao123.com";
	private static Object obj = new ���߳�����();

	public static void main(String[] args) throws Exception {
		/** �����ļ�����·�� */
		File file;
		URL url = new URL(path);
		file = new File(FileTool.getCurrentPath(obj), "1.html");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5000);
		conn.setRequestProperty("User-Agent",
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
		int code = conn.getResponseCode();
		if (code == 200) {
			int len = conn.getContentLength();
			// 1.���ñ����ļ���С�����������ļ���Сһ��
			RandomAccessFile raf = new RandomAccessFile(file, "rwd");
			raf.setLength(len);
			// 2 .���迪��3 ���߳�
			int threadnumber = 3;
			int blocksize = len / threadnumber;
			/**
			 * �߳�1 0~ blocksize �߳�2 1*bolocksize ~ 2*blocksize �߳�3 2*blocksize ~
			 * �ļ�ĩβ
			 */
			for (int i = 0; i < threadnumber; i++) {
				int startposition = i * blocksize;
				int endpositon = (i + 1) * blocksize;
				if (i == (threadnumber - 1)) {
					// ���һ���߳�
					endpositon = len;
				}

				DownLoadTask task = new DownLoadTask(i, path,
						file.getAbsolutePath(), startposition, endpositon);
				task.start();
			}

		}

	}

	public static String getFilenName(String path) {
		int start = path.lastIndexOf("/") + 1;
		return path.substring(start, path.length());
	}

}

/**
 * @Decription �ϵ�����
 * 
 * @date 2014-2-24
 * 
 * @author ����
 * 
 */
class DownLoadTask extends Thread {
	/** �߳�id */
	private int threadid;
	/** url����·�� */
	private String urlPath;
	/** ���ص��ļ���·�� */
	private String filePath;
	int startposition;
	int endpositon;

	public DownLoadTask(int threadid, String urlPath, String filePath,
			int startposition, int endpositon) {
		super();
		this.threadid = threadid;
		this.urlPath = urlPath;
		this.filePath = filePath;
		this.startposition = startposition;
		this.endpositon = endpositon;
	}

	@Override
	public void run() {
		try {
			// ʵ�ֶϵ������м�File���߳�id��������¼�ļ�λ��
			File postionfile = new File(FileTool.getCurrentPath(this),
					+threadid + ".txt");
			URL url = new URL(urlPath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			System.out.println("�߳�" + threadid + "�������� " + "��ʼλ�� : "
					+ startposition + "����λ�� " + endpositon);

			if (postionfile.exists()) {
				FileInputStream fis = new FileInputStream(postionfile);
				byte[] result = StreamTool.getBytes(fis);
				int newstartposition = Integer.parseInt(new String(result));
				if (newstartposition > startposition) {
					startposition = newstartposition;
				}
			}

			// "Range", "bytes=2097152-4194303")
			conn.setRequestProperty("Range", "bytes=" + startposition + "-"
					+ endpositon);
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);
			conn.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			InputStream is = conn.getInputStream();
			// ���� ���ݴ��ļ��ĸ�λ�ÿ�ʼд
			RandomAccessFile file = new RandomAccessFile(filePath, "rwd");
			file.seek(startposition);
			byte[] buffer = new byte[1024];
			int len = 0;
			// ����ǰ�����ķ��������ݵ�λ�� ,ͬʱ���ֵ�Ѿ��洢���ļ���λ��
			int currentPostion = startposition;
			// ����һ���ļ����� ,��¼��ǰĳ���ļ�������λ��

			while ((len = is.read(buffer)) != -1) {
				file.write(buffer, 0, len);
				currentPostion += len;
				// ��Ҫ��currentPostion ��Ϣ���־û����洢�豸
				String position = currentPostion + "";
				// ��������������write error
				FileOutputStream fos = new FileOutputStream(postionfile);
				fos.write(position.getBytes());
				fos.flush();
				fos.close();
			}

			file.close();
			System.out.println("�߳�" + threadid + "�������");
			// ���߳�������Ϻ� ���ļ�ɾ����
			if (postionfile.exists()) {
				postionfile.delete();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		super.run();
	}
}
