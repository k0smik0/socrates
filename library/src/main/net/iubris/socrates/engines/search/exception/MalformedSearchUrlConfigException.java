package net.iubris.socrates.engines.search.exception;


public class MalformedSearchUrlConfigException extends SearcherConfigException {
	public MalformedSearchUrlConfigException(Throwable cause) {
		super(cause);
	}
	public MalformedSearchUrlConfigException(String reason) {
		super(reason);		
	}
	public MalformedSearchUrlConfigException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}
	private static final long serialVersionUID = -5789775335469970580L;
}
