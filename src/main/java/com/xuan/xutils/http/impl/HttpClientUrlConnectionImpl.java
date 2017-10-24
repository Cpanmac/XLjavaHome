package com.xuan.xutils.http.impl;

import com.xuan.xutils.http.HttpClient;
import com.xuan.xutils.http.HttpRequest;
import com.xuan.xutils.http.HttpResponse;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * ��UrlConnect��ʽʵ��HTTP����
 * <p>
 * Created by xuan on 16/2/24.
 */
public class HttpClientUrlConnectionImpl implements HttpClient {
    /**
     * �����ֽ���
     */
    private static final int BUFFER_SIZE = 1024;
    /**
     * ��POST�ύ
     */
    private static final String METHOD_POST = "POST";

    /**
     * ��������ŵ��������
     *
     * @param conn
     * @param request
     */
    private static void putBodyEntityToOutputStream(HttpURLConnection conn, HttpRequest request) {
        try {
            UrlMultipartEntity bodyEntity = new UrlMultipartEntity();
            bodyEntity.writeDataToBody(conn, request);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * ��Json�ĸ�ʽ����������
     *
     * @param conn
     * @param request
     */
    private static void putParamsToOutputStreamForJson(HttpURLConnection conn, HttpRequest request) {
        String bodyJson = request.getBodyJson();
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(conn.getOutputStream());
            //dos.writeBytes(bodyJson);
            dos.write(bodyJson.getBytes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                dos.flush();
                dos.close();
            } catch (Exception e) {
                //Ignore
            }
        }
    }

    /**
     * �Ѳ���������ͨ���ŵ�OutputStream��ȥ
     *
     * @param conn
     * @param request
     */
    private static void putParamsToOutputStream(HttpURLConnection conn, HttpRequest request) {
        String paramStr = request.getParamsStr();
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(conn.getOutputStream());
            //dos.writeBytes(paramStr);
            dos.write(paramStr.getBytes());
        } catch (Exception e) {
        } finally {
            try {
                dos.flush();
                dos.close();
            } catch (Exception e) {
                //Ignore
            }
        }
    }

    /**
     * ��ȡ���Ϊ�ļ�
     *
     * @param conn
     * @param request
     * @return
     */
    private static HttpResponse readResponseForFile(HttpURLConnection conn, HttpRequest request) {
        boolean hasListener = false;
        if (null != request.getDownloadListener()) {
            //���������ؼ���,��Ҫ��ѹ���ķ�ʽ����,����������ǰ������ļ���С
            hasListener = true;
        }
        HttpResponse response = new HttpResponse();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        InputStream inStream = null;
        try {
            inStream = conn.getInputStream();
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            int curCount = 0;//��ǰ�ֽ���
            int total = -1;//���ֽ���
            if (hasListener) {
                total = conn.getContentLength();
            }
            while ((len = inStream.read(buffer)) != -1) {
                curCount += len;
                if (hasListener) {
                    // �����лص�
                    request.getDownloadListener().callBack(total, curCount, false);
                }
                outStream.write(buffer, 0, len);
            }
            if (hasListener) {
                // �����лص�
                request.getDownloadListener().callBack(total, curCount, true);
            }
            response.setStatusCode(conn.getResponseCode());
            response.setReasonPhrase(conn.getResponseMessage());
            byte[] data = outStream.toByteArray();
            File file = new File(request.getDownloadFileName());
            com.xuan.xutils.io.FileUtils.writeByteArrayToFile(file, data, false);
            response.setResultFile(file);
        } catch (Exception e) {
            response.setStatusCode(HttpResponse.STATUS_CODE_FAIL);
            response.setReasonPhrase(e.getMessage());
        } finally {
            try {
                outStream.close();
                inStream.close();
            } catch (Exception e) {
                //Ignore
            }
        }
        return response;
    }

