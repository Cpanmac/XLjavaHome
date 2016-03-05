package com.project;

import java.sql.Connection;

import ibator.util.DBUtil;

/**
 * @Description 1.取得数据表。2.根据列名，类型得到同类型的java类。3.通过io写到硬盘上去
 * 
 * @author 徐立
 * 
 * @date 2014-6-29
 */
public class 数据表生成java实体类 {
	/** 指定实体生成所在包的路径 */
	private String packageOutPath = "com.xl.entity";
	/** 作者名字 */
	private String authorName = "徐立";
	/** 表名 */
	private String tablename = "user";
	/** 列名数组 */
	private String[] colnames;
	/** 列名类型数组 */
	private String[] colTypes;
	/** 列名大小数组 */
	private int[] colSizes;
	/** 是否需要导入包java.util. **/
	private boolean f_util = false;
	/** 是否需要导入包java.sql.* */
	private boolean f_sql = false;
	
	public 数据表生成java实体类(){
		String sql="select * from "+tablename;
	}
	
	public static void main(String[] args) {
		数据表生成java实体类 a=new 数据表生成java实体类();
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
