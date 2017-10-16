package com.xl.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
//import com.sinitek.spirit.logger.LoggerFactory;

/**
 * File Desc:
 * Product Name: SIRM
 * Module Name: BaseDase
 * Author:      Αυ½¨
 * History:     11-4-4 created by Αυ½¨
 */
public class ClobUtil {
    static final Logger LOGGER = Logger.getLogger(ClobUtil.class);

    public static String clobToString(Clob clob) {
        return clobToString(clob, "");
    }

    public static String clobToString(Clob clob, String sprtStr) {
        StringBuffer content = new StringBuffer();
        if (clob != null) {
            Reader in = null;
            try {
                int p = 0;
                char[] buff = new char[1024];
                in = clob.getCharacterStream();
                while ((p = in.read(buff, 0, 1024)) != -1) {
                    content.append(new String(buff, 0, p));
                }
                //                BufferedReader br = new BufferedReader(in);
                //                String strtemp = br.readLine();
                //                while (strtemp != null) {
                //                    content.append(strtemp+"\n");
                //                    if (!"".equals(sprtStr))
                //                        content.append(sprtStr);
                //                    strtemp = br.readLine();
                //                }
            } catch (Exception e) {
                LOGGER.error("read clob failed.", e);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return content.length() > 0 ? content.toString() : sprtStr;
    }
}
