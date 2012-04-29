package net.iubris.socrates.model.http.exceptions;


public class PlacesOverQuotaException extends PlacesStatusException {

	public PlacesOverQuotaException(String message) {
		super(message);
	}
	private static final long serialVersionUID = -8450217144613028959L;
}
