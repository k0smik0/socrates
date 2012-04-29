package net.iubris.socrates.model.data.places.search;

import java.util.List;

import net.iubris.socrates.model.data.places.AbstractResponse;

import com.google.api.client.util.Key;

public class PlacesSearchResponse extends AbstractResponse {
	
	@Key ("results")
	private List<Place> results;
	
	public List<Place> getResults() {		
		return results;
	}
}
