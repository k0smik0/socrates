package net.iubris.socrates._roboguice.providers.url.services;

import javax.inject.Inject;

import net.iubris.socrates.engines.details.url.annotation.ServiceTypeDetails;
import net.iubris.socrates.model.http.request.url.service.ServiceType;

public class DetailsRequestMandatoryUrlProvider extends AbstractPlaceRequestMandatoryUrlProvider {
		
	@Inject
	public DetailsRequestMandatoryUrlProvider(@ServiceTypeDetails ServiceType serviceType) {
		super(serviceType);
	}
}
