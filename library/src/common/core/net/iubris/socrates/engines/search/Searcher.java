/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * Searcher.java is part of 'Socrates'.
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
package net.iubris.socrates.engines.search;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import net.iubris.socrates.config.SearchOptions;
import net.iubris.socrates.engines.base.annotations.PlacesHttpRequestFactory;
import net.iubris.socrates.engines.search.exception.MalformedSearchUrlConfigException;
import net.iubris.socrates.engines.search.exception.NullConfigException;
import net.iubris.socrates.engines.search.exception.PlacesSearcherException;
import net.iubris.socrates.engines.search.url.SearchRequestUrlBuilder;
import net.iubris.socrates.engines.search.url.annotation.SearchRequestMandatoryUrl;
import net.iubris.socrates.model.http.request.url.ParameterKey;
import net.iubris.socrates.model.http.request.url.language.Language;
import net.iubris.socrates.model.http.request.url.parameters.optional.search.SearchOptionalParameter;
import net.iubris.socrates.model.http.request.url.parameters.optional.search.values.RankBy;
import net.iubris.socrates.model.http.response.data.search.GooglePlaceType;
import net.iubris.socrates.model.http.response.search.SearchResponse;

import org.codehaus.jackson.JsonProcessingException;

import android.location.Location;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;

public class Searcher {
	
	private final SearchRequestUrlBuilder searchRequestUrlBuilder;
	private final HttpRequestFactory httpRequestFactory;

	private final GenericUrl nextPageTokenRequestUrl;
	//private final Integer radius;	

	private final SearchOptions configOptionalDefault;
	
		
	@Inject
	public Searcher(SearchRequestUrlBuilder searchRequestUrlBuilder,
			@SearchRequestMandatoryUrl GenericUrl nextPageTokenRequestUrl,
			@PlacesHttpRequestFactory HttpRequestFactory httpRequestFactory//,
			//@Radius Integer radius
			
			,/*@Config*/ SearchOptions configOptional) throws MalformedSearchUrlConfigException {
		this.searchRequestUrlBuilder = searchRequestUrlBuilder;
		this.nextPageTokenRequestUrl = nextPageTokenRequestUrl;
		//this.radius = radius;
		this.nextPageTokenRequestUrl.put(SearchOptionalParameter.pagetoken.name(), "");
		//urlForNextPage = searchRequestUrlBuilder.getUrl().clone();
		this.httpRequestFactory = httpRequestFactory;
		this.configOptionalDefault = configOptional;
		initFromConfig(configOptionalDefault);
//System.out.println("net.iubris.socrates.engines.search.Searcher: "+hashCode() );
	}
	
	/*
	@Inject(optional=true)
	public void setConfig(@Config ConfigOptional configOptional) {
		this.configOptional = configOptional;
	}*/
	
	public Searcher reset() {
		searchRequestUrlBuilder.resetUrl();
		return this;
	}
	public Searcher setSearchOptions(SearchOptions searchOptions) throws NullConfigException, MalformedSearchUrlConfigException {
		if (searchOptions==null ) throw new NullConfigException("config must be not null");
//		this.configOptionalDefault = configOptional;
		return initFromConfig(searchOptions);
	}
	public Searcher resetSearchOptions() throws MalformedSearchUrlConfigException {
		return initFromConfig(configOptionalDefault);
	}
	
	private Searcher initFromConfig(SearchOptions configOptionalDefault) throws MalformedSearchUrlConfigException /*throws NullConfigException, MalformedSearchUrlConfigException */{
//		if (configOptional==null ) throw new NullConfigException("config not setted");
		
		Language language = configOptionalDefault.getLanguage();
		if (language != null) setLanguage( language );
		
		String keyword = configOptionalDefault.getKeyword();
		if (keyword != null && keyword != "") setKeyword(keyword);
		
		Set<GooglePlaceType> types = configOptionalDefault.getTypes();
		if (types != null && !types.isEmpty()) setTypes(types);
		
		List<String> names = configOptionalDefault.getNames();
		if (names != null && !names.isEmpty()) setNames(names);
		
//Log.d("115",""+searchRequestUrlBuilder.getUrl());
//System.out.println("116 "+searchRequestUrlBuilder.getUrl());
		
		RankBy rankBy = configOptionalDefault.getRankBy();
		if (rankBy != null) {
			if (rankBy.equals(RankBy.prominence)) {
				// if prominence, add radius
				Integer radius = configOptionalDefault.getRadius();
				if (radius !=null && radius >0) { 
					setRadius(configOptionalDefault.getRadius());
					return this;
				}
				throw new MalformedSearchUrlConfigException("with prominence, you must provide radius parameter");
			}			
//			try {
			setRankBy(rankBy); // if not prominence, it's distance
//			} catch (MalformedSearchUrlConfigException e) {
//				e.printStackTrace();
//			}			
		}
		
//Log.d(getClass().getSimpleName()+":127",""+searchRequestUrlBuilder.getUrl());
		
		return this;
	}
	
