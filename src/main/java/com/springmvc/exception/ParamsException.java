package com.springmvc.exception;

/**
 * @Description:
 * @ClassName: ParamsException
 * @author
 * @date
 *
 */
public class ParamsException extends BaseException {

	/**
	 *
	 */
	private static final long serialVersionUID = 7137006668984255381L;

	public ParamsException() {
		super();
	}

	public ParamsException(ErrorCode error, Object data) {
		super(error, data);
	}

	public ParamsException(ErrorCode error) {
		super(error);
	}


}
