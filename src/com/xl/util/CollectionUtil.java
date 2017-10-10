package com.xl.util;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.map.CaseInsensitiveMap;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 集合工具类
 * Created by 立 on 3/25 0025.
 */
public class CollectionUtil {
    /**
     * 将listMap转化为不区别大小写的listMap
     *
     * @param listMap
     */
    public static List<Map> convertListMapToCaseInsensitiveListMap(List<Map> listMap) {
        if (listMap != null) {
            for (int i = 0; i < listMap.size(); i++) {
                Map map = listMap.get(i);
                Map result = new CaseInsensitiveMap(map);
                listMap.remove(i);
                listMap.add(i, result);
            }
        }
        return listMap;
    }

    /**
     * 将Object转为map
     *
     * @param object
     * @return
     */
    public static Map toMap(Object object) {
        CaseInsensitiveMap _result = new CaseInsensitiveMap();
        if (object != null) {
            if (object instanceof Map) {
                _result.putAll((Map) object);
            } else {
                PropertyDescriptor[] _props = PropertyUtils.getPropertyDescriptors(object);
                int i = 0;
                for (int length = _props.length; i < length; ++i) {
                    PropertyDescriptor _prop = _props[i];
                    try {
                        if (_prop.getReadMethod() != null) {
                            Object ex = PropertyUtils.getProperty(object, _prop.getName());
                            _result.put(_prop.getName(), ex);
                        }
                    } catch (Exception var7) {
                        var7.printStackTrace();
                    }
                }
            }
        }
        return _result;
    }

    /**
     * 将list集合转化map集合
     *
     * @param keyPropName
     * @param list        map中的key
     * @return
     */
    public static Map toMap(String keyPropName, List<Map> list) {
        HashMap _result = new HashMap();
        if (list != null) {
            Iterator i$ = list.iterator();
            while (i$.hasNext()) {
                Object object = i$.next();
                try {
                    Object e = PropertyUtils.getProperty(object, keyPropName);
                    _result.put(e, object);
                } catch (Exception var6) {
                    var6.printStackTrace();
                }
            }
        }
        return _result;
    }

}
