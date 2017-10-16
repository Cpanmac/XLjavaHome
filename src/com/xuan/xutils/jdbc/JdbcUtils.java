package com.xuan.xutils.jdbc;

import com.xuan.xutils.jdbc.helper.InSQLProcessor;
import com.xuan.xutils.jdbc.helper.PairKeyword;
import com.xuan.xutils.jdbc.helper.PairKeywordComparator;
import com.xuan.xutils.utils.DateUtils;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;

/**
 * JDBC ������,
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:13:34 $
 */
public abstract class JdbcUtils {
    /**
     * ȡ�����������sql
     *
     * @param preparedSQL Ԥ����sql
     * @param args        ��������
     * @return ���������sql
     */
    public static String getSQL(String preparedSQL, Object[] args) {
        if (args == null || args.length == 0) {
            return preparedSQL;
        }
        StringBuilder sql = new StringBuilder();
        int index = 0;
        int parameterIndex = 0;
        while ((index = preparedSQL.indexOf('?')) > 0) {
            sql.append(preparedSQL.substring(0, index));
            preparedSQL = preparedSQL.substring(index + 1);
            Object arg = args[parameterIndex++];
            if (arg == null) {
                sql.append("null");
            } else if (arg instanceof String) {
                sql.append("'");
                sql.append(arg);
                sql.append("'");
            } else if (arg instanceof java.util.Date) {
                sql.append("'");
                sql.append(DateUtils.date2String((java.util.Date) arg));
                sql.append("'");
            } else {
                sql.append(arg);
            }
        }
        sql.append(preparedSQL);
        return sql.toString();
    }

    /**
     * ȡ��ִ��count��sql
     *
     * @param sql ִ�в�ѯ��sql
     * @return ִ��count��sql
     */
    public static String getCountSQL(String sql) {
        String normalSql = sql;
        String lowerCaseSql = sql.toLowerCase();
        int index = lowerCaseSql.indexOf(" order ");
        if (index != -1) {
            normalSql = normalSql.substring(0, index);
            lowerCaseSql = normalSql.toLowerCase();
        }
        int fromIndex = getFirstPairIndex(lowerCaseSql, "select ", " from ");
        if (fromIndex == -1) {
            throw new IllegalArgumentException("Could not get count sql[" + sql + "]");
        }
        int groupByIndex = getFirstPairIndex(lowerCaseSql, " group ", " by ");
        if (groupByIndex != -1 || lowerCaseSql.contains(" union ")) {
            return "SELECT COUNT(1) FROM (" + normalSql + ") temp_rs";
        } else {
            return "SELECT COUNT(1)" + normalSql.substring(fromIndex);
        }
    }

