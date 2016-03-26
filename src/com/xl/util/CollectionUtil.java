package com.xl.util;

import org.apache.commons.collections.map.CaseInsensitiveMap;

import java.util.List;
import java.util.Map;

/**
 * ���Ϲ�����
 * Created by �� on 3/25 0025.
 */
public class CollectionUtil {
    /**
     * ��listMapת��Ϊ�������Сд��listMap
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
}
