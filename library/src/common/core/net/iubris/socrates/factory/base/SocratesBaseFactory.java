package net.iubris.socrates.factory.base;

import net.iubris.socrates._di.providers.http.PlacesHttpRequestFactoryProvider;
import net.iubris.socrates._di.providers.parser.PlacesHttpParserProvider;
import net.iubris.socrates._di.providers.url.common.CommonPartPlaceUrlProvider;
import net.iubris.socrates._di.providers.url.services.details.DetailsRequestMandatoryUrlProvider;
import net.iubris.socrates._di.providers.url.services.search.SearchRequestMandatoryUrlProvider;
import net.iubris.socrates.config.ConfigMandatory;
import net.iubris.socrates.config.SearchOptions;
import net.iubris.socrates.engines.details.DetailsRetriever;
import net.iubris.socrates.engines.details.url.DetailsRequestUrlBuilder;
import net.iubris.socrates.engines.search.Searcher;
import net.iubris.socrates.engines.search.exception.MalformedSearchUrlConfigException;
import net.iubris.socrates.engines.search.url.SearchRequestUrlBuilder;
import net.iubris.socrates.model.http.request.url.service.ServiceType;

import com.google.api.client.extensions.android2.AndroidHttp;
import com.google.api.client.http.GenericUrl;

public class SocratesBaseFactory {

	private static Searcher searcher;
	private static DetailsRetriever detailsRetriever;
	
	public static Searcher getSearcher(SearchOptions searchOptions, ConfigMandatory configMandatory) throws MalformedSearchUrlConfigException {
		if (searcher==null) {
			CommonPartPlaceUrlProvider commonPartPlaceUrlProvider = new CommonPartPlaceUrlProvider(new GenericUrl());
			SearchRequestMandatoryUrlProvider searchRequestMandatoryUrlProvider = new SearchRequestMandatoryUrlProvider(ServiceType.search, commonPartPlaceUrlProvider.get(), configMandatory); 
			
			SearchRequestUrlBuilder searchRequestUrlBuilder = new SearchRequestUrlBuilder(searchRequestMandatoryUrlProvider.get());
			GenericUrl nextPageTokenRequestUrl = searchRequestMandatoryUrlProvider.get();
			PlacesHttpParserProvider placesHttpParserProvider = new PlacesHttpParserProvider(configMandatory);
			PlacesHttpRequestFactoryProvider placesHttpRequestFactoryProvider = new PlacesHttpRequestFactoryProvider(configMandatory, AndroidHttp.newCompatibleTransport(), placesHttpParserProvider.get());
			
			searcher = new Searcher(searchRequestUrlBuilder, nextPageTokenRequestUrl, placesHttpRequestFactoryProvider.get(), searchOptions);
		}
		return searcher;
	}
	
	public static DetailsRetriever getDetailsRetriever(SearchOptions searchOptions, ConfigMandatory configMandatory) {
		if (detailsRetriever==null) {
			CommonPartPlaceUrlProvider commonPartPlaceUrlProvider = new CommonPartPlaceUrlProvider(new GenericUrl());
			DetailsRequestMandatoryUrlProvider detailsRequestMandatoryUrlProvider = new DetailsRequestMandatoryUrlProvider(ServiceType.details, commonPartPlaceUrlProvider.get(), configMandatory);
			DetailsRequestUrlBuilder detailsRequestUrlBuilder = new DetailsRequestUrlBuilder(detailsRequestMandatoryUrlProvider.get());
		
			PlacesHttpParserProvider placesHttpParserProvider = new PlacesHttpParserProvider(configMandatory);
			PlacesHttpRequestFactoryProvider placesHttpRequestFactoryProvider = new PlacesHttpRequestFactoryProvider(configMandatory, AndroidHttp.newCompatibleTransport(), placesHttpParserProvider.get());
			
			detailsRetriever = new DetailsRetriever(detailsRequestUrlBuilder,
					placesHttpRequestFactoryProvider.get(),
					searchOptions);
		}
		return detailsRetriever;
	}
}
