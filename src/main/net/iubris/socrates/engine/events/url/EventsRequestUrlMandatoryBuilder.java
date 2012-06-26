package net.iubris.socrates.engine.events.url;

import net.iubris.socrates.config.PlaceConfig;
import net.iubris.socrates.url.builders.AbstractRequestUrlMandatoryBuilder;

import com.google.inject.Inject;

public class EventsRequestUrlMandatoryBuilder extends AbstractRequestUrlMandatoryBuilder {

	@Inject
	public EventsRequestUrlMandatoryBuilder(EventsPlaceUrl placeUrl,
			PlaceConfig placeConfig) {
		super(placeUrl, placeConfig);
	}
}
