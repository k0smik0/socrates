/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * SocratesModule.java is part of 'Socrates'
 * 
 * 'Socrates' is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * 'Socrates' is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with 'Socrates' ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package net.iubris.socrates._roboguice.module;

import net.iubris.socrates._roboguice.providers.annotations.PlacesHttpParser;
import net.iubris.socrates._roboguice.providers.annotations.PlacesHttpTransport;
import net.iubris.socrates._roboguice.providers.http.PlacesHttpRequestFactoryProvider;
import net.iubris.socrates._roboguice.providers.parser.PlacesHttpParserProvider;
import net.iubris.socrates._roboguice.providers.url.common.CommonPartPlaceUrlProvider;
import net.iubris.socrates._roboguice.providers.url.services.DetailsRequestMandatoryUrlProvider;
import net.iubris.socrates._roboguice.providers.url.services.SearchRequestMandatoryUrlProvider;
import net.iubris.socrates.engines.base.annotations.PlacesHttpRequestFactory;
import net.iubris.socrates.engines.base.url.annotation.CommonPartUrl;
import net.iubris.socrates.engines.details.url.annotation.DetailsRequestMandatoryUrl;
import net.iubris.socrates.engines.details.url.annotation.ServiceTypeDetails;
import net.iubris.socrates.engines.search.url.annotation.SearchRequestMandatoryUrl;
import net.iubris.socrates.engines.search.url.annotation.ServiceTypeSearch;
import net.iubris.socrates.model.url.service.ServiceType;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpParser;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class SocratesModule extends AbstractModule {

	@Override
	protected void configure() {				

		bind(ServiceType.class).annotatedWith(ServiceTypeSearch.class).toInstance(ServiceType.search);
		bind(ServiceType.class).annotatedWith(ServiceTypeDetails.class).toInstance(ServiceType.details);
		
		
		
		//bindConstant().annotatedWith(ServiceTypeEvent.class).to( ServiceType.event.getServiceName() );
		
		
		bind(GenericUrl.class).annotatedWith(CommonPartUrl.class).toProvider(CommonPartPlaceUrlProvider.class);
		bind(GenericUrl.class).annotatedWith(SearchRequestMandatoryUrl.class).toProvider(SearchRequestMandatoryUrlProvider.class);
		bind(GenericUrl.class).annotatedWith(DetailsRequestMandatoryUrl.class).toProvider(DetailsRequestMandatoryUrlProvider.class);
		
		
		
		
				
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
		return  new NetHttpTransport();
		//return AndroidHttp.newCompatibleTransport();
	}
	
	/*
	@Provides @CommonPartUrl @Singleton
	public GenericUrl providesCommonPartUrl() {
		final String placeScheme = "https";
		final String placeHost = "maps.googleapis.com";	
		final List<String> placePathParts = Arrays.asList( "","maps","api","place");
		
		final GenericUrl genericUrl = new GenericUrl();
		
		genericUrl.setScheme(placeScheme);
		genericUrl.setHost(placeHost);
		//final List<String> localPlacePathParts = new ArrayList<String>();
		//localPlacePathParts.addAll(placePathParts);
		//localPlacePathParts.add(serviceType.getServiceName());
		genericUrl.setPathParts( placePathParts );
		
		return genericUrl;
	}
	*/
	
}
