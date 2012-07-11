package net.iubris.socrates.model.data.details.review;

import java.net.URI;
import java.util.List;

import net.iubris.socrates.engines.base.url.UrlUtils;

import com.google.api.client.util.Key;

public class Review {
	
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
   //private String timeString;

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
