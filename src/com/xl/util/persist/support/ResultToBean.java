package com.xl.util.persist.support;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuming
 * @description 将ResultSet转换为Bean对象
 * @date 2013-9-16 下午12:18:52
 */
public class ResultToBean {
    private Class convertBean;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public List convertResultToBean(Class classBean, ResultSet rs) {
        this.convertBean = classBean;
        List list = new ArrayList();
        Map<String, String> fieldMap = new HashMap<String, String>();
        Map<String, Class> fieldTypeMap = new HashMap<String, Class>();
        Field[] fields = classBean.getDeclaredFields();
        for (Field f : fields) {
            fieldMap.put(f.getName().toLowerCase(), f.getName());
            fieldTypeMap.put(f.getName().toLowerCase(), f.getType());
        }
        try {
            while (rs.next()) {
                Object bean = convertBean.newInstance();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String colName = rs.getMetaData().getColumnName(i);
                    String convertName = convertColumnName(colName);
                    if (fieldMap.containsKey(convertName.toLowerCase())) {
                        String method = "set" + fieldMap.get(convertName.toLowerCase()).substring(0, 1).toUpperCase() + fieldMap.get(convertName.toLowerCase()).substring(1);
                        //						NullableType colType = (NullableType) TypeFactory
                        //						        .basic(((Class) fieldTypeMap.get(convertName
                        //						                .toLowerCase())).getName());
                        //						bean.getClass()
                        //						        .getMethod(
                        //						                method,
                        //						                fieldTypeMap.get(convertName
                        //						                        .toLowerCase()))
                        //						        .invoke(bean, colType.get(rs, colName));
                    }
                }
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //		} catch (InvocationTargetException e) {
            //			// TODO Auto-generated catch block
            //			e.printStackTrace();
            //		} catch (NoSuchMethodException e) {
            //			// TODO Auto-generated catch block
            //			e.printStackTrace();
        }
        return list;
    }

    public String convertColumnName(String columnName) {
        char[] cols = columnName.toLowerCase().toCharArray();
        boolean upCase = false;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < cols.length; i++) {
            if (cols[i] == '_') {
                upCase = true;
            } else {
                if (upCase) {
                    sb.append(String.valueOf(cols[i]).toUpperCase());
                    upCase = false;
                } else {
                    sb.append(cols[i]);
                }
            }
        }
        return sb.toString();
    }

    /**
     * @return the convertBean
     */
    public Class getConvertBean() {
        return convertBean;
    }

    /**
     * @param convertBean the convertBean to set
     */
    public void setConvertBean(Class convertBean) {
        this.convertBean = convertBean;
    }
}
