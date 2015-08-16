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
package socrates.test.guiced.main;

import javax.inject.Inject;

import net.iubris.socrates.config.SearchOptions;
import net.iubris.socrates.engines.search.url.SearchRequestUrlBuilder;
import socrates.test.roboguiced.module.SocratesModuleTest;
import android.location.Location;

import com.google.api.client.http.HttpParser;
import com.google.api.client.http.HttpRequestFactory;
import com.google.inject.Guice;
import com.google.inject.Injector;

//@RunWith(RobolectricTestRunner.class)
abstract public class AbstractTest {
	
	protected Injector injector;
	protected Location location;
	
	@Inject
	protected SearchOptions searchOptions;
	
	protected SearchRequestUrlBuilder placeRequestUrlBuilder;
	protected HttpRequestFactory httpRequestFactory;
	protected HttpParser httpParser;
	
//	@Before	
	public AbstractTest() {		
//		location = new Location("GPS");
//		location.setLatitude(44.4937382342);
//		location.setLongitude(11.376947768);
		
		injector = Guice.createInjector( new SocratesModuleTest() );
				
//		searchOptions = injector.getInstance(SearchOptions.class);
		injector.injectMembers(this);
	}
}
