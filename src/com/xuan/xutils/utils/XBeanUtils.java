package com.xuan.xutils.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * һЩ�������ַ���,����,���ֵ�У�鹤��
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2017-08-01 ����9:44:21 $
 */
public abstract class XBeanUtils {
    /**
     * Map --> Bean : ����Introspector,PropertyDescriptorʵ�� Map --> Bean
     * map ��value �����ͱ����Ӧ��Bean�е�����
     *
     * @param map
     * @param beanClass �����ṩ������Ĭ�Ϲ��캯��
     * @param <T>
     * @return
     */
    public static <T> T map2Bean(Map<String, Object> map, Class<T> beanClass) {
        T obj;
        try {
            obj = beanClass.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (!map.containsKey(key)) {
                    continue;
                }
                Object value = map.get(key);
                // �õ�property��Ӧ��setter����
                Method setter = property.getWriteMethod();
                setter.invoke(obj, value);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    /**
     * Bean --> Map ����Introspector��PropertyDescriptor ��Bean --> Map,��getClass ���˹���
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> bean2Map(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // ����class����
                if (key.equals("class")) {
                    continue;
                }
                // �õ�property��Ӧ��getter����
                Method getter = property.getReadMethod();
                Object value = getter.invoke(obj);
                map.put(key, value);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
