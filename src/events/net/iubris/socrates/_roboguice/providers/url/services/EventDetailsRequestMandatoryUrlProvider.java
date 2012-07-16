package net.iubris.socrates._roboguice.providers.url.services;

import net.iubris.socrates.engines.events.details.url.annotation.ServiceTypeEvent;
import net.iubris.socrates.model.http.request.url.service.ServiceType;
import net.iubris.socrates.model.http.request.url.service.events.method.EventMethod;

import com.google.inject.Inject;

public class EventDetailsRequestMandatoryUrlProvider extends AbstractPlaceRequestMandatoryUrlProvider {
		
	@Inject
	public EventDetailsRequestMandatoryUrlProvider(@ServiceTypeEvent ServiceType serviceType) {
		super(serviceType);
	}	
	
	@Override
	protected void addMethod() {
		getMandatoryUrl().appendRawPath( "/"+EventMethod.details.name() );		
	}
}
