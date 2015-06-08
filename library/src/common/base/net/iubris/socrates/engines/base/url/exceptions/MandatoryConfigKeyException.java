package net.iubris.socrates.engines.base.url.exceptions;

import net.iubris.socrates.engines.base.exception.PlacesException;

public class MandatoryConfigKeyException extends PlacesException {

	public MandatoryConfigKeyException(String message) {
		super(message);
	}	
	public MandatoryConfigKeyException(Throwable cause) {
		super(cause);
	}
	public MandatoryConfigKeyException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}
	
	private static final long serialVersionUID = 3544000003161930437L;

}
