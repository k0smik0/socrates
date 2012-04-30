/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * AbstractPlaceUrl.java is part of socrates.
 * 
 * socrates is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * socrates is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with socrates ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
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
