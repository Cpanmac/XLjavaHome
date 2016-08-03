package com.xl.����;

/*
 * map��չ֪ʶ�� �洢���HashMap���� map���ϱ�ʹ������Ϊ�߱�ӳ���ϵ�� "yureban" "01" "zhangsan"; "yureban" "03" "lisi"; "jiuyeban" 01" "wangwu"; "jiuyeban" "02" "zhaoliu"; һ��ѧУ�ж������ÿ�����Ҷ������ƣ�
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author ����
 * @Description sutdentӵ�бȽ���
 * @date 2014-6-10
 */
class StudentCompareable implements Comparable<StudentCompareable> {
    private String id;
    private String name;
    private int age;

    StudentCompareable(String id, String name) {
        this.name = name;
        this.id = id;
    }

    public int compareTo(StudentCompareable s) {
        int num = new Integer(this.age).compareTo(new Integer(s.age));
        if (num == 0) {
            return this.name.compareTo(s.name);
        }
        return num;
    }
}

public class MapDemo3 {
    public static void getInfos(List<StudentCompareable> list) {
        Iterator<StudentCompareable> it = list.iterator();
        while (it.hasNext()) {
            StudentCompareable s = it.next();
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        /*
         * HashMap<String,HashMap<String,String>> czbk = new
		 * HashMap<String,HashMap<String,String>>(); HashMap<String,String> yure
		 * = new HashMap<String,String>(); HashMap<String,String> jiuye = new
		 * HashMap<String,String>(); czbk.put("yureban",yure);
		 * czbk.put("jiuyeban",jiuye); //�ұ���� yure.put("01","zhangsan");
		 * yure.put("02","lisi"); jiuye.put("01","zhaoliu");
		 * jiuye.put("02","wangwu"); // getStudentInfo(jiuye); //
		 * getStudentInfo(yure); /*
		 * Set<Map.Entry<String,HashMap<String,String>>> entrySet =
		 * czbk.entrySet(); //����Map.Entry�������洢��ֵ
		 * Iterator<Map.Entry<String,HashMap<String,String>>> iter =
		 * entrySet.iterator(); //����MAp.Entry�ĵ����� while (iter.hasNext()) {
		 * Map.Entry<String,HashMap<String,String>> me = iter.next(); //����
		 * Map.Entry���������ܼ�ֵ String key = me.getKey(); //getKey������ߵ�
		 * HashMap<String,String> hm = me.getValue(); //getValue�����ұߵ�
		 * System.out.println("key:"+key+".."+hm); getStudentInfo(hm); }
		 */
        // Set<String> keySet= czbk.keySet(); //��Set���Ͼ�ֱ��ȡ��ߵ�
        // ��ֵ���ұߵ���getStudentInfo
        // Iterator<String> it = keySet.iterator();
        /*
         * Iterator<String> it =czbk.keySet().iterator(); //�������кϳ�һ��
		 * while(it.hasNext()) { String roomName= it.next();
		 * //ȡ�����ҵ����ָ�ֵ��roomName HashMap<String,String> room= czbk.get(roomName);
		 * //����HashMap���� ����ݼ��õ��ұߵ�ֵ System.out.println(roomName);
		 * getStudentInfo(room); }
		 */
    }

    public static void getStudentInfo(HashMap<String, String> roomMap) // ����һ��
    // ���Ҵ����������幦��ȡ��
    {
        Iterator<String> it = roomMap.keySet().iterator();
        while (it.hasNext()) {
            String id = it.next();
            String name = roomMap.get(id);
            System.out.println(id + ":" + name);
        }
    }

    @Test
    public void demo() // һ�����Ҷ�Ӧ�ܶ�Student����
    {
        Map<String, List<StudentCompareable>> czbk = new HashMap<String, List<StudentCompareable>>(); // �ұߵ�ֵ��ΪList��ArrayListҲ����
        List<StudentCompareable> reyu = new ArrayList<StudentCompareable>();
        List<StudentCompareable> jiuye = new ArrayList<StudentCompareable>();
        czbk.put("yureban", reyu);
        czbk.put("jiuyeban", jiuye);
        reyu.add(new StudentCompareable("01", "zhagnsa"));
        reyu.add(new StudentCompareable("04", "wangwu"));
        jiuye.add(new StudentCompareable("01", "zhouqi"));
        jiuye.add(new StudentCompareable("02", "zhaoli"));
        Iterator<String> it = czbk.keySet().iterator(); // �������кϳ�һ��
        while (it.hasNext()) {
            String roomName = it.next(); // ȡ�����ҵ����ָ�ֵ��roomName
            List<StudentCompareable> room = (List<StudentCompareable>) czbk.get(roomName); // �Ͱ�����Ĵ��븴�ƣ���Ϊ
            System.out.println(roomName);
            getInfos(room);
        }
    }
}
