package net.iubris.socrates._roboguice.providers.url.services;

import net.iubris.socrates.config.PlaceConfig;
import net.iubris.socrates.engines.base.url.annotation.CommonPartUrl;
import net.iubris.socrates.model.url.mandatory.PlaceUrlMandatoryParameter;
import net.iubris.socrates.model.url.service.ServiceType;

import com.google.api.client.http.GenericUrl;
import com.google.inject.Inject;
import com.google.inject.Provider;

public abstract class AbstractPlaceRequestMandatoryUrlProvider implements Provider<GenericUrl>{

	@Inject @CommonPartUrl
	private GenericUrl urlWithoutParameters;
	@Inject 
	private PlaceConfig placeConfig;
	private final ServiceType serviceType;
//	private final ServiceType serviceType;
	private GenericUrl mandatoryUrl;
	
	public AbstractPlaceRequestMandatoryUrlProvider(
			/*GenericUrl urlWithoutParameters, PlaceConfig placeConfig,*/ ServiceType serviceType) {
				this.serviceType = serviceType;
		/*
		this.urlWithoutParameters = urlWithoutParameters;
		this.placeConfig = placeConfig;
		*/
	//	this.serviceType = serviceType;		
	}
	
	public GenericUrl get() {
		
		mandatoryUrl = urlWithoutParameters.clone();
				
		
		//System.out.println("34:"+mandatoryUrl);
		
		mandatoryUrl.getPathParts().add(serviceType.getServiceName());
		
		//urlWithoutParameters.appendRawPath("/"+serviceType.getServiceName());
		
		addOutput();
		//System.out.println("37:"+mandatoryUrl);
		
		addMethod();
		
		

		setValue(PlaceUrlMandatoryParameter.key, placeConfig.getKey());
		//System.out.println(mandatoryUrl);
		setValue(PlaceUrlMandatoryParameter.sensor, placeConfig.isUseSensor());
		//System.out.println(mandatoryUrl);
		
		return mandatoryUrl;
	}
	
	protected void addMethod() {}
	
	private void addOutput() {
		mandatoryUrl.appendRawPath("/"+placeConfig.getOutput().name());
	}
	
	private void setValue(PlaceUrlMandatoryParameter placeUrlParameter, Object value) {
		mandatoryUrl.put(placeUrlParameter.name(), value);
	}
	
	protected GenericUrl getMandatoryUrl() {
		return mandatoryUrl;
	}
}