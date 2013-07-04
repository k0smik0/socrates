/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * AbstractRequestUrlBuilder.java is part of 'Socrates'.
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
package net.iubris.socrates.engines.base.url.builders;


import net.iubris.socrates.model.http.request.url.ParameterKey;

import com.google.api.client.http.GenericUrl;

public abstract class AbstractRequestUrlBuilder<B> implements IRequestUrlBuilder<B> {	
	
	private final GenericUrl mandatoryUrl;
	
	//protected final PlaceConfig placeConfig;	
	protected GenericUrl buildedUrl;
	
	/*
	public AbstractPlacesRequestUrlBuilder(AbstractRequestMandatoryUrlBuilder requestMandatoryUrlBuilder
			//, PlaceConfig placeConfig
	) {		
		this.mandatoryUrl = requestMandatoryUrlBuilder.getUrl();
		this.buildedUrl = mandatoryUrl.clone();
		//this.placeConfig = placeConfig;
	}*/
	
	//injection way
	public AbstractRequestUrlBuilder(GenericUrl requestMandatoryUrl/*, 
			PlaceConfig placesConfig*/) {		
		this.mandatoryUrl = requestMandatoryUrl;
		this.buildedUrl = mandatoryUrl.clone();
		//this.placeConfig = placesConfig;
	}
	/*
	public AbstractPlacesRequestUrlBuilder(GenericUrl requestMandatoryUrl) {	
		this.mandatoryUrl = requestMandatoryUrl;
		this.buildedUrl = mandatoryUrl.clone();
		this.placeConfig = null;
	}*/	
	
	public GenericUrl getUrl() {
		return buildedUrl;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public B resetUrl() {
		resetUrlFromSuperClass();
		return (B) this;
	}
	
	protected void resetUrlFromSuperClass() {
		this.buildedUrl = mandatoryUrl.clone();
	}	
	
	/*
	protected void setValue(SearchMandatoryParameter urlParameter, String value) {		
//		if (!isPresent(placeUrlParameter)) buildedUrl.put(placeUrlParameter.name(), "");
//		buildedUrl.set(placeUrlParameter.name(), value);
		setParameter(urlParameter, value);
	}*/
	
	/*
	protected void setValue(DetailsMandatoryParameters urlParameter, String value) {		
//		if (!isPresent(placeUrlParameter)) buildedUrl.put(placeUrlParameter.name(), "");
//		buildedUrl.set(placeUrlParameter.name(), value);		
		setParameter(urlParameter, value);
	}*/
		
	/*
	protected void setParameterValue(ParameterKey urlParameterKey, ParameterValue value) {		
		setParameterValue(urlParameterKey, value.getName());
	}*/
	
	protected void setParameterValue(ParameterKey urlParameter, String value) {
		if ( isPresent(urlParameter) ) {
			buildedUrl.set(urlParameter.name(), value);			
		} else {
			buildedUrl.put(urlParameter.name(), value);
		}
	}
	/*
	protected void setParameterValue(ParameterKey urlParameter) {
		if ( isPresent(urlParameter) ) {
			buildedUrl.set(urlParameter.name(), "");			
		} else {
			buildedUrl.put(urlParameter.name(), "");
			buildedUrl.
		}
	}*/
	
	private boolean isPresent(ParameterKey urlParameter) {
		//final String key = urlParameter.name();
		if (buildedUrl.containsKey( urlParameter.name() )) return true;
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
