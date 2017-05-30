package com.springmvc.exception;

/**
 * 请求无效异常
 * Created by taoping on 2016/8/16.
 */
public class ServiceException extends BaseException {
    private static final long serialVersionUID = 1690624130527369260L;

	public ServiceException() {
		super();
	}

	public ServiceException(ErrorCode error, Object data) {
		super(error, data);
	}

	public ServiceException(ErrorCode error) {
		super(error);
	}
	
	public ServiceException(ErrorCode error, String msg, Object data) {
		super(error, msg, data);
	}

    
}
