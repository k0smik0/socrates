package net.iubris.socrates.engines.search.url.exception;

public class LocationNullException extends Exception {

	
	public LocationNullException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public LocationNullException(String detailMessage) {
		super(detailMessage);
	}

	public LocationNullException(Throwable throwable) {
		super(throwable);
	}

	private static final long serialVersionUID = 4624985998375622475L;

}
