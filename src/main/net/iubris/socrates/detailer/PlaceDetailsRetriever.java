package net.iubris.socrates.detailer;


import java.io.IOException;

import net.iubris.socrates._roboguice.providers.annotations.PlacesHttpRequestFactory;
import net.iubris.socrates.detailer.exception.PlaceDetailsRetrieverException;
import net.iubris.socrates.model.data.places.details.PlaceDetailsResponse;

import org.codehaus.jackson.JsonProcessingException;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Inject;

public class PlaceDetailsRetriever {
	
	private final PlaceDetailsRequestUrlBuilder placeDetailsRequestUrlBuilder;
	private final HttpRequestFactory httpRequestFactory;
	
	@Inject
	public PlaceDetailsRetriever(PlaceDetailsRequestUrlBuilder placeDetailstRequestUrlBuilder,
			@PlacesHttpRequestFactory HttpRequestFactory httpRequestFactory) {
		this.placeDetailsRequestUrlBuilder = placeDetailstRequestUrlBuilder;
		this.httpRequestFactory = httpRequestFactory;
	}
	
	public PlaceDetailsResponse retrieveDetails(String reference) throws PlaceDetailsRetrieverException {
//Ln.d(reference);		
		placeDetailsRequestUrlBuilder.resetUrl().buildUrl(reference);
		try {

			/*GenericUrl url = placeDetailsRequestUrlBuilder.getUrl();
			
			HttpRequest httpRequest = httpRequestFactory.buildGetRequest(url);

			HttpResponse httpResponse = httpRequest.execute();

			PlaceDetailsResponse placeDetailsResponse = httpResponse.parseAs(PlaceDetailsResponse.class);
	
			return placeDetailsResponse;*/
			return httpRequestFactory.buildGetRequest(placeDetailsRequestUrlBuilder.getUrl()).execute().parseAs(PlaceDetailsResponse.class);
		} catch (GoogleJsonResponseException e) {
			e.printStackTrace();
			throw new PlaceDetailsRetrieverException(e.getMessage());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new PlaceDetailsRetrieverException(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new PlaceDetailsRetrieverException(e.getMessage());
		}/*catch (NullPointerException e) {
			e.printStackTrace();
			throw new PlaceDetailsRetrieverException(e.getMessage());
		}*/
	}
	


}
