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
package net.iubris.socrates.model.http.base;

import java.util.List;

import net.iubris.socrates.model.data.details.Details;
import net.iubris.socrates.model.data.search.Place;
import net.iubris.socrates.model.http.base.exceptions.InvalidRequestException;
import net.iubris.socrates.model.http.base.exceptions.OverQuotaException;
import net.iubris.socrates.model.http.base.exceptions.RequestDeniedException;
import net.iubris.socrates.model.http.base.exceptions.ZeroResultException;
import net.iubris.socrates.model.http.details.DetailsResponse;
import net.iubris.socrates.model.http.search.SearchResponse;

public interface StatusHandler {

	List<Place> act(SearchResponse placesSearchResponse)
		throws OverQuotaException,
			ZeroResultException,
			RequestDeniedException,
			InvalidRequestException;

	Details act(DetailsResponse placeDetailsResponse) 
		throws ZeroResultException, 
			OverQuotaException, 
			RequestDeniedException, 
			InvalidRequestException;
}
