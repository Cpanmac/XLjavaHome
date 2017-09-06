package com.xl.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by IntelliJ IDEA.
 * User: sinitek
 * Date: 12-2-27
 * Time: 上午10:41
 * To change this template use File | Settings | File Templates.
 */
public class EncryptUtil {
    /**
     * 进行des加密
     *
     * @param message
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptDES(String message, String key) {
        return encryptDES(message, key, "UTF-8");
    }

    /**
     * 进行des加密
     *
     * @param message
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptDES(String message, String key, String encoding) {
        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            return byte2hex(cipher.doFinal(message.getBytes(encoding)));
        } catch (Exception ex) {
            return message;
        }
    }

    /**
     * 进行des解密
     *
     * @param message
     * @param key
     * @return
     * @throws Exception
     */
    public static String decryptDES(String message, String key) {
        try {
            byte[] bytesrc = convertHexString(message);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            byte[] retByte = cipher.doFinal(bytesrc);
            return new String(retByte);
        } catch (Exception ex) {
            return message;
        }
    }

    /**
     * 16进制字符串转byte
     *
     * @param ss
     * @return
     */
    public static byte[] convertHexString(String ss) {
        byte digest[] = new byte[ss.length() / 2];
        for (int i = 0; i < digest.length; i++) {
            String byteString = ss.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte) byteValue;
        }
        return digest;
    }

    /**
     * byte流转换成16进制字符串
     *
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
        }
        return hs.toUpperCase();
    }

    public String encodeMD5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] cipher = md.digest(plainText.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : cipher) {
                byte b1 = (byte) ((b & 0xf0) >> 4);
                byte b2 = (byte) (b & 0x0f);
                builder.append((b1 < 10 ? (char) ('0' + b1) : (char) ('a' + (b1 - 10))));
                builder.append((b2 < 10 ? (char) ('0' + b2) : (char) ('a' + (b2 - 10))));
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException nsae) {
            return plainText;
        }
    }
}