/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * PlacesHttpRequestFactoryProvider.java is part of 'Socrates'
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
package net.iubris.socrates._roboguice.providers.http;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import net.iubris.socrates._roboguice.providers.annotations.PlacesHttpParser;
import net.iubris.socrates._roboguice.providers.annotations.PlacesHttpTransport;
import net.iubris.socrates.config.ConfigMandatory;

import com.google.api.client.http.HttpParser;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;

public class PlacesHttpRequestFactoryProvider implements Provider<HttpRequestFactory> {
	
	private final HttpTransport httpTransport;
	private final HttpParser httpParser;
	private final ConfigMandatory config;
	
	@Inject
	public PlacesHttpRequestFactoryProvider(
			ConfigMandatory configMandatory,
			@PlacesHttpTransport HttpTransport httpTransport,  
			@PlacesHttpParser HttpParser httpParser) {
		this.config = configMandatory;
		this.httpTransport = httpTransport;
		this.httpParser = httpParser;
	}
	
	@Override @Singleton
	public HttpRequestFactory get() {		
		return HttpRequestFactoryFactory.createRequestFactory(httpTransport, 
				config.getApplicationName(), 
				httpParser);
	}

}
