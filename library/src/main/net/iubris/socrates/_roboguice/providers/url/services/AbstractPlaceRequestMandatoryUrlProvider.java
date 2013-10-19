/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * AbstractPlaceRequestMandatoryUrlProvider.java is part of 'Socrates'.
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
package net.iubris.socrates._roboguice.providers.url.services;

import javax.inject.Inject;
import javax.inject.Provider;

import net.iubris.socrates.config.ConfigMandatory;
import net.iubris.socrates.engines.base.url.annotation.CommonPartUrl;
import net.iubris.socrates.model.http.request.url.parameters.mandatory.common.CommonMandatoryParameters;
import net.iubris.socrates.model.http.request.url.service.ServiceType;

import com.google.api.client.http.GenericUrl;

public abstract class AbstractPlaceRequestMandatoryUrlProvider implements Provider<GenericUrl>{

	@Inject @CommonPartUrl
	private GenericUrl urlWithoutParameters;
	@Inject 
	private ConfigMandatory config;

	private final ServiceType serviceType;
	
	private GenericUrl mandatoryUrl;
	
	public AbstractPlaceRequestMandatoryUrlProvider(ServiceType serviceType) {
		this.serviceType = serviceType;
		/*
		this.urlWithoutParameters = urlWithoutParameters;
		this.placeConfig = placeConfig;
		*/
	//	this.serviceType = serviceType;		
	}
	
	public GenericUrl get() {
		
		mandatoryUrl = urlWithoutParameters.clone();
		
		mandatoryUrl.getPathParts().add(serviceType.getServiceName());
		
		//urlWithoutParameters.appendRawPath("/"+serviceType.getServiceName());
		
		addOutput();
		
		addMethod();
		
//		String key = config.getKey();
//		if (key.length()!=39)
//			throw new MandatoryConfigKeyException("Your key is invalid");
//		setValue(CommonMandatoryParameters.key, config.getKey());
		mandatoryUrl.put(CommonMandatoryParameters.key.name(), config.getKey());
		//System.out.println(mandatoryUrl);
//		setValue(CommonMandatoryParameters.sensor, config.isUseSensor());
		mandatoryUrl.put(CommonMandatoryParameters.sensor.name(), config.isUseSensor());
		//System.out.println(mandatoryUrl);
		
		return mandatoryUrl;
	}
	
	protected void addMethod() {}
	
	private void addOutput() {
		mandatoryUrl.appendRawPath("/"+config.getOutput().name());
	}
	
	/*
	private void setValue(CommonMandatoryParameters placeUrlParameter, Object value) {
		mandatoryUrl.put(placeUrlParameter.name(), value);
	}
	*/
	
	protected GenericUrl getMandatoryUrl() {
		return mandatoryUrl;
	}
}
