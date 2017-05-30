package com.springmvc.exception;

/**
 * @Description: �������չException��Ϣ
 * @ClassName: ExceptionScalable
 * @author
 * @date 2016��9��14�� ����8:30:04
 *
 */
public interface ExceptionScalable{

	/**
	 * �������
	 * @return
	 */
	ErrorCode getError();

	/**
	 * ����ִ���쳣������, ���������ݣ���ִ������
	 * @return
     */
	Object getData();
}
