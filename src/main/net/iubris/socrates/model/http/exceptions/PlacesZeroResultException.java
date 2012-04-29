package net.iubris.socrates.model.http.exceptions;


public class PlacesZeroResultException extends PlacesStatusException {

	private static final long serialVersionUID = 326224504515929176L;

	public PlacesZeroResultException(String reason) {
		super(reason);
	}
}
