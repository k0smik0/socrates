/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlacesSearcherGeneric.java is part of 'Socrates'
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
package net.iubris.socrates.engine.searches;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.JsonProcessingException;

import net.iubris.socrates.engine.searches.exception.PlacesSearcherException;
import net.iubris.socrates.engine.searches.url.SearchRequestUrlBuilder;
import net.iubris.socrates.model.data.place.PlaceType;
import android.location.Location;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;

public class PlacesSearcherGeneric<PL> {
	
	private final SearchRequestUrlBuilder placeRequestUrlBuilder;
	private final HttpRequestFactory httpRequestFactory;
	private final Class<	PL> parsingClass;	
		
	public PlacesSearcherGeneric(SearchRequestUrlBuilder placeRequestUrlBuilder,
			HttpRequestFactory httpRequestFactory, 
			Class<PL> parsingClass) {
		this.placeRequestUrlBuilder = placeRequestUrlBuilder;
		this.httpRequestFactory = httpRequestFactory;
		this.parsingClass = parsingClass;
	}

	public PL searchPlaces(Location location) throws  PlacesSearcherException {
		placeRequestUrlBuilder.resetUrl().initConfigRadiusTypesNames().buildUrl(location);
		return searchPlaces(placeRequestUrlBuilder);	
	}	
	public PL searchPlaces(Location location, Set<PlaceType> types) throws PlacesSearcherException {
		placeRequestUrlBuilder.resetUrl().initConfigRadius().buildUrl(location).buildUrl(types);
		return searchPlaces(placeRequestUrlBuilder);
	}
	public PL searchPlaces(Location location, Set<PlaceType> types, List<String> names) throws PlacesSearcherException {
		placeRequestUrlBuilder.resetUrl().initConfigRadius().buildUrl(location).buildUrl(types).buildUrl(names);
		return searchPlaces(placeRequestUrlBuilder);
	}
	
	private PL searchPlaces(SearchRequestUrlBuilder placeRequestUrlBuilder) throws PlacesSearcherException {
		return searchPlaces(httpRequestFactory, placeRequestUrlBuilder.getUrl(), parsingClass);
	}
	
	
	private static <PL> PL searchPlaces(HttpRequestFactory httpRequestFactory, GenericUrl genericUrl, Class<PL> parsingClass) throws PlacesSearcherException {
		try {
			//Ln.d(genericUrl);
			return httpRequestFactory.buildGetRequest(genericUrl).execute().parseAs(parsingClass);
		} catch (GoogleJsonResponseException e) {
			e.printStackTrace();
			throw new PlacesSearcherException(e.getMessage());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new PlacesSearcherException(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new PlacesSearcherException(e.getMessage());
		}
	}

	
}
