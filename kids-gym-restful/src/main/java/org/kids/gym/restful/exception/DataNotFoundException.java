package org.kids.gym.restful.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7754109340103411774L;
	
	public DataNotFoundException(String message) {
		super(message);
	}

}
