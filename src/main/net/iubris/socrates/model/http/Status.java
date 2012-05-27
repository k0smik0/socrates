/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * Status.java is part of 'Socrates'.
 * 
 * socrates is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * socrates is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with socrates ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
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

import com.google.api.client.util.Value;

public enum Status implements StatusHandler {

	@Value OK ("no errors occurred; the place was successfully detected and at least one result was returned") {
		@Override
		public List<Place> act(PlacesSearchResponse placesSearchResponse) {
			return placesSearchResponse.getResults();
		}
		@Override
		public PlaceDetails act(PlaceDetailsResponse placeDetailsResponse) {
			return placeDetailsResponse.getResult();
		}
	},
	@Value ZERO_RESULTS ("the search was successful but returned no results. This may occur if the search was passed a latlng in a remote location.") {
		@Override
		public List<Place> act(PlacesSearchResponse placesSearchResponse) throws PlacesZeroResultException {
			throw new PlacesZeroResultException(getReason());
		}
		@Override
		public PlaceDetails act(PlaceDetailsResponse placeDetailsResponse) throws PlacesZeroResultException {
			throw new PlacesZeroResultException(getReason());
		}
	},
	@Value OVER_QUERY_LIMIT ("you are over your quota.") {
		@Override
		public List<Place> act(PlacesSearchResponse placesSearchResponse) throws PlacesOverQuotaException {
			throw new PlacesOverQuotaException(getReason());
		}
		@Override
		public PlaceDetails act(PlaceDetailsResponse placeDetailsResponse) throws PlacesOverQuotaException {
			throw new PlacesOverQuotaException(getReason());
		}
	},
	@Value REQUEST_DENIED ("your request was denied, generally because of lack of a sensor parameter.") {
		@Override
		public List<Place> act(PlacesSearchResponse placesSearchResponse) throws PlacesRequestDeniedException {
			throw new PlacesRequestDeniedException(getReason());
		}
		@Override
		public PlaceDetails act(PlaceDetailsResponse placeDetailsResponse) throws PlacesRequestDeniedException {
			throw new PlacesRequestDeniedException(getReason());
		}
	},
	@Value INVALID_REQUEST ("required query parameter (generally location or radius) is missing.") {
		@Override
		public List<Place> act(PlacesSearchResponse placesSearchResponse) throws PlacesInvalidRequestException {
			throw new PlacesInvalidRequestException(getReason());
		}
		@Override
		public PlaceDetails act(PlaceDetailsResponse placeDetailsResponse) throws PlacesInvalidRequestException {
			throw new PlacesInvalidRequestException(getReason());
		}
	};
	
	private String reason;

	private Status(String reason) {
		this.reason = reason;
	}
	
	public String getReason() {
		return reason;
	}	
}
