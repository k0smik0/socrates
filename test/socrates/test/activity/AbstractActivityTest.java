/*******************************************************************************
 * Copyleft 2012 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * AbstractUDActivityTest.java is part of 'Socrates'
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
package socrates.test.activity;

import net.iubris.socrates.config.PlaceConfig;
import net.iubris.socrates.engines.search.url.SearchRequestUrlBuilder;

import org.junit.Before;
import org.junit.runner.RunWith;

import roboguice.RoboGuice;
import roboguice.inject.RoboInjector;
import android.location.Location;
import android.test.ActivityTestCase;

import com.google.api.client.http.HttpParser;
import com.google.api.client.http.HttpRequestFactory;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
abstract public class AbstractActivityTest extends ActivityTestCase {
	
	protected RoboInjector injector;
	//PlacesFinderProvider<Place> placesFinderProvider;
	//private net.iubris.ulysses.finder.generics.result.PlacesFinder<Place> placesFinderGenericsResult;
	//PlacesFinder<Place> placesFinderGenericsResult;
	//private net.iubris.ulysses.finder.generics.list.PlacesFinder<net.iubris.ulysses.model.nongenerics.PlacesList>placesFinderGenericsList;
	//private PlacesFinder placesFinderNoGenerics;
	protected Location location;
	protected PlaceConfig placesConfig;
	//private XmlAssetReader<PlacesConfig> xmlReader;
	protected SearchRequestUrlBuilder placeRequestUrlBuilder;
	protected HttpRequestFactory httpRequestFactory;
	protected HttpParser httpParser;
	
	@Before	
	public void setUp() {		
		location = new Location("GPS");
		location.setLatitude(44.4937382342);
		location.setLongitude(11.376947768);
		
		injector = RoboGuice.getInjector( Robolectric.application.getApplicationContext() );
		
		//xmlReader = injector.getInstance( Key.get(new TypeLiteral<XmlReader<PlacesConfig>>() {}) );
		
		//PlaceRequestUrlBuilder placeRequestUrlBuilder = injector.getInstance(PlaceRequestUrlBuilder.class);
		
		//PlacesRequestUrlProvider placesRequestUrlProvider = injector.getInstance(PlacesRequestUrlProvider.class);
		//System.out.println(placesRequestUrlProvider);
		
		//placeRequestUrlBuilder = injector.getInstance(PlaceRequestUrlBuilder.class);
		
		placesConfig = injector.getInstance(PlaceConfig.class);
System.out.println(placesConfig.getApplicationName());

		//httpParser = injector.getInstance(PlacesHttpParserProvider.class).get();

/*
		System.out.println(
			injector.getInstance( Key.get(GenericUrl.class, SearchRequestMandatoryUrl.class) )
		);*/
		
		//System.out.println(httpParser);
		
		//httpRequestFactory = injector.getInstance(Key.get(HttpRequestFactory.class,PlacesHttpRequestFactory.class));
		
		

//		HttpTransport httpTransport = new NetHttpTransport();
		//httpRequestFactory = HttpRequestFactoryFactory.createRequestFactory(new NetHttpTransport() , placesConfig.getApplicationName(), httpParser);		
		
	}	
}
