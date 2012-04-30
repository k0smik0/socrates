/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlacesSearcher.java is part of socrates.
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
