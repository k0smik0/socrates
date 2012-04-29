package net.iubris.socrates.model.http.exceptions;


public class PlacesRequestDeniedException extends PlacesStatusException {

	public PlacesRequestDeniedException(String reason) {
		super(reason);
	}	
	private static final long serialVersionUID = -2394114252710231525L;

}
