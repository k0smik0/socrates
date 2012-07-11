/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * AbstractPlacesRequestUrlBuilder.java is part of 'Socrates'
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
package net.iubris.socrates.engines.base.url.builders;

import com.google.api.client.http.GenericUrl;

import net.iubris.socrates.model.url.parameters.ConfigParameter;
import net.iubris.socrates.model.url.parameters.DetailsConfigParameter;
import net.iubris.socrates.model.url.parameters.SearchConfigParameter;

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
	
	protected void setValue(SearchConfigParameter placeUrlParameter, String value) {		
//		if (!isPresent(placeUrlParameter)) buildedUrl.put(placeUrlParameter.name(), "");
//		buildedUrl.set(placeUrlParameter.name(), value);
		setParameter(placeUrlParameter, value);
	}
	
	protected void setValue(DetailsConfigParameter placeUrlParameter, String value) {		
//		if (!isPresent(placeUrlParameter)) buildedUrl.put(placeUrlParameter.name(), "");
//		buildedUrl.set(placeUrlParameter.name(), value);		
		setParameter(placeUrlParameter, value);
	}
	
	private void setParameter(ConfigParameter placeUrlParameter, String value) {
		if (!isPresent(placeUrlParameter)) buildedUrl.put(placeUrlParameter.getName(), "");
		buildedUrl.set(placeUrlParameter.getName(), value);
	}
	
	private boolean isPresent(ConfigParameter placeUrlParameter) {
		final String key = placeUrlParameter.getName();
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
