/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * AbstractActivityTest.java is part of 'Socrates'.
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
package socrates.test.roboguiced.activity;

import net.iubris.socrates.config.ConfigOptional;
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
	protected ConfigOptional placesConfig;
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
				
		placesConfig = injector.getInstance(ConfigOptional.class);
	}	
}
