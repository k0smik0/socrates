/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * AbstractSocratesModule.java is part of 'Socrates'.
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
 * along with 'Socrates'; if not, write to the Free Software
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
import net.iubris.socrates.model.http.request.url.service.ServiceType;

import com.google.api.client.extensions.android2.AndroidHttp;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpParser;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public abstract class AbstractSocratesModule extends AbstractModule {
	
//	private Application application;
//
//	public AbstractSocratesModule(Application application) {
//		this.application = application;
//	}
	
	@Override
	protected final void configure() {

		bind(ServiceType.class).annotatedWith(ServiceTypeSearch.class).toInstance(ServiceType.search);
		bind(ServiceType.class).annotatedWith(ServiceTypeDetails.class).toInstance(ServiceType.details);
						
		bind(GenericUrl.class).annotatedWith(CommonPartUrl.class).toProvider(CommonPartPlaceUrlProvider.class);
		bind(GenericUrl.class).annotatedWith(SearchRequestMandatoryUrl.class).toProvider(SearchRequestMandatoryUrlProvider.class);
		bind(GenericUrl.class).annotatedWith(DetailsRequestMandatoryUrl.class).toProvider(DetailsRequestMandatoryUrlProvider.class);
				
		bind(HttpRequestFactory.class).annotatedWith(PlacesHttpRequestFactory.class).toProvider(PlacesHttpRequestFactoryProvider.class);
		bind(HttpParser.class).annotatedWith(PlacesHttpParser.class).toProvider(PlacesHttpParserProvider.class);

		bindConfigMandatory();
		bindSearchOptions();
	}
	
	protected abstract void bindConfigMandatory();
	protected abstract void bindSearchOptions();

	@Provides @PlacesHttpTransport
	public HttpTransport providesHttpTransport() {
		return AndroidHttp.newCompatibleTransport();
	}	
}
