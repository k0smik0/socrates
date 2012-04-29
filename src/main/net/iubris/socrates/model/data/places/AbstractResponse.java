package net.iubris.socrates.model.data.places;

import net.iubris.socrates.model.http.Status;

import com.google.api.client.util.Key;

abstract public class AbstractResponse {

	@Key ("status")
	protected Status status;
	 
	public Status getStatus() {
		return status;
	}	
}
