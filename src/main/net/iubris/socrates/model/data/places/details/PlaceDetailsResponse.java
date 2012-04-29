package net.iubris.socrates.model.data.places.details;

import net.iubris.socrates.model.data.places.AbstractResponse;

import com.google.api.client.util.Key;

public class PlaceDetailsResponse extends AbstractResponse {		
	
	@Key ("result")
	private PlaceDetails result;
	
	public PlaceDetails getResult() {		
		return result;
	}
}
