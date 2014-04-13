package com.xl.集合;
/*
"sdfgzxcvasdfxcvdf"获取该字符串中的字母出现的次数
希望打印结果：a(1)c(2)...

结果发现，每一个字符都有对应的次数，说明字母和次数有映射关系

注意了，当发现有映射关系时，可以选择map集合
因为map集合中存放就是映射关系。

思路：
1.将字符串转换成字符数组。因为要对每一个字母进行操作。
2。定义一个map集合，因为打印结果的字母有顺序，所以使用treemap集合。
3。遍历字符数组。
	将每一个字母作为键去查map集合。
	如果返回null，将该字母和1存储map集合中。
	如果返回不是空，说明该字母已经在map集合内已经存在并有对应的次数那么就获取该次数并进行自增。然后将该字母和自增后的次数存入到map集合中
4.将map集合中的数据变成指定的字符串形式返回。
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
		int count = 0 ;  //定义一个计数器，如果定义在循环里面就会一直开辟释放。。
		TreeMap<Character,Integer> tm =new TreeMap<Character,Integer>();		
		for (int x=0;x<ch.length;x++ )
		{
			//如果传入的不是字母怎么办
			if (!(ch[x]>'a'&&ch[x]<'z'  || ch[x]>'A'&&ch[x]<'Z'))  //左边判断了 为假，右边就不用判断了
				continue;
		Integer value = tm.get(ch[x]);        //定义Tnteger类型的值
		//只有不是空的时候值就变化
		if (value != null)
			count=value;
		count++;
		tm.put(ch[x],count);
		count = 0; //用完一次要清零
		/*上面是代码优化后的
		if (value == null) 
			{
				tm.put(ch[x],1);
			}
			else
			{				
				tm.put(ch[x],++value);   //写这里就不行
			}
		*/
		}
		
		
		System.out.println(tm);
		StringBuilder sb =new StringBuilder();			//缓冲区什么都能放
		Set<Map.Entry<Character,Integer>> entrySet = tm.entrySet();
		Iterator<Map.Entry<Character,Integer>> it = entrySet.iterator();
		while (it.hasNext())
		{
			Map.Entry<Character,Integer> me =it.next();
			Character cha = me.getKey();
			Integer value = me.getValue();
			sb.append(cha+"("+value+")");      //用append
		}		
		//return null; //为了编译通过
		return sb.toString();  //因为sb是StringBuilder类型，要转换
	} 
}
