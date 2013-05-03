/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * AbstractPlaceUrl.java is part of 'Socrates'
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
package net.iubris.socrates._roboguice.providers.url.common;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import com.google.api.client.http.GenericUrl;

@Singleton
public class CommonPartPlaceUrlProvider implements Provider<GenericUrl>{

	private final String placeScheme = "https";
	private final String placeHost = "maps.googleapis.com";	
	private final List<String> placePathParts = Arrays.asList( "","maps","api","place");
	
	private GenericUrl genericUrl;
	
	/*
	public CommonPartPlaceUrl(GenericUrl genericUrl, ServiceType serviceType) {
		this.genericUrl = genericUrl;
		genericUrl.setScheme(placeScheme);
		genericUrl.setHost(placeHost);
		final List<String> localPlacePathParts = new ArrayList<String>();
		localPlacePathParts.addAll(placePathParts);
		localPlacePathParts.add(serviceType.getServiceName());
		genericUrl.setPathParts( localPlacePathParts );
	}*/
	
	@Inject
	public CommonPartPlaceUrlProvider(GenericUrl genericUrl) {
		this.genericUrl = genericUrl;
		genericUrl.setScheme(placeScheme);
		genericUrl.setHost(placeHost);
//		final List<String> localPlacePathParts = new ArrayList<String>();
//		localPlacePathParts.addAll(placePathParts);
//		localPlacePathParts.add(serviceTypeName);
		genericUrl.setPathParts( placePathParts );		
	}
	
	/*
	public CommonPartPlaceUrlBuilder(GenericUrl genericUrl) {
		this.genericUrl = genericUrl;
		genericUrl.setScheme(placeScheme);
		genericUrl.setHost(placeHost);
		final List<String> localPlacePathParts = new ArrayList<String>();
		localPlacePathParts.addAll(placePathParts);
		//localPlacePathParts.add(serviceTypeName);
		genericUrl.setPathParts( localPlacePathParts );		
	}*/
	
	public GenericUrl get() {
		return genericUrl;
	}	
}
