package net.iubris.socrates.engines.base.url;

import java.net.URI;
import java.net.URISyntaxException;

public class UrlUtils {

	public static URI buildURI(String urlString) {
		try {
			if (urlString != null) {			
				return new URI(urlString);
			}
		} catch (URISyntaxException e) {
			System.out.println( "UrlUtils, catched exception"+e.getClass() );
			e.printStackTrace();		 
		}
		return null;
	}

}
