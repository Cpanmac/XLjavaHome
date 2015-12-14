package com.xl.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @description ����ͳһ���չ��̷���ֵ�Ķ���
 * @date 2013-9-10 ����5:25:09
 * @author zhuming
 */
public class ResultVO<T> implements Serializable {
	/** ResultVO.java long */
	private static final long serialVersionUID = 1L;
	/**************************************
	 * ����������
	 **************************************/
	/** ����� */
	private List<T> resultList;
	private String returnCode;
	private String errorMessage;
	private String sqlError;
	/** ��ҳ�� */
	private int pageCount;
	private int rowCount;
	/** �������ؽ���� */
	private Map<String, Object> othermap;
	
	/**
	 * �Ƿ��з��ؽ�������Ҵ���1
	 * 
	 * @param: @return
	 * @return: boolean
	 * @exception
	 */
	public boolean hasResult() {
		boolean bool = false;
		if (this.getResultList() != null && this.getResultList().size() > 0) {
			bool = true;
		}
		return bool;
	}
	
	/**
	 * �����Ϊ��
	 * 
	 * @param: @return
	 * @return: boolean
	 * @exception
	 */
	public boolean hasEmptyResult() {
		boolean bool = false;
		if (this.getResultList() != null && this.getResultList().size() == 0) {
			bool = true;
		}
		return bool;
	}
	
	/**
	 * @return the resultList
	 */
	public List<T> getResultList() {
		return resultList;
	}
	
	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	
	/**
	 * @return the returnCode
	 */
	public String getReturnCode() {
		return returnCode;
	}
	
	/**
	 * @param returnCode the returnCode to set
	 */
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	/**
	 * @return the sqlError
	 */
	public String getSqlError() {
		return sqlError;
	}
	
	/**
	 * @param sqlError the sqlError to set
	 */
	public void setSqlError(String sqlError) {
		this.sqlError = sqlError;
	}
	
	/**
	 * @return the pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}
	
	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	/**
	 * @return the othermap
	 */
	public Map<String, Object> getOthermap() {
		return othermap;
	}
	
	/**
	 * @param othermap the othermap to set
	 */
	public void setOthermap(Map<String, Object> othermap) {
		this.othermap = othermap;
	}
	
	/**
	 * @return the rowCount
	 */
	public int getRowCount() {
		return rowCount;
	}
	
	/**
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
}
