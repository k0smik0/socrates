package net.iubris.socrates.detailer.url;

import com.google.inject.Inject;

import net.iubris.socrates.config.PlaceConfig;
import net.iubris.socrates.url.builders.AbstractRequestUrlMandatoryBuilder;

public class DetailsRequestUrlMandatoryBuilder extends AbstractRequestUrlMandatoryBuilder {

	@Inject
	public DetailsRequestUrlMandatoryBuilder(DetailsPlaceUrl placeUrl,
			PlaceConfig placeConfig) {
		super(placeUrl, placeConfig);
	}

}
