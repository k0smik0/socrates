/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlacesSearcher.java is part of 'Socrates'
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
package net.iubris.socrates.engines.search;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.JsonProcessingException;

import net.iubris.socrates.engines.base.annotations.PlacesHttpRequestFactory;
import net.iubris.socrates.engines.search.exception.SearcherException;
import net.iubris.socrates.engines.search.url.SearchRequestUrlBuilder;
import net.iubris.socrates.model.data.search.PlaceType;
import net.iubris.socrates.model.http.search.SearchResponse;

import android.location.Location;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Inject;

public class Searcher {
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
	public Searcher(SearchRequestUrlBuilder placeRequestUrlBuilder,
			@PlacesHttpRequestFactory HttpRequestFactory httpRequestFactory/*, 
			Class<PlacesSearchResponse> parsingClass*/) {
		this.placeRequestUrlBuilder = placeRequestUrlBuilder;
		this.httpRequestFactory = httpRequestFactory;
		//this.parsingClass = parsingClass;
	}

	public SearchResponse searchPlaces(Location location) throws  SearcherException {
		placeRequestUrlBuilder.resetUrl().setRadiusAndTypesAndNames().setLocation(location);
		return searchPlaces(placeRequestUrlBuilder);	
	}	
	public SearchResponse searchPlaces(Location location, Set<PlaceType> types) throws SearcherException {
		placeRequestUrlBuilder.resetUrl().setRadius().setLocation(location).setTypes(types);
		return searchPlaces(placeRequestUrlBuilder);
	}
	public SearchResponse searchPlaces(Location location, Set<PlaceType> types, List<String> names) throws SearcherException {
		placeRequestUrlBuilder.resetUrl().setRadius().setLocation(location).setTypes(types).setNames(names);
		return searchPlaces(placeRequestUrlBuilder);
	}
	public SearchResponse searchPlaces(String nextPageToken) throws SearcherException {
		placeRequestUrlBuilder.resetUrl().setNextPageToken(nextPageToken);
//		System.out.println( placeRequestUrlBuilder.getUrl() );
		return searchPlaces(placeRequestUrlBuilder);
	}
	
	
	private SearchResponse searchPlaces(SearchRequestUrlBuilder placeRequestUrlBuilder) throws SearcherException {
		return searchPlaces(httpRequestFactory, placeRequestUrlBuilder.getUrl()/*, parsingClass*/);
	}
	
	private SearchResponse searchPlaces(HttpRequestFactory httpRequestFactory, GenericUrl genericUrl/*, Class<PlacesSearchResponse> parsingClass*/) throws SearcherException {
		try {
			//Ln.d(genericUrl);
			return httpRequestFactory.buildGetRequest(genericUrl).execute().parseAs(/*parsingClass*/SearchResponse.class);
		} catch (GoogleJsonResponseException e) {
			e.printStackTrace();
			throw new SearcherException(e.getMessage());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new SearcherException(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new SearcherException(e.getMessage());
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
