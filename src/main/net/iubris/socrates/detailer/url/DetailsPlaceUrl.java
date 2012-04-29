package net.iubris.socrates.detailer.url;

import net.iubris.socrates.detailer.url.annotation.PlaceUrlFinalPartDetails;
import net.iubris.socrates.url.AbstractPlaceUrl;
import net.iubris.socrates.url.PlaceUrlFinalPart;

import com.google.api.client.http.GenericUrl;
import com.google.inject.Inject;

public class DetailsPlaceUrl extends AbstractPlaceUrl {

	@Inject
	public DetailsPlaceUrl(GenericUrl genericUrl, 
			@PlaceUrlFinalPartDetails PlaceUrlFinalPart placeUrlFinalPart) {
		super(genericUrl, placeUrlFinalPart);
	}
}
