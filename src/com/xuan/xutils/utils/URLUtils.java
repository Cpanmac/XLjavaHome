package com.xuan.xutils.utils;

import com.xuan.xutils.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * URL ������
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����9:58:48 $
 */
public abstract class URLUtils {
    private static final char AND_SIGN = '&';
    private static final char EQUALS_SIGN = '=';
    private static final char POINT_SIGN = '.';
    private static final char QUESTION_MARK = '?';
    private static final char SEPARATOR_SIGN = '/';
    private static int BUFFER_SIZE = 1024 * 4; // 4K
    private static String charSet = "UTF-8";

    /**
     * ������ĸ��
     *
     * @param charSet
     */
    public static void setCharSet(String charSet) {
        URLUtils.charSet = charSet;
    }

    /**
     * ƴ��URL������ֵ��obj��ͨ������ȡ��
     *
     * @param url   URL
     * @param obj   ����
     * @param names ����������
     * @return ƴ�Ӻ��URL
     */
    @SuppressWarnings("rawtypes")
    public static String addInnerQueryString(String url, Object obj, String[] names) {
        Class objClass = obj.getClass();
        Object[] values = new Object[names.length];
        for (int i = 0; i < names.length; i++) {
            try {
                Field field = objClass.getDeclaredField(names[i]);
                field.setAccessible(true);
                values[i] = field.get(obj);
            } catch (Exception e) {
                // Ignore
            }
        }
        return addQueryString(url, names, values);
    }

    /**
     * ƴ��URL
     *
     * @param url         URL
     * @param queryString ��ѯ�ַ��������磺id=1
     * @return ƴ�Ӻ��URL
     */
    public static String addQueryString(String url, String queryString) {
        if (Validators.isEmpty(queryString)) {
            return url;
        }
        if (url.indexOf(QUESTION_MARK) == -1) {
            url = url + QUESTION_MARK + queryString;
        } else {
            url = url + AND_SIGN + queryString;
        }
        return url;
    }

    /**
     * ƴ��URL
     *
     * @param url   URL
     * @param name  ����������
     * @param value ������ֵ
     * @return ƴ�Ӻ��URL
     */
    public static String addQueryString(String url, String name, Object value) {
        return addQueryString(url, new String[]{name}, new Object[]{value});
    }

    /**
     * ƴ�� URL��
     *
     * @param url    URL
     * @param names  ��������������
     * @param values ������ֵ����
     * @return ƴ�Ӻ��URL
     */
    public static String addQueryString(String url, String[] names, Object[] values) {
        if (names.length != values.length) {
            throw new IllegalArgumentException("Length of array must be equal");
        }
        StringBuilder queryString = new StringBuilder();
        boolean isFirst = true;
        for (int i = 0; i < names.length; i++) {
            Object value = values[i];
            if (value != null) {
                if (!isFirst) {
                    queryString.append(AND_SIGN);
                } else {
                    isFirst = false;
                }
                if (value instanceof Object[]) {
                    Object[] array = (Object[]) value;
                    for (int j = 0; j < array.length; j++) {
                        if (j > 0) {
                            queryString.append(AND_SIGN);
                        }
                        appendParameter(queryString, names[i], array[j]);
                    }
                } else if (value instanceof Collection<?>) {
                    int j = 0;
                    Collection<?> clc = (Collection<?>) value;
                    Iterator<?> iterator = clc.iterator();
                    while (iterator.hasNext()) {
                        if (j++ > 0) {
                            queryString.append(AND_SIGN);
                        }
                        appendParameter(queryString, names[i], iterator.next());
                    }
                } else {
                    appendParameter(queryString, names[i], value);
                }
            }
        }
        return addQueryString(url, queryString.toString());
    }

