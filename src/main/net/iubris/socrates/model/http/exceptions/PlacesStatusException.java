package net.iubris.socrates.model.http.exceptions;

public class PlacesStatusException extends Exception {
	
	private static final long serialVersionUID = -8128983763531125004L;

	public PlacesStatusException(String reason) {
		super(reason);
	}
}
