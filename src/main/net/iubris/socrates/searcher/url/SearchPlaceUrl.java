package net.iubris.socrates.searcher.url;

import net.iubris.socrates.searcher.url.annotation.PlaceUrlFinalPartSearch;
import net.iubris.socrates.url.AbstractPlaceUrl;
import net.iubris.socrates.url.PlaceUrlFinalPart;


import com.google.api.client.http.GenericUrl;
import com.google.inject.Inject;

public class SearchPlaceUrl extends AbstractPlaceUrl {
	
	@Inject
	public SearchPlaceUrl(GenericUrl genericUrl, @PlaceUrlFinalPartSearch PlaceUrlFinalPart placeUrlFinalPart) {
		super(genericUrl, placeUrlFinalPart);		
	}		
}
