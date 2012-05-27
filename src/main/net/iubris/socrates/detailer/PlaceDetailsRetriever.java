/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlaceDetailsRetriever.java is part of 'Socrates'.
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
