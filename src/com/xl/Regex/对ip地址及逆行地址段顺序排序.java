package com.xl.Regex;

import java.util.TreeSet;

/*
 192.68.1.254  102.29.23.013  10.10.10.10  2.2.2.2  8.109.90.30
 �������ַ�����Ȼ����ֻҪ������ÿһ�ζ���3λ���ɡ�
 1.����ÿһ����Ҫ������0���в��룬��ôÿһ�ξͻ����ٱ�֤��λ
 2.��ÿһ��ֻ����3λ�����������е�ip��ַ����ÿһ��3λ
 */
public class ��ip��ַ�����е�ַ��˳������
{
public static void main(String[] args)
{
	ipSort();
}
	public static void ipSort(){
		String ip="192.68.1.254  102.29.23.013  10.10.10.10  2.2.2.2  8.109.90.30";
		ip=ip.replaceAll("(\\d+)","00$1");   //Ҫ���þͷ�װ����
		System.out.println(ip);
		ip=ip.replaceAll("0*(\\d{3})","$1");  //ȡ�ұߵ�3λ
		System.out.println(ip);
		String[] arr =ip.split(" ");
		/*
//		����һ��
		Arrays.sort(arr);
		for(String s:arr){
			System.out.println(s.replaceAll("0*(\\d+)","$1"));
		}
		*/
		//��������
		TreeSet<String>  ts=new TreeSet<String>();
		for(String s:arr){
			ts.add(s);
		}
		for(String s:ts)
		{
			System.out.println(s.replaceAll("0*(\\d+)","$1"));//������λ��֪��  0����һ�λ���0*
		}
	}
}