    /**
     * �� url ����ָ�����뷽ʽ���롣
     *
     * @param url
     * @param encoding
     * @return
     */
    public static String decode(String url, String encoding) {
        try {
            return URLDecoder.decode(url, encoding);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * ʹ URL ��Ϊ��̬ URL�����û���ʺž����������ʺš�
     *
     * @param url
     * @return
     */
    public static String dynamicURL(String url) {
        if (url.indexOf(QUESTION_MARK) == -1) {
            url = url + QUESTION_MARK;
        }
        return url;
    }

    /**
     * �� url ����ָ�����뷽ʽ���롣
     *
     * @param url
     * @param encoding
     * @return
     */
    public static String encode(String url, String encoding) {
        try {
            return URLEncoder.encode(url, encoding);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * ͨ��servletPathȡ��action������
     *
     * @param servletPath
     * @return
     */
    public static String getActionName(String servletPath) {
        return servletPath.substring(servletPath.lastIndexOf(SEPARATOR_SIGN) + 1, servletPath.lastIndexOf(POINT_SIGN));
    }

    /**
     * ȡ��url�ĺ�׺��
     *
     * @param url
     * @return
     */
    public static String getExtension(String url) {
        int pointIndex = url.indexOf(POINT_SIGN);
        if (pointIndex == -1) {
            return null;
        }
        int interrogationIndex = url.indexOf(QUESTION_MARK);
        return interrogationIndex == -1 ? url.substring(pointIndex + 1) : url.substring(pointIndex + 1, interrogationIndex);
    }

    /**
     * ͨ��servletPath���namespace
     *
     * @param servletPath
     * @return
     */
    public static String getNamespace(String servletPath) {
        return servletPath.substring(0, servletPath.lastIndexOf(SEPARATOR_SIGN));
    }

    /**
     * ����URL�е�ĩβ��'/'����.
     *
     * @param url url��ַ�ַ���
     * @return ����ĩβ'/'���ź��url��ַ.
     */
    public static String ignoreLastRightSlash(String url) {
        if (Validators.isEmpty(url)) {
            return url;
        }
        // ĩβ�ַ��Ƿ�Ϊ'/', ������ȥ��
        if (url.charAt(url.length() - 1) == SEPARATOR_SIGN) {
            return url.substring(0, url.length() - 1);
        }
        return url;
    }

    /**
     * ����ҳ��URL�����������
     *
     * @param pageURL ҳ��URL
     * @return ������
     * @throws IOException
     */
    public static InputStream visitContent(String pageURL) throws IOException {
        URL url = new URL(pageURL);
        HttpURLConnection client = (HttpURLConnection) url.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        client.setInstanceFollowRedirects(false);
        client.connect();
        return client.getInputStream();
    }

    /**
     * ����ҳ��URL�����ҳ������
     *
     * @param pageURL ҳ��URL
     * @return ҳ������
     * @throws IOException
     */
    public static String readContent(String pageURL) throws IOException {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = visitContent(pageURL);
            out = new ByteArrayOutputStream();
            byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
            return new String(out.toByteArray());
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
    }

    /**
     * ��URL�з����ַ����������ŵ�һ�� map �
     *
     * @param url URL
     * @return map����ŵĶ����ַ����ļ�ֵ��
     */
    public static Map<String, String> getParameters(String url) {
        HashMap<String, String> parameters = new HashMap<String, String>();
        if (Validators.isEmpty(url)) {
            return parameters;
        }
        int questionMarkIndex = url.indexOf(QUESTION_MARK);
        if (questionMarkIndex == -1 || questionMarkIndex == url.length() - 1) {
            return parameters;
        }
        String queryString = url.substring(questionMarkIndex + 1);
        String[] paramArray = queryString.split(String.valueOf(AND_SIGN));
        for (int i = 0; i < paramArray.length; i++) {
            int equalsSignIndex = paramArray[i].indexOf(EQUALS_SIGN);
            if (equalsSignIndex == -1) {
                continue;
            }
            String paramName = paramArray[i].substring(0, equalsSignIndex);
            String paramValue = paramArray[i].substring(equalsSignIndex + 1);
            parameters.put(paramName, paramValue);
        }
        return parameters;
    }

    /**
     * ����url����baseURL��ͷ�Ĳ���ȥ�������̵�url������"/"��ͷ��
     *
     * @param url
     * @param baseURL
     * @return
     */
    public static String shortenURL(String url, String baseURL) {
        url = StringUtils.trim(url);
        baseURL = StringUtils.trim(baseURL);
        if (baseURL != null && baseURL.endsWith(String.valueOf(SEPARATOR_SIGN))) {
            baseURL = baseURL.substring(0, baseURL.length() - 1);
        }
        return !Validators.isEmpty(url) && !Validators.isEmpty(baseURL) && url.startsWith(baseURL) ? url.substring(baseURL.length()) : url;
    }

    /**
     * ��ѯ�ַ����������Ӳ���
     *
     * @param queryString ��ѯ�ַ��������磺id=1&type=1
     * @param name        ����������
     * @param value       ������ֵ
     * @return ƴ�Ӻ�Ĳ�ѯ�ַ���
     */
    private static StringBuilder appendParameter(StringBuilder queryString, String name, Object value) {
        queryString.append(name);
        queryString.append(EQUALS_SIGN);
        if (value instanceof Boolean) {
            value = ((Boolean) value).booleanValue() ? "1" : "0";
        } else if (value instanceof Date) {
            value = DateUtils.date2StringByDay((Date) value);
        }
        try {
            queryString.append(URLEncoder.encode(String.valueOf(value), charSet));
        } catch (UnsupportedEncodingException e) {
            // ignore
        }
        return queryString;
    }
}
