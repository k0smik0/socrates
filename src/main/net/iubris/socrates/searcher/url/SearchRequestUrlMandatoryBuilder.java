package net.iubris.socrates.searcher.url;

import com.google.inject.Inject;

import net.iubris.socrates.config.PlaceConfig;
import net.iubris.socrates.url.builders.AbstractRequestUrlMandatoryBuilder;

public class SearchRequestUrlMandatoryBuilder extends AbstractRequestUrlMandatoryBuilder {

	@Inject
	public SearchRequestUrlMandatoryBuilder(SearchPlaceUrl placeUrl, PlaceConfig placeConfig) {
		super(placeUrl, placeConfig);
	}

}
