package net.iubris.socrates.url;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.http.GenericUrl;

public abstract class AbstractPlaceUrl {

	private static final String placeScheme = "https";
	private static final String placeHost = "maps.googleapis.com";	
	private static final List<String> placePathParts = Arrays.asList( "","maps","api","place");
	
	private GenericUrl genericUrl;
	
	public AbstractPlaceUrl(GenericUrl genericUrl, PlaceUrlFinalPart placeUrlFinalPart) {
		this.genericUrl = genericUrl;
		genericUrl.setScheme(placeScheme);
		genericUrl.setHost(placeHost);
		final List<String> localPlacePathParts = new ArrayList<String>();
		localPlacePathParts.addAll(placePathParts);
		localPlacePathParts.add(placeUrlFinalPart.name());
		genericUrl.setPathParts( localPlacePathParts );
	}	
	
	public GenericUrl getUrl() {
		return genericUrl;
	}	
	
}
