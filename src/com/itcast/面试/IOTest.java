package com.itcast.����;

import com.xl.util.FileTool;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author ����
 * @Decription ���׹ر�����, close����Ҳ���쳣
 * @date 2014-5-15
 */
public class IOTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String src = FileTool.getCurrentPath(IOTest.class) + "\\1";
        System.out.println(src);
    }

    public static void copy(String src, String dest) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) > 0)
                out.write(buf, 0, n);
        } finally {
            // ���ǲ��õ�����
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
    }

    public static void copy2(String src, String dest) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) > 0)
                out.write(buf, 0, n);
        } finally {
            // ����
            if (in != null)
                try {
                    in.close();
                } finally {
                    in = null;
                }
            if (out != null)
                try {
                    out.close();
                } finally {
                    out = null;
                }
        }
    }
}
