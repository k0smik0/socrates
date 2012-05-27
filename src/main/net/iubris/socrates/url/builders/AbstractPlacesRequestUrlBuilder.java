/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * AbstractPlacesRequestUrlBuilder.java is part of 'Socrates'.
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
package net.iubris.socrates.url.builders;

import com.google.api.client.http.GenericUrl;

import net.iubris.socrates.config.PlaceConfig;
import net.iubris.socrates.url.PlaceUrlConfigParameter;

public abstract class AbstractPlacesRequestUrlBuilder<B> implements IPlacesRequestUrlBuilder<B> {	
	
	private final GenericUrl mandatoryUrl;
	
	protected final PlaceConfig placeConfig;	
	protected GenericUrl buildedUrl;
	
	public AbstractPlacesRequestUrlBuilder(AbstractRequestUrlMandatoryBuilder requestUrlMandatoryBuilder, 
			PlaceConfig placesConfig) {		
		this.mandatoryUrl = requestUrlMandatoryBuilder.getUrl();
		this.buildedUrl = mandatoryUrl.clone();
		this.placeConfig = placesConfig;
	}
	
	public GenericUrl getUrl() {
		return buildedUrl;
	}
	/*
	@Override
	public B resetUrl() {
		resetUrlFromSuperClass();
		return null;
	}*/
	
	protected void resetUrlFromSuperClass() {
		this.buildedUrl = mandatoryUrl.clone();
	}
	
	protected void setValue(PlaceUrlConfigParameter placeUrlParameter, Object value) {		
		if (!isPresent(placeUrlParameter)) buildedUrl.put(placeUrlParameter.name(), "");
		buildedUrl.set(placeUrlParameter.name(), value);
	}
	
	private boolean isPresent(PlaceUrlConfigParameter placeUrlParameter) {
		final String key = placeUrlParameter.name();
		if (buildedUrl.containsKey(key)) return true;
		return false;
	}

	
	
	/*protected AbstractPlacesRequestUrlBuilder resetUrl() {
		this.buildedUrl = mandatoryUrl.clone();
		return this;
	}*/
	
	/*
	protected static void setValue(GenericUrl  requestToBeBuildedGenericUrl, PlaceUrlConfigParameter placeUrlParameter, Object value) {		
		if (!isPresent(requestToBeBuildedGenericUrl, placeUrlParameter)) requestToBeBuildedGenericUrl.put(placeUrlParameter.name(), "");
		requestToBeBuildedGenericUrl.set(placeUrlParameter.name(), value);
	}
	
	private static boolean isPresent(GenericUrl  requestToBeBuildedGenericUrl, PlaceUrlConfigParameter placeUrlParameter) {
		final String key = placeUrlParameter.name();
		if (requestToBeBuildedGenericUrl.containsKey(key)) return true;
		return false;
	}*/
}
