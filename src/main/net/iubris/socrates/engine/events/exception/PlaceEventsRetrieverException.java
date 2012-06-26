package net.iubris.socrates.engine.events.exception;

import net.iubris.socrates.exceptions.PlacesException;

public class PlaceEventsRetrieverException extends PlacesException {
	
	private static final long serialVersionUID = 7689392664123655149L;
	public PlaceEventsRetrieverException(String exception) {
		super(exception);
	}
	public PlaceEventsRetrieverException(Throwable cause) {
		super(cause);
	}

}