    /**
     * ���ݲ�����������IN��������Ĳ���sql����������
     *
     * @param size ��������
     * @return IN��������Ĳ���sql
     */
    public static String getInSQL(int size) {
        StringBuilder inSQL = new StringBuilder();
        inSQL.append("(");
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                inSQL.append("?");
            } else {
                inSQL.append(",?");
            }
        }
        inSQL.append(")");
        return inSQL.toString();
    }

    /**
     * ���ƴ� IN �Ӿ�� SQL ����� IN �Ӿ������Ŀ���Ϊ 300 ����ASE ��������������������ͷ���ִ�С�<br>
     * ���ڽ���� IN �Ӿ�� SQL �� IN �Ӿ������Ŀ�������������ʱ��������⡣
     *
     * @param inSQL     �� "IN" �� sql ���, e.g. SELECT * FROM table_name WHERE field_name IN
     * @param inArgs    IN �Ӿ��е����в���
     * @param otherArgs ��������
     * @param processor ����ÿ�� SQL ִ�н���Ľӿڣ�����ʵ���пɻ�ȡÿ�β�ѯ�����Ȼ�������ۼ�
     */
    public static void executeInSQL(String inSQL, Object[] inArgs, Object[] otherArgs, InSQLProcessor processor) {
        if (inArgs == null || inArgs.length == 0) {
            return;
        }
        // IN�Ӿ����������Ĳ�����Ŀ
        int inArgsMaxNum = 300;
        // ����������Ŀ
        int otherArgsNum = (otherArgs == null) ? 0 : otherArgs.length;
        // ��ѯִ�еĴ���
        int execNum = (inArgs.length % inArgsMaxNum == 0) ? inArgs.length / inArgsMaxNum : inArgs.length / inArgsMaxNum + 1;
        // ����ִ��SQL
        for (int i = 0; i < execNum; i++) {
            // ÿ��ִ��SQLʱIN�Ӿ��еĲ�����Ŀ
            // ��������һ��ִ�е�SQL, ��������������
            int inArgsNum = ((i + 1) == execNum) ? inArgs.length - inArgsMaxNum * i : inArgsMaxNum;
            String sql = inSQL + JdbcUtils.getInSQL(inArgsNum); // ����sql���
            int count = inArgsNum + otherArgsNum; // ÿ��ִ��ʱ�ܵĲ�����Ŀ
            Object[] args = new Object[count]; // �ܵĲ���
            // ��ʼ����������
            for (int j = 0; j < otherArgsNum; j++) {
                args[j] = otherArgs[j];
            }
            // ÿ��ִ��ʱIN�Ӿ��е�һ�������������е�����
            int startParamIndex = inArgsMaxNum * i;
            // ��ʼ��IN�Ӿ����
            for (int j = otherArgsNum; j < count; j++) {
                // ע������
                args[j] = inArgs[startParamIndex + j - otherArgsNum];
            }
            processor.executeSQL(sql, args); // Call back
        }
    }

    /**
     * ��������Object��������Ԥ��ʽsql�����.
     *
     * @param args ����
     * @param ps   Ԥ��ʽsql������
     * @throws SQLException
     */
    public static void setParamsToStatement(Object[] args, PreparedStatement ps) throws SQLException {
        // Set the parameters
        for (int i = 0, index; i < args.length; i++) {
            index = i + 1;
            if (args[i] instanceof java.util.Date) {
                args[i] = new Timestamp(((java.util.Date) args[i]).getTime());
            }
            ps.setObject(index, args[i]);
        }
    }

    /**
     * �������Ժ��ʵ���������Ԥ��ʽsql�����.
     *
     * @param args     ����
     * @param argTypes ��������
     * @param ps       Ԥ��ʽsql������
     * @throws SQLException
     */
    public static void setSuitedParamsToStatement(Object[] args, int[] argTypes, PreparedStatement ps) throws SQLException {
        for (int i = 0, index; i < args.length; i++) {
            index = i + 1;
            if (args[i] == null) {
                ps.setNull(index, argTypes[i]);
                continue;
            }
            switch (argTypes[i]) {
                case Types.INTEGER:
                    ps.setInt(index, ((Integer) args[i]).intValue());
                    break;
                case Types.BOOLEAN:
                    ps.setBoolean(index, ((Boolean) args[i]).booleanValue());
                    break;
                case Types.FLOAT:
                    ps.setFloat(index, ((Float) args[i]).floatValue());
                    break;
                case Types.DOUBLE:
                    ps.setDouble(index, ((Double) args[i]).doubleValue());
                    break;
                case Types.CHAR:
                case Types.VARCHAR:
                    ps.setString(index, (String) args[i]);
                    break;
                case Types.DATE:
                    ps.setDate(index, new Date(((java.util.Date) args[i]).getTime()));
                    break;
                case Types.TIMESTAMP:
                    ps.setTimestamp(index, new Timestamp(((java.util.Date) args[i]).getTime()));
                    break;
                default:
                    ps.setObject(index, args[i]);
                    break;
            }
        }
    }

    /**
     * �Ӽ�¼���л��ָ���е�ֵ
     *
     * @param columnIndex ����ţ���1��ʼ
     * @param argType     �е�����
     * @param rs          ��¼��
     * @return ָ���е�ֵ
     * @throws SQLException
     */
    public static Object getColumnValueFromResultSet(int columnIndex, int argType, ResultSet rs) throws SQLException {
        switch (argType) {
            case Types.INTEGER:
                return Integer.valueOf(rs.getInt(columnIndex));
            case Types.BOOLEAN:
                return Boolean.valueOf(rs.getBoolean(columnIndex));
            case Types.FLOAT:
                return new Float(rs.getFloat(columnIndex));
            case Types.DOUBLE:
                return new Double(rs.getDouble(columnIndex));
            case Types.CHAR:
            case Types.VARCHAR:
                return rs.getString(columnIndex);
            case Types.DATE:
                return rs.getDate(columnIndex);
            case Types.TIMESTAMP:
                return rs.getTimestamp(columnIndex);
            default:
                return rs.getObject(columnIndex);
        }
    }

    /**
     * ��óɶԳ��ֵĵ�һ���ؼ��ֶ�Ӧ�Ĺؼ��ֵ�λ�á�
     *
     * @param str
     * @param keyword         �ؼ��֣����磺select
     * @param oppositeKeyword ��Ӧ�Ĺؼ��֣����磺from
     * @return ��һ���ؼ��ֶ�Ӧ�Ĺؼ��ֵ�λ��
     */
    private static int getFirstPairIndex(String str, String keyword, String oppositeKeyword) {
        ArrayList<PairKeyword> keywordArray = new ArrayList<PairKeyword>();
        int index = -1;
        while ((index = str.indexOf(keyword, index)) != -1) {
            keywordArray.add(new PairKeyword(keyword, index));
            index += keyword.length();
        }
        index = -1;
        while ((index = str.indexOf(oppositeKeyword, index)) != -1) {
            keywordArray.add(new PairKeyword(oppositeKeyword, index));
            index += oppositeKeyword.length();
        }
        if (keywordArray.size() < 2) {
            return -1;
        }
        Collections.sort(keywordArray, new PairKeywordComparator());
        PairKeyword firstKeyword = keywordArray.get(0);
        if (!firstKeyword.getName().equals(keyword)) {
            return -1;
        }
        while (keywordArray.size() > 2) {
            boolean hasOpposite = false;
            for (int i = 2; i < keywordArray.size(); i++) {
                PairKeyword keyword0 = keywordArray.get(i - 1);
                PairKeyword keyword1 = keywordArray.get(i);
                if (keyword0.getName().equals(keyword) && keyword1.getName().equals(oppositeKeyword)) {
                    keywordArray.remove(i);
                    keywordArray.remove(i - 1);
                    hasOpposite = true;
                    break;
                }
            }
            if (!hasOpposite) {
                return -1;
            }
        }
        if (keywordArray.size() != 2) {
            return -1;
        }
        PairKeyword lastKeyword = keywordArray.get(1);
        if (!lastKeyword.getName().equals(oppositeKeyword)) {
            return -1;
        }
        return lastKeyword.getIndex();
    }
}
