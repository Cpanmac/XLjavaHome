package com.xl.����;
/*
"sdfgzxcvasdfxcvdf"��ȡ���ַ����е���ĸ���ֵĴ���
ϣ����ӡ�����a(1)c(2)...

������֣�ÿһ���ַ����ж�Ӧ�Ĵ�����˵����ĸ�ʹ�����ӳ���ϵ

ע���ˣ���������ӳ���ϵʱ������ѡ��map����
��Ϊmap�����д�ž���ӳ���ϵ��

˼·��
1.���ַ���ת�����ַ����顣��ΪҪ��ÿһ����ĸ���в�����
2������һ��map���ϣ���Ϊ��ӡ�������ĸ��˳������ʹ��treemap���ϡ�
3�������ַ����顣
	��ÿһ����ĸ��Ϊ��ȥ��map���ϡ�
	�������null��������ĸ��1�洢map�����С�
	������ز��ǿգ�˵������ĸ�Ѿ���map�������Ѿ����ڲ��ж�Ӧ�Ĵ�����ô�ͻ�ȡ�ô���������������Ȼ�󽫸���ĸ��������Ĵ������뵽map������
4.��map�����е����ݱ��ָ�����ַ�����ʽ���ء�
*/
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
class MapTest3 
{
	public static void main(String[] args) 
	{
		String s = charCount("awsdnqwdnaksna");
		
		System.out.println(s);
		
	}
	public static String charCount(String str)
	{
		char[] ch = str.toCharArray();
		int count = 0 ;  //����һ�������������������ѭ������ͻ�һֱ�����ͷš���
		TreeMap<Character,Integer> tm =new TreeMap<Character,Integer>();		
		for (int x=0;x<ch.length;x++ )
		{
			//�������Ĳ�����ĸ��ô��
			if (!(ch[x]>'a'&&ch[x]<'z'  || ch[x]>'A'&&ch[x]<'Z'))  //����ж��� Ϊ�٣��ұ߾Ͳ����ж���
				continue;
		Integer value = tm.get(ch[x]);        //����Tnteger���͵�ֵ
		//ֻ�в��ǿյ�ʱ��ֵ�ͱ仯
		if (value != null)
			count=value;
		count++;
		tm.put(ch[x],count);
		count = 0; //����һ��Ҫ����
		/*�����Ǵ����Ż����
		if (value == null) 
			{
				tm.put(ch[x],1);
			}
			else
			{				
				tm.put(ch[x],++value);   //д����Ͳ���
			}
		*/
		}
		
		
		System.out.println(tm);
		StringBuilder sb =new StringBuilder();			//������ʲô���ܷ�
		Set<Map.Entry<Character,Integer>> entrySet = tm.entrySet();
		Iterator<Map.Entry<Character,Integer>> it = entrySet.iterator();
		while (it.hasNext())
		{
			Map.Entry<Character,Integer> me =it.next();
			Character cha = me.getKey();
			Integer value = me.getValue();
			sb.append(cha+"("+value+")");      //��append
		}		
		//return null; //Ϊ�˱���ͨ��
		return sb.toString();  //��Ϊsb��StringBuilder���ͣ�Ҫת��
	} 
}
