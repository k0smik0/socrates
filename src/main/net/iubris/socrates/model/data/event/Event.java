/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * Event.java is part of 'Socrates'
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
