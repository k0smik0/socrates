package net.iubris.socrates._roboguice.providers.url.services;

import net.iubris.socrates.engines.search.url.annotation.ServiceTypeSearch;
import net.iubris.socrates.model.url.service.ServiceType;

import com.google.api.client.http.GenericUrl;
import com.google.inject.Inject;

public class SearchRequestMandatoryUrlProvider extends AbstractPlaceRequestMandatoryUrlProvider {
	
	@Inject 
	public SearchRequestMandatoryUrlProvider(@ServiceTypeSearch ServiceType serviceType) {
		super(serviceType);
		//Ln.d(serviceType);
		//System.out.println(serviceType);
	}
	
	@Override
	public GenericUrl get() {
		GenericUrl genericUrl = super.get();
//System.out.println("21:"+genericUrl);
		return genericUrl;
	}
}
