/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * Review.java is part of 'Socrates'.
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
package net.iubris.socrates.model.http.response.data.details.review;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import net.iubris.socrates.engines.base.url.UrlUtils;

import com.google.api.client.util.Key;

public class Review implements Serializable {
	
	private static final long serialVersionUID = 8110289096930054514L;

	@Key("aspects")
	private List<AspectRating> aspects;

	@Key("author_name")
	private String authorName;

	@Key("author_url")
	private String authorUrlString;

	private URI authorUrl;

	@Key("text")
	private String text;
	
	@Key("time")
//	private String timeString;

	private long time;

	public List<AspectRating> getAspects() {
		return aspects;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public URI getAuthorUrl() {
		if (authorUrl == null)
			authorUrl = UrlUtils.buildURI(authorUrlString);
		return authorUrl;
	}
	
	public String getText() {
		return text;
	}
	
	public long getTime() {
//		if (time==0)
//			Long.valueOf(timeString);
		return time;
	}
}
