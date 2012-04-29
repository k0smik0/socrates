package net.iubris.socrates.searcher;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.JsonProcessingException;

import net.iubris.socrates.model.data.places.PlaceType;
import net.iubris.socrates.searcher.exception.PlacesSearcherException;
import net.iubris.socrates.searcher.url.SearchRequestUrlBuilder;
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