	public GenericUrl getRequestUrl() {
		return searchRequestUrlBuilder.getUrl();
	}
		
	public Searcher setRadius(int radius) /*throws MalformedSearchUrlException */{
		//if (radius<0) throw new MalformedSearchUrlException("radius must be greater than zero");			
		searchRequestUrlBuilder.setRadius(radius);		
		return this;
	}
		
	public Searcher setLanguage(Language language) {		
		searchRequestUrlBuilder.setLanguage(language);
		return this;
	}
	public Searcher setTypes(Set<GooglePlaceType> types){
		searchRequestUrlBuilder.setTypes(types);
		return this;
	}	
	public Searcher setNames(List<String> names){
		searchRequestUrlBuilder.setNames(names);
		return this;
	}
	public Searcher setKeyword(String keyword){
		searchRequestUrlBuilder.setKeyword(keyword);
		return this;
	}
	public Searcher setRankBy(RankBy rankBy) throws MalformedSearchUrlConfigException {		
		/*if (rankBy.equals(RankBy.distance)) {
			//if ( isParameterInUrl(SearchOptionalParameter.radius)) {
				searchRequestUrlBuilder.removeRadius();
				searchRequestUrlBuilder.setRankBy(rankBy);
				//throw new MalformedSearchUrlException("you must not provide radius");
		} else if (rankBy.equals(RankBy.prominence)) {
			if ( isParameterInUrl(SearchOptionalParameter.types) || isParameterInUrl(SearchOptionalParameter.names) || isParameterInUrl(SearchOptionalParameter.keyword) ) {
				searchRequestUrlBuilder.setRankBy(rankBy);
			}
//			} else {
//				throw new MalformedSearchUrlConfigException("you must provide one of 'names', 'types' or 'keyword' parameters");
//			}
		}*/
//System.out.println("181 "+searchRequestUrlBuilder.getUrl());
		if (rankBy.equals(RankBy.distance)) {
//Log.d(getClass().getSimpleName()+":173","we want use distance in url");
			if ( isParameterInUrl(SearchOptionalParameter.types) || isParameterInUrl(SearchOptionalParameter.names) || isParameterInUrl(SearchOptionalParameter.keyword) ) {
				if (isParameterInUrl(SearchOptionalParameter.radius)) {
//Log.d(getClass().getSimpleName()+":178","found radius, removing");
					searchRequestUrlBuilder.removeRadius();
//Log.d(getClass().getSimpleName()+":178",""+isParameterInUrl(SearchOptionalParameter.radius));
				}
				searchRequestUrlBuilder.setRankBy(rankBy);
				return this;
			}
			throw new MalformedSearchUrlConfigException("you must provide one of 'names', 'types' or 'keyword' parameters");
		}
		return this;
	}
	private boolean isParameterInUrl(ParameterKey parameter){
		/*for ( String k : searchRequestUrlBuilder.getUrl().keySet()) {
			System.out.println("198: "+k);
		}*/
//System.out.println("200: "+parameter.name()+" "+searchRequestUrlBuilder.getUrl().containsKey(parameter.name()));
		return searchRequestUrlBuilder.getUrl().containsKey(parameter.name());
	}
	
		
	// TODO restore Location
	public SearchResponse search(/*Location location*/ double latitude, double longitude) throws PlacesSearcherException {
		// TODO restore
//		formatLocationDecimalPlaces(location);
//		searchRequestUrlBuilder.setLocation(location);

		searchRequestUrlBuilder.setLocation(latitude, longitude);
//Log.d("Searcher:165", "searchRequestUrlBuilder.getUrl(): "+searchRequestUrlBuilder.getUrl() );
		return searchPlaces( searchRequestUrlBuilder.getUrl() );
	}
	public SearchResponse search(String nextPageToken) throws PlacesSearcherException {
		nextPageTokenRequestUrl.set(SearchOptionalParameter.pagetoken.name(), nextPageToken);		
		return searchPlaces( nextPageTokenRequestUrl );
	}
	
