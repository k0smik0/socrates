package net.iubris.socrates.url;

import com.google.api.client.http.HttpParser;
import com.google.api.client.http.json.JsonHttpParser;
import com.google.api.client.json.jackson.JacksonFactory;

public enum HttpParserOutputType {	
	json {
		@Override
		public HttpParser getHttpParser() {		
			return new JsonHttpParser(new JacksonFactory());
		}
	},
	xml {
		@Override
		public HttpParser getHttpParser() {
			//return new XmlHttpParser(new XmlNamespaceDictionary());
			return null;
		}		
	};
	
	public abstract HttpParser getHttpParser();	
}
