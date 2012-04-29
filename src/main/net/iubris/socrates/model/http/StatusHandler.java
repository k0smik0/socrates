package net.iubris.socrates.model.http;

import java.util.List;

import net.iubris.socrates.model.data.places.details.PlaceDetails;
import net.iubris.socrates.model.data.places.details.PlaceDetailsResponse;
import net.iubris.socrates.model.data.places.search.Place;
import net.iubris.socrates.model.data.places.search.PlacesSearchResponse;
import net.iubris.socrates.model.http.exceptions.PlacesInvalidRequestException;
import net.iubris.socrates.model.http.exceptions.PlacesOverQuotaException;
import net.iubris.socrates.model.http.exceptions.PlacesRequestDeniedException;
import net.iubris.socrates.model.http.exceptions.PlacesZeroResultException;

public interface StatusHandler {

	List<Place> act(PlacesSearchResponse placesSearchResponse)
		throws PlacesOverQuotaException,
			PlacesZeroResultException,
			PlacesRequestDeniedException,
			PlacesInvalidRequestException;

	PlaceDetails act(PlaceDetailsResponse placeDetailsResponse) 
		throws PlacesZeroResultException, 
			PlacesOverQuotaException, 
			PlacesRequestDeniedException, 
			PlacesInvalidRequestException;
}
