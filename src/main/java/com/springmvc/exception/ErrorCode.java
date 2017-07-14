package com.springmvc.exception;

/**
 * @Description: 错误返回码接口
 * @ClassName: ErrorCode
 * @author
 * @date 2016年9月14日 下午8:29:26
 *
 */
public interface ErrorCode {

	/**
	 * 返回码
	 * @return
	 */
	int getCode();

	/**
	 * 异常信息, 源自{@link Throwable#getMessage()}
	 *
	 * @return
	 */
	String getMessage();

	void setMessage(String msg);

}
