package com.xuan.xutils.cache;

/**
 * ��ʾ�������淢���쳣���쳣��
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:39:10 $
 */
public class CacheException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CacheException() {
        super();
    }

    public CacheException(String message, Throwable cause) {
        super(message, cause);
    }

    public CacheException(String message) {
        super(message);
    }

    public CacheException(Throwable cause) {
        super(cause);
    }
}
