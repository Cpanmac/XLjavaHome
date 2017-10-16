package com.xuan.xutils.jdbc;

import java.util.ArrayList;
import java.util.List;

/**
 * ��̬��ѯ SQL ������ɹ�����
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����10:35:37 $
 */
public class SqlCreator {
    private final StringBuilder sql;
    private final List<Object> args;
    private final List<Integer> argTypes;
    private boolean hasOrderBy = false;
    private boolean hasWhere = true;
    private boolean isFirst = true;

    /**
     * ���췽����
     *
     * @param baseSQL ���� WHERE �ؼ��ֵ�ԭʼ sql
     */
    public SqlCreator(String baseSQL) {
        this(baseSQL, true);
    }

    /**
     * ���췽����
     *
     * @param baseSQL  ԭʼ sql
     * @param hasWhere ԭʼ sql �Ƿ���� WHERE �ؼ���
     */
    public SqlCreator(String baseSQL, boolean hasWhere) {
        if (baseSQL == null || baseSQL.trim().length() == 0) {
            throw new IllegalArgumentException("baseSQL can't be null");
        }
        args = new ArrayList<Object>();
        argTypes = new ArrayList<Integer>();
        sql = new StringBuilder();
        sql.append(baseSQL.trim());
        this.hasWhere = hasWhere;
    }

    /**
     * ���Ӳ�ѯ����
     *
     * @param operator     ���������磺AND��OR
     * @param expression   ���ʽ�����磺id=1
     * @param precondition �Ⱦ���������Ϊtrueʱ�Ż����Ӳ�ѯ���������� user != null
     */
    public void addExpression(String operator, String expression, boolean precondition) {
        addExpression(operator, expression, null, precondition);
    }

    /**
     * ���Ӳ�ѯ����
     *
     * @param operator     ���������磺AND��OR
     * @param expression   ���ʽ�����磺id=?
     * @param arg          ���ʽ�еĲ�����ֵ
     * @param precondition �Ⱦ���������Ϊtrueʱ�Ż����Ӳ�ѯ���������� id != null
     */
    public void addExpression(String operator, String expression, Object arg, boolean precondition) {
        addExpression(operator, expression, arg, Integer.MIN_VALUE, precondition);
    }

    /**
     * ���Ӳ�ѯ����
     *
     * @param operator     ���������磺AND��OR
     * @param expression   ���ʽ�����磺id=?
     * @param arg          ���ʽ�еĲ�����ֵ
     * @param argType      ���ʽ�еĲ���������
     * @param precondition �Ⱦ���������Ϊtrueʱ�Ż����Ӳ�ѯ���������� id != null
     */
    public void addExpression(String operator, String expression, Object arg, int argType, boolean precondition) {
        if (precondition) {
            if (isFirst) {
                if (hasWhere) {
                    if (!sql.toString().toLowerCase().endsWith("where")) {
                        sql.append(" " + operator);
                    }
                } else {
                    sql.append(" WHERE");
                }
                isFirst = false;
            } else {
                sql.append(" " + operator);
            }
            sql.append(" " + expression);
            if (arg != null) {
                args.add(arg);
            }
            if (argType != Integer.MIN_VALUE) {
                argTypes.add(argType);
            }
        }
    }

    /**
     * ����AND��ѯ����
     *
     * @param expression   ���ʽ
     * @param precondition �Ⱦ�����
     */
    public void and(String expression, boolean precondition) {
        addExpression("AND", expression, precondition);
    }

    /**
     * ����AND��ѯ����
     *
     * @param expression   ���ʽ
     * @param arg          ������ֵ
     * @param precondition �Ⱦ�����
     */
    public void and(String expression, Object arg, boolean precondition) {
        addExpression("AND", expression, arg, precondition);
    }

    /**
     * ����AND��ѯ����
     *
     * @param expression   ���ʽ
     * @param arg          ������ֵ
     * @param argType      ����������
     * @param precondition �Ⱦ�����
     */
    public void and(String expression, Object arg, int argType, boolean precondition) {
        addExpression("AND", expression, arg, argType, precondition);
    }

