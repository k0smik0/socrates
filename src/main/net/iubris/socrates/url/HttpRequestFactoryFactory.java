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
