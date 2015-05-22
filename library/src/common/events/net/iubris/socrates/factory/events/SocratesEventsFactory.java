package net.iubris.socrates.factory.events;

import net.iubris.socrates._di.providers.http.PlacesHttpRequestFactoryProvider;
import net.iubris.socrates._di.providers.parser.PlacesHttpParserProvider;
import net.iubris.socrates._di.providers.url.common.CommonPartPlaceUrlProvider;
import net.iubris.socrates._di.providers.url.services.events.EventDetailsRequestMandatoryUrlProvider;
import net.iubris.socrates.config.ConfigMandatory;
import net.iubris.socrates.engines.events.details.EventsDetailsRetriever;
import net.iubris.socrates.engines.events.details.url.EventDetailsRequestUrlBuilder;
import net.iubris.socrates.model.http.request.url.service.ServiceType;

import com.google.api.client.extensions.android2.AndroidHttp;
import com.google.api.client.http.GenericUrl;

public class SocratesEventsFactory {
	
	private static EventsDetailsRetriever eventsDetailsRetriever;

	public static EventsDetailsRetriever getEventsDetailsRetriever(ConfigMandatory configMandatory) {
		if (eventsDetailsRetriever==null) {
			CommonPartPlaceUrlProvider commonPartPlaceUrlProvider = new CommonPartPlaceUrlProvider(new GenericUrl());
			EventDetailsRequestMandatoryUrlProvider eventDetailsRequestMandatoryUrlProvider = new EventDetailsRequestMandatoryUrlProvider(ServiceType.event, commonPartPlaceUrlProvider.get(), configMandatory);
			EventDetailsRequestUrlBuilder eventDetailsRequestUrlBuilder = new EventDetailsRequestUrlBuilder(eventDetailsRequestMandatoryUrlProvider.get());
			
			PlacesHttpParserProvider placesHttpParserProvider = new PlacesHttpParserProvider(configMandatory);
			PlacesHttpRequestFactoryProvider placesHttpRequestFactoryProvider = new PlacesHttpRequestFactoryProvider(configMandatory, AndroidHttp.newCompatibleTransport(), placesHttpParserProvider.get());
			
			eventsDetailsRetriever = new EventsDetailsRetriever(eventDetailsRequestUrlBuilder, placesHttpRequestFactoryProvider.get());
		}
		return eventsDetailsRetriever;
	}

}