	protected void formatLocationDecimalPlaces(Location location) {
//		DecimalFormat dec = new DecimalFormat("##.######");
		DecimalFormat dec = new DecimalFormat("00.000000");
//		NumberFormat dec = NumberFormat.getCurrencyInstance();
//		dec.setMaximumFractionDigits(6);
		String latString = dec.format(location.getLatitude()).replace(",", ".");
//		Log.d("Searcher:184",latString);
		float fLat = Float.parseFloat(latString);
		location.setLatitude( fLat );
		
		String lngString = dec.format(location.getLongitude()).replace(",", ".");
		float fLng = Float.parseFloat(lngString);
		location.setLongitude( fLng );
//		Dec
	}
	
		
	
/*
	public SearchResponse searchPlaces(Location location) throws SearcherException {
		searchRequestUrlBuilder.resetUrl().setRadiusAndTypesAndNames().setLocation(location);
System.out.println(searchRequestUrlBuilder.getUrl());
		return searchPlaces(searchRequestUrlBuilder);	
	}
	public SearchResponse searchPlaces(Location location, int radius) throws SearcherException {
		searchRequestUrlBuilder.resetUrl().setRadius(radius).setLocation(location);
		return searchPlaces(searchRequestUrlBuilder);
	}
	public SearchResponse searchPlaces(Location location, Set<PlaceType> types) throws SearcherException {
		searchRequestUrlBuilder.resetUrl().setRadius().setLocation(location).setTypes(types);
		return searchPlaces(searchRequestUrlBuilder);
	}
	public SearchResponse searchPlaces(Location location, List<String> names) throws SearcherException {
		searchRequestUrlBuilder.resetUrl().setRadius().setLocation(location).setNames(names);
		return searchPlaces(searchRequestUrlBuilder);
	}
	public SearchResponse searchPlaces(Location location, Set<PlaceType> types, List<String> names) throws SearcherException {
		searchRequestUrlBuilder.resetUrl().setRadius().setLocation(location).setTypes(types).setNames(names);
		return searchPlaces(searchRequestUrlBuilder);
	}
	public SearchResponse searchPlaces(Location location, int radius, Set<PlaceType> types) throws SearcherException {
		searchRequestUrlBuilder.resetUrl().setRadius(radius).setLocation(location).setTypes(types);
		return searchPlaces(searchRequestUrlBuilder);
	}
	public SearchResponse searchPlaces(Location location, int radius, List<String> names) throws SearcherException {
		searchRequestUrlBuilder.resetUrl().setRadius(radius).setLocation(location).setNames(names);
		return searchPlaces(searchRequestUrlBuilder);
	}
	public SearchResponse searchPlaces(Location location, int radius, Set<PlaceType> types, List<String> names) throws SearcherException {
		searchRequestUrlBuilder.resetUrl().setRadius(radius).setLocation(location).setTypes(types).setNames(names);
		return searchPlaces(searchRequestUrlBuilder);
	}
		
	public SearchResponse searchPlaces(String nextPageToken) throws SearcherException {
		searchRequestUrlBuilder
		.resetUrl()
		.setNextPageToken(nextPageToken);
System.out.println( searchRequestUrlBuilder.getUrl() );
		return searchPlaces(searchRequestUrlBuilder);
	}
	*/
	
	private SearchResponse searchPlaces(GenericUrl searchRequestUrl) throws PlacesSearcherException {		
		return searchPlaces(httpRequestFactory, searchRequestUrl);
	}	
	
	private SearchResponse searchPlaces(HttpRequestFactory httpRequestFactory, GenericUrl genericUrl/*, Class<PlacesSearchResponse> parsingClass*/) throws PlacesSearcherException {
		try {
			//Ln.d(genericUrl);
			HttpResponse httpResponse = httpRequestFactory.buildGetRequest(genericUrl).execute();
//			System.out.println(  httpResponse.parseAsString() );
			return httpResponse.parseAs(SearchResponse.class);
		} catch (GoogleJsonResponseException e) {
			System.out.println("GoogleJsonResponseException");
			throw new PlacesSearcherException(e);
		} catch (JsonProcessingException e) {
			System.out.println("JsonProcessingException");
			throw new PlacesSearcherException(e);
		} catch (IOException e) {
			System.out.println("IOException");
			throw new PlacesSearcherException(e);
		}		
	}
}
