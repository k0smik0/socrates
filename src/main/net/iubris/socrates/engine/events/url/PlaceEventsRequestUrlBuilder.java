package net.iubris.socrates.engine.events.url;

import net.iubris.socrates.config.PlaceConfig;
import net.iubris.socrates.url.PlaceUrlConfigParameter;
import net.iubris.socrates.url.builders.AbstractPlacesRequestUrlBuilder;

import com.google.inject.Inject;

public class PlaceEventsRequestUrlBuilder extends AbstractPlacesRequestUrlBuilder<PlaceEventsRequestUrlBuilder> {

	@Inject
	public PlaceEventsRequestUrlBuilder(EventsRequestUrlMandatoryBuilder requestUrlMandatory,
			PlaceConfig placesConfig) {
		super(requestUrlMandatory, placesConfig);
	}
	
	public PlaceEventsRequestUrlBuilder buildUrl(String reference) {
		//setValue(buildedUrl, PlaceUrlConfigParameter.reference, reference);
		setValue(PlaceUrlConfigParameter.reference, reference);
		return this;
	}

	@Override
	public PlaceEventsRequestUrlBuilder resetUrl() {
		resetUrlFromSuperClass();
		return this;
	}
	
}
