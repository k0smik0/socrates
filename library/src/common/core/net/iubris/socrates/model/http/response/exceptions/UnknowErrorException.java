package net.iubris.socrates.model.http.response.exceptions;

public class UnknowErrorException extends StatusException {

	private static final long serialVersionUID = 421145428489274433L;

	public UnknowErrorException() {
		super();
	}

	public UnknowErrorException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public UnknowErrorException(String detailMessage) {
		super(detailMessage);
	}

	public UnknowErrorException(Throwable throwable) {
		super(throwable);
	}

	
}
