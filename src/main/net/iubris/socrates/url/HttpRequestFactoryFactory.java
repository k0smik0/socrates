/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * HttpRequestFactoryFactory.java is part of 'Socrates'
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
package net.iubris.socrates.url;

import com.google.api.client.googleapis.GoogleHeaders;
import com.google.api.client.http.HttpParser;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;

public class HttpRequestFactoryFactory {
	
	static public HttpRequestFactory createRequestFactory(final HttpTransport transport, 
		final String applicationName, 
		final HttpParser httpParser) {
		return transport.createRequestFactory(new HttpRequestInitializer() {
			@Override
			public void initialize(HttpRequest request) {
			    GoogleHeaders headers = new GoogleHeaders();
			    headers.setApplicationName(applicationName);
			    request.setHeaders(headers);		    		    
			    /* old
			    JsonHttpParser parser = new JsonHttpParser();
			    parser.jsonFactory = new JacksonFactory();  
			    */
			    //JsonHttpParser parser = new JsonHttpParser(new JacksonFactory());
			    request.addParser(httpParser);
		   }
		} );
	}		
}
