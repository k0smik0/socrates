package net.iubris.socrates.detailer;

import com.google.inject.Inject;

import net.iubris.socrates.config.PlaceConfig;
import net.iubris.socrates.detailer.url.DetailsRequestUrlMandatoryBuilder;
import net.iubris.socrates.url.PlaceUrlConfigParameter;
import net.iubris.socrates.url.builders.AbstractPlacesRequestUrlBuilder;

public class PlaceDetailsRequestUrlBuilder extends AbstractPlacesRequestUrlBuilder<PlaceDetailsRequestUrlBuilder> {
	
	@Inject
	public PlaceDetailsRequestUrlBuilder(DetailsRequestUrlMandatoryBuilder requestUrlMandatory,
			PlaceConfig placesConfig) {
		super(requestUrlMandatory, placesConfig);
	}
	
	public PlaceDetailsRequestUrlBuilder buildUrl(String reference) {
		//setValue(buildedUrl, PlaceUrlConfigParameter.reference, reference);
		setValue(PlaceUrlConfigParameter.reference, reference);
		return this;
	}

	@Override
	public PlaceDetailsRequestUrlBuilder resetUrl() {
		resetUrlFromSuperClass();
		return this;
	}

}
