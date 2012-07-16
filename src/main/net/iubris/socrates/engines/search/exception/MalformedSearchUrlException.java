package net.iubris.socrates.engines.search.exception;


public class MalformedSearchUrlException extends SearcherConfigException {
	public MalformedSearchUrlException(Throwable cause) {
		super(cause);
	}

	public MalformedSearchUrlException(String reason) {
		super(reason);		
	}

	private static final long serialVersionUID = -5789775335469970580L;
}
