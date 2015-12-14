package com.xl.util;

import java.io.File;
import java.net.URISyntaxException;

/**
 * 
 * Title: Tools Description: �ַ������������
 * 
 * @author ����
 * @version 1.0
 */

public class Tools {
	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(Object str) {
		if (null == str || "".equals(str) || "null".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * �ն�����
	 * 
	 * @param ob
	 * @return
	 */
	public static String checkNull(Object ob) {
		if ((null == ob) || ("null".equals(ob)) || ("".equals(ob))) {
			return "";
		} else {
			return ob.toString();
		}
	}

	/**
	 * 
	 * @param outMode
	 * @param outInfo
	 */
	public static void logToControl(String outMode, Object outInfo) {
		// ����ERR���ӡ��ɫ���������Ϣ
		if ("err".equals(outMode)) {
			System.err.println(outInfo);
		} else {
			System.out.println(outInfo);
		}
	}

	/**
	 * �õ���ǰ����·��
	 * 
	 * @return
	 */
	@Deprecated
	public static String getClassPath() {
		String path = "";
		try {
			path = System.getProperty("user.dir");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return path;
	}

	/**
	 * �õ�ClassPath�ľ���·��:web ����classes·��
	 * 
	 * @return
	 */
	public static String getWebClassPath() {
		String result = null;
		try {
			File file = new File(Tools.class.getClassLoader().getResource("/")
					.toURI());
			result = file.getAbsolutePath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ��ȡweb����·����
	 * 
	 * @return
	 */
	public static String getWebPath() {
		String s = getWebClassPath();
		String m = rLeft(s, "WEB-INF");
		return m;
	}

	/**
	 * ����ת��
	 * 
	 * @param tmpStr
	 *            string
	 * @return string
	 */
	public static String toChinese(String strvalue) {
		try {
			if (null == strvalue)
				return "";
			else {
				strvalue = new String(strvalue.getBytes("ISO8859-1"), "gbk");
				return strvalue;
			}
		} catch (Exception e) {
			return "";
		}

	}

	/*
	 * �ַ����滻���������ִ�Сд
	 * 
	 * @param sourceStr String ԭʼ�ַ���
	 * 
	 * @param oldString String Ҫ���滻���ַ��� @param newString String �滻���ַ��� @return
	 * String �����滻����ַ��� replaceStr("1234K5678","K","8888");123488885678
	 */

	public static final String replaceStr1(String sourceStr, String oldString,
			String newString) {
		if (null == sourceStr) {
			return null;
		}

		int i = 0;
		if ((i = sourceStr.indexOf(oldString, i)) >= 0) {
			char[] line2 = sourceStr.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = sourceStr.indexOf(oldString, i)) > 0) {
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return sourceStr;
	}

	/*
	 * ���ұ�����ȡ�ָ�����ߵ�ֵ
	 * 
	 * @param sourceԭʼ�ı� @param sep�ָ��� rLeft("1234K5678","K");1234
	 */
	public static String rLeft(String source, String sep) {
		source = source.toLowerCase();
		sep = sep.toLowerCase();
		String retstr = "";
		int len = source.length();
		int len1 = sep.length();
		int len2 = len - len1;
		for (int i = len2 - 1; i >= 0; i--) {
			if (source.substring(i, i + len1).equals(sep)) {
				retstr = source.substring(0, i);
				break;
			}
		}
		return retstr;
	}

	/*
	 * ���ұ�����ȡ�ָ����ұߵ�ֵ
	 * 
	 * @param sourceԭʼ�ı� @param sep�ָ���
	 * 
	 * rRight("1234K5678","K");5678
	 */
	public static String rRight(String source, String sep) {
		source = source.toLowerCase();
		sep = sep.toLowerCase();
		String retstr = "";
		int len = source.length();
		int len1 = sep.length();
		int len2 = len - len1;
		for (int i = len2 - 1; i >= 0; i--) {
			if (source.substring(i, i + len1).equals(sep)) {
				retstr = source.substring(i + len1, len);
				break;
			}
		}
		return retstr;
	}

	public static void main(String args[]) {
		String s = "E:\\workproject\\JspXMLProject\\WebRoot\\WEB-INF\\classes";
		String m = rLeft(s, "Webroot");
		System.out.println("m==" + m);

	}
}
