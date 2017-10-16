package com.xuan.xutils.jdbc.helper;

/**
 * SQLִ�д������ӿ�, ���ڴ����IN�Ӿ��SQL�����IN�в�������������
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:14:51 $
 */
public interface InSQLProcessor {
    /**
     * ִ��SQL�ķ���.
     *
     * @param sql  SQL���
     * @param args ����еĲ���
     */
    void executeSQL(String sql, Object[] args);
}
