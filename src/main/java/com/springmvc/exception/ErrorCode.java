package com.springmvc.exception;

/**
 * @Description: ���󷵻���ӿ�
 * @ClassName: ErrorCode
 * @author 
 * @date 2016��9��14�� ����8:29:26
 *
 */
public interface ErrorCode {
	
	/**
	 * ������
	 * @return
	 */
	int getCode();

	/**
	 * �쳣��Ϣ, Դ��{@link Throwable#getMessage()}
	 * 
	 * @return
	 */
	String getMessage();
	
	void setMessage(String msg);

}
