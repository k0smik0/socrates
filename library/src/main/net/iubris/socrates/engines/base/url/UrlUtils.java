package net.iubris.socrates.engines.base.url;

import java.net.URI;
import java.net.URISyntaxException;

import android.util.Log;

public class UrlUtils {

	public static URI buildURI(String urlString) {
		try {
			if (urlString != null) {			
				return new URI(urlString);
			}
		} catch (URISyntaxException e) {
			Log.d("UrlUtils:14", "catched exception"+e.getClass() );
//			e.printStackTrace();		 
		}
		return null;
	}

}
