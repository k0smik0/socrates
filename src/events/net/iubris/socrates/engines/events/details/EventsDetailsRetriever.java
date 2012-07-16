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
package net.iubris.socrates.engines.events.details;

import java.io.IOException;

import net.iubris.socrates.engines.base.annotations.PlacesHttpRequestFactory;
import net.iubris.socrates.engines.events.details.exception.EventDetailsRetrieverException;
import net.iubris.socrates.engines.events.details.url.EventDetailsRequestUrlBuilder;
import net.iubris.socrates.model.http.response.events.details.EventDetailsResponse;

import org.codehaus.jackson.JsonProcessingException;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Inject;

public class EventsDetailsRetriever {

	private final EventDetailsRequestUrlBuilder eventDetailsRequestUrlBuilder;
	private final HttpRequestFactory httpRequestFactory;
	
	@Inject
	public EventsDetailsRetriever(EventDetailsRequestUrlBuilder eventDetailstRequestUrlBuilder,
			@PlacesHttpRequestFactory HttpRequestFactory httpRequestFactory) {
		this.eventDetailsRequestUrlBuilder = eventDetailstRequestUrlBuilder;
		this.httpRequestFactory = httpRequestFactory;
	}
	
	public EventDetailsResponse retrieveDetails(String reference) throws EventDetailsRetrieverException {
//Ln.d(reference);		
		eventDetailsRequestUrlBuilder.resetUrl().setReference(reference);
		try {
			return httpRequestFactory.buildGetRequest(eventDetailsRequestUrlBuilder.getUrl()).execute().parseAs(EventDetailsResponse.class);
		} catch (GoogleJsonResponseException e) {
			e.printStackTrace();
			throw new EventDetailsRetrieverException(e.getMessage());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new EventDetailsRetrieverException(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new EventDetailsRetrieverException(e.getMessage());
		}/*catch (NullPointerException e) {
			e.printStackTrace();
			throw new PlaceDetailsRetrieverException(e.getMessage());
		}*/
	}
}
