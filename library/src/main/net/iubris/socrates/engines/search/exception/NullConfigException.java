package net.iubris.socrates.engines.search.exception;

public class NullConfigException extends SearcherConfigException {
	
	private static final long serialVersionUID = 7967813949068376549L;

	public NullConfigException(Throwable cause) {
		super(cause);
	}
	public NullConfigException(String reason) {
		super(reason);
	}
	public NullConfigException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}
}
