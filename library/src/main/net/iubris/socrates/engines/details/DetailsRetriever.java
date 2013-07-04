/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * DetailsRetriever.java is part of 'Socrates'.
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
package net.iubris.socrates.engines.details;


import java.io.IOException;

import javax.inject.Inject;

import net.iubris.socrates.engines.base.annotations.PlacesHttpRequestFactory;
import net.iubris.socrates.engines.details.exception.DetailsRetrieverException;
import net.iubris.socrates.engines.details.url.DetailsRequestUrlBuilder;
import net.iubris.socrates.model.http.request.url.language.Language;
import net.iubris.socrates.model.http.response.details.DetailsResponse;

import org.codehaus.jackson.JsonProcessingException;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;

public class DetailsRetriever {
	
	private final DetailsRequestUrlBuilder detailsRequestUrlBuilder;
	private final HttpRequestFactory httpRequestFactory;
	
	@Inject
	public DetailsRetriever(DetailsRequestUrlBuilder detailstRequestUrlBuilder,
			@PlacesHttpRequestFactory HttpRequestFactory httpRequestFactory) {
		this.detailsRequestUrlBuilder = detailstRequestUrlBuilder;
		this.httpRequestFactory = httpRequestFactory;
	}
	
	public DetailsRetriever setLanguage(Language language) {		
		detailsRequestUrlBuilder.setLanguage(language);
		return this;
	}
	
	public DetailsRetriever reset(){
		detailsRequestUrlBuilder.resetUrl();
		return this;
	}
	
	public DetailsResponse retrieve(String reference) throws DetailsRetrieverException {	
		detailsRequestUrlBuilder.setReference(reference);
		return retrieve(detailsRequestUrlBuilder.getUrl());
	}
	
	private DetailsResponse retrieve(GenericUrl genericUrl) throws DetailsRetrieverException {
		try {
			return httpRequestFactory.buildGetRequest(detailsRequestUrlBuilder.getUrl()).execute().parseAs(DetailsResponse.class);
		} catch (GoogleJsonResponseException e) {
//			e.printStackTrace();
			throw new DetailsRetrieverException(e);
		} catch (JsonProcessingException e) {
//			e.printStackTrace();
			throw new DetailsRetrieverException(e);
		} catch (IOException e) {
//			e.printStackTrace();
			throw new DetailsRetrieverException(e);
		}catch (NullPointerException e) {
//			e.printStackTrace();
			throw new DetailsRetrieverException(e);
		}
	}
	
}
