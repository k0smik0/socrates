package net.iubris.socrates.engine.events;

import java.io.IOException;

import net.iubris.socrates._roboguice.providers.annotations.PlacesHttpRequestFactory;
import net.iubris.socrates.engine.events.exception.PlaceEventsRetrieverException;
import net.iubris.socrates.engine.events.url.PlaceEventsRequestUrlBuilder;
import net.iubris.socrates.model.data.place.events.PlaceEventsResponse;

import org.codehaus.jackson.JsonProcessingException;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Inject;

public class PlaceEventsRetriever {

	private final PlaceEventsRequestUrlBuilder placeEventsRequestUrlBuilder;
	private final HttpRequestFactory httpRequestFactory;
	
	@Inject
	public PlaceEventsRetriever(PlaceEventsRequestUrlBuilder placeEventsRequestUrlBuilder ,
			@PlacesHttpRequestFactory HttpRequestFactory httpRequestFactory) {
		this.placeEventsRequestUrlBuilder = placeEventsRequestUrlBuilder;
		this.httpRequestFactory = httpRequestFactory;
	}
	
	public PlaceEventsResponse retrieveEvents(String reference) throws PlaceEventsRetrieverException {
//Ln.d(reference);		
		placeEventsRequestUrlBuilder.resetUrl().buildUrl(reference);
		try {			
			return httpRequestFactory.buildGetRequest(placeEventsRequestUrlBuilder.getUrl()).execute().parseAs(PlaceEventsResponse.class);
		} catch (GoogleJsonResponseException e) {
			e.printStackTrace();
			throw new PlaceEventsRetrieverException(e.getMessage());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new PlaceEventsRetrieverException(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new PlaceEventsRetrieverException(e.getMessage());
		}
	}	
}
