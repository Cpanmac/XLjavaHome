package com.project;

import java.sql.Connection;

import ibator.util.DBUtil;

/**
 * @Description 1.ȡ�����ݱ�2.�������������͵õ�ͬ���͵�java�ࡣ3.ͨ��ioд��Ӳ����ȥ
 * 
 * @author ����
 * 
 * @date 2014-6-29
 */
public class ���ݱ�����javaʵ���� {
	/** ָ��ʵ���������ڰ���·�� */
	private String packageOutPath = "com.xl.entity";
	/** �������� */
	private String authorName = "����";
	/** ���� */
	private String tablename = "user";
	/** �������� */
	private String[] colnames;
	/** ������������ */
	private String[] colTypes;
	/** ������С���� */
	private int[] colSizes;
	/** �Ƿ���Ҫ�����java.util. **/
	private boolean f_util = false;
	/** �Ƿ���Ҫ�����java.sql.* */
	private boolean f_sql = false;
	
	public ���ݱ�����javaʵ����(){
		String sql="select * from "+tablename;
	}
	
	public static void main(String[] args) {
		���ݱ�����javaʵ���� a=new ���ݱ�����javaʵ����();
    }

	public String getPackageOutPath() {
    	return packageOutPath;
    }

	public void setPackageOutPath(String packageOutPath) {
    	this.packageOutPath = packageOutPath;
    }

	public String getAuthorName() {
    	return authorName;
    }

	public void setAuthorName(String authorName) {
    	this.authorName = authorName;
    }

	public String getTablename() {
    	return tablename;
    }

	public void setTablename(String tablename) {
    	this.tablename = tablename;
    }

	public String[] getColnames() {
    	return colnames;
    }

	public void setColnames(String[] colnames) {
    	this.colnames = colnames;
    }

	public String[] getColTypes() {
    	return colTypes;
    }

	public void setColTypes(String[] colTypes) {
    	this.colTypes = colTypes;
    }

	public int[] getColSizes() {
    	return colSizes;
    }

	public void setColSizes(int[] colSizes) {
    	this.colSizes = colSizes;
    }

	public boolean isF_util() {
    	return f_util;
    }

	public void setF_util(boolean f_util) {
    	this.f_util = f_util;
    }

	public boolean isF_sql() {
    	return f_sql;
    }

	public void setF_sql(boolean f_sql) {
    	this.f_sql = f_sql;
    }
	
	
}
