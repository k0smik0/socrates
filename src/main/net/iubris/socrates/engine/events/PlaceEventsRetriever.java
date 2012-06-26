/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlaceEventsRetriever.java is part of 'Socrates'
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
