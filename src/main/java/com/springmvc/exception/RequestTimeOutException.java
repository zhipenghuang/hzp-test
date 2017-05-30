package com.springmvc.exception;

/**
 * @Description: ����ʱ
 * @ClassName: RequestOutTime
 * @author
 * @date 2016��9��17�� ����3:30:38
 *
 */
public class RequestTimeOutException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6634469533564245709L;

	public RequestTimeOutException() {
		super();
	}

	public RequestTimeOutException(ErrorCode error, Object data) {
		super(error, data);
	}

	public RequestTimeOutException(ErrorCode error) {
		super(error);
	}
	

}
