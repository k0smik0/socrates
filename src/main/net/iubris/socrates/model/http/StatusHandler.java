/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * StatusHandler.java is part of 'Socrates'
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
 * along with 'Socrates' ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates.model.http;

import java.util.List;

import net.iubris.socrates.model.data.place.details.PlaceDetails;
import net.iubris.socrates.model.data.place.details.PlaceDetailsResponse;
import net.iubris.socrates.model.data.place.search.Place;
import net.iubris.socrates.model.data.place.search.PlacesSearchResponse;
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
