package net.iubris.socrates._roboguice.providers.url.services;

import net.iubris.socrates.engines.details.url.annotation.ServiceTypeDetails;
import net.iubris.socrates.model.url.service.ServiceType;

import com.google.inject.Inject;

public class DetailsRequestMandatoryUrlProvider extends AbstractPlaceRequestMandatoryUrlProvider {
		
	@Inject
	public DetailsRequestMandatoryUrlProvider(@ServiceTypeDetails ServiceType serviceType) {
		super(serviceType);
	}
}
