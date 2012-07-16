package net.iubris.socrates.engines.search.exception;


public class SearcherConfigException extends SearcherException {

	private static final long serialVersionUID = -19826046786460871L;

	public SearcherConfigException(Throwable cause) {
		super(cause);
	}

	public SearcherConfigException(String reason) {
		super(reason);		
	}
}
