package net.iubris.socrates.searcher;

import net.iubris.socrates._roboguice.providers.annotations.PlacesHttpRequestFactory;
import net.iubris.socrates.model.data.places.search.PlacesSearchResponse;
import net.iubris.socrates.searcher.url.SearchRequestUrlBuilder;

import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Inject;

public class PlacesSearcher extends PlacesSearcherGeneric<PlacesSearchResponse> {
		
	@Inject
	public PlacesSearcher(SearchRequestUrlBuilder placeRequestUrlBuilder,
			@PlacesHttpRequestFactory HttpRequestFactory httpRequestFactory) {
		super(placeRequestUrlBuilder,httpRequestFactory,PlacesSearchResponse.class);
	}	
}
