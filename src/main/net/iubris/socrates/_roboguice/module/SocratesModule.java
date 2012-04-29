package net.iubris.socrates._roboguice.module;

import net.iubris.socrates._roboguice.providers.annotations.PlacesHttpParser;
import net.iubris.socrates._roboguice.providers.annotations.PlacesHttpRequestFactory;
import net.iubris.socrates._roboguice.providers.annotations.PlacesHttpTransport;
import net.iubris.socrates._roboguice.providers.parser.PlacesHttpParserProvider;
import net.iubris.socrates._roboguice.providers.url.PlacesHttpRequestFactoryProvider;
import net.iubris.socrates.detailer.url.annotation.PlaceUrlFinalPartDetails;
import net.iubris.socrates.searcher.url.annotation.PlaceUrlFinalPartSearch;
import net.iubris.socrates.url.PlaceUrlFinalPart;

import com.google.api.client.extensions.android2.AndroidHttp;
import com.google.api.client.http.HttpParser;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class SocratesModule extends AbstractModule {

	@Override
	protected void configure() {				

		bind(PlaceUrlFinalPart.class).annotatedWith(PlaceUrlFinalPartSearch.class).toInstance(PlaceUrlFinalPart.search);
		bind(PlaceUrlFinalPart.class).annotatedWith(PlaceUrlFinalPartDetails.class).toInstance(PlaceUrlFinalPart.details);
				
		bind(HttpRequestFactory.class).annotatedWith(PlacesHttpRequestFactory.class).toProvider(PlacesHttpRequestFactoryProvider.class);
		bind(HttpParser.class).annotatedWith(PlacesHttpParser.class).toProvider(PlacesHttpParserProvider.class);
				
		/*
		//bind(PlaceConfigFromXml.class).toProvider(PlacesConfigProvider.class);
		// old
		bind(PlaceConfig.class).toProvider(PlaceConfigProvider.class);//.in(Singleton.class);
		
		bind(PlaceConfigXml.class).toProvider(PlaceConfigXmlProvider.class);
		//bind(PlaceConfigXmlParser.class).toProvider(PlaceConfigXmlParserProvider.class);
		*/
		
		//install (new UlyssesModuleDemo());		
	}
	
	@Provides @PlacesHttpTransport
	public HttpTransport providesHttpTransport() {
		//return  new NetHttpTransport();
		return AndroidHttp.newCompatibleTransport();
	}
}
