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

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.JsonProcessingException;

import net.iubris.socrates.model.data.places.PlaceType;
import net.iubris.socrates.model.data.places.search.PlacesSearchResponse;
import net.iubris.socrates.searcher.exception.PlacesSearcherException;
import net.iubris.socrates.searcher.url.SearchRequestUrlBuilder;

import android.location.Location;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Inject;

public class PlacesSearcher /*extends PlacesSearcherGeneric<PlacesSearchResponse>*/ {
		/*
	@Inject
	public PlacesSearcher(SearchRequestUrlBuilder placeRequestUrlBuilder,
			@PlacesHttpRequestFactory HttpRequestFactory httpRequestFactory) {
		super(placeRequestUrlBuilder,httpRequestFactory,PlacesSearchResponse.class);
	}*/
	
	private final SearchRequestUrlBuilder placeRequestUrlBuilder;
	private final HttpRequestFactory httpRequestFactory;
	//private final Class<PlacesSearchResponse> parsingClass;	
		
	@Inject
	public PlacesSearcher(SearchRequestUrlBuilder placeRequestUrlBuilder,
			HttpRequestFactory httpRequestFactory/*, 
			Class<PlacesSearchResponse> parsingClass*/) {
		this.placeRequestUrlBuilder = placeRequestUrlBuilder;
		this.httpRequestFactory = httpRequestFactory;
		//this.parsingClass = parsingClass;
	}

	public PlacesSearchResponse searchPlaces(Location location) throws  PlacesSearcherException {
		placeRequestUrlBuilder.resetUrl().initConfigRadiusTypesNames().buildUrl(location);
		return searchPlaces(placeRequestUrlBuilder);	
	}	
	public PlacesSearchResponse searchPlaces(Location location, Set<PlaceType> types) throws PlacesSearcherException {
		placeRequestUrlBuilder.resetUrl().initConfigRadius().buildUrl(location).buildUrl(types);
		return searchPlaces(placeRequestUrlBuilder);
	}
	public PlacesSearchResponse searchPlaces(Location location, Set<PlaceType> types, List<String> names) throws PlacesSearcherException {
		placeRequestUrlBuilder.resetUrl().initConfigRadius().buildUrl(location).buildUrl(types).buildUrl(names);
		return searchPlaces(placeRequestUrlBuilder);
	}
	
	private PlacesSearchResponse searchPlaces(SearchRequestUrlBuilder placeRequestUrlBuilder) throws PlacesSearcherException {
		return searchPlaces(httpRequestFactory, placeRequestUrlBuilder.getUrl()/*, parsingClass*/);
	}
	
	private PlacesSearchResponse searchPlaces(HttpRequestFactory httpRequestFactory, GenericUrl genericUrl/*, Class<PlacesSearchResponse> parsingClass*/) throws PlacesSearcherException {
		try {
			//Ln.d(genericUrl);
			return httpRequestFactory.buildGetRequest(genericUrl).execute().parseAs(/*parsingClass*/PlacesSearchResponse.class);
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
	
	/*
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
	}*/
}
