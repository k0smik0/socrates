/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * Status.java is part of 'Socrates'.
 * 
 * 'Socrates' is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * 'Socrates' is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with 'Socrates'; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates.model.http.response.common;

import java.util.Collections;
import java.util.List;

import net.iubris.socrates.model.http.response.data.details.Details;
import net.iubris.socrates.model.http.response.data.search.GooglePlace;
import net.iubris.socrates.model.http.response.details.DetailsResponse;
import net.iubris.socrates.model.http.response.exceptions.InvalidRequestException;
import net.iubris.socrates.model.http.response.exceptions.NotFoundException;
import net.iubris.socrates.model.http.response.exceptions.OverQuotaException;
import net.iubris.socrates.model.http.response.exceptions.RequestDeniedException;
import net.iubris.socrates.model.http.response.exceptions.UnknowErrorException;
import net.iubris.socrates.model.http.response.exceptions.ZeroResultException;
import net.iubris.socrates.model.http.response.search.SearchResponse;

import com.google.api.client.util.Value;

public enum Status implements StatusHandler {

	@Value OK ("no errors occurred; the place was successfully detected and at least one result was returned") {
		@Override
		public List<GooglePlace> handleStatusAndGetData(SearchResponse placesSearchResponse) {
			return placesSearchResponse.getResults();
		}
		@Override
		public Details handleStatusAndGetData(DetailsResponse placeDetailsResponse) {
			return placeDetailsResponse.getResult();
		}
	},
	@Value UNKNOWN_ERROR ("a server-side error; trying again may be successful") {
		@Override
		public List<GooglePlace> handleStatusAndGetData(SearchResponse placesSearchResponse) throws UnknowErrorException {
			throw new UnknowErrorException(getReason());
		}
		@Override
		public Details handleStatusAndGetData(DetailsResponse placeDetailsResponse) throws UnknowErrorException {
			throw new UnknowErrorException(getReason());
		}		
	},
	@Value ZERO_RESULTS ("the search was successful but returned no results. This may occur if the search was passed a latlng in a remote location.") {
		@Override
		public List<GooglePlace> handleStatusAndGetData(SearchResponse placesSearchResponse) throws ZeroResultException {
			throw new ZeroResultException(getReason());
		}
		@Override
		public Details handleStatusAndGetData(DetailsResponse placeDetailsResponse) throws ZeroResultException {
			throw new ZeroResultException(getReason());
		}
	},
	@Value OVER_QUERY_LIMIT ("you are over your quota.") {
		@Override
		public List<GooglePlace> handleStatusAndGetData(SearchResponse placesSearchResponse) throws OverQuotaException {
			throw new OverQuotaException(getReason());
		}
		@Override
		public Details handleStatusAndGetData(DetailsResponse placeDetailsResponse) throws OverQuotaException {
			throw new OverQuotaException(getReason());
		}
	},
	@Value REQUEST_DENIED ("your request was denied, generally because of lack of a sensor parameter or api key is wrong/expired.") {
		@Override
		public List<GooglePlace> handleStatusAndGetData(SearchResponse placesSearchResponse) throws RequestDeniedException {
			throw new RequestDeniedException(getReason());
		}
		@Override
		public Details handleStatusAndGetData(DetailsResponse placeDetailsResponse) throws RequestDeniedException {
			throw new RequestDeniedException(getReason());
		}
	},
	@Value INVALID_REQUEST ("required query parameter (generally location or radius) is missing.") {
		@Override
		public List<GooglePlace> handleStatusAndGetData(SearchResponse placesSearchResponse) throws InvalidRequestException {
			throw new InvalidRequestException(getReason());
		}
		@Override
		public Details handleStatusAndGetData(DetailsResponse placeDetailsResponse) throws InvalidRequestException {
			throw new InvalidRequestException(getReason());
		}
	},
	@Value NOT_FOUND("an event could not be found with the specified event_id"){
		@Override
		public List<GooglePlace> handleStatusAndGetData(SearchResponse placesSearchResponse)  {
			return Collections.emptyList();
		}
		@Override
		public Details handleStatusAndGetData(DetailsResponse placeDetailsResponse) throws NotFoundException {
			throw new NotFoundException(getReason());
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
