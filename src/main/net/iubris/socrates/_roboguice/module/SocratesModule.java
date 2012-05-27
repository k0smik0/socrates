/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * SocratesModule.java is part of 'Socrates'.
 * 
 * socrates is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * socrates is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with socrates ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
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
