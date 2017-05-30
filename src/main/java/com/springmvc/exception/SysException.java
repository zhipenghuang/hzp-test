package com.springmvc.exception;

/**
 * @Description: 系统异常
 * @ClassName: sysException
 * @author 
 * @date 
 *
 */
public class SysException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6878142870884828535L;

	public SysException() {
		super();
	}

	public SysException(ErrorCode error, Object data) {
		super(error, data);
	}

	public SysException(ErrorCode error) {
		super(error);
	}


}
