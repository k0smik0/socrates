package net.iubris.socrates.model.data.event;

import java.net.URI;
import java.net.URISyntaxException;

import com.google.api.client.util.Key;

public class Event {
	
	@Key("event_id")
	private String eventId;
	
	@Key("start_time")
	private long startTime;
	
	@Key("summary")
	private String summary;
     
	@Key("url")
	private String urlString;
	
	private URI uri;
	
	public String getEventId() {
		return eventId;
	}
	public long getStartTime() {
		return startTime;
	}
	public String getSummary() {
		return summary;
	}
	
	public URI getUri() {
		if (uri == null) {
			uri = buildURI(urlString);
		}
		return uri;
	}
	
	private static URI buildURI(String urlString) {
		try {
			if (urlString != null) {			
				return new URI(urlString);
			}
		} catch (URISyntaxException e) {
			System.out.println(e.getClass());
			e.printStackTrace();		 
		}
		return null;
	}
	
	

}
