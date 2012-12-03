package com.baidu.zinc30;

public class IllegalFindByException extends RuntimeException {

	private static final long serialVersionUID = -4695296086821979809L;

	public IllegalFindByException(String reason) {
		super(reason);
	}

	public IllegalFindByException(String reason, Throwable cause) {
		super(reason, cause);
	}
}
