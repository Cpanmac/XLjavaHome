package com.xuan.xutils.cache;

/**
 * ��ʾ�����Ѿ����ڵ��쳣��
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:39:34 $
 */
public class CacheExistsException extends CacheException {
    private static final long serialVersionUID = 1L;

    public CacheExistsException() {
        super();
    }

    public CacheExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CacheExistsException(String message) {
        super(message);
    }

    public CacheExistsException(Throwable cause) {
        super(cause);
    }
}
