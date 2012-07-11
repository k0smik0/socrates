/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlaceDetailsRetriever.java is part of 'Socrates'
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
package net.iubris.socrates.engines.details;


import java.io.IOException;
import net.iubris.socrates.engines.base.annotations.PlacesHttpRequestFactory;
import net.iubris.socrates.engines.details.exception.DetailsRetrieverException;
import net.iubris.socrates.engines.details.url.DetailsRequestUrlBuilder;
import net.iubris.socrates.model.http.details.DetailsResponse;

import org.codehaus.jackson.JsonProcessingException;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Inject;

public class DetailsRetriever {
	
	private final DetailsRequestUrlBuilder placeDetailsRequestUrlBuilder;
	private final HttpRequestFactory httpRequestFactory;
	
	@Inject
	public DetailsRetriever(DetailsRequestUrlBuilder placeDetailstRequestUrlBuilder,
			@PlacesHttpRequestFactory HttpRequestFactory httpRequestFactory) {
		this.placeDetailsRequestUrlBuilder = placeDetailstRequestUrlBuilder;
		this.httpRequestFactory = httpRequestFactory;
	}
	
	public DetailsResponse retrieveDetails(String reference) throws DetailsRetrieverException {
//Ln.d(reference);		
		placeDetailsRequestUrlBuilder.resetUrl().setReference(reference);
		try {

//			GenericUrl url = placeDetailsRequestUrlBuilder.getUrl();
//			
//			HttpRequest httpRequest = httpRequestFactory.buildGetRequest(url);
/*
			HttpResponse httpResponse = httpRequestFactory.buildGetRequest(placeDetailsRequestUrlBuilder.getUrl()).execute();

			//System.out.println( httpResponse.parseAsString() );
			
			DetailsResponse detailsResponse = httpResponse.parseAs(DetailsResponse.class);
								
			 Iterator<Review> iterator = detailsResponse.getResult().getReviews().iterator();
			 while (iterator.hasNext()) {
				 List<AspectRating> aspects = iterator.next().getAspects();
				 Iterator<AspectRating> iterator2 = aspects.iterator();
				 while (iterator2.hasNext()) {
					 System.out.println( iterator2.next().getType() );
				 }
			 }
	
			return detailsResponse;
			*/
			return httpRequestFactory.buildGetRequest(placeDetailsRequestUrlBuilder.getUrl()).execute().parseAs(DetailsResponse.class);
		} catch (GoogleJsonResponseException e) {
			e.printStackTrace();
			throw new DetailsRetrieverException(e.getMessage());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new DetailsRetrieverException(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new DetailsRetrieverException(e.getMessage());
		}/*catch (NullPointerException e) {
			e.printStackTrace();
			throw new PlaceDetailsRetrieverException(e.getMessage());
		}*/
	}
	


}
