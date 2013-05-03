package net.iubris.socrates.engines.events.details.exception;

import net.iubris.socrates.engines.base.exception.PlacesException;

public class EventDetailsRetrieverException extends PlacesException {

	public EventDetailsRetrieverException(String detailMessage,Throwable throwable) {
		super(detailMessage, throwable);
	}
	public EventDetailsRetrieverException(String exception) {
		super(exception);
	}
	public EventDetailsRetrieverException(Throwable cause) {
		super(cause);
	}
	
	private static final long serialVersionUID = 7747563021658995700L;

}