    /**
     * ��HttpURLConnection�����ж�ȡ����,��ʹ��ָ���ı�����б�����ַ���
     *
     * @param conn
     * @param encode
     * @return
     */
    private static HttpResponse readResponseForString(HttpURLConnection conn, String encode) {
        HttpResponse response = new HttpResponse();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        InputStream inStream = null;
        try {
            inStream = conn.getInputStream();
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            byte[] data = outStream.toByteArray();
            response.setStatusCode(conn.getResponseCode());
            response.setReasonPhrase(conn.getResponseMessage());
            response.setResultStr(new String(data, encode));
        } catch (Exception e) {
            response.setStatusCode(HttpResponse.STATUS_CODE_FAIL);
            response.setReasonPhrase(e.getMessage());
        } finally {
            try {
                outStream.close();
                inStream.close();
            } catch (Exception e) {
                //Ignore
            }
        }
        return response;
    }

    @Override
    public HttpResponse getDowload(HttpRequest request) {
        try {
            URL url = new URL(request.getGetUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            initRequest(conn, request);
            return readResponseForFile(conn, request);
        } catch (Exception e) {
            e.printStackTrace();
            HttpResponse response = new HttpResponse();
            response.setStatusCode(HttpResponse.STATUS_CODE_FAIL);
            response.setReasonPhrase(e.getMessage());
            return response;
        }
    }

    @Override
    public HttpResponse postDowload(HttpRequest request) {
        try {
            URL url = new URL(request.getUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(METHOD_POST);// POSTģʽ
            conn.setDoOutput(true);//����POST���������������
            conn.setUseCaches(false);
            initRequest(conn, request);
            //����POST����
            putParamsToOutputStream(conn, request);
            return readResponseForFile(conn, request);
        } catch (Exception e) {
            HttpResponse response = new HttpResponse();
            response.setStatusCode(HttpResponse.STATUS_CODE_FAIL);
            response.setReasonPhrase(e.getMessage());
            return response;
        }
    }

    @Override
    public HttpResponse get(HttpRequest request) {
        try {
            URL url = new URL(request.getGetUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            initRequest(conn, request);
            return readResponseForString(conn, request.getEncode());
        } catch (Exception e) {
            HttpResponse response = new HttpResponse();
            response.setStatusCode(HttpResponse.STATUS_CODE_FAIL);
            response.setReasonPhrase(e.getMessage());
            return response;
        }
    }

    @Override
    public HttpResponse post(HttpRequest request) {
        try {
            URL url = new URL(request.getUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(METHOD_POST);// POSTģʽ
            conn.setDoOutput(true);//����POST���������������
            conn.setUseCaches(false);
            initRequest(conn, request);
            //����POST����
            putParamsToOutputStream(conn, request);
            return readResponseForString(conn, request.getEncode());
        } catch (Exception e) {
            HttpResponse response = new HttpResponse();
            response.setStatusCode(HttpResponse.STATUS_CODE_FAIL);
            response.setReasonPhrase(e.getMessage());
            return response;
        }
    }

    @Override
    public HttpResponse postJson(HttpRequest request) {
        try {
            URL url = new URL(request.getUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(METHOD_POST);// POSTģʽ
            conn.setDoOutput(true);//����POST���������������
            initRequest(conn, request);
            //����POST����
            putParamsToOutputStreamForJson(conn, request);
            return readResponseForString(conn, request.getEncode());
        } catch (Exception e) {
            HttpResponse response = new HttpResponse();
            response.setStatusCode(HttpResponse.STATUS_CODE_FAIL);
            response.setReasonPhrase(e.getMessage());
            return response;
        }
    }

    @Override
    public HttpResponse upload(HttpRequest request) {
        try {
            URL url = new URL(request.getUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            initRequest(conn, request);
            putBodyEntityToOutputStream(conn, request);
            return readResponseForString(conn, request.getEncode());
        } catch (Exception e) {
            HttpResponse response = new HttpResponse();
            response.setStatusCode(HttpResponse.STATUS_CODE_FAIL);
            response.setReasonPhrase(e.getMessage());
            return response;
        }
    }

    /**
     * �����������
     *
     * @param conn
     * @param request
     */
    private void initRequest(URLConnection conn, HttpRequest request) {
        //ͷ������
        for (Map.Entry<String, String> entry : request.getHeaderMap().entrySet()) {
            conn.addRequestProperty(entry.getKey(), entry.getValue());
        }
        //��ʱ����
        conn.setConnectTimeout(request.getConnectionTimeout());
        conn.setReadTimeout(request.getReadTimeout());
    }
}