    /**
     * ���� AND IN ��ѯ����������AND id IN (?, ?, ?);
     *
     * @param columnName   �����ƣ����� id
     * @param args         ������ֵ���飬���� new String[] {"1", "2", "3"}
     * @param argType      ����������
     * @param precondition �Ⱦ�����
     */
    public void andIn(String columnName, Object[] args, int argType, boolean precondition) {
        if (precondition && args.length > 0) {
            if (isFirst) {
                if (hasWhere) {
                    if (!sql.toString().toLowerCase().endsWith("where")) {
                        sql.append(" AND");
                    }
                } else {
                    sql.append(" WHERE");
                }
                sql.append(" ");
                isFirst = false;
            } else {
                sql.append(" AND ");
            }
            sql.append(columnName);
            sql.append(" IN ");
            sql.append(JdbcUtils.getInSQL(args.length));
            for (int i = 0; i < args.length; i++) {
                this.args.add(args[i]);
                argTypes.add(argType);
            }
        }
    }

    /**
     * ����OR��ѯ����
     *
     * @param expression   ���ʽ
     * @param precondition �Ⱦ�����
     */
    public void or(String expression, boolean precondition) {
        addExpression("OR", expression, precondition);
    }

    /**
     * ����OR��ѯ����
     *
     * @param expression   ���ʽ
     * @param arg          ������ֵ
     * @param precondition �Ⱦ�����
     */
    public void or(String expression, Object arg, boolean precondition) {
        addExpression("OR", expression, arg, precondition);
    }

    /**
     * ����OR��ѯ����
     *
     * @param expression   ���ʽ
     * @param arg          ������ֵ
     * @param argType      ����������
     * @param precondition �Ⱦ�����
     */
    public void or(String expression, Object arg, int argType, boolean precondition) {
        addExpression("OR", expression, arg, argType, precondition);
    }

    /**
     * ��� GROUP BY ��䡣
     *
     * @param columnNames ����
     */
    public void groupBy(String... columnNames) {
        if (columnNames == null || columnNames.length == 0 || (columnNames.length == 1 && columnNames[0] == null)) {
            return;
        }
        sql.append(" GROUP BY ");
        for (String columnName : columnNames) {
            sql.append(columnName).append(", ");
        }
        sql.delete(sql.length() - 2, sql.length() - 1);
    }

    /**
     * ��������
     *
     * @param columnName ����
     */
    public void orderBy(String columnName) {
        orderBy(columnName, false);
    }

    /**
     * ��������
     *
     * @param columnName ����
     */
    public void orderByDesc(String columnName) {
        orderBy(columnName, true);
    }

    /**
     * ����
     *
     * @param columnName ����
     * @param isDesc     �Ƿ���
     */
    public void orderBy(String columnName, boolean isDesc) {
        if (!hasOrderBy) {
            sql.append(" ORDER BY ");
        } else {
            sql.append(", ");
        }
        sql.append(columnName);
        if (isDesc) {
            sql.append(" DESC");
        }
        hasOrderBy = true;
    }

    /**
     * ȡ�����в�����ֵ����
     *
     * @return ���в�����ֵ����
     */
    public Object[] getArgs() {
        return args.toArray();
    }

    /**
     * ȡ�����в�������������
     *
     * @return ���в�������������
     */
    public int[] getArgTypes() {
        Integer[] objectTypes = argTypes.toArray(new Integer[argTypes.size()]);
        int[] intTypes = new int[objectTypes.length];
        for (int i = 0; i < objectTypes.length; i++) {
            intTypes[i] = objectTypes[i].intValue();
        }
        return intTypes;
    }

    /**
     * ȡ��������ɲ�ѯsql
     *
     * @return ��ѯsql
     */
    public String getSQL() {
        return sql.toString();
    }
}
